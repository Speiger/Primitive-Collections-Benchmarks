package speiger.src;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;

public class BenchmarkMapper
{
	public static final DecimalFormat FORMAT = new DecimalFormat("###,##0.0##");
	public static final List<String> INDEXES = ObjectArrayList.wrap("100", "1000", "10000");
	public static final List<String> FOLDERS = ObjectArrayList.wrap("java", "eclipse", "hppc", "fastutil", "pc");
	public static final List<String> NAMES = ObjectArrayList.wrap("Java", "Eclipse", "HPPC", "FastUtil", "PC");
	public static final List<String> SORTING_ORDER = ObjectArrayList.wrap("ArrayList", "LinkedList", "FIFOQueue", "HeapQueue", "ArrayQueue", "HashSet", "LinkedHashSet", "ArraySet", "AVLTreeSet", "RBTreeSet", "HashMap", "LinkedHashMap", "ArrayMap", "AVLTreeMap", "RBTreeMap");
	
	public static void main(String[] args)
	{
		try
		{
			Object2ObjectMap<String, List<JsonObject>> objects = Object2ObjectMap.builder().linkedMap();
			for(JsonElement el : JsonParser.parseReader(Files.newBufferedReader(Paths.get(args[0]))).getAsJsonArray())
			{
				JsonObject obj = el.getAsJsonObject();
				String[] s = obj.get("benchmark").getAsString().split("\\.");
				objects.supplyIfAbsent(s[s.length-1], ObjectArrayList::new).add(obj);
			}
			ObjectList<BenchmarkResult> results = objects.object2ObjectEntrySet().map(BenchmarkResult::new).pour(new ObjectArrayList<>());
			results.sort(Comparator.comparing(BenchmarkResult::getName));
			Object2ObjectMap<String, ObjectList<BenchmarkResult>> mappedResults = Object2ObjectMap.builder().linkedMap();
			for(int i = 0,m=results.size();i<m;i++) {
				BenchmarkResult result = results.get(i);
				mappedResults.supplyIfAbsent(result.getCollection(), ObjectArrayList::new).add(result);
			}
			BenchmarkResult.applyTreePatch(mappedResults); //Combining TreeSets.
			StringBuilder finalBuilder = new StringBuilder();
			for(String key : SORTING_ORDER)
			{
				ObjectList<BenchmarkResult> value = mappedResults.get(key);
				StringBuilder builder = new StringBuilder();
				WidthInfo info = new WidthInfo();
				value.forEach(info);
				info.finish();
				info.buildBeginArea(builder);
				builder.insert(0, "\n").insert(0, key).insert(0, "### ");
				value.forEach(builder, info::buildRow);
				builder.append("\n");
				finalBuilder.append(builder.toString());
			}
			try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(args[1])))
			{
				writer.append(finalBuilder.toString());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static class WidthInfo implements Consumer<BenchmarkResult>
	{
		int nameWidth = 0;
		int[] maxWidths = new int[NAMES.size()];
		
		@Override
		public void accept(BenchmarkResult t) {
			nameWidth = Math.max(nameWidth, t.name.length());
			for(int i = 0;i<maxWidths.length;i++) {
				maxWidths[i] = Math.max(maxWidths[i], t.calculateCharCountForRow(i));
			}
		}
		
		public void finish() {
			nameWidth += 4;
			int hppc = NAMES.indexOf("HPPC");
			for(int i = 0;i<maxWidths.length;i++) {
				maxWidths[i] = Math.max(maxWidths[i], (NAMES.get(i)+" Score").length()) + (i == 0 || i == hppc ? 1 : 0) + 4;
			}
		}
		
		public void buildBeginArea(StringBuilder builder) {
			int[] result = calcCenter(6, nameWidth);
			builder.append("|");
			appendSpaces(builder, result[0]);
			builder.append("Action");
			appendSpaces(builder, result[1]);
			builder.append("|");
			result = calcCenter(4, 10);
			appendSpaces(builder, result[0]);
			builder.append("Size");
			appendSpaces(builder, result[1]);
			builder.append("|");
			for(int i = 0;i<NAMES.size();i++) {
				String s = NAMES.get(i)+" Score";
				result = calcCenter(s.length(), maxWidths[i]);
				appendSpaces(builder, result[0]);
				builder.append(s);
				appendSpaces(builder, result[1]);
				builder.append("|");
			}
			builder.append(" Units |");
			int length = builder.length();
			builder.append("\n");
			for(int i = 0;i<length;i++) {
				builder.append(builder.charAt(i) == '|' ? '|' : "-");
			}
			builder.append("\n");
		}
		
		private void appendSpaces(StringBuilder builder, int amount) {
			for(int i = 0;i<amount;i++) builder.append(" ");			
		}
		
		public void buildRow(StringBuilder builder, BenchmarkResult result) {
			for(int j = 0;j<INDEXES.size();j++) {
				String count = INDEXES.get(j);
				builder.append("|");
				int[] spaces = calcNameCenter(result.name.length());
				appendSpaces(builder, spaces[0]);
				builder.append(result.name);
				appendSpaces(builder, spaces[1]);
				builder.append("|");
				spaces = scaleSizeCenter(count.length());
				appendSpaces(builder, spaces[0]);
				builder.append(count);
				appendSpaces(builder, spaces[1]);
				builder.append("|");
				for(int i = 0;i<FOLDERS.size();i++) {
					spaces = calcBarBuff(result.scoresText[j][i], maxWidths[i], i);
					appendSpaces(builder, spaces[0]);
					builder.append(result.scoresText[j][i]);
					appendSpaces(builder, spaces[1]);
					builder.append("|");
				}
				builder.append(" us/op |");
				builder.append("\n");
			}
		}
		
		private int[] scaleSizeCenter(int count) {
			return new int[]{8-count, 2};
		}
		
		private int[] calcNameCenter(int length) {
			return new int[]{2, (nameWidth-2) - length};
		}
		
		private int[] calcBarBuff(String number, int width, int index) {
			if(index == 0) { //Java Specific
				if(number.equalsIgnoreCase("N/A")) return new int[]{width - 6, 3};
				String[] split = number.split("\\,");
				if(split.length != 2) System.out.println(number);
				return new int[]{width - 5 - split[0].length(), 4-split[1].length()};
			}
			if(number.equalsIgnoreCase("N/A")) return new int[]{width - 7, 4};
			String[] split = number.split("\\,");
			if(split.length != 2) System.out.println(number);
			return new int[]{width - 6 - split[0].length(), 5-split[1].length()};
		}
		
		private int[] calcCenter(int textLength, int width) {
			double result = (width - textLength) * 0.5D;
			return result != (int)result ? new int[]{(int)result, (int)(result+1)} : new int[]{(int)result, (int)result};
		}
	}
}
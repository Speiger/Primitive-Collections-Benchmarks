package speiger.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.impl.hash.Object2ObjectLinkedOpenHashMap;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;
import speiger.src.collections.objects.utils.ObjectLists;

public class BenchmarkMapper {
	public static final Map<String, String> ID_TO_NAME = Object2ObjectMap.builder().<String, String>start()
			.put("java", "Java").put("eclipse", "Eclipse")
			.put("hppc", "HPPC").put("koloboke", "Koloboke")
			.put("fastutil", "FastUtil").put("pc", "PC").map();
	public static final List<String> IDS = ObjectArrayList.wrap("java", "eclipse", "hppc", "koloboke", "fastutil", "pc");

	private static final List<String> SORTING_ORDER = ObjectArrayList.wrap("ArrayList", "LinkedList", "FIFOQueue", "HeapQueue", "ArrayQueue", "HashSet", "LinkedHashSet", "ArraySet", "AVLTreeSet", "RBTreeSet", "HashMap", "LinkedHashMap", "ArrayMap", "AVLTreeMap", "RBTreeMap");
	
	public static void main(String[] args) {
		try {
			Map<String, BenchCollection> mapped = parseData(Paths.get(args[0]));
			mergeData(mapped, "TreeMap", "AVLTreeMap", "RBTreeMap");
			mergeData(mapped, "TreeSet", "AVLTreeSet", "RBTreeSet");
			StringBuilder builder = new StringBuilder();
			for(String clz : SORTING_ORDER) {
				BenchCollection collection = mapped.get(clz);
				if(collection == null) continue;
				builder.append("### ").append(clz).append("\n");
				builder.append(collection.buildResult(filterIds(collection), ID_TO_NAME));
				builder.append("\n\n");
			}
			try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(args[1])))
			{
				writer.append(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ObjectList<String> filterIds(BenchCollection collection) {
		ObjectList<String> lists = new ObjectArrayList<>();
		Set<String> ids = collection.getUsedLibraries();
		for(String id : IDS) {
			if(ids.contains(id)) lists.add(id);
		}
		return lists;
	}
	
	public static void mergeData(Map<String, BenchCollection> mapped, String source, String...targets) {
		if(targets == null || targets.length <= 0) return;
		BenchCollection collection = mapped.remove(source);
		if(collection == null) return;
		for(String value : targets) {
			BenchCollection target = mapped.get(value);
			if(target == null) continue;
			target.merge(collection);
		}
		mapped.values().forEach(BenchCollection::sort);
	}
	
	public static Map<String, BenchCollection> parseData(Path file) throws IOException {
		ObjectList<Path> files = Files.isDirectory(file) ? Files.walk(file).filter(Predicate.not(Files::isDirectory)).collect(Collectors.toCollection(ObjectArrayList::new)) : ObjectLists.singleton(file);
		Map<String, BenchCollection> mappedCollections = new Object2ObjectLinkedOpenHashMap<>();
		for(int i = 0,m=files.size();i<m;i++) {
			for(JsonElement el : JsonParser.parseReader(Files.newBufferedReader(files.get(i))).getAsJsonArray())
			{
				JsonObject obj = el.getAsJsonObject();
				String[] path = obj.get("benchmark").getAsString().split("\\.");
				String library = path[path.length-3];
				String[] names = path[path.length-1].split("Result");
				int size = Integer.parseInt(obj.getAsJsonObject("params").get("setSize").getAsString());
				double score = obj.getAsJsonObject("primaryMetric").get("score").getAsDouble();
				mappedCollections.computeIfAbsent(names[1], BenchCollection::new).addFunction(names[0], size, library, score);
			}
		}
		mappedCollections.values().forEach(BenchCollection::sort);
		return mappedCollections;
	}
}

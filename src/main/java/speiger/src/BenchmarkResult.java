package speiger.src;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap.Entry;
import speiger.src.collections.objects.utils.maps.Object2ObjectMaps;

class BenchmarkResult
{
	String name;
	String collection;
	String[][] scoresText = new String[BenchmarkMapper.INDEXES.size()][BenchmarkMapper.FOLDERS.size()];
	double[][] scores = new double[BenchmarkMapper.INDEXES.size()][BenchmarkMapper.FOLDERS.size()];
	
	public BenchmarkResult(Entry<String, List<JsonObject>> entry) {
		this(entry.getKey(), entry.getValue());
	}
	
	public BenchmarkResult(String name, List<JsonObject> objs) {
		String[] split = name.split("Result");
		this.name = split[0];
		collection = split[1];
		for(JsonObject obj : objs)
		{
			String[] path = obj.get("benchmark").getAsString().split("\\.");
			int mainScore = BenchmarkMapper.INDEXES.indexOf(obj.getAsJsonObject("params").get("setSize").getAsString());
			int subScore = BenchmarkMapper.FOLDERS.indexOf(path[path.length-3]);
			double score = obj.getAsJsonObject("primaryMetric").get("score").getAsDouble();
			scoresText[mainScore][subScore] = BenchmarkMapper.FORMAT.format(score);
			scores[mainScore][subScore] = score;
		}
		for(int i = 0;i<scoresText.length;i++)
		{
			for(int j = 0;j<scoresText[i].length;j++)
			{
				if(scoresText[i][j] == null) scoresText[i][j] = "N/A";
			}
		}
	}
	
	public void merge(BenchmarkResult toInject) {
		for(int i = 0;i<scoresText.length;i++) {
			for(int j = 0;j<scoresText[i].length;j++) {
				if(scoresText[i][j].equalsIgnoreCase("N/A") && !toInject.scoresText[i][j].equalsIgnoreCase("N/A")) {
					scoresText[i][j] = toInject.scoresText[i][j];
					scores[i][j] = toInject.scores[i][j];
				}
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getNames() {
		return new String[]{name+" (100)", name+" (1000)", name+" (10000)"};
	}
	
	public String getName(int index) {
		switch(index) {
			case 1: return name+" (1000)";
			case 2: return name+" (10000)";
			default: return name+" (100)";
		}
	}
	
	public String getFileName(int index) {
		switch(index) {
			case 1: return name+"_1000";
			case 2: return name+"_10000";
			default: return name+"_100";
		}
	}
	
	public String getCollection() {
		return collection;
	}
	
	public double getValue(int count, int value) {
		return scores[count][value];
	}
	
	public boolean isInvalid(int count, int value) {
		return scoresText[count][value].equalsIgnoreCase("N/A");
	}
	
	public int getCount() {
		return scores.length;
	}
	
	public int calculateCharCountForRow(int row) {
		return Arrays.stream(scoresText).map(T -> T[row]).mapToInt(String::length).max().getAsInt();
	}
	
	public static void applyTreePatch(Object2ObjectMap<String, ObjectList<BenchmarkResult>> mappedResults) {
		Object2ObjectMap<String, BenchmarkResult> tree = mapResults(mappedResults.get("TreeMap"));
		Map<String, BenchmarkResult> avl = mapResults(mappedResults.get("AVLTreeMap"));
		Map<String, BenchmarkResult> rb = mapResults(mappedResults.get("RBTreeMap"));
		for(Entry<String, BenchmarkResult> entry : Object2ObjectMaps.fastIterable(tree)) {
			BenchmarkResult data = avl.get(entry.getKey());
			if(data != null) {
				data.merge(entry.getValue());
			}
			data = rb.get(entry.getKey());
			if(data != null) {
				data.merge(entry.getValue());
			}
		}
		
		tree = mapResults(mappedResults.get("TreeSet"));
		avl = mapResults(mappedResults.get("AVLTreeSet"));
		rb = mapResults(mappedResults.get("RBTreeSet"));
		for(Entry<String, BenchmarkResult> entry : Object2ObjectMaps.fastIterable(tree)) {
			BenchmarkResult data = avl.get(entry.getKey());
			if(data != null) {
				data.merge(entry.getValue());
			}
			data = rb.get(entry.getKey());
			if(data != null) {
				data.merge(entry.getValue());
			}
		}
		mappedResults.remove("TreeMap");
		mappedResults.remove("TreeSet");
	}
	
	public static Object2ObjectMap<String, BenchmarkResult> mapResults(List<BenchmarkResult> list) {
		if(list == null) return Object2ObjectMaps.empty();
		Object2ObjectMap<String, BenchmarkResult> obj = Object2ObjectMap.builder().linkedMap();
		for(int i = 0;i<list.size();i++) {
			BenchmarkResult result = list.get(i);
			obj.put(result.getName(), result);
		}
		return obj;
	}
}
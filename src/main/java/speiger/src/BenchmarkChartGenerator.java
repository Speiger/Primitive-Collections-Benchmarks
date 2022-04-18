package speiger.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import io.quickchart.QuickChart;
import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;
import speiger.src.collections.objects.misc.pairs.ObjectObjectPair;
import speiger.src.collections.objects.sets.ObjectOpenHashSet;
import speiger.src.collections.objects.sets.ObjectSet;
import speiger.src.collections.objects.utils.ObjectLists;

public class BenchmarkChartGenerator
{
	public static final String PREFIX = "{type: 'line', options: {legend: {display: true, position: 'left'}}, data: {labels: ['100', '1000', '10000'], datasets: [";
	public static final String SUFFIX = "]}}";
	public static final TaskBuilder LIST = new TaskBuilder("charts/lists", "ArrayList", "LinkedList").addFunctions("add").addFunctions("addEmpty").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder SET = new TaskBuilder("charts/sets/", "HashSet", "LinkedHashSet").addFunctions("add").addFunctions("addEmpty").addFunctions("contains").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder TREE_SET = new TaskBuilder("charts/tree-sets", "TreeSet", "RBTreeSet", "AVLTreeSet").addFunctions("add").addFunctions("addEmpty").addFunctions("contains").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder MAP = new TaskBuilder("charts/maps", "HashMap", "LinkedHashMap").addFunctions("put").addFunctions("putEmpty").addFunctions("containsKey").addFunctions("forEach").addFunctions("clone").addFunctions("forEach").addFunctions("get").addFunctions("getOrDefault").addFunctions("remove");
	public static final TaskBuilder TREE_MAP = new TaskBuilder("charts/tree-maps", "TreeMap", "RBTreeMap", "AVLTreeMap").addFunctions("put").addFunctions("putEmpty").addFunctions("containsKey").addFunctions("forEach").addFunctions("clone").addFunctions("forEach").addFunctions("get").addFunctions("getOrDefault").addFunctions("remove");
	
	public static void main(String...args) throws Exception {
		Object2ObjectMap<String, ObjectList<BenchmarkResult>> map = getFiles();
		ObjectList<ObjectObjectPair<QuickChart, String>> charts = new ObjectArrayList<>();
		LIST.buildCharts(map, charts);
		SET.buildCharts(map, charts);
		TREE_SET.buildCharts(map, charts);
		MAP.buildCharts(map, charts);
		TREE_MAP.buildCharts(map, charts);
		System.out.println("Start Printing Images ["+charts.size()+"]");
		charts.forEach(BenchmarkChartGenerator::printChart);
		System.out.println("End Printing Image");
	}
	
	private static void printChart(ObjectObjectPair<QuickChart, String> chart)
	{
		System.out.println(chart.getValue());
		try
		{
			Path path = Paths.get(chart.getValue()).getParent();
			if(Files.notExists(path)) {
				Files.createDirectories(path);
			}
			chart.getKey().toFile(chart.getValue());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static Object2ObjectMap<String, ObjectList<BenchmarkResult>> getFiles() throws Exception
	{
		Object2ObjectMap<String, ObjectList<BenchmarkResult>> obj = Object2ObjectMap.builder().linkedMap();
		for(BenchmarkResult result : BenchmarkMapper.parseFiles(Paths.get("build/reports/collections"))) {
			obj.supplyIfAbsent(result.getName(), ObjectArrayList::new).add(result);
		}
		return obj;
	}
	
	public static class TaskBuilder 
	{
		String baseFolder;
		ObjectSet<String> classes = new ObjectOpenHashSet<>();
		ObjectList<String[]> functions = new ObjectArrayList<>();
		
		public TaskBuilder(String baseFolder, String...classes)
		{
			this.baseFolder = baseFolder;
			this.classes.addAll(classes);
		}
		
		public TaskBuilder addFunctions(String...functionNames)
		{
			functions.add(functionNames);
			return this;
		}
		
		public void buildCharts(Object2ObjectMap<String, ObjectList<BenchmarkResult>> benchmarks, ObjectList<ObjectObjectPair<QuickChart, String>> charts)
		{
			int offset = 0;
			for(String[] function : functions)
			{
				List<String> names = BenchmarkMapper.NAMES;
				StringBuilder builder = new StringBuilder(PREFIX);
				for(String s : function) {
					for(BenchmarkResult result : benchmarks.getOrDefault(s, ObjectLists.empty())) {
						if(!classes.contains(result.getCollection())) continue;
						for(int i = 0,m=names.size();i<m;i++) {
							String value = result.getChartData(i);
							if(value == null) continue;
							builder.append("{label: '").append(result.getCollectionName(names.get(i))).append("', fill: false, borderDash: [10,10], borderDashOffset: ").append(offset).append(", ").append(value).append("},");
							offset+=2;
						}
					}
				}
				if(builder.length() == PREFIX.length()) continue;
				builder.setLength(builder.length()-1);
				builder.append(SUFFIX);
				QuickChart chart = new QuickChart();
				chart.setWidth(800);
				chart.setHeight(500);
				chart.setBackgroundColor("white");
				chart.setConfig(builder.toString());
				charts.add(ObjectObjectPair.of(chart, baseFolder+"/"+function[0]+".png"));
			}
		}
	}
}

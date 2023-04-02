package speiger.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import io.quickchart.QuickChart;
import speiger.src.collections.doubles.lists.DoubleList;
import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.misc.pairs.ObjectObjectPair;

public class BenchmarkChartGenerator
{
	public static final String PREFIX = "{type: 'line', options: {legend: {display: true, position: 'left'}}, data: {labels: ['100', '1000', '10000'], datasets: [";
	public static final String SUFFIX = "]}}";
	public static final Map<String, String> ID_TO_NAME = BenchmarkMapper.ID_TO_NAME;
	public static final List<String> IDS = BenchmarkMapper.IDS;
	public static final TaskBuilder LIST = new TaskBuilder("charts/temp/lists", "ArrayList", "LinkedList").addFunctions("add").addFunctions("addEmpty").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder SET = new TaskBuilder("charts/temp/sets", "HashSet", "LinkedHashSet").addFunctions("add").addFunctions("addEmpty").addFunctions("contains").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder TREE_SET = new TaskBuilder("charts/temp/tree-sets", "TreeSet", "RBTreeSet", "AVLTreeSet").addFunctions("add").addFunctions("addEmpty").addFunctions("contains").addFunctions("remove").addFunctions("iterateForLoop").addFunctions("toArray");
	public static final TaskBuilder MAP = new TaskBuilder("charts/temp/maps", "HashMap", "LinkedHashMap").addFunctions("put").addFunctions("putEmpty").addFunctions("containsKey").addFunctions("forEach").addFunctions("clone").addFunctions("forEach").addFunctions("get").addFunctions("getOrDefault").addFunctions("remove");
	public static final TaskBuilder TREE_MAP = new TaskBuilder("charts/temp/tree-maps", "TreeMap", "RBTreeMap", "AVLTreeMap").addFunctions("put").addFunctions("putEmpty").addFunctions("containsKey").addFunctions("forEach").addFunctions("clone").addFunctions("forEach").addFunctions("get").addFunctions("getOrDefault").addFunctions("remove");
	
	public static void main(String...args) throws Exception {
		Map<String, BenchCollection> result = getFiles("build/reports/collections");
		ObjectList<ObjectObjectPair<QuickChart, String>> charts = new ObjectArrayList<>();
		LIST.buildCharts(result, charts);
		SET.buildCharts(result, charts);
		TREE_SET.buildCharts(result, charts);
		MAP.buildCharts(result, charts);
		TREE_MAP.buildCharts(result, charts);
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
	
	public static Map<String, BenchCollection> getFiles(String path) throws IOException {
		return BenchmarkMapper.parseData(Paths.get(path));
	}
	
	public static class TaskBuilder 
	{
		String baseFolder;
		ObjectList<String> classes = new ObjectArrayList<>();
		ObjectList<String> functions = new ObjectArrayList<>();
		
		public TaskBuilder(String baseFolder, String...classes)
		{
			this.baseFolder = baseFolder;
			this.classes.addAll(classes);
		}
		
		public TaskBuilder addFunctions(String functionNames)
		{
			functions.add(functionNames);
			return this;
		}
		
		public void buildCharts(Map<String, BenchCollection> collections, ObjectList<ObjectObjectPair<QuickChart, String>> charts)
		{
			for(String function : functions) {
				int offset = 0;
				StringBuilder builder = new StringBuilder(PREFIX);
				for(String clz : classes) {
					BenchCollection collection = collections.get(clz);
					if(collection == null) continue;
					Map<String, DoubleList> mapped = collection.buildChartData(function);
					for(String id : IDS) {
						DoubleList list = mapped.get(id);
						if(list == null) continue;
						builder.append("{label: '");
						builder.append(ID_TO_NAME.get(id)).append(" ").append(clz).append(": ").append(function);
						builder.append("', fill: false, borderDash: [10,20], borderDashOffset: ").append(offset).append(", ");
						builder.append(buildChartData(list)).append("},");
						offset+=5;
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
				charts.add(ObjectObjectPair.of(chart, baseFolder+"/"+function+".png"));
				
			}
		}
		
		private String buildChartData(DoubleList list) {
			StringJoiner joiner = new StringJoiner(", ");
			for(double entry : list) {
				joiner.add(Double.toString(entry));
			}
			return new StringBuilder().append("data: [").append(joiner).append("]").toString();
		}
	}
}

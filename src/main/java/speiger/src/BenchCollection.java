package speiger.src;

import java.util.List;
import java.util.Map;
import java.util.Set;

import speiger.src.TableGenerator.Alignment;
import speiger.src.TableGenerator.ColumnSettings;
import speiger.src.collections.doubles.lists.DoubleList;
import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;
import speiger.src.collections.objects.sets.ObjectLinkedOpenHashSet;
import speiger.src.collections.objects.utils.ObjectIterables;

public class BenchCollection {
	String collectionName;
	List<BenchFunction> functions = new ObjectArrayList<>();
	
	public BenchCollection(String collectionName) {
		this.collectionName = collectionName;
	}
	
	public String getCollectionName() {
		return collectionName;
	}
	
	public void addFunction(String function, int amount, String library, double time) {
		BenchFunction result = find(function, amount);
		if(result == null) {
			result = new BenchFunction(function, amount);
			functions.add(result);
		}
		result.addEntry(library, time);
	}
	
	public Map<String, DoubleList> buildChartData(String functionName) {
		Object2ObjectMap<String, DoubleList> mappedData = Object2ObjectMap.builder().linkedMap();
		for(BenchFunction function : functions) {
			if(function.getFunction().equals(functionName)) {
				function.fillIntoMappedData(mappedData);
			}
		}
		mappedData.values().forEach(T -> T.sort(null));
		return mappedData;
	}
	
	public String buildResult(ObjectList<String> order, Map<String, String> idToName) {
		if(functions.isEmpty()) return "";
		List<List<String>> table = new ObjectArrayList<>();
		table.add(getHeaderRow(order, idToName));
		for(BenchFunction function : functions) {
			table.add(function.createTableRow(order));
		}
		List<ColumnSettings> settings = new ObjectArrayList<>();
		settings.add(new ColumnSettings(1, 1, Alignment.CENTER));
		settings.add(new ColumnSettings(2, 2, Alignment.LEFT));
		settings.add(new ColumnSettings(2, 2, Alignment.RIGHT));
		for(int i = 0,m=order.size();i<m;i++) {
			settings.add(new ColumnSettings(2, 2, 3, "[,/]", Alignment.RIGHT));
		}
		settings.add(new ColumnSettings(1, 1, Alignment.CENTER));
		return TableGenerator.buildTable(table, settings, true);
	}
	
	public Set<String> getUsedLibraries() {
		Set<String> result = new ObjectLinkedOpenHashSet<>();
		for(int i = 0,m=functions.size();i<m;i++) {
			functions.get(i).fillInFunctions(result);
		}
		return result;
	}
	
	public void merge(BenchCollection other) {
		for(BenchFunction function : other.getFunctions()) {
			BenchFunction found = find(function.getFunction(), function.getAmount());
			if(found == null) {
				functions.add(function);
				continue;
			}
			found.merge(function);
		}
	}
	
	public void sort() {
		functions.sort(this::sortFunction);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Collection=").append(collectionName).append("\n");
		for(BenchFunction function : functions) {
			builder.append("   ").append(function).append("\n");
		}
		return builder.toString();
	}
	
	protected List<BenchFunction> getFunctions() {
		return functions;
	}
	
	private List<String> getHeaderRow(List<String> order, Map<String, String> idToName) {
		List<String> result = new ObjectArrayList<>();
		result.add("Action");
		result.add("Size");
		ObjectIterables.map(order, T -> idToName.get(T)+" Score").forEach(result::add);
		result.add("Units");
		return result;
	}
	
	private BenchFunction find(String function, int amount) {
		for(BenchFunction entry : functions) {
			if(entry.matches(function, amount)) {
				return entry;
			}
		}
		return null;
	}
	
	private int sortFunction(BenchFunction key, BenchFunction value) {
		int result = String.CASE_INSENSITIVE_ORDER.compare(key.getFunction(), value.getFunction());
		return result != 0 ? result : Integer.compare(key.getAmount(), value.getAmount());
	}
}

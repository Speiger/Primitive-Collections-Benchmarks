package speiger.src;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import speiger.src.collections.doubles.lists.DoubleArrayList;
import speiger.src.collections.doubles.lists.DoubleList;
import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.lists.ObjectList;
import speiger.src.collections.objects.maps.interfaces.Object2DoubleMap;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;

public class BenchFunction {
	private static final DecimalFormat FORMAT = new DecimalFormat("###,##0.0##");
	String functionName;
	int amount;
	Object2DoubleMap<String> library = Object2DoubleMap.builder().map();

	public BenchFunction(String functionName, int amount) {
		this.functionName = functionName;
		this.amount = amount;
	}
	
	public boolean matches(String functionName, int amount) {
		return this.functionName.equals(functionName) && this.amount == amount;
	}
	
	public void addEntry(String libraryName, double speeds) {
		library.put(libraryName, speeds);
	}
	
	public void merge(BenchFunction other) {
		library.putAllIfAbsent(other.getLibraries());
	}
	
	public void fillInFunctions(Set<String> libraryNames) {
		libraryNames.addAll(library.keySet());
	}
	
	public void fillIntoMappedData(Object2ObjectMap<String, DoubleList> listData) {
		for(Object2DoubleMap.Entry<String> entry : library.object2DoubleEntrySet()) {
			listData.supplyIfAbsent(entry.getKey(), DoubleArrayList::new).add(entry.getDoubleValue());
		}
	}
	
	public List<String> createTableRow(ObjectList<String> order) {
		List<String> list = new ObjectArrayList<>();
		list.add(functionName);
		list.add(Integer.toString(amount));
		order.map(T -> library.containsKey(T) ? FORMAT.format(library.getDouble(T)) : "N/A").forEach(list::add);
		list.add("µs/op");
		return list;
	}
	
	public String getFunction() {
		return functionName;
	}

	public int getAmount() {
		return amount;
	}
	
	protected Object2DoubleMap<String> getLibraries() {
		return library;
	}
	
	@Override
	public String toString() {
		return "Function="+functionName+", Amount="+amount+", Data="+library;
	}
}

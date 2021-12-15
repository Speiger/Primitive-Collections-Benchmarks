package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.PutMapBenchmarks;
import speiger.src.collections.ints.maps.interfaces.Int2DoubleMap;

public class PCPutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public Int2DoubleMap putMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().map(setSize);
		map.putAll(addedKeys, addedValues); //Could use a constructor but don't do it so it shows it uses a method not a constructor. Also this is just a a for loop in the implementation...
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().map();
		map.putAll(addedKeys, addedValues); 
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putLinkedMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().linkedMap(setSize);
		map.putAll(addedKeys, addedValues);
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyLinkedMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().linkedMap();
		map.putAll(addedKeys, addedValues);
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putArrayMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().arrayMap(setSize);
		map.putAll(addedKeys, addedValues);
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyArrayMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().arrayMap();
		map.putAll(addedKeys, addedValues);
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putRBTreeMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().rbTreeMap();
		map.putAll(addedKeys, addedValues);
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putAVLTreeMap() {
		Int2DoubleMap map = Int2DoubleMap.builder().avlTreeMap();
		map.putAll(addedKeys, addedValues);
		return map;
	}
}

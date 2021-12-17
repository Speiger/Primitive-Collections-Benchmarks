package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;

import it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap;
import speiger.src.collections.base.PutMapBenchmarks;

public class FastUtilPutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public Int2DoubleMap putResultHashMap() {
		Int2DoubleMap map = new Int2DoubleOpenHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyResultHashMap() {
		Int2DoubleMap map = new Int2DoubleOpenHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putResultLinkedHashMap() {
		Int2DoubleMap map = new Int2DoubleLinkedOpenHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyResultLinkedHashMap() {
		Int2DoubleMap map = new Int2DoubleLinkedOpenHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putResultArrayMap() {
		Int2DoubleMap map = new Int2DoubleArrayMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putEmptyResultArrayMap() {
		Int2DoubleMap map = new Int2DoubleArrayMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putResultRBTreeMap() {
		Int2DoubleMap map = new Int2DoubleRBTreeMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Int2DoubleMap putResultAVLTreeMap() {
		Int2DoubleMap map = new Int2DoubleAVLTreeMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}

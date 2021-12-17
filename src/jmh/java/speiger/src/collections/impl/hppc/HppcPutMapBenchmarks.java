package speiger.src.collections.impl.hppc;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.IntDoubleHashMap;
import com.carrotsearch.hppc.IntDoubleMap;
import com.carrotsearch.hppc.IntDoubleWormMap;

import speiger.src.collections.base.PutMapBenchmarks;

public class HppcPutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public IntDoubleMap putResultHashMap() {
		IntDoubleMap map = new IntDoubleHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public IntDoubleMap putEmptyResultHashMap() {
		IntDoubleMap map = new IntDoubleHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public IntDoubleMap putResultLinkedHashMap() {
		IntDoubleMap map = new IntDoubleWormMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public IntDoubleMap putEmptyResultLinkedHashMap() {
		IntDoubleMap map = new IntDoubleWormMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}
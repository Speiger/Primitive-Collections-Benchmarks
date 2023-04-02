package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;

import com.koloboke.collect.map.IntDoubleMap;
import com.koloboke.collect.map.hash.HashIntDoubleMaps;

import speiger.src.collections.base.PutMapBenchmarks;

public class KolobokePutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public IntDoubleMap putResultHashMap() {
		IntDoubleMap map = HashIntDoubleMaps.newMutableMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public IntDoubleMap putEmptyResultHashMap() {
		IntDoubleMap map = HashIntDoubleMaps.newMutableMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}
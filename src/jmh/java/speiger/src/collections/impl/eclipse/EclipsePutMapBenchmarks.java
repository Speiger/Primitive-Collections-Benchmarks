package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.PutMapBenchmarks;

public class EclipsePutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public MutableIntDoubleMap putResultHashMap() {
		MutableIntDoubleMap map = new IntDoubleHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public MutableIntDoubleMap putEmptyResultHashMap() {
		MutableIntDoubleMap map = new IntDoubleHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}

package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadMapBenchmarks;

public class EclipseReadMapBenchmarks extends ReadMapBenchmarks
{
	MutableIntDoubleMap map;
	
	@Override
	protected void initMaps()
	{
		map = new IntDoubleHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public void containsKeyResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void keySetResultHashMap(Blackhole hole) {
		for(MutableIntIterator iter = map.keySet().intIterator();iter.hasNext();hole.consume(iter.next()));
	}
	
	@Benchmark
	public void valuesResultHashMap(Blackhole hole) {
		for(MutableDoubleIterator iter = map.values().doubleIterator();iter.hasNext();hole.consume(iter.next()));
	}
	
}

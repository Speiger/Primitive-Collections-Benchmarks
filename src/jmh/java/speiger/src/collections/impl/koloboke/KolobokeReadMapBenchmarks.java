package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.koloboke.collect.DoubleIterator;
import com.koloboke.collect.IntIterator;
import com.koloboke.collect.map.IntDoubleMap;
import com.koloboke.collect.map.hash.HashIntDoubleMaps;
import com.koloboke.function.IntDoubleConsumer;

import speiger.src.collections.base.ReadMapBenchmarks;

public class KolobokeReadMapBenchmarks extends ReadMapBenchmarks
{
	IntDoubleMap map;
	
	@Override
	protected void initMaps()
	{
		map = HashIntDoubleMaps.newMutableMap(setSize);
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
	public void getOrDefaultResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void forEachResultHashMap(Blackhole hole) {
		map.forEach((IntDoubleConsumer)(K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	
	@Benchmark
	@SuppressWarnings("deprecation")
	public void keySetResultHashMap(Blackhole hole) {
		for(IntIterator iter = map.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	@SuppressWarnings("deprecation")
	public void valuesResultHashMap(Blackhole hole) {
		for(DoubleIterator iter = map.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
}

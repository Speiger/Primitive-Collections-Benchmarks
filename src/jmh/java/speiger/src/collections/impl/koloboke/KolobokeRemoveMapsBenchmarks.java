package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.koloboke.collect.map.IntDoubleMap;
import com.koloboke.collect.map.hash.HashIntDoubleMaps;

import speiger.src.collections.base.RemoveMapBenchmarks;

public class KolobokeRemoveMapsBenchmarks extends RemoveMapBenchmarks
{
	IntDoubleMap map;
	
	@Override
	protected void updateMap()
	{
		map = HashIntDoubleMaps.newMutableMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void replaceResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.replace(removeKeys[i], 5D));
		}
	}
}

package speiger.src.collections.impl.hppc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.carrotsearch.hppc.IntDoubleHashMap;
import com.carrotsearch.hppc.IntDoubleMap;
import com.carrotsearch.hppc.IntDoubleWormMap;

import speiger.src.collections.base.RemoveMapBenchmarks;

public class HppcRemoveMapsBenchmarks extends RemoveMapBenchmarks
{
	IntDoubleMap map;
	IntDoubleMap linkedMap;
	
	@Override
	protected void updateMap()
	{
		map = new IntDoubleHashMap(setSize);
		linkedMap = new IntDoubleWormMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
			linkedMap.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(linkedMap.remove(removeKeys[i]));
		}
	}
}

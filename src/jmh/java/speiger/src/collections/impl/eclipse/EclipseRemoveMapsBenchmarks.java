package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.RemoveMapBenchmarks;

public class EclipseRemoveMapsBenchmarks extends RemoveMapBenchmarks
{
	MutableIntDoubleMap map;
	
	@Override
	protected void updateMap()
	{
		map = new IntDoubleHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			map.removeKeyIfAbsent(removeKeys[i], 0D);
		}
	}
}

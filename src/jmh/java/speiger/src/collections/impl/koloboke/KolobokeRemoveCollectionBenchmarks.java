package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;

import com.koloboke.collect.set.IntSet;
import com.koloboke.collect.set.hash.HashIntSets;

import speiger.src.collections.base.RemoveCollectionBenchmarks;


public class KolobokeRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	IntSet set;
	
	@Override
	protected void updateCollection()
	{
		set = HashIntSets.newMutableSet();
		for(int i = 0;i<setSize;i++) {
			set.add(addedValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultHashSet() {
		for(int i = 0;i<100;i++) {
			set.removeInt(removeValues[i]);
		}
	}
}

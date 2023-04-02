package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;

import com.koloboke.collect.set.IntSet;
import com.koloboke.collect.set.hash.HashIntSets;

import speiger.src.collections.base.AddCollectionBenchmarks;


public class KolobokeAddCollectionBenchmarks extends AddCollectionBenchmarks
{	
	@Benchmark
	public IntSet addResultHashSet() {
	    IntSet result = HashIntSets.newMutableSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultHashSet() {
	    IntSet result = HashIntSets.newMutableSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
}

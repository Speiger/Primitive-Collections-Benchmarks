package speiger.src.collections.impl.koloboke;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.koloboke.collect.IntIterator;
import com.koloboke.collect.set.IntSet;
import com.koloboke.collect.set.hash.HashIntSets;
import com.koloboke.function.IntConsumer;

import speiger.src.collections.base.ReadCollectionBenchmarks;

@SuppressWarnings("deprecation")
public class KolobokeReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	IntSet set;
	
	@Override
	protected void initCollections()
	{
		set = HashIntSets.newMutableSet(setSize);
		for(int i = 0;i<setSize;i++) {
			set.add(addedValues[i]);
		}
	}
	
	@Benchmark
	public void containsResultHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateForLoopResultHashSet(Blackhole hole) {
		for(IntIterator iter = set.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultHashSet(Blackhole hole) {
		set.forEach((IntConsumer)hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultHashSet(Blackhole hole) {
		set.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public int[] toArrayResultHashSet() {
		return set.toIntArray();
	}
}

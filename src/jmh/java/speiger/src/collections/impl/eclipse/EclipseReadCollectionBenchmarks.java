package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadCollectionBenchmarks;


public class EclipseReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	MutableIntList arrayList;
	MutableIntSet set;
	
	@Override
	protected void initCollections()
	{
		arrayList = new IntArrayList(addedValues);
		set = new IntHashSet(addedValues);
	}
	
	@Benchmark
	public void containsResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void indexOfResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.indexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void lastIndexOfResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.lastIndexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void getResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.get(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateIndexResultArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.get(i));
		}
	}
	
	@Benchmark
	public void iterateForLoopResultArrayList(Blackhole hole) {
		for(MutableIntIterator iter = arrayList.intIterator();iter.hasNext();) {
			hole.consume(iter.next());
		}
	}
	
	@Benchmark
	public void iterateForEachResultArrayList(Blackhole hole) {
		arrayList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultArrayList(Blackhole hole) {
		arrayList.primitiveStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultHashSet(Blackhole hole) {
		for(MutableIntIterator iter = set.intIterator();iter.hasNext();) {
			hole.consume(iter.next());
		}
	}
	
	@Benchmark
	public void iterateForEachResultHashSet(Blackhole hole) {
		set.forEach(hole::consume);
	}
	
	@Benchmark
	public int[] toArrayResultArrayList() {
		return arrayList.toArray();
	}
	
	@Benchmark
	public int[] toArrayResultHashSet() {
		return set.toArray();
	}
}
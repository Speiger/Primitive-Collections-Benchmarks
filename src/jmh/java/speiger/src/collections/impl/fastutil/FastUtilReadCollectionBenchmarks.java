package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntRBTreeSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import speiger.src.collections.base.ReadCollectionBenchmarks;

public class FastUtilReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	IntList arrayList;
	IntSet set;
	IntSet linkedSet;
	IntSet arraySet;
	IntSet rbTreeSet;
	IntSet avlTreeSet;
	
	@Override
	protected void initCollections()
	{
		arrayList = new IntArrayList(addedValues);
		set = new IntOpenHashSet(addedValues);
		linkedSet = new IntLinkedOpenHashSet(addedValues);
		arraySet = new IntArraySet(addedValues);
		rbTreeSet = new IntRBTreeSet(addedValues);
		avlTreeSet = new IntAVLTreeSet(addedValues);
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
			hole.consume(arrayList.getInt(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultLinkedHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultArraySet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arraySet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultRBTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultAVLTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateIndexResultArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.getInt(i));
		}
	}
	
	@Benchmark
	public void iterateForLoopResultArrayList(Blackhole hole) {
		for(IntIterator iter = arrayList.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultArrayList(Blackhole hole) {
		arrayList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultArrayList(Blackhole hole) {
		arrayList.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultHashSet(Blackhole hole) {
		for(IntIterator iter = set.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultHashSet(Blackhole hole) {
		set.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultHashSet(Blackhole hole) {
		set.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultLinkedHashSet(Blackhole hole) {
		for(IntIterator iter = linkedSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultLinkedHashSet(Blackhole hole) {
		linkedSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultLinkedHashSet(Blackhole hole) {
		linkedSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultArraySet(Blackhole hole) {
		for(IntIterator iter = arraySet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultArraySet(Blackhole hole) {
		arraySet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultArraySet(Blackhole hole) {
		arraySet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultRBTreeSet(Blackhole hole) {
		for(IntIterator iter = rbTreeSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultRBTreeSet(Blackhole hole) {
		rbTreeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultRBTreeSet(Blackhole hole) {
		rbTreeSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultAVLTreeSet(Blackhole hole) {
		for(IntIterator iter = avlTreeSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultAVLTreeSet(Blackhole hole) {
		avlTreeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultAVLTreeSet(Blackhole hole) {
		avlTreeSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public int[] toArrayResultArrayList() {
		return arrayList.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultHashSet() {
		return set.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultLinkedHashSet() {
		return linkedSet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultArraySet() {
		return arraySet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultRBTreeSet() {
		return rbTreeSet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultAVLTreeSet() {
		return avlTreeSet.toIntArray();
	}
}

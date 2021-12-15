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
	public void containsArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void indexOfArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.indexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void lastIndexOfArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.lastIndexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void getArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.getInt(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsLinkedSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsArraySet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arraySet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsRBTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsAVLTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateIndexArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.getInt(i));
		}
	}
	
	@Benchmark
	public void iterateForArrayList(Blackhole hole) {
		for(IntIterator iter = arrayList.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachArrayList(Blackhole hole) {
		arrayList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamArrayList(Blackhole hole) {
		arrayList.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForSet(Blackhole hole) {
		for(IntIterator iter = set.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachSet(Blackhole hole) {
		set.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamSet(Blackhole hole) {
		set.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLinkedSet(Blackhole hole) {
		for(IntIterator iter = linkedSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachLinkedSet(Blackhole hole) {
		linkedSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamLinkedSet(Blackhole hole) {
		linkedSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForArraySet(Blackhole hole) {
		for(IntIterator iter = arraySet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachArraySet(Blackhole hole) {
		arraySet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamArraySet(Blackhole hole) {
		arraySet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForRBTreeSet(Blackhole hole) {
		for(IntIterator iter = rbTreeSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachRBTreeSet(Blackhole hole) {
		rbTreeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamRBTreeSet(Blackhole hole) {
		rbTreeSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForAVLTreeSet(Blackhole hole) {
		for(IntIterator iter = avlTreeSet.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachAVLTreeSet(Blackhole hole) {
		avlTreeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamAVLTreeSet(Blackhole hole) {
		avlTreeSet.intStream().forEach(hole::consume);
	}
	
	@Benchmark
	public int[] toArrayArrayList() {
		return arrayList.toIntArray();
	}
	
	@Benchmark
	public int[] toArraySet() {
		return set.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayLinkedSet() {
		return linkedSet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayArraySet() {
		return arraySet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayRBTreeSet() {
		return rbTreeSet.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayAVLTreeSet() {
		return avlTreeSet.toIntArray();
	}
}

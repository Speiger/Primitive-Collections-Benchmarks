package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadBenchmarks;
import speiger.src.collections.ints.collections.IntIterator;
import speiger.src.collections.ints.lists.IntArrayList;
import speiger.src.collections.ints.lists.IntLinkedList;
import speiger.src.collections.ints.lists.IntList;
import speiger.src.collections.ints.sets.IntAVLTreeSet;
import speiger.src.collections.ints.sets.IntLinkedOpenHashSet;
import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntRBTreeSet;
import speiger.src.collections.ints.sets.IntSet;

public class PCReadBenchmarks extends ReadBenchmarks
{
	IntList arrayList;
	IntList linkedList;
	IntSet set;
	IntSet linkedSet;
	IntSet rbTreeSet;
	IntSet avlTreeSet;
	
	@Override
	protected void initCollections()
	{
		arrayList = new IntArrayList(addedValues);
		linkedList = new IntLinkedList(addedValues);
		set = new IntOpenHashSet(addedValues);
		linkedSet = new IntLinkedOpenHashSet(addedValues);
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
	public void containsLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	@Measurement(batchSize = 10, iterations = 1)
	public void indexOfLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.indexOf(testValues[i]));
		}
	}
	
	@Benchmark
	@Measurement(batchSize = 10, iterations = 1)
	public void lastIndexOfLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.lastIndexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void getLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.getInt(testValues[i]));
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
		arrayList.primitiveStream().forEach(hole::consume);
	}
	
	@Benchmark
	@Measurement(batchSize = 10, iterations = 1)
	public void iterateIndexLinkedList(Blackhole hole) {
		for(int i = 0;i<Math.min(setSize, 1000);i++) {
			hole.consume(linkedList.getInt(i));
		}
	}
	
	@Benchmark
	public void iterateForLinkedList(Blackhole hole) {
		for(IntIterator iter = linkedList.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachLinkedList(Blackhole hole) {
		linkedList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamLinkedList(Blackhole hole) {
		linkedList.primitiveStream().forEach(hole::consume);
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
		set.primitiveStream().forEach(hole::consume);
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
		linkedSet.primitiveStream().forEach(hole::consume);
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
		rbTreeSet.primitiveStream().forEach(hole::consume);
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
		avlTreeSet.primitiveStream().forEach(hole::consume);
	}
}

package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadCollectionBenchmarks;
import speiger.src.collections.ints.collections.IntIterator;
import speiger.src.collections.ints.lists.IntArrayList;
import speiger.src.collections.ints.lists.IntLinkedList;
import speiger.src.collections.ints.lists.IntList;
import speiger.src.collections.ints.queues.IntArrayFIFOQueue;
import speiger.src.collections.ints.queues.IntArrayPriorityQueue;
import speiger.src.collections.ints.queues.IntHeapPriorityQueue;
import speiger.src.collections.ints.queues.IntPriorityDequeue;
import speiger.src.collections.ints.queues.IntPriorityQueue;
import speiger.src.collections.ints.sets.IntAVLTreeSet;
import speiger.src.collections.ints.sets.IntArraySet;
import speiger.src.collections.ints.sets.IntLinkedOpenHashSet;
import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntRBTreeSet;
import speiger.src.collections.ints.sets.IntSet;

public class PCReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	IntList arrayList;
	IntList linkedList;
	IntSet set;
	IntSet linkedSet;
	IntSet arraySet;
	IntSet rbTreeSet;
	IntSet avlTreeSet;
	IntPriorityDequeue fifoQueue;
	IntPriorityQueue heapQueue;
	IntPriorityQueue arrayQueue;
	
	@Override
	protected void initCollections()
	{
		arrayList = new IntArrayList(addedValues);
		linkedList = new IntLinkedList(addedValues);
		set = new IntOpenHashSet(addedValues);
		linkedSet = new IntLinkedOpenHashSet(addedValues);
		arraySet = new IntArraySet(addedValues);
		rbTreeSet = new IntRBTreeSet(addedValues);
		avlTreeSet = new IntAVLTreeSet(addedValues);
		fifoQueue = new IntArrayFIFOQueue(addedValues);
		heapQueue = new IntHeapPriorityQueue(addedValues);
		arrayQueue = new IntArrayPriorityQueue(addedValues);
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
	public void containsResultLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.contains(testValues[i]));
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
		arrayList.primitiveStream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultLinkedList(Blackhole hole) {
		for(IntIterator iter = linkedList.iterator();iter.hasNext();) {
			hole.consume(iter.nextInt());
		}
	}
	
	@Benchmark
	public void iterateForEachResultLinkedList(Blackhole hole) {
		linkedList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultLinkedList(Blackhole hole) {
		linkedList.primitiveStream().forEach(hole::consume);
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
		set.primitiveStream().forEach(hole::consume);
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
		linkedSet.primitiveStream().forEach(hole::consume);
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
		arraySet.primitiveStream().forEach(hole::consume);
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
		rbTreeSet.primitiveStream().forEach(hole::consume);
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
		avlTreeSet.primitiveStream().forEach(hole::consume);
	}
	
	@Benchmark
	public int[] toArrayResultArrayList() {
		return arrayList.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultLinkedList() {
		return linkedList.toIntArray();
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
	
	@Benchmark
	public int[] toArrayResultFIFOQueue() {
		return fifoQueue.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultHeapQueue() {
		return heapQueue.toIntArray();
	}
	
	@Benchmark
	public int[] toArrayResultArrayQueue() {
		return arrayQueue.toIntArray();
	}
}

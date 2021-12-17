package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.RemoveCollectionBenchmarks;
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
import speiger.src.collections.ints.sets.IntNavigableSet;
import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntRBTreeSet;
import speiger.src.collections.ints.sets.IntSet;

public class PCRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	IntList arrayList;
	IntLinkedList linkedList;
	IntSet set;
	IntSet linkedSet;
	IntSet arraySet;
	IntNavigableSet rbTreeSet;
	IntNavigableSet avlTreeSet;
	IntPriorityDequeue fifoQueue;
	IntPriorityQueue heapQueue;
	IntPriorityQueue arrayQueue;
	
	@Override
	protected void updateCollection()
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
	public void removeResultArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.remInt(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultLinkedList() {
		for(int i = 0;i<100;i++) {
			linkedList.remInt(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstResultLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.dequeue());
		}
	}
	
	@Benchmark
	public void pollLastResultLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.dequeueLast());
		}
	}
	
	@Benchmark
	public void removeResultHashSet() {
		for(int i = 0;i<100;i++) {
			set.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultLinkedHashSet() {
		for(int i = 0;i<100;i++) {
			linkedSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultRBTreeSet() {
		for(int i = 0;i<100;i++) {
			rbTreeSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstResultRBTreeSet(Blackhole hole) {
		while(!rbTreeSet.isEmpty()) {
			hole.consume(rbTreeSet.pollFirstInt());
		}
	}
	
	@Benchmark
	public void pollLastResultRBTreeSet(Blackhole hole) {
		while(!rbTreeSet.isEmpty()) {
			hole.consume(rbTreeSet.pollLastInt());
		}
	}
	
	@Benchmark
	public void removeResultAVLTreeSet() {
		for(int i = 0;i<100;i++) {
			avlTreeSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstResultAVLTreeSet(Blackhole hole) {
		while(!avlTreeSet.isEmpty()) {
			hole.consume(avlTreeSet.pollFirstInt());
		}
	}
	
	@Benchmark
	public void pollLastResultAVLTreeSet(Blackhole hole) {
		while(!avlTreeSet.isEmpty()) {
			hole.consume(avlTreeSet.pollLastInt());
		}
	}
	
	@Benchmark
	public void removeResultFIFOQueue() {
		for(int i = 0;i<100;i++) {
			fifoQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstResultFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.dequeue());
		}
	}
	
	@Benchmark
	public void pollLastResultFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.dequeueLast());
		}
	}
	
	@Benchmark
	public void removeResultHeapQueue() {
		for(int i = 0;i<100;i++) {
			heapQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollResultHeapQueue(Blackhole hole) {
		while(!heapQueue.isEmpty()) {
			hole.consume(heapQueue.dequeue());
		}
	}
	
	@Benchmark
	public void removeResultArrayQueue() {
		for(int i = 0;i<100;i++) {
			arrayQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollResultArrayQueue(Blackhole hole) {
		while(!arrayQueue.isEmpty()) {
			hole.consume(arrayQueue.dequeue());
		}
	}
}

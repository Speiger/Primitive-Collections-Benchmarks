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
	public void removeArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.remInt(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeLinkedList() {
		for(int i = 0;i<100;i++) {
			linkedList.remInt(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.dequeue());
		}
	}
	
	@Benchmark
	public void pollLastLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.dequeueLast());
		}
	}
	
	@Benchmark
	public void removeSet() {
		for(int i = 0;i<100;i++) {
			set.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeLinkedSet() {
		for(int i = 0;i<100;i++) {
			linkedSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeRBTreeSet() {
		for(int i = 0;i<100;i++) {
			rbTreeSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstRBTreeSet(Blackhole hole) {
		while(!rbTreeSet.isEmpty()) {
			hole.consume(rbTreeSet.pollFirstInt());
		}
	}
	
	@Benchmark
	public void pollLastRBTreeSet(Blackhole hole) {
		while(!rbTreeSet.isEmpty()) {
			hole.consume(rbTreeSet.pollLastInt());
		}
	}
	
	@Benchmark
	public void removeAVLTreeSet() {
		for(int i = 0;i<100;i++) {
			avlTreeSet.remove(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstAVLTreeSet(Blackhole hole) {
		while(!avlTreeSet.isEmpty()) {
			hole.consume(avlTreeSet.pollFirstInt());
		}
	}
	
	@Benchmark
	public void pollLastAVLTreeSet(Blackhole hole) {
		while(!avlTreeSet.isEmpty()) {
			hole.consume(avlTreeSet.pollLastInt());
		}
	}
	
	@Benchmark
	public void removeFIFOQueue() {
		for(int i = 0;i<100;i++) {
			fifoQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.dequeue());
		}
	}
	
	@Benchmark
	public void pollLastFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.dequeueLast());
		}
	}
	
	@Benchmark
	public void removeHeapQueue() {
		for(int i = 0;i<100;i++) {
			heapQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollHeapQueue(Blackhole hole) {
		while(!heapQueue.isEmpty()) {
			hole.consume(heapQueue.dequeue());
		}
	}
	
	@Benchmark
	public void removeArrayQueue() {
		for(int i = 0;i<100;i++) {
			arrayQueue.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollArrayQueue(Blackhole hole) {
		while(!arrayQueue.isEmpty()) {
			hole.consume(arrayQueue.dequeue());
		}
	}
}

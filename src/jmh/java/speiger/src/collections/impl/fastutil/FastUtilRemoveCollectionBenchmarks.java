package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayFIFOQueue;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntHeapPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntRBTreeSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import speiger.src.collections.base.RemoveCollectionBenchmarks;


public class FastUtilRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	IntList arrayList;
	IntSet set;
	IntSet linkedSet;
	IntSet arraySet;
	IntSet rbTreeSet;
	IntSet avlTreeSet;
	IntPriorityQueue fifoQueue;
	IntPriorityQueue heapQueue;
	IntPriorityQueue arrayQueue;
	
	@Override
	protected void updateCollection()
	{
		arrayList = new IntArrayList(addedValues);
		set = new IntOpenHashSet(addedValues);
		linkedSet = new IntLinkedOpenHashSet(addedValues);
		arraySet = new IntArraySet(addedValues);
		rbTreeSet = new IntRBTreeSet(addedValues);
		avlTreeSet = new IntAVLTreeSet(addedValues);
		fifoQueue = new IntArrayFIFOQueue();
		for(int i = 0;i<addedValues.length;i++) {
			fifoQueue.enqueue(addedValues[i]);
		}
		heapQueue = new IntHeapPriorityQueue(addedValues);
		arrayQueue = new IntArrayPriorityQueue(addedValues);
	}
	
	@Benchmark
	public void removeArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.rem(removeValues[i]);
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
	
//	@Benchmark
//	public void removeRBTreeSet() {
//		for(int i = 0;i<100;i++) {
//			rbTreeSet.remove(removeValues[i]); //Was Causing a freeze thats why disabled
//		}
//	}
//	
//	@Benchmark
//	public void removeAVLTreeSet() {
//		for(int i = 0;i<100;i++) {
//			avlTreeSet.remove(removeValues[i]); //Was Causing a freeze thats why disabled
//		}
//	}
	
	@Benchmark
	public void pollFirstFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.dequeueInt());
		}
	}
	
	@Benchmark
	public void pollHeapQueue(Blackhole hole) {
		while(!heapQueue.isEmpty()) {
			hole.consume(heapQueue.dequeueInt());
		}
	}
	
	@Benchmark
	public void pollArrayQueue(Blackhole hole) {
		while(!arrayQueue.isEmpty()) {
			hole.consume(arrayQueue.dequeueInt());
		}
	}
}

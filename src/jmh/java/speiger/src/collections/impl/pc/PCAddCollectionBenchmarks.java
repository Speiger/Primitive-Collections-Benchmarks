package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.AddCollectionBenchmarks;
import speiger.src.collections.ints.lists.IntArrayList;
import speiger.src.collections.ints.lists.IntLinkedList;
import speiger.src.collections.ints.lists.IntList;
import speiger.src.collections.ints.queues.IntArrayFIFOQueue;
import speiger.src.collections.ints.queues.IntArrayPriorityQueue;
import speiger.src.collections.ints.queues.IntHeapPriorityQueue;
import speiger.src.collections.ints.queues.IntPriorityQueue;
import speiger.src.collections.ints.sets.IntAVLTreeSet;
import speiger.src.collections.ints.sets.IntArraySet;
import speiger.src.collections.ints.sets.IntLinkedOpenHashSet;
import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntRBTreeSet;
import speiger.src.collections.ints.sets.IntSet;

public class PCAddCollectionBenchmarks extends AddCollectionBenchmarks
{
	@Benchmark
	public IntList addResultArrayList() {
	    IntList result = new IntArrayList(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntList addEmptyResultArrayList() {
	    IntList result = new IntArrayList();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntList addResultLinkedList() {
	    IntList result = new IntLinkedList();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultHashSet() {
	    IntSet result = new IntOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultHashSet() {
	    IntSet result = new IntOpenHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultLinkedHashSet() {
	    IntSet result = new IntLinkedOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultLinkedHashSet() {
	    IntSet result = new IntLinkedOpenHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultArraySet() {
	    IntSet result = new IntArraySet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultArraySet() {
	    IntSet result = new IntArraySet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultRBTreeSet() {
	    IntSet result = new IntRBTreeSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultAVLTreeSet() {
	    IntSet result = new IntAVLTreeSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntPriorityQueue addResultFIFOQueue() {
		IntPriorityQueue result = new IntArrayFIFOQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyResultFIFOQueue() {
		IntPriorityQueue result = new IntArrayFIFOQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addResultHeapQueue() {
		IntPriorityQueue result = new IntHeapPriorityQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyResultHeapQueue() {
		IntPriorityQueue result = new IntHeapPriorityQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addResultArrayQueue() {
		IntPriorityQueue result = new IntArrayPriorityQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyResultArrayQueue() {
		IntPriorityQueue result = new IntArrayPriorityQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
}

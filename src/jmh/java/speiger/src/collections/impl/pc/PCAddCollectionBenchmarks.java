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
	public IntList addList() {
	    IntList result = new IntArrayList(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntList addEmptyList() {
	    IntList result = new IntArrayList();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntList addLinkedList() {
	    IntList result = new IntLinkedList();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addSetBenchmark() {
	    IntSet result = new IntOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptySetBenchmark() {
	    IntSet result = new IntOpenHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addLinkedSetBenchmark() {
	    IntSet result = new IntLinkedOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyLinkedSetBenchmark() {
	    IntSet result = new IntLinkedOpenHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addArraySetBenchmark() {
	    IntSet result = new IntArraySet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyArraySetBenchmark() {
	    IntSet result = new IntArraySet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addRBTreeSetBenchmark() {
	    IntSet result = new IntRBTreeSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addAVLTreeSetBenchmark() {
	    IntSet result = new IntAVLTreeSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntPriorityQueue addFIFOQueueBenchmark() {
		IntPriorityQueue result = new IntArrayFIFOQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyFIFOQueueBenchmark() {
		IntPriorityQueue result = new IntArrayFIFOQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addHeapQueueBenchmark() {
		IntPriorityQueue result = new IntHeapPriorityQueue(setSize);
		result.clear();//Due to a bug in the implementation this has to be done
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyHeapQueueBenchmark() {
		IntPriorityQueue result = new IntHeapPriorityQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addArrayQueueBenchmark() {
		IntPriorityQueue result = new IntArrayPriorityQueue(setSize);
		result.clear();//Due to a bug in the implementation this has to be done
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyArrayQueueBenchmark() {
		IntPriorityQueue result = new IntArrayPriorityQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
}

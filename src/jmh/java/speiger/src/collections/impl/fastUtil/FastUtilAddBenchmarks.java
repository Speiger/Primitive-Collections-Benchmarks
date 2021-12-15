package speiger.src.collections.impl.fastUtil;

import org.openjdk.jmh.annotations.Benchmark;

import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntHeapPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntPriorityQueue;
import it.unimi.dsi.fastutil.ints.IntRBTreeSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import speiger.src.collections.base.AddBenchmarks;

public class FastUtilAddBenchmarks extends AddBenchmarks
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
	public IntPriorityQueue addArrayQueueBenchmark() {
		IntPriorityQueue result = new IntArrayPriorityQueue(setSize);
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
	
	@Benchmark
	public IntPriorityQueue addHeapQueueBenchmark() {
		IntPriorityQueue result = new IntHeapPriorityQueue(setSize);
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
	public IntPriorityQueue addSortedArrayQueueBenchmark() {
		IntPriorityQueue result = new IntArrayPriorityQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptySortedArrayQueueBenchmark() {
		IntPriorityQueue result = new IntArrayPriorityQueue();
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
}

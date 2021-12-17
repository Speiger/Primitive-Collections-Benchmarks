package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;

import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
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
import speiger.src.collections.base.AddCollectionBenchmarks;


public class FastUtilAddCollectionBenchmarks extends AddCollectionBenchmarks
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
		IntPriorityQueue result = new IntArrayPriorityQueue(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.enqueue(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntPriorityQueue addEmptyResultFIFOQueue() {
		IntPriorityQueue result = new IntArrayPriorityQueue();
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

package speiger.src.collections.impl.hppc;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.IntArrayDeque;
import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntDeque;
import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntIndexedContainer;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;

import speiger.src.collections.base.AddCollectionBenchmarks;


public class HppcAddCollectionBenchmarks extends AddCollectionBenchmarks
{
	@Benchmark
	public IntIndexedContainer addResultArrayList() {
		IntIndexedContainer result = new IntArrayList(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntIndexedContainer addEmptyResultArrayList() {
		IntIndexedContainer result = new IntArrayList();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultHashSet() {
	    IntSet result = new IntHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultHashSet() {
	    IntSet result = new IntHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addResultLinkedHashSet() {
	    IntSet result = new IntWormSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntSet addEmptyResultLinkedHashSet() {
	    IntSet result = new IntWormSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public IntDeque addResultFIFOQueue() {
		IntDeque result = new IntArrayDeque(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.addLast(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public IntDeque addEmptyResultFIFOQueue() {
		IntDeque result = new IntArrayDeque();
	    for(int i = 0; i < setSize; i++) {
	        result.addLast(addedValues[i]);
	    }
		return result;
	}
}

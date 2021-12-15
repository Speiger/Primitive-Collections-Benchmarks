package speiger.src.collections.impl.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.AddCollectionBenchmarks;

public class JavaAddCollectionBenchmarks extends AddCollectionBenchmarks
{
	@Benchmark
	public List<Integer> addList() {
		List<Integer> result = new ArrayList<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public List<Integer> addEmptyList() {
		List<Integer> result = new ArrayList<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public List<Integer> addLinkedList() {
		List<Integer> result = new LinkedList<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addSetBenchmark() {
		Set<Integer> result = new HashSet<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addEmptySetBenchmark() {
		Set<Integer> result = new HashSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addLinkedSetBenchmark() {
		Set<Integer> result = new LinkedHashSet<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addEmptyLinkedSetBenchmark() {
	    Set<Integer> result = new LinkedHashSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addTreeSetBenchmark() {
	    Set<Integer> result = new TreeSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Deque<Integer> addFIFOQueueBenchmark() {
		Deque<Integer> result = new ArrayDeque<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public Deque<Integer> addEmptyFIFOQueueBenchmark() {
		Deque<Integer> result = new ArrayDeque<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
		return result;
	}
}

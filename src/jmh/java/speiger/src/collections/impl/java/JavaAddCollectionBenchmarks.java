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
	public List<Integer> addResultArrayList() {
		List<Integer> result = new ArrayList<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public List<Integer> addEmptyResultArrayList() {
		List<Integer> result = new ArrayList<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public List<Integer> addResultLinkedList() {
		List<Integer> result = new LinkedList<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addResultHashSet() {
		Set<Integer> result = new HashSet<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addEmptyResultHashSet() {
		Set<Integer> result = new HashSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addResultLinkedHashSet() {
		Set<Integer> result = new LinkedHashSet<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addEmptyResultLinkedHashSet() {
	    Set<Integer> result = new LinkedHashSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Set<Integer> addResultTreeSet() {
	    Set<Integer> result = new TreeSet<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public Deque<Integer> addResultFIFOQueue() {
		Deque<Integer> result = new ArrayDeque<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
		return result;
	}
	
	@Benchmark
	public Deque<Integer> addEmptyResultFIFOQueue() {
		Deque<Integer> result = new ArrayDeque<>();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
		return result;
	}
}

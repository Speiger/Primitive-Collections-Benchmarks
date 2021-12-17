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
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadCollectionBenchmarks;

public class JavaReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	List<Integer> arrayList;
	List<Integer> linkedList;
	Set<Integer> set;
	Set<Integer> linkedSet;
	Set<Integer> treeSet;
	Deque<Integer> dequeue;
	
	@Override
	protected void initCollections()
	{
		arrayList = new ArrayList<>(setSize);
		linkedList = new LinkedList<>();
		set = new HashSet<>(setSize);
		linkedSet = new LinkedHashSet<>(setSize);
		treeSet = new TreeSet<>();
		dequeue = new ArrayDeque<>();
		for(int i = 0;i<setSize;i++)
		{
			arrayList.add(addedValues[i]);
			linkedList.add(addedValues[i]);
			set.add(addedValues[i]);
			linkedSet.add(addedValues[i]);
			treeSet.add(addedValues[i]);
			dequeue.add(addedValues[i]);
		}
	}
	
	@Benchmark
	public void containsResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void indexOfResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.indexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void lastIndexOfResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.lastIndexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void getResultArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.get(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultLinkedHashSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsResultFIFOQueue(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(dequeue.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateIndexResultArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.get(i));
		}
	}
	
	@Benchmark
	public void iterateForLoopResultArrayList(Blackhole hole) {
		for(Integer value : arrayList) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultArrayList(Blackhole hole) {
		arrayList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultArrayList(Blackhole hole) {
		arrayList.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultLinkedList(Blackhole hole) {
		for(Integer value : linkedList) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultLinkedList(Blackhole hole) {
		linkedList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultLinkedList(Blackhole hole) {
		linkedList.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultHashSet(Blackhole hole) {
		for(Integer value : set) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultHashSet(Blackhole hole) {
		set.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultHashSet(Blackhole hole) {
		set.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultLinkedHashSet(Blackhole hole) {
		for(Integer value : linkedSet) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultLinkedHashSet(Blackhole hole) {
		linkedSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultLinkedHashSet(Blackhole hole) {
		linkedSet.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLoopResultTreeSet(Blackhole hole) {
		for(Integer value : treeSet) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultTreeSet(Blackhole hole) {
		treeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamResultTreeSet(Blackhole hole) {
		treeSet.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public Integer[] toArrayResultArrayList() {
		return arrayList.toArray(new Integer[arrayList.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayResultLinkedList() {
		return linkedList.toArray(new Integer[linkedList.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayResultHashSet() {
		return set.toArray(new Integer[set.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayResultLinkedHashSet() {
		return linkedSet.toArray(new Integer[linkedSet.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayResultTreeSet() {
		return treeSet.toArray(new Integer[treeSet.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayResultFIFOQueue() {
		return dequeue.toArray(new Integer[dequeue.size()]);
	}
}

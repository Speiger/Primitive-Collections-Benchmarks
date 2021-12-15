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
	public void containsArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void indexOfArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.indexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void lastIndexOfArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.lastIndexOf(testValues[i]));
		}
	}
	
	@Benchmark
	public void getArrayList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayList.get(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsLinkedList(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedList.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(set.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsLinkedSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsTreeSet(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeSet.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void containsQueue(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(dequeue.contains(testValues[i]));
		}
	}
	
	@Benchmark
	public void iterateIndexArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.get(i));
		}
	}
	
	@Benchmark
	public void iterateForArrayList(Blackhole hole) {
		for(Integer value : arrayList) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachArrayList(Blackhole hole) {
		arrayList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamArrayList(Blackhole hole) {
		arrayList.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLinkedList(Blackhole hole) {
		for(Integer value : linkedList) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachLinkedList(Blackhole hole) {
		linkedList.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamLinkedList(Blackhole hole) {
		linkedList.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForSet(Blackhole hole) {
		for(Integer value : set) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachSet(Blackhole hole) {
		set.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamSet(Blackhole hole) {
		set.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForLinkedSet(Blackhole hole) {
		for(Integer value : linkedSet) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachLinkedSet(Blackhole hole) {
		linkedSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamLinkedSet(Blackhole hole) {
		linkedSet.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateForTreeSet(Blackhole hole) {
		for(Integer value : treeSet) {
			hole.consume(value);
		}
	}
	
	@Benchmark
	public void iterateForEachTreeSet(Blackhole hole) {
		treeSet.forEach(hole::consume);
	}
	
	@Benchmark
	public void iterateStreamTreeSet(Blackhole hole) {
		treeSet.stream().forEach(hole::consume);
	}
	
	@Benchmark
	public Integer[] toArrayArrayList() {
		return arrayList.toArray(new Integer[arrayList.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayLinkedList() {
		return linkedList.toArray(new Integer[linkedList.size()]);
	}
	
	@Benchmark
	public Integer[] toArraySet() {
		return set.toArray(new Integer[set.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayLinkedSet() {
		return linkedSet.toArray(new Integer[linkedSet.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayTreeSet() {
		return treeSet.toArray(new Integer[treeSet.size()]);
	}
	
	@Benchmark
	public Integer[] toArrayFIFOQueue() {
		return dequeue.toArray(new Integer[dequeue.size()]);
	}
}

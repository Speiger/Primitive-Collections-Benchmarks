package speiger.src.collections.impl.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.RemoveCollectionBenchmarks;

public class JavaRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	List<Integer> arrayList;
	LinkedList<Integer> linkedList;
	Set<Integer> set;
	Set<Integer> linkedSet;
	NavigableSet<Integer> treeSet;
	Deque<Integer> dequeue;
	
	@Override
	protected void updateCollection()
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
	public void removeArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void removeLinkedList() {
		for(int i = 0;i<100;i++) {
			linkedList.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void pollFirstLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.pollFirst());
		}
	}
	
	@Benchmark
	public void pollLastLinkedList(Blackhole hole) {
		while(!linkedList.isEmpty()) {
			hole.consume(linkedList.pollLast());
		}
	}
	
	@Benchmark
	public void removeSet() {
		for(int i = 0;i<100;i++) {
			set.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void removeLinkedSet() {
		for(int i = 0;i<100;i++) {
			linkedSet.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void removeTreeSet() {
		for(int i = 0;i<100;i++) {
			treeSet.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void pollFirstTreeSet(Blackhole hole) {
		while(!treeSet.isEmpty()) {
			hole.consume(treeSet.pollFirst());
		}
	}
	
	@Benchmark
	public void pollLastTreeSet(Blackhole hole) {
		while(!treeSet.isEmpty()) {
			hole.consume(treeSet.pollLast());
		}
	}
	
	public void removeFIFOQueue() {
		for(int i = 0;i<100;i++) {
			dequeue.remove(Integer.valueOf(removeValues[i]));
		}
	}
	
	@Benchmark
	public void pollFirstFIFOQueue(Blackhole hole) {
		while(!dequeue.isEmpty()) {
			hole.consume(dequeue.pollFirst());
		}
	}
	
	@Benchmark
	public void pollLastFIFOQueue(Blackhole hole) {
		while(!dequeue.isEmpty()) {
			hole.consume(dequeue.pollLast());
		}
	}
}

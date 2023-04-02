package speiger.src.collections.impl.hppc;

import java.util.function.Consumer;
import java.util.stream.StreamSupport;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntIndexedContainer;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;
import com.carrotsearch.hppc.cursors.IntCursor;

import speiger.src.collections.base.ReadCollectionBenchmarks;

public class HppcReadCollectionBenchmarks extends ReadCollectionBenchmarks
{
	IntIndexedContainer arrayList;
	IntSet set;
	IntSet linkedSet;
	
	@Override
	protected void initCollections()
	{
		arrayList = new IntArrayList(setSize);
		set = new IntHashSet(setSize);
		linkedSet = new IntWormSet(setSize);
		for(int i = 0;i<setSize;i++) {
			arrayList.add(addedValues[i]);
			set.add(addedValues[i]);
			linkedSet.add(addedValues[i]);
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
	public void iterateIndexResultArrayList(Blackhole hole) {
		for(int i = 0;i<setSize;i++) {
			hole.consume(arrayList.get(i));
		}
	}
	
	@Benchmark
	public void iterateForLoopResultArrayList(Blackhole hole) {
		for(IntCursor cursor : arrayList) {
			hole.consume(cursor.value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultArrayList(Blackhole hole) {
		Consumer<IntCursor> action = T -> hole.consume(T.value);
		arrayList.forEach(action);
	}
	
	@Benchmark
	public void iterateStreamResultArrayList(Blackhole hole) {
		StreamSupport.stream(arrayList.spliterator(), false).forEach(T -> hole.consume(T.value));
	}
	
	@Benchmark
	public void iterateForLoopResultHashSet(Blackhole hole) {
		for(IntCursor cursor : set) {
			hole.consume(cursor.value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultHashSet(Blackhole hole) {
		Consumer<IntCursor> action = T -> hole.consume(T.value);
		set.forEach(action);
	}
	
	@Benchmark
	public void iterateStreamResultHashSet(Blackhole hole) {
		StreamSupport.stream(set.spliterator(), false).forEach(T -> hole.consume(T.value));
	}
	
	@Benchmark
	public void iterateForLoopResultLinkedHashSet(Blackhole hole) {
		for(IntCursor cursor : linkedSet) {
			hole.consume(cursor.value);
		}
	}
	
	@Benchmark
	public void iterateForEachResultLinkedHashSet(Blackhole hole) {
		Consumer<IntCursor> action = T -> hole.consume(T.value);
		linkedSet.forEach(action);
	}
	
	@Benchmark
	public void iterateStreamResultLinkedHashSet(Blackhole hole) {
		StreamSupport.stream(linkedSet.spliterator(), false).forEach(T -> hole.consume(T.value));
	}
	
	@Benchmark
	public int[] toArrayResultArrayList() {
		return arrayList.toArray();
	}
	
	@Benchmark
	public int[] toArrayResultHashSet() {
		return set.toArray();
	}
	
	@Benchmark
	public int[] toArrayResultLinkedHashSet() {
		return linkedSet.toArray();
	}
}

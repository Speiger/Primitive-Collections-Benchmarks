package speiger.src.collections.impl.hppc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.carrotsearch.hppc.IntArrayDeque;
import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntDeque;
import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntIndexedContainer;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;

import speiger.src.collections.base.RemoveCollectionBenchmarks;


public class HppcRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	IntIndexedContainer arrayList;
	IntSet set;
	IntSet linkedSet;
	IntDeque fifoQueue;
	
	@Override
	protected void updateCollection()
	{
		arrayList = new IntArrayList();
		set = new IntHashSet();
		linkedSet = new IntWormSet();
		fifoQueue = new IntArrayDeque();
		for(int i = 0;i<setSize;i++) {
			arrayList.add(addedValues[i]);
			set.add(addedValues[i]);
			linkedSet.add(addedValues[i]);
			fifoQueue.addLast(addedValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.removeFirst(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultHashSet() {
		for(int i = 0;i<100;i++) {
			set.removeAll(removeValues[i]);
		}
	}
	
	@Benchmark
	public void removeResultLinkedHashSet() {
		for(int i = 0;i<100;i++) {
			linkedSet.removeAll(removeValues[i]);
		}
	}
	
	@Benchmark
	public void pollFirstResultFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.removeFirst());
		}
	}
	
	@Benchmark
	public void pollLastResultFIFOQueue(Blackhole hole) {
		while(!fifoQueue.isEmpty()) {
			hole.consume(fifoQueue.removeLast());
		}
	}
}

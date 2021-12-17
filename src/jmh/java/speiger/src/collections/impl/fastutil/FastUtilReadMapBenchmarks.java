package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import it.unimi.dsi.fastutil.doubles.DoubleIterator;
import it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import speiger.src.collections.base.ReadMapBenchmarks;

public class FastUtilReadMapBenchmarks extends ReadMapBenchmarks
{
	Int2DoubleMap map;
	Int2DoubleMap linkedMap;
	Int2DoubleMap arrayMap;
	Int2DoubleMap rbTreeMap;
	Int2DoubleMap avlTreeMap;
	
	@Override
	protected void initMaps()
	{
		map = new Int2DoubleOpenHashMap(addedKeys, addedValues);
		linkedMap = new Int2DoubleLinkedOpenHashMap(addedKeys, addedValues);
		arrayMap = new Int2DoubleArrayMap(addedKeys, addedValues);
		rbTreeMap = new Int2DoubleRBTreeMap(addedKeys, addedValues, null);
		avlTreeMap = new Int2DoubleAVLTreeMap(addedKeys, addedValues, null);
	}
	
	@Benchmark
	public Int2DoubleMap cloneResultHashMap() {
		return ((Int2DoubleOpenHashMap)map).clone();
	}
	
	@Benchmark
	public Int2DoubleMap cloneResultLinkedHashMap() {
		return ((Int2DoubleLinkedOpenHashMap)linkedMap).clone();
	}
	
	@Benchmark
	public Int2DoubleMap cloneResultArrayMap() {
		return ((Int2DoubleArrayMap)arrayMap).clone();
	}
	
	@Benchmark
	public Int2DoubleMap cloneResultRBTreeMap() {
		return ((Int2DoubleRBTreeMap)rbTreeMap).clone();
	}
	
	@Benchmark
	public Int2DoubleMap cloneResultAVLTreeMap() {
		return ((Int2DoubleAVLTreeMap)avlTreeMap).clone();
	}
	
	@Benchmark
	public void containsKeyResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyResultArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyResultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyResultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getResultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getOrDefaultResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultResultArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultResultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultResultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void forEachResultHashMap(Blackhole hole) {
		map.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachResultLinkedHashMap(Blackhole hole) {
		linkedMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachResultArrayMap(Blackhole hole) {
		arrayMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachResultRBTreeMap(Blackhole hole) {
		rbTreeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachResultAVLTreeMap(Blackhole hole) {
		avlTreeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void keySetResultHashMap(Blackhole hole) {
		for(IntIterator iter = map.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetResultLinkedHashMap(Blackhole hole) {
		for(IntIterator iter = linkedMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetResultArrayMap(Blackhole hole) {
		for(IntIterator iter = arrayMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetResultRBTreeMap(Blackhole hole) {
		for(IntIterator iter = rbTreeMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetResultAVLTreeMap(Blackhole hole) {
		for(IntIterator iter = avlTreeMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void valuesResultHashMap(Blackhole hole) {
		for(DoubleIterator iter = map.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesResultLinkedHashMap(Blackhole hole) {
		for(DoubleIterator iter = linkedMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesResultArrayMap(Blackhole hole) {
		for(DoubleIterator iter = arrayMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesResultRBTreeMap(Blackhole hole) {
		for(DoubleIterator iter = rbTreeMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesResultAVLTreeMap(Blackhole hole) {
		for(DoubleIterator iter = avlTreeMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
}

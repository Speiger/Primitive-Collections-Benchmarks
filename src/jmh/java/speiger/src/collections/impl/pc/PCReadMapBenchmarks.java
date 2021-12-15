package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadMapBenchmarks;
import speiger.src.collections.doubles.collections.DoubleIterator;
import speiger.src.collections.ints.collections.IntIterator;
import speiger.src.collections.ints.maps.interfaces.Int2DoubleMap;
import speiger.src.collections.ints.maps.interfaces.Int2DoubleNavigableMap;

public class PCReadMapBenchmarks extends ReadMapBenchmarks
{
	Int2DoubleMap map;
	Int2DoubleMap linkedMap;
	Int2DoubleMap arrayMap;
	Int2DoubleNavigableMap rbTreeMap;
	Int2DoubleNavigableMap avlTreeMap;
	
	@Override
	protected void initMaps()
	{
		map = Int2DoubleMap.builder().map(addedKeys, addedValues);
		linkedMap = Int2DoubleMap.builder().linkedMap(addedKeys, addedValues);
		arrayMap = Int2DoubleMap.builder().arrayMap(addedKeys, addedValues);
		rbTreeMap = Int2DoubleMap.builder().rbTreeMap(addedKeys, addedValues, null);
		avlTreeMap = Int2DoubleMap.builder().avlTreeMap(addedKeys, addedValues, null);
	}
	
	@Benchmark
	public Int2DoubleMap cloneMap() {
		return map.copy();
	}
	
	@Benchmark
	public Int2DoubleMap cloneLinkedMap() {
		return linkedMap.copy();
	}
	
	@Benchmark
	public Int2DoubleMap cloneArrayMap() {
		return arrayMap.copy();
	}
	
	@Benchmark
	public Int2DoubleMap cloneRBTreeMap() {
		return rbTreeMap.copy();
	}
	
	@Benchmark
	public Int2DoubleMap cloneAVLMap() {
		return avlTreeMap.copy();
	}
	
	@Benchmark
	public void containsKeyMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyLinkedMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getLinkedMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getOrDefaultMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultLinkedMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultArrayMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(arrayMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(rbTreeMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(avlTreeMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void forEachMap(Blackhole hole) {
		map.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachLinkedMap(Blackhole hole) {
		linkedMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachArrayMap(Blackhole hole) {
		arrayMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachRBTreeMap(Blackhole hole) {
		rbTreeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachAVLTreeMap(Blackhole hole) {
		avlTreeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void keySetMap(Blackhole hole) {
		for(IntIterator iter = map.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetLinkedMap(Blackhole hole) {
		for(IntIterator iter = linkedMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetArrayMap(Blackhole hole) {
		for(IntIterator iter = arrayMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetRBTreeMap(Blackhole hole) {
		for(IntIterator iter = rbTreeMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void keySetAVLTreeMap(Blackhole hole) {
		for(IntIterator iter = avlTreeMap.keySet().iterator();iter.hasNext();hole.consume(iter.nextInt()));
	}
	
	@Benchmark
	public void valuesMap(Blackhole hole) {
		for(DoubleIterator iter = map.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesLinkedMap(Blackhole hole) {
		for(DoubleIterator iter = linkedMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesArrayMap(Blackhole hole) {
		for(DoubleIterator iter = arrayMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesRBTreeMap(Blackhole hole) {
		for(DoubleIterator iter = rbTreeMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
	
	@Benchmark
	public void valuesAVLTreeMap(Blackhole hole) {
		for(DoubleIterator iter = avlTreeMap.values().iterator();iter.hasNext();hole.consume(iter.nextDouble()));
	}
}

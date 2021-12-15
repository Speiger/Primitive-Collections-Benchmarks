package speiger.src.collections.impl.pc;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.RemoveMapBenchmarks;
import speiger.src.collections.ints.maps.interfaces.Int2DoubleMap;
import speiger.src.collections.ints.maps.interfaces.Int2DoubleNavigableMap;

public class PCRemoveMapsBenchmarks extends RemoveMapBenchmarks
{
	Int2DoubleMap map;
	Int2DoubleMap linkedMap;
	Int2DoubleMap arrayMap;
	Int2DoubleNavigableMap rbTreeMap;
	Int2DoubleNavigableMap avlTreeMap;
	
	@Override
	protected void updateMap()
	{
		map = Int2DoubleMap.builder().map(addedKeys, addedValues);
		linkedMap = Int2DoubleMap.builder().linkedMap(addedKeys, addedValues);
		arrayMap = Int2DoubleMap.builder().arrayMap(addedKeys, addedValues);
		rbTreeMap = Int2DoubleMap.builder().rbTreeMap(addedKeys, addedValues, null);
		avlTreeMap = Int2DoubleMap.builder().avlTreeMap(addedKeys, addedValues, null);		
	}
	
	@Benchmark
	public void removeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeLinkedMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(linkedMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeArrayMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(arrayMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeRBTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(rbTreeMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeAVLMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(avlTreeMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void replaceMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceLinkedMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(linkedMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceArrayMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(arrayMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceRBTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(rbTreeMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceAVLMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(avlTreeMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void pollFirstRBTreeMap(Blackhole hole) {
		while(!rbTreeMap.isEmpty()) {
			hole.consume(rbTreeMap.pollFirstIntKey());
		}
	}
	
	@Benchmark
	public void pollLastRBTreeMap(Blackhole hole) {
		while(!rbTreeMap.isEmpty()) {
			hole.consume(rbTreeMap.pollLastIntKey());
		}
	}
	
	@Benchmark
	public void pollFirstAVLTreeMap(Blackhole hole) {
		while(!avlTreeMap.isEmpty()) {
			hole.consume(avlTreeMap.pollFirstIntKey());
		}
	}
	
	@Benchmark
	public void pollLastAVLTreeMap(Blackhole hole) {
		while(!avlTreeMap.isEmpty()) {
			hole.consume(avlTreeMap.pollLastIntKey());
		}
	}
}

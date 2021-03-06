package speiger.src.collections.impl.fastutil;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap;
import speiger.src.collections.base.RemoveMapBenchmarks;

public class FastUtilRemoveMapsBenchmarks extends RemoveMapBenchmarks
{
	Int2DoubleMap map;
	Int2DoubleMap linkedMap;
	Int2DoubleMap arrayMap;
	Int2DoubleMap rbTreeMap;
	Int2DoubleMap avlTreeMap;
	
	@Override
	protected void updateMap()
	{
		map = new Int2DoubleOpenHashMap(addedKeys, addedValues);
		linkedMap = new Int2DoubleLinkedOpenHashMap(addedKeys, addedValues);
		arrayMap = new Int2DoubleArrayMap(addedKeys, addedValues);
		rbTreeMap = new Int2DoubleRBTreeMap(addedKeys, addedValues, null);
		avlTreeMap = new Int2DoubleAVLTreeMap(addedKeys, addedValues, null);
	}
	
	@Benchmark
	public void removeResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(linkedMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultArrayMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(arrayMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(rbTreeMap.remove(removeKeys[i])); //Was Causing a freeze thats why disabled
		}
	}
	
	@Benchmark
	public void removeResultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(avlTreeMap.remove(removeKeys[i])); //Was Causing a freeze thats why disabled
		}
	}
	
	@Benchmark
	public void replaceResultHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(map.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(linkedMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultArrayMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(arrayMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultRBTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(rbTreeMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultAVLTreeMap(Blackhole hole) {
		for(int i = 0;i<removeKeys.length;i++) {
			hole.consume(avlTreeMap.replace(removeKeys[i], 5D));
		}
	}
}

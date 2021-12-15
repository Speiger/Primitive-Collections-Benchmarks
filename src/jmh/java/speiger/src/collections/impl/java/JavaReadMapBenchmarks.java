package speiger.src.collections.impl.java;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.ReadMapBenchmarks;

public class JavaReadMapBenchmarks extends ReadMapBenchmarks
{
	Map<Integer, Double> map;
	Map<Integer, Double> linkedMap;
	Map<Integer, Double> identityMap;
	NavigableMap<Integer, Double> treeMap;
	
	@Override
	protected void initMaps() {
		map = new HashMap<>();
		linkedMap = new LinkedHashMap<>();
		identityMap = new IdentityHashMap<>();
		treeMap = new TreeMap<>();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
			linkedMap.put(addedKeys[i], addedValues[i]);
			identityMap.put(addedKeys[i], addedValues[i]);
			treeMap.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public Object cloneMap() {
		return ((HashMap<Integer, Double>)map).clone();
	}
	
	@Benchmark
	public Object cloneLinkedMap() {
		return ((LinkedHashMap<Integer, Double>)linkedMap).clone();
	}
	
	@Benchmark
	public Object cloneIdentityMap() {
		return ((IdentityHashMap<Integer, Double>)identityMap).clone();
	}
	
	@Benchmark
	public Object cloneTreeMap() {
		return ((TreeMap<Integer, Double>)treeMap).clone();
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
	public void containsKeyIdentityMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(identityMap.containsKey(testKeys[i]));
		}
	}
	
	@Benchmark
	public void containsKeyTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.containsKey(testKeys[i]));
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
	public void getIdentityMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(identityMap.get(testKeys[i]));
		}
	}
	
	@Benchmark
	public void getTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.get(testKeys[i]));
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
	public void getOrDefaultIdentityMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(identityMap.getOrDefault(testKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void getOrDefaultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.getOrDefault(testKeys[i], 5D));
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
	public void forEachIdentityMap(Blackhole hole) {
		identityMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void forEachTreeMap(Blackhole hole) {
		treeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void keySetMap(Blackhole hole) {
		for(Integer key : map.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void keySetLinkedMap(Blackhole hole) {
		for(Integer key : linkedMap.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void keySetIdentityMap(Blackhole hole) {
		for(Integer key : identityMap.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void keySetTreeMap(Blackhole hole) {
		for(Integer key : treeMap.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void valuesMap(Blackhole hole) {
		for(Double value : map.values())
			hole.consume(value);
	}
	
	@Benchmark
	public void valuesLinkedMap(Blackhole hole) {
		for(Double value : linkedMap.values())
			hole.consume(value);
	}
	
	@Benchmark
	public void valuesIdentityMap(Blackhole hole) {
		for(Double value : identityMap.values())
			hole.consume(value);
	}
	
	@Benchmark
	public void valuesTreeMap(Blackhole hole) {
		for(Double value : treeMap.values())
			hole.consume(value);
	}
}

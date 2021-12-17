package speiger.src.collections.impl.java;

import java.util.HashMap;
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
	NavigableMap<Integer, Double> treeMap;
	
	@Override
	protected void initMaps() {
		map = new HashMap<>();
		linkedMap = new LinkedHashMap<>();
		treeMap = new TreeMap<>();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
			linkedMap.put(addedKeys[i], addedValues[i]);
			treeMap.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public Object cloneResultHashMap() {
		return ((HashMap<Integer, Double>)map).clone();
	}
	
	@Benchmark
	public Object cloneResultLinkedHashMap() {
		return ((LinkedHashMap<Integer, Double>)linkedMap).clone();
	}
	
	@Benchmark
	public Object cloneResultTreeMap() {
		return ((TreeMap<Integer, Double>)treeMap).clone();
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
	public void containsKeyResultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.containsKey(testKeys[i]));
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
	public void getResultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.get(testKeys[i]));
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
	public void getOrDefaultResultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.getOrDefault(testKeys[i], 5D));
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
	public void forEachResultTreeMap(Blackhole hole) {
		treeMap.forEach((K, V) -> {
			hole.consume(K);
			hole.consume(V);
		});
	}
	
	@Benchmark
	public void keySetResultHashMap(Blackhole hole) {
		for(Integer key : map.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void keySetResultLinkedHashMap(Blackhole hole) {
		for(Integer key : linkedMap.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void keySetResultTreeMap(Blackhole hole) {
		for(Integer key : treeMap.keySet())
			hole.consume(key);
	}
	
	@Benchmark
	public void valuesResultHashMap(Blackhole hole) {
		for(Double value : map.values())
			hole.consume(value);
	}
	
	@Benchmark
	public void valuesResultLinkedHashMap(Blackhole hole) {
		for(Double value : linkedMap.values())
			hole.consume(value);
	}
	
	@Benchmark
	public void valuesResultTreeMap(Blackhole hole) {
		for(Double value : treeMap.values())
			hole.consume(value);
	}
}

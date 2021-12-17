package speiger.src.collections.impl.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.base.RemoveMapBenchmarks;

public class JavaRemoveMapBenchmarks extends RemoveMapBenchmarks
{
	Map<Integer, Double> map;
	Map<Integer, Double> linkedMap;
	NavigableMap<Integer, Double> treeMap;
	
	@Override
	protected void updateMap()
	{
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
	public void removeResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void removeResultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.remove(removeKeys[i]));
		}
	}
	
	@Benchmark
	public void replaceResultHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(map.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultLinkedHashMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(linkedMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void replaceResultTreeMap(Blackhole hole) {
		for(int i = 0;i<100;i++) {
			hole.consume(treeMap.replace(removeKeys[i], 5D));
		}
	}
	
	@Benchmark
	public void pollFirstResultTreeMap(Blackhole hole) {
		for(int i = 0,m=treeMap.size();i<m;i++) {
			hole.consume(treeMap.pollFirstEntry());
		}
	}
	
	@Benchmark
	public void pollLastResultTreeMap(Blackhole hole) {
		for(int i = 0,m=treeMap.size();i<m;i++) {
			hole.consume(treeMap.pollLastEntry());
		}
	}
}

package speiger.src.collections.impl.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.PutMapBenchmarks;

public class JavaPutMapBenchmarks extends PutMapBenchmarks
{
	@Benchmark
	public Map<Integer, Double> putResultHashMap() {
		Map<Integer, Double> map = new HashMap<>(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Map<Integer, Double> putEmptyResultHashMap() {
		Map<Integer, Double> map = new HashMap<>();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Map<Integer, Double> putResultLinkedHashMap() {
		Map<Integer, Double> map = new LinkedHashMap<>(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Map<Integer, Double> putEmptyResultLinkedHashMap() {
		Map<Integer, Double> map = new LinkedHashMap<>();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	@Benchmark
	public Map<Integer, Double> putResultTreeMap() {
		Map<Integer, Double> map = new TreeMap<>();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}

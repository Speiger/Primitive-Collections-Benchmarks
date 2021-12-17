package speiger.src.collections.impl.hppc;

import java.util.function.Consumer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.carrotsearch.hppc.IntDoubleHashMap;
import com.carrotsearch.hppc.IntDoubleMap;
import com.carrotsearch.hppc.IntDoubleWormMap;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.cursors.IntDoubleCursor;

import speiger.src.collections.base.ReadMapBenchmarks;

public class HppcReadMapBenchmarks extends ReadMapBenchmarks
{
	IntDoubleMap map;
	IntDoubleMap linkedMap;
	
	@Override
	protected void initMaps()
	{
		map = new IntDoubleHashMap(setSize);
		linkedMap = new IntDoubleWormMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
			linkedMap.put(addedKeys[i], addedValues[i]);
		}
	}
	
	@Benchmark
	public IntDoubleMap cloneResultHashMap() {
		return ((IntDoubleHashMap)map).clone();
	}
	
	@Benchmark
	public IntDoubleMap cloneResultLinkedHashMap() {
		return ((IntDoubleWormMap)linkedMap).clone();
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
	public void forEachResultHashMap(Blackhole hole) {
		Consumer<IntDoubleCursor> action = T -> {
			hole.consume(T.key);
			hole.consume(T.value);			
		};
		map.forEach(action);
	}
	
	@Benchmark
	public void forEachResultLinkedHashMap(Blackhole hole) {
		Consumer<IntDoubleCursor> action = T -> {
			hole.consume(T.key);
			hole.consume(T.value);			
		};
		linkedMap.forEach(action);
	}
	
	@Benchmark
	public void keySetResultHashMap(Blackhole hole) {
		for(IntCursor cursor : map.keys()) {
			hole.consume(cursor.value);
		}
	}
	
	@Benchmark
	public void keySetResultLinkedHashMap(Blackhole hole) {
		for(IntCursor cursor : linkedMap.keys()) {
			hole.consume(cursor.value);
		}
	}
}

package speiger.src.collections;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import speiger.src.collections.ints.lists.IntArrayList;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class StreamReplaceFunctions
{
	public int[] data;
	
	@Setup
	public void setup() {
		Random rand = new Random(1210214121L);
		data = new int[100000];
		for(int i = 0;i<data.length;i++) {
			data[i] = rand.nextInt(1000);
		}
	}
	
	@Benchmark
	public void streamForEach(Blackhole hole) {
		Arrays.stream(data).forEach(hole::consume);
	}
	
	@Benchmark
	public void queryForEach(Blackhole hole) {
		IntArrayList.wrap(data).forEach(hole::consume);
	}
	
	@Benchmark
	public void streamFilterForEach(Blackhole hole) {
		Arrays.stream(data).filter(T -> T % 2 != 0).forEach(hole::consume);
	}
	
	@Benchmark
	public void queryFilterForEach(Blackhole hole) {
		IntArrayList.wrap(data).filter(T -> T % 2 != 0).forEach(hole::consume);
	}
	
	@Benchmark
	public void streamDistinctForEach(Blackhole hole) {
		Arrays.stream(data).distinct().forEach(hole::consume);
	}
	
	@Benchmark
	public void queryDistinctForEach(Blackhole hole) {
		IntArrayList.wrap(data).distinct().forEach(hole::consume);
	}
}
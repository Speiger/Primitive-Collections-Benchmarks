package speiger.src.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntSet;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SetAddBenchmark
{
	@Param({"100", "1000", "10000", "100000"})
	public int setSize;
    
	@Benchmark
	public IntSet generateSetWithValuesPC() {
	    IntSet intSet = new IntOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        intSet.add(i);
	    }
	    return intSet;
	}
	
	@Benchmark
	public Set<Integer> generateSetWithValuesJava() {
	    Set<Integer> intSet = new HashSet<>(setSize);
	    for(int i = 0; i < setSize; i++) {
	        intSet.add(i);
	    }
	    return intSet;
	}
	
	@Benchmark
	public it.unimi.dsi.fastutil.ints.IntSet generateSetWithValuesFastUtil() {
		it.unimi.dsi.fastutil.ints.IntSet intSet = new it.unimi.dsi.fastutil.ints.IntOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        intSet.add(i);
	    }
	    return intSet;
	}
	
	@Benchmark
	public org.eclipse.collections.api.set.primitive.IntSet generateSetWithValuesEclipseC() {
		org.eclipse.collections.api.set.primitive.MutableIntSet intSet = new org.eclipse.collections.impl.set.mutable.primitive.IntHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	    	intSet.with(i);
	    }
	    return intSet;
	}
}

package speiger.src.collections;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import speiger.src.collections.ints.sets.IntOpenHashSet;
import speiger.src.collections.ints.sets.IntSet;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Test
{
	@Param({"100", "1000", "10000", "100000"})
	public int setSize;
    
	@Benchmark
	public IntSet generateSetWithValues() {
	    IntSet intSet = new IntOpenHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        intSet.add(i);
	    }
	    return intSet;
	}
	
	@Benchmark
	public void testCall() {
		
	}
	
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + Test.class.getSimpleName() + ".*")
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}

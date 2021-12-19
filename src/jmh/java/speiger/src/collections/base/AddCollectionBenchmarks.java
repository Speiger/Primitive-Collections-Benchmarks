package speiger.src.collections.base;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(batchSize = 1000, iterations = 10)
@State(Scope.Benchmark)
public abstract class AddCollectionBenchmarks
{
	@Param({"100", "1000", "10000"})
	public int setSize;
	
	public int[] addedValues;
	
	@Setup
	public void init() {
		addedValues = new int[setSize];
		Random rand = new Random(1210438692124L);
		for(int i = 0;i<setSize;i++) {
			addedValues[i] = rand.nextInt(setSize);
		}
	}
}
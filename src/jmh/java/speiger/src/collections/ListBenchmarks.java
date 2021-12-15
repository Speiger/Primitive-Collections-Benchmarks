package speiger.src.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import speiger.src.collections.ints.lists.IntArrayList;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(batchSize = 100000, iterations = 10)
@Warmup(batchSize = 100000, iterations = 10)
@State(Scope.Thread)
public class ListBenchmarks
{
	private static final Integer[] ARRAY_OBJ = IntStream.range(0, 10000).mapToObj(Integer::valueOf).toArray(Integer[]::new);
	private static final int[] ARRAY = IntStream.range(0, 10000).toArray();
    private List<Integer> javaList = new ArrayList<>(Arrays.asList(ARRAY_OBJ));
    private it.unimi.dsi.fastutil.ints.IntArrayList fastUtilList = new it.unimi.dsi.fastutil.ints.IntArrayList(ARRAY);
    private IntArrayList pcList = new IntArrayList(ARRAY);
    private org.eclipse.collections.impl.list.mutable.primitive.IntArrayList eclipseList = new org.eclipse.collections.impl.list.mutable.primitive.IntArrayList(ARRAY.clone());
    
    private int getValue = 4;
    
    @Benchmark
    public boolean addJavaList() {
        return javaList.add(getValue);
    }

    @Benchmark
    public boolean addFastUtilList() {
        return fastUtilList.add(getValue);
    }

    @Benchmark
    public boolean addPCList() {
    	return pcList.add(getValue);
    }

    @Benchmark
    public boolean addEclipseList() {
        return eclipseList.add(getValue);
    }

    @Benchmark
    public int getJavaList() {
        return javaList.get(getValue);
    }

    @Benchmark
    public int getFastUtilList() {
        return fastUtilList.getInt(getValue);
    }

    @Benchmark
    public int getPCList() {
        return pcList.getInt(getValue);
    }

    @Benchmark
    public int getEclipseList() {
        return eclipseList.get(getValue);
    }

    @Benchmark
    public boolean containsJavaList() {
        return javaList.contains(getValue);
    }

    @Benchmark
    public boolean containsFastUtilList() {
        return fastUtilList.contains(getValue);
    }

    @Benchmark
    public boolean containsPCList() {
        return pcList.contains(getValue);
    }

    @Benchmark
    public boolean containsEclipseList() {
        return eclipseList.contains(getValue);
    }
}

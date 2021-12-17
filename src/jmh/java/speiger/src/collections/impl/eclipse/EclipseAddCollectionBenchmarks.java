package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.AddCollectionBenchmarks;

public class EclipseAddCollectionBenchmarks extends AddCollectionBenchmarks
{
	@Benchmark
	public MutableIntList addResultArrayList() {
		MutableIntList result = new IntArrayList(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public MutableIntList addEmptyResultArrayList() {
		MutableIntList result = new IntArrayList();
	    for(int i = 0; i < setSize; i++) {
	        result.with(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public MutableIntSet addResultHashSet() {
		MutableIntSet result = new IntHashSet(setSize);
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
	
	@Benchmark
	public MutableIntSet addEmptyResultHashSet() {
		MutableIntSet result = new IntHashSet();
	    for(int i = 0; i < setSize; i++) {
	        result.add(addedValues[i]);
	    }
	    return result;
	}
}

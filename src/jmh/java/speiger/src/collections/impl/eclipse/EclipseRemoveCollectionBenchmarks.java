package speiger.src.collections.impl.eclipse;

import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.openjdk.jmh.annotations.Benchmark;

import speiger.src.collections.base.RemoveCollectionBenchmarks;

public class EclipseRemoveCollectionBenchmarks extends RemoveCollectionBenchmarks
{
	MutableIntList arrayList;
	MutableIntSet set;
	
	@Override
	protected void updateCollection()
	{
		arrayList = new IntArrayList(addedValues);
		set = new IntHashSet(addedValues);
	}
	
	@Benchmark
	public void removeResultArrayList() {
		for(int i = 0;i<100;i++) {
			arrayList.remove(removeValues[i]);
		}
	}
		
	@Benchmark
	public void removeResultHashSet() {
		for(int i = 0;i<100;i++) {
			set.remove(removeValues[i]);
		}
	}
}

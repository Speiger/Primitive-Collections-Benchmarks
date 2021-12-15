package speiger.src.collections.impl.fastutil;

import it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleArrayMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap;
import speiger.src.collections.base.PutMapBenchmarks;

public class FastUtilPutMapBenchmarks extends PutMapBenchmarks
{
	public Int2DoubleMap putMap() {
		Int2DoubleMap map = new Int2DoubleOpenHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putEmptyMap() {
		Int2DoubleMap map = new Int2DoubleOpenHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putLinkedMap() {
		Int2DoubleMap map = new Int2DoubleLinkedOpenHashMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putEmptyLinkedMap() {
		Int2DoubleMap map = new Int2DoubleLinkedOpenHashMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putArrayMap() {
		Int2DoubleMap map = new Int2DoubleArrayMap(setSize);
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putEmptyArrayMap() {
		Int2DoubleMap map = new Int2DoubleArrayMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putRBTreeMap() {
		Int2DoubleMap map = new Int2DoubleRBTreeMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
	
	public Int2DoubleMap putAVLTreeMap() {
		Int2DoubleMap map = new Int2DoubleAVLTreeMap();
		for(int i = 0;i<setSize;i++) {
			map.put(addedKeys[i], addedValues[i]);
		}
		return map;
	}
}

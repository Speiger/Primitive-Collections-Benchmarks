## Benchmarks charts/V053

Benchmarks were made using Jmh version 1.25 and Java OpenJDK 8 version 275-1 on a Intel I5-7500 and the following libraries:
- Primitive Collections 0.5.3
- FastUtil 8.5.6
- HPPC 0.9.1
- Eclipse Collections 11.0.0
   
Each benchmark was created using Average Time with a 10 second warmup time and using Primitive Values (objects for Java Collections)
Score is the amount of time it took to do each operation in Microseconds (according to Jmh)
The Variable Size defines the amount of elements the Collection had to deal with.
These are used in 2 ways.
- If the function is a "add/put" it is the amount of elements that are added into the empty collection.
- If the function is not a "add/put" its the amount of elements that are inside of the Collection and a 100 random elements (within range) are tested against.

Another definition is "addEmptyCollection". The Empty stands for the Collection was initialized without a expected size.
While the "addCollection" is prepared with how many elements are about to be inserted.
   
The results may differ for each JVM.    
More detailed results with Exact Numbers can be found [[here]](BENCHMARKS.md)

### Chart Infos
The X Axis is the amount elements added/inside the collection while the operation is performed.   
The Y Axis is the amount of time to process each action. In Microseconds. (Lower is better)

<details>
<summary>Lists</summary>
<p>

## Add

![image](charts/V053/lists/add.png)

## AddEmpty

![image](charts/V053/lists/addEmpty.png)

## For Loop

![image](charts/V053/lists/iterateForLoop.png)

## Remove

![image](charts/V053/lists/remove.png)

## To Array

![image](charts/V053/lists/toArray.png)

</p>
</details>

<details>
<summary>HashSets</summary>
<p>

## Add

![image](charts/V053/sets/add.png)

## AddEmpty

![image](charts/V053/sets/addEmpty.png)

## Contains

![image](charts/V053/sets/contains.png)

## For Loop

![image](charts/V053/sets/iterateForLoop.png)

## Remove

![image](charts/V053/sets/remove.png)

## To Array

![image](charts/V053/sets/toArray.png)

</p>
</details>

<details>
<summary>TreeSets</summary>
<p>

## Add

![image](charts/V053/tree-sets/add.png)

## Contains

![image](charts/V053/tree-sets/contains.png)

## For Loop

![image](charts/V053/tree-sets/iterateForLoop.png)

## Remove

![image](charts/V053/tree-sets/remove.png)

## To Array

![image](charts/V053/tree-sets/toArray.png)

</p>
</details>

<details>
<summary>HashMaps</summary>
<p>

## Put

![image](charts/V053/maps/put.png)

## PutEmpty

![image](charts/V053/maps/putEmpty.png)

## Contains Key

![image](charts/V053/maps/containsKey.png)

## For Each

![image](charts/V053/maps/forEach.png)

## Clone

![image](charts/V053/maps/clone.png)

## Get

![image](charts/V053/maps/get.png)

## Get Or Default

![image](charts/V053/maps/getOrDefault.png)

## Remove

![image](charts/V053/maps/remove.png)

</p>
</details>

<details>
<summary>TreeMaps</summary>
<p>

## Put

![image](charts/V053/tree-maps/put.png)

## Contains Key

![image](charts/V053/tree-maps/containsKey.png)

## For Each

![image](charts/V053/tree-maps/forEach.png)

## Clone

![image](charts/V053/tree-maps/clone.png)

## Get

![image](charts/V053/tree-maps/get.png)

## Get Or Default

![image](charts/V053/tree-maps/getOrDefault.png)

## Remove

![image](charts/V053/tree-maps/remove.png)

</p>
</details>
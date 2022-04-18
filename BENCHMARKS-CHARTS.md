## Benchmarks Charts

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


<details>
<summary>Lists</summary>
<p>

## Add

![image](charts/lists/add.png)

## AddEmpty

![image](charts/lists/addEmpty.png)

## For Loop

![image](charts/lists/iterateForLoop.png)

## Remove

![image](charts/lists/remove.png)

## To Array

![image](charts/lists/toArray.png)

</p>
</details>

<details>
<summary>HashSets</summary>
<p>

## Add

![image](charts/sets/add.png)

## AddEmpty

![image](charts/sets/addEmpty.png)

## Contains

![image](charts/sets/contains.png)

## For Loop

![image](charts/sets/iterateForLoop.png)

## Remove

![image](charts/sets/remove.png)

## To Array

![image](charts/sets/toArray.png)

</p>
</details>

<details>
<summary>TreeSets</summary>
<p>

## Add

![image](charts/tree-sets/add.png)

## Contains

![image](charts/tree-sets/contains.png)

## For Loop

![image](charts/tree-sets/iterateForLoop.png)

## Remove

![image](charts/tree-sets/remove.png)

## To Array

![image](charts/tree-sets/toArray.png)

</p>
</details>

<details>
<summary>HashMaps</summary>
<p>

## Put

![image](charts/maps/put.png)

## PutEmpty

![image](charts/maps/putEmpty.png)

## Contains Key

![image](charts/maps/containsKey.png)

## For Each

![image](charts/maps/forEach.png)

## Clone

![image](charts/maps/clone.png)

## Get

![image](charts/maps/get.png)

## Get Or Default

![image](charts/maps/getOrDefault.png)

## Remove

![image](charts/maps/remove.png)

</p>
</details>

<details>
<summary>TreeMaps</summary>
<p>

## Put

![image](charts/maps/put.png)

## Contains Key

![image](charts/maps/containsKey.png)

## For Each

![image](charts/maps/forEach.png)

## Clone

![image](charts/maps/clone.png)

## Get

![image](charts/maps/get.png)

## Get Or Default

![image](charts/maps/getOrDefault.png)

## Remove

![image](charts/maps/remove.png)

</p>
</details>
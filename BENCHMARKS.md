## Benchmarks

### Info
Benchmarks were made using Jmh version 1.25 and Java OpenJDK 8 version 275-1
The results may differ for each JVM.

Each benchmark was created using SingleShotTime and BatchSizes of 1000 with 10 iterations
Score is the amount of time it took to do each operation in Microseconds (according to Jmh)
The Variable Size defines the amount of elements the Collection had to deal with.
These are used in 2 ways.
- If the function is a "add/put" it is the amount of elements that are added into the empty collection.
- If the function is not a "add/put" its the amount of elements that are inside of the Collection and a 100 random elements (within range) are tested against.

Another definition is "addEmptyCollection". The Empty stands for the Collection was initialized without a expected size.
While the "addCollection" is prepared with how many elements are about to be inserted.
KeySets/Values are forEach Iterators

Also JavaValues inside TreeSets/Maps are Javas "TreeMap/Set" implementation and are a RedBlack Tree Implementation.


Now to the Benchmarks

### ArrayList
|      Action       |   Size   |   Java Score  |  FastUtil Score  |    PC Score     | Units |
|-------------------|----------|---------------|------------------|-----------------|-------|
|  addEmpty         |     100  |    4.159,45   |      2.359,05    |      3.013,45   | us/op |
|  addEmpty         |    1000  |   25.566,55   |     16.568,4     |     15.148,45   | us/op |
|  addEmpty         |   10000  |  113.327,1    |     97.823,7     |     94.274,4    | us/op |
|  add              |     100  |    2.651,7    |      1.688,5     |      2.040,75   | us/op |
|  add              |    1000  |   21.218,3    |     10.224,2     |     12.671,2    | us/op |
|  add              |   10000  |  102.062,25   |     30.497,75    |     70.388,1    | us/op |
|  contains         |     100  |   11.112,15   |      4.608,05    |      5.795,75   | us/op |
|  contains         |    1000  |   65.966,8    |     17.962,35    |     17.136,1    | us/op |
|  contains         |   10000  |1.361.566,5    |    133.048,45    |    128.903,95   | us/op |
|  get              |     100  |    1.927,8    |      1.622,9     |      2.152,6    | us/op |
|  get              |    1000  |    1.624,85   |      1.984,35    |      1.653,85   | us/op |
|  get              |   10000  |    1.968,05   |      1.753,7     |      1.645,75   | us/op |
|  indexOf          |     100  |   11.354,6    |      5.547,2     |      6.409,2    | us/op |
|  indexOf          |    1000  |   67.131,5    |     16.486,35    |     18.090,05   | us/op |
|  indexOf          |   10000  |1.433.152,85   |    124.294,05    |    131.302,75   | us/op |
|  lastIndexOf      |     100  |   11.748,6    |      7.270,4     |      5.821,7    | us/op |
|  lastIndexOf      |    1000  |   61.763,1    |     38.533,6     |     16.226,85   | us/op |
|  lastIndexOf      |   10000  |1.252.073,65   |    376.184,95    |    127.616,85   | us/op |
|  remove           |     100  |    6.980,5    |      3.879,9     |      5.023,2    | us/op |
|  remove           |    1000  |   94.642,65   |     23.164,65    |     25.416,95   | us/op |
|  remove           |   10000  |2.027.889      |    197.862,85    |    214.189,6    | us/op |
|  iterateForLoop   |     100  |    2.236,7    |      2.268,05    |      2.582,8    | us/op |
|  iterateForLoop   |    1000  |   11.619,5    |     10.063,6     |     10.528,95   | us/op |
|  iterateForLoop   |   10000  |   63.474,35   |     36.165,9     |     40.435,8    | us/op |
|  iterateForEach   |     100  |    1.676,05   |      1.643,4     |      1.895,6    | us/op |
|  iterateForEach   |    1000  |    8.810,5    |      6.326,55    |      6.813,5    | us/op |
|  iterateForEach   |   10000  |   62.146,4    |     31.663,25    |     31.274,0    | us/op |
|  iterateForIndex  |     100  |    1.770,35   |      1.479,2     |      1.733,85   | us/op |
|  iterateForIndex  |    1000  |    7.417,85   |      7.903,7     |      8.497,1    | us/op |
|  iterateForIndex  |   10000  |   36.266,55   |     33.096,65    |     33.784,65   | us/op |
|  iterateStream    |     100  |    2.309,4    |      2.293,0     |      2.306,05   | us/op |
|  iterateStream    |    1000  |    8.436,8    |      7.761,65    |      7.023,7    | us/op |
|  iterateStream    |   10000  |   59.207,4    |     31.827,15    |     27.083,05   | us/op |
|  toArray          |     100  |      574,3    |        781,1     |        599,45   | us/op |
|  toArray          |    1000  |    3.799,8    |      2.459,7     |      2.353,15   | us/op |
|  toArray          |   10000  |   41.336,1    |     21.651,65    |     20.370,35   | us/op |

### Linked List
|      Action       |   Size   |  Java Score   |  FastUtil Score  |    PC Score     | Units |
|-------------------|----------|---------------|------------------|-----------------|-------|
|  add              |     100  |    3.358,6    |        N/A       |      4.090,6    | us/op |
|  add              |    1000  |   25.789,6    |        N/A       |     18.491,5    | us/op |
|  add              |   10000  |  125.652,6    |        N/A       |     99.090,05   | us/op |
|  contains         |     100  |   16.762,2    |        N/A       |     14.090,45   | us/op |
|  contains         |    1000  |  283.227,5    |        N/A       |    112.328,35   | us/op |
|  contains         |   10000  |4.546.138,45   |        N/A       |  1.237.460,4    | us/op |
|  iterateForEach   |     100  |    3.757,3    |        N/A       |      1.449,3    | us/op |
|  iterateForEach   |    1000  |   12.629,55   |        N/A       |      6.219,45   | us/op |
|  iterateForEach   |   10000  |   90.217,55   |        N/A       |     31.070,65   | us/op |
|  iterateForLoop   |     100  |    2.592,25   |        N/A       |      2.426,65   | us/op |
|  iterateForLoop   |    1000  |   11.982,1    |        N/A       |     10.030,7    | us/op |
|  iterateForLoop   |   10000  |   80.277,6    |        N/A       |     43.069,55   | us/op |
|  iterateStream    |     100  |    2.930,95   |        N/A       |      2.345,45   | us/op |
|  iterateStream    |    1000  |   10.031,45   |        N/A       |      7.719,05   | us/op |
|  iterateStream    |   10000  |   79.357,25   |        N/A       |     36.510,65   | us/op |
|  pollFirst        |     100  |      113,55   |        N/A       |        106,95   | us/op |
|  pollFirst        |    1000  |      144,4    |        N/A       |        111,75   | us/op |
|  pollFirst        |   10000  |      727,8    |        N/A       |      1.634,8    | us/op |
|  pollLast         |     100  |      150,05   |        N/A       |         87,95   | us/op |
|  pollLast         |    1000  |      130,7    |        N/A       |        214,05   | us/op |
|  pollLast         |   10000  |      605,6    |        N/A       |        442,2    | us/op |
|  remove           |     100  |   10.160,85   |        N/A       |      9.584,7    | us/op |
|  remove           |    1000  |  460.792,45   |        N/A       |    169.668,7    | us/op |
|  remove           |   10000  |6.564.341,35   |        N/A       |  1.926.300,4    | us/op |
|  toArray          |     100  |    1.192,9    |        N/A       |        927,3    | us/op |
|  toArray          |    1000  |    9.768,5    |        N/A       |      5.998,45   | us/op |
|  toArray          |   10000  |   90.329,6    |        N/A       |     38.176,1    | us/op |

### FIFO Queue
|    Action   |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|-------------|----------|--------------|------------------|-----------------|-------|
|  addEmpty   |     100  |   3.802,0    |      3.247,8     |      2.419,95   | us/op |
|  addEmpty   |    1000  |  21.157,35   |     15.218,9     |     13.374,15   | us/op |
|  addEmpty   |   10000  | 106.866,35   |     88.689,65    |     92.597,85   | us/op |
|  add        |     100  |   2.639,75   |      2.130,3     |      2.423,7    | us/op |
|  add        |    1000  |  17.855,15   |      8.622,15    |     10.919,55   | us/op |
|  add        |   10000  | 101.884,1    |     35.094,05    |     84.288,15   | us/op |
|  pollFirst  |     100  |     114,35   |        135,85    |        272,8    | us/op |
|  pollFirst  |    1000  |     125,7    |        130,35    |        592,25   | us/op |
|  pollFirst  |   10000  |     640,45   |        520,05    |        903,15   | us/op |
|  pollLast   |     100  |     100,35   |        N/A       |        123,8    | us/op |
|  pollLast   |    1000  |     183,45   |        N/A       |        196,75   | us/op |
|  pollLast   |   10000  |     463,95   |        N/A       |      2.066,8    | us/op |
|  remove     |     100  |     N/A      |        N/A       |     13.989,35   | us/op |
|  remove     |    1000  |     N/A      |        N/A       |    260.060,6    | us/op |
|  remove     |   10000  |     N/A      |        N/A       |  2.726.510,65   | us/op |
|  toArray    |     100  |     738,9    |        N/A       |        772,85   | us/op |
|  toArray    |    1000  |   4.300,1    |        N/A       |      2.338,0    | us/op |
|  toArray    |   10000  |  45.144,4    |        N/A       |     20.392,45   | us/op |

### ArrayPriorityQueue
|   Action   |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|------------|----------|--------------|------------------|-----------------|-------|
|  add       |     100  |     N/A      |      2.072,5     |      2.051,45   | us/op |
|  add       |    1000  |     N/A      |      9.487,2     |      9.225,55   | us/op |
|  add       |   10000  |     N/A      |     34.606,25    |     32.205,1    | us/op |
|  addEmpty  |     100  |     N/A      |      2.544,85    |      2.807,5    | us/op |
|  addEmpty  |    1000  |     N/A      |     15.306,9     |     14.244,25   | us/op |
|  addEmpty  |   10000  |     N/A      |     87.993,55    |    108.329,2    | us/op |
|  poll      |     100  |     N/A      |        197,8     |        248,55   | us/op |
|  poll      |    1000  |     N/A      |      2.014,45    |      1.749,15   | us/op |
|  poll      |   10000  |     N/A      |     33.594,55    |     25.986,5    | us/op |
|  remove    |     100  |     N/A      |        N/A       |      3.686,2    | us/op |
|  remove    |    1000  |     N/A      |        N/A       |     24.992,8    | us/op |
|  remove    |   10000  |     N/A      |        N/A       |    202.226,1    | us/op |
|  toArray   |     100  |     N/A      |        N/A       |        680,95   | us/op |
|  toArray   |    1000  |     N/A      |        N/A       |      2.195,7    | us/op |
|  toArray   |   10000  |     N/A      |        N/A       |     19.567,45   | us/op |

### HeapPriorityQueue
|   Action   |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|------------|----------|--------------|------------------|-----------------|-------|
|  addEmpty  |     100  |     N/A      |      3.900,35    |      4.394,05   | us/op |
|  addEmpty  |    1000  |     N/A      |     20.754,15    |     20.954,85   | us/op |
|  addEmpty  |   10000  |     N/A      |    191.021,6     |    199.797,25   | us/op |
|  add       |     100  |     N/A      |      2.912,2     |      2.903,65   | us/op |
|  add       |    1000  |     N/A      |     12.088,75    |     13.052,05   | us/op |
|  add       |   10000  |     N/A      |    132.735,1     |    130.670,0    | us/op |
|  poll      |     100  |     N/A      |        167,65    |        135,9    | us/op |
|  poll      |    1000  |     N/A      |        185,05    |        224,7    | us/op |
|  poll      |   10000  |     N/A      |      1.890,8     |      1.137,15   | us/op |
|  remove    |     100  |     N/A      |        N/A       |      3.212,5    | us/op |
|  remove    |    1000  |     N/A      |        N/A       |     24.672,3    | us/op |
|  remove    |   10000  |     N/A      |        N/A       |    205.691,75   | us/op |
|  toArray   |     100  |     N/A      |        N/A       |        613,8    | us/op |
|  toArray   |    1000  |     N/A      |        N/A       |      2.420,0    | us/op |
|  toArray   |   10000  |     N/A      |        N/A       |     20.129,7    | us/op |

### ArraySet
|      Action      |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|--------------|------------------|-----------------|-------|
|  add             |     100  |     N/A      |      4.882,1     |      3.742,2    | us/op |
|  add             |    1000  |     N/A      |    196.601,3     |     75.662,95   | us/op |
|  add             |   10000  |     N/A      | 17.819.982,65    |  5.670.174,05   | us/op |
|  addEmpty        |     100  |     N/A      |      6.443,95    |      5.720,05   | us/op |
|  addEmpty        |    1000  |     N/A      |    197.342,2     |     84.310,45   | us/op |
|  addEmpty        |   10000  |     N/A      | 17.848.574,0     |  6.006.785,35   | us/op |
|  contains        |     100  |     N/A      |      7.766,3     |      5.947,85   | us/op |
|  contains        |    1000  |     N/A      |     44.286,05    |     10.834,45   | us/op |
|  contains        |   10000  |     N/A      |    399.409,2     |    101.889,3    | us/op |
|  iterateForLoop  |     100  |     N/A      |      2.411,95    |      1.897,6    | us/op |
|  iterateForLoop  |    1000  |     N/A      |      9.264,7     |      7.855,1    | us/op |
|  iterateForLoop  |   10000  |     N/A      |     35.243,25    |     25.424,55   | us/op |
|  iterateForEach  |     100  |     N/A      |      2.740,8     |      1.179,95   | us/op |
|  iterateForEach  |    1000  |     N/A      |      9.725,7     |      5.304,35   | us/op |
|  iterateForEach  |   10000  |     N/A      |     37.769,25    |     23.121,9    | us/op |
|  iterateStream   |     100  |     N/A      |      2.435,0     |      4.524,3    | us/op |
|  iterateStream   |    1000  |     N/A      |      8.592,55    |      9.509,85   | us/op |
|  iterateStream   |   10000  |     N/A      |     32.753,05    |     31.785,4    | us/op |
|  toArray         |     100  |     N/A      |        438,2     |        437,4    | us/op |
|  toArray         |    1000  |     N/A      |      2.074,3     |      1.521,1    | us/op |
|  toArray         |   10000  |     N/A      |     19.083,05    |     12.615,35   | us/op |

### HashSet
|      Action      |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|--------------|------------------|-----------------|-------|
|  addEmpty        |     100  |   8.407,25   |      9.458,95    |     10.221,2    | us/op |
|  addEmpty        |    1000  |  45.939,55   |     23.250,2     |     23.275,2    | us/op |
|  addEmpty        |   10000  | 407.586,65   |    329.705,95    |    322.761,0    | us/op |
|  add             |     100  |   5.782,5    |      6.352,35    |      7.041,45   | us/op |
|  add             |    1000  |  37.722,1    |     15.105,15    |     15.573,2    | us/op |
|  add             |   10000  | 242.788,0    |    105.122,4     |    100.013,1    | us/op |
|  contains        |     100  |   4.581,7    |      2.197,6     |      2.066,15   | us/op |
|  contains        |    1000  |   4.409,75   |      1.883,95    |      2.623,85   | us/op |
|  contains        |   10000  |   5.069,3    |      2.213,3     |      2.235,55   | us/op |
|  iterateForEach  |     100  |   2.968,85   |      2.690,85    |      2.124,45   | us/op |
|  iterateForEach  |    1000  |  12.021,25   |      8.247,75    |      7.442,95   | us/op |
|  iterateForEach  |   10000  |  91.930,65   |     85.940,65    |    101.074,55   | us/op |
|  iterateForLoop  |     100  |   2.517,7    |      2.548,4     |      2.904,6    | us/op |
|  iterateForLoop  |    1000  |  11.414,05   |     12.338,65    |     15.522,6    | us/op |
|  iterateForLoop  |   10000  |  92.557,95   |     88.817,1     |    113.413,6    | us/op |
|  iterateStream   |     100  |   3.499,7    |      2.848,45    |      3.826,95   | us/op |
|  iterateStream   |    1000  |  11.435,7    |      9.805,35    |     16.306,1    | us/op |
|  iterateStream   |   10000  |  97.088,3    |    104.473,15    |    117.392,2    | us/op |
|  remove          |     100  |   3.238,15   |      2.222,6     |      1.688,5    | us/op |
|  remove          |    1000  |   4.220,8    |      1.698,85    |      1.788,95   | us/op |
|  remove          |   10000  |   4.676,0    |      3.195,35    |      3.211,25   | us/op |
|  toArray         |     100  |   2.916,9    |      2.612,1     |      2.790,9    | us/op |
|  toArray         |    1000  |  17.191,6    |     14.421,8     |     13.792,7    | us/op |
|  toArray         |   10000  |  89.872,25   |     77.768,05    |     79.211,55   | us/op |

### LinkedHashSet
|      Action      |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|--------------|------------------|-----------------|-------|
|  addEmpty        |     100  |   9.430,3    |      9.846,55    |     11.930,05   | us/op |
|  addEmpty        |    1000  |  53.706,95   |     35.949,3     |     42.672,1    | us/op |
|  addEmpty        |   10000  | 439.658,4    |    386.223,85    |    423.738,25   | us/op |
|  add             |     100  |   8.224,55   |      6.877,6     |      9.823,35   | us/op |
|  add             |    1000  |  44.667,55   |     24.933,8     |     25.052,85   | us/op |
|  add             |   10000  | 285.845,5    |    160.526,85    |    173.808,95   | us/op |
|  contains        |     100  |   4.467,65   |      1.990,3     |      2.840,85   | us/op |
|  contains        |    1000  |   5.027,55   |      4.813,75    |      2.000,35   | us/op |
|  contains        |   10000  |   5.042,25   |      2.271,65    |      2.206,4    | us/op |
|  iterateForEach  |     100  |   2.389,05   |      1.316,15    |      1.252,25   | us/op |
|  iterateForEach  |    1000  |   9.811,35   |      5.689,45    |      6.354,7    | us/op |
|  iterateForEach  |   10000  |  67.095,8    |     31.247,25    |     32.547,1    | us/op |
|  iterateForLoop  |     100  |   1.874,75   |      1.841,95    |      2.019,85   | us/op |
|  iterateForLoop  |    1000  |   9.297,4    |      8.837,75    |      8.798,45   | us/op |
|  iterateForLoop  |   10000  |  66.044,05   |     35.433,95    |     34.773,45   | us/op |
|  iterateStream   |     100  |   3.862,05   |      2.327,7     |      3.158,2    | us/op |
|  iterateStream   |    1000  |  10.120,35   |      8.384,65    |     10.853,9    | us/op |
|  iterateStream   |   10000  |  67.668,15   |     40.581,6     |     42.664,35   | us/op |
|  remove          |     100  |   2.627,45   |      1.590,15    |      1.695,5    | us/op |
|  remove          |    1000  |   3.656,5    |      1.614,05    |      2.089,35   | us/op |
|  remove          |   10000  |   4.078,7    |      1.720,7     |      1.962,1    | us/op |
|  toArray         |     100  |   2.134,15   |      2.099,8     |      2.168,75   | us/op |
|  toArray         |    1000  |  12.463,95   |     10.919,95    |     11.190,85   | us/op |
|  toArray         |   10000  |  84.635,65   |     47.663,2     |     48.841,45   | us/op |

### AVLTreeSet
|      Action      |   Size   |  Java Score   |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|------------------|-----------------|-------|
|  add             |     100  |   11.662,8    |     16.084,6     |     12.861,8    | us/op |
|  add             |    1000  |  100.301,6    |    123.940,7     |     97.217,05   | us/op |
|  add             |   10000  |1.308.010,7    |  1.643.839,35    |  1.312.695,45   | us/op |
|  contains        |     100  |    6.287,2    |      3.308,0     |      3.659,15   | us/op |
|  contains        |    1000  |    6.212,05   |      4.994,8     |      5.049,5    | us/op |
|  contains        |   10000  |    9.597,55   |      9.968,35    |      6.699,25   | us/op |
|  iterateForLoop  |     100  |    3.128,15   |      2.520,3     |      2.894,7    | us/op |
|  iterateForLoop  |    1000  |   13.744,6    |     10.728,85    |     10.543,0    | us/op |
|  iterateForLoop  |   10000  |  157.661,8    |     71.162,6     |     77.867,9    | us/op |
|  iterateForEach  |     100  |    3.137,75   |      3.135,05    |      1.826,5    | us/op |
|  iterateForEach  |    1000  |   13.000,65   |     11.312,0     |      8.413,55   | us/op |
|  iterateForEach  |   10000  |  155.681,8    |     63.141,95    |     74.072,9    | us/op |
|  iterateStream   |     100  |    2.535,1    |      3.358,55    |      4.515,4    | us/op |
|  iterateStream   |    1000  |   13.495,95   |     10.992,25    |     12.330,9    | us/op |
|  iterateStream   |   10000  |  151.518,8    |     66.113,6     |     82.985,95   | us/op |
|  pollFirst       |     100  |      196,6    |        N/A       |        131,2    | us/op |
|  pollFirst       |    1000  |      937,45   |        N/A       |        195,0    | us/op |
|  pollFirst       |   10000  |    1.522,55   |        N/A       |      2.332,9    | us/op |
|  pollLast        |     100  |      321,65   |        N/A       |        665,75   | us/op |
|  pollLast        |    1000  |      686,2    |        N/A       |        176,1    | us/op |
|  pollLast        |   10000  |    1.713,45   |        N/A       |      1.530,25   | us/op |
|  remove          |     100  |    4.747,7    |        N/A       |      3.921,8    | us/op |
|  remove          |    1000  |    5.298,25   |        N/A       |      7.503,35   | us/op |
|  remove          |   10000  |   11.527,45   |        N/A       |     15.511,7    | us/op |
|  toArray         |     100  |    2.802,9    |      2.471,9     |      2.274,15   | us/op |
|  toArray         |    1000  |   18.250,5    |     11.079,5     |     11.751,45   | us/op |
|  toArray         |   10000  |  167.791,6    |     66.565,1     |     73.323,25   | us/op |

### RBTreeSet
|      Action      |   Size   |  Java Score   |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|------------------|-----------------|-------|
|  add             |     100  |   11.662,8    |     16.572,0     |     12.729,8    | us/op |
|  add             |    1000  |  100.301,6    |    116.382,7     |     77.347,15   | us/op |
|  add             |   10000  |1.308.010,7    |  1.446.686,2     |  1.038.922,85   | us/op |
|  contains        |     100  |    6.287,2    |      3.536,7     |      4.492,55   | us/op |
|  contains        |    1000  |    6.212,05   |      4.641,3     |      3.993,6    | us/op |
|  contains        |   10000  |    9.597,55   |      8.164,1     |      5.818,1    | us/op |
|  iterateForEach  |     100  |    3.128,15   |      3.517,35    |      1.785,1    | us/op |
|  iterateForEach  |    1000  |   13.744,6    |     10.524,1     |      9.147,65   | us/op |
|  iterateForEach  |   10000  |  157.661,8    |     64.481,45    |     72.350,65   | us/op |
|  iterateForLoop  |     100  |    3.137,75   |      2.358,55    |      2.817,25   | us/op |
|  iterateForLoop  |    1000  |   13.000,65   |     10.746,65    |     12.200,3    | us/op |
|  iterateForLoop  |   10000  |  155.681,8    |     66.835,2     |     75.191,5    | us/op |
|  iterateStream   |     100  |    2.535,1    |      3.888,75    |      4.673,45   | us/op |
|  iterateStream   |    1000  |   13.495,95   |     11.229,6     |     13.019,25   | us/op |
|  iterateStream   |   10000  |  151.518,8    |     65.174,75    |     82.806,95   | us/op |
|  pollFirst       |     100  |      196,6    |        N/A       |        180,5    | us/op |
|  pollFirst       |    1000  |      937,45   |        N/A       |        213,35   | us/op |
|  pollFirst       |   10000  |    1.522,55   |        N/A       |      1.342,95   | us/op |
|  pollLast        |     100  |      321,65   |        N/A       |        144,2    | us/op |
|  pollLast        |    1000  |      686,2    |        N/A       |        411,35   | us/op |
|  pollLast        |   10000  |    1.713,45   |        N/A       |      1.351,4    | us/op |
|  remove          |     100  |    4.747,7    |        N/A       |      3.695,7    | us/op |
|  remove          |    1000  |    5.298,25   |        N/A       |      8.985,4    | us/op |
|  remove          |   10000  |   11.527,45   |        N/A       |     15.866,05   | us/op |
|  toArray         |     100  |    2.802,9    |      3.972,35    |      2.502,8    | us/op |
|  toArray         |    1000  |   18.250,5    |     12.524,5     |     11.129,75   | us/op |
|  toArray         |   10000  |  167.791,6    |     69.611,75    |     74.448,25   | us/op |

### HashMap
|     Action     |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|--------------|------------------|-----------------|-------|
|  putEmpty      |     100  |   8.607,85   |     11.217,05    |     10.561,5    | us/op |
|  putEmpty      |    1000  |  58.514,5    |     34.211,95    |     30.514,65   | us/op |
|  putEmpty      |   10000  | 511.705,65   |    386.631,75    |    347.893,3    | us/op |
|  put           |     100  |   7.245,15   |      9.489,4     |      7.699,55   | us/op |
|  put           |    1000  |  50.489,25   |     23.762,3     |     22.937,85   | us/op |
|  put           |   10000  | 287.986,65   |    157.322,85    |    174.547,65   | us/op |
|  containsKey   |     100  |   4.052,2    |      1.927,1     |      2.502,6    | us/op |
|  containsKey   |    1000  |   4.313,15   |      1.774,95    |      2.196,15   | us/op |
|  containsKey   |   10000  |   4.376,8    |      2.306,6     |      1.910,0    | us/op |
|  get           |     100  |   3.965,6    |      2.219,0     |      2.941,1    | us/op |
|  get           |    1000  |   4.590,85   |      2.238,65    |      2.990,95   | us/op |
|  get           |   10000  |   4.537,85   |      2.507,85    |      2.679,0    | us/op |
|  getOrDefault  |     100  |   5.014,0    |      3.005,35    |      2.765,75   | us/op |
|  getOrDefault  |    1000  |   5.797,15   |      2.933,05    |      4.058,05   | us/op |
|  getOrDefault  |   10000  |   5.784,5    |      3.905,55    |      3.695,05   | us/op |
|  remove        |     100  |   2.966,0    |      2.044,4     |      2.848,2    | us/op |
|  remove        |    1000  |   4.517,85   |      2.924,9     |      2.544,05   | us/op |
|  remove        |   10000  |   4.063,4    |      2.933,9     |      2.707,05   | us/op |
|  replace       |     100  |   5.324,35   |      2.302,6     |      2.808,8    | us/op |
|  replace       |    1000  |   5.608,8    |      2.445,35    |      3.696,0    | us/op |
|  replace       |   10000  |   7.765,55   |      2.625,4     |      5.597,6    | us/op |
|  clone         |     100  |   7.058,25   |      2.475,55    |      8.559,8    | us/op |
|  clone         |    1000  |  35.594,7    |     11.793,8     |     15.841,55   | us/op |
|  clone         |   10000  | 242.580,85   |     73.618,15    |     78.117,65   | us/op |
|  forEach       |     100  |   2.227,65   |      5.693,65    |      2.448,95   | us/op |
|  forEach       |    1000  |  12.699,8    |     26.448,4     |     10.297,05   | us/op |
|  forEach       |   10000  | 126.800,85   |    200.591,05    |    110.539,5    | us/op |
|  keySet        |     100  |   2.577,0    |      3.125,5     |      5.541,65   | us/op |
|  keySet        |    1000  |  14.697,15   |     13.826,9     |     16.741,6    | us/op |
|  keySet        |   10000  |  95.308,15   |    104.695,65    |    117.057,35   | us/op |
|  values        |     100  |   2.855,35   |      3.406,4     |      3.614,1    | us/op |
|  values        |    1000  |  14.373,05   |     13.269,35    |     16.046,6    | us/op |
|  values        |   10000  | 103.829,15   |    106.984,5     |    124.475,6    | us/op |

### LinkedHashMap
|     Action     |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|--------------|------------------|-----------------|-------|
|  putEmpty      |     100  |  11.416,35   |     12.216,45    |     13.248,15   | us/op |
|  putEmpty      |    1000  |  65.484,7    |     46.935,5     |     43.765,65   | us/op |
|  putEmpty      |   10000  | 549.974,85   |    491.405,45    |    434.703,8    | us/op |
|  put           |     100  |   8.726,1    |      9.814,85    |      8.679,25   | us/op |
|  put           |    1000  |  56.386,6    |     42.206,25    |     31.741,9    | us/op |
|  put           |   10000  | 354.428,3    |    211.276,85    |    219.091,3    | us/op |
|  containsKey   |     100  |   3.843,8    |      1.834,2     |      2.977,4    | us/op |
|  containsKey   |    1000  |   5.288,25   |      2.126,35    |      2.429,85   | us/op |
|  containsKey   |   10000  |   4.439,1    |      2.841,05    |      2.500,7    | us/op |
|  get           |     100  |   3.759,6    |      2.705,4     |      3.081,15   | us/op |
|  get           |    1000  |   4.555,25   |      2.189,75    |      2.357,15   | us/op |
|  get           |   10000  |   4.361      |      3.197,8     |      2.855,1    | us/op |
|  getOrDefault  |     100  |   5.631,05   |      2.178,25    |      2.767,85   | us/op |
|  getOrDefault  |    1000  |   7.079,25   |      2.601,05    |      2.387,85   | us/op |
|  getOrDefault  |   10000  |   5.843,25   |      3.396,5     |      2.400,2    | us/op |
|  remove        |     100  |   3.556,8    |      2.482       |      3.029,6    | us/op |
|  remove        |    1000  |   4.557,6    |      3.437,55    |      2.735      | us/op |
|  remove        |   10000  |   4.402,95   |      2.362,7     |      3.864,2    | us/op |
|  replace       |     100  |   5.382,9    |      2.484,75    |      2.984,4    | us/op |
|  replace       |    1000  |   5.832,45   |      2.565,5     |      2.683,4    | us/op |
|  replace       |   10000  |   7.156,35   |      2.201,25    |      2.841,45   | us/op |
|  clone         |     100  |   6.054,85   |      2.876,8     |      9.861,8    | us/op |
|  clone         |    1000  |  40.643,7    |     20.820,25    |     23.696      | us/op |
|  clone         |   10000  | 199.400,8    |     94.858,8     |    101.142,75   | us/op |
|  forEach       |     100  |   2.224,15   |      4.736,85    |      2.193,75   | us/op |
|  forEach       |    1000  |   8.606,6    |     23.849,25    |      8.298,3    | us/op |
|  forEach       |   10000  |  77.762,1    |    154.895,8     |     65.403,1    | us/op |
|  keySet        |     100  |   1.998,8    |      2.242,35    |      1.904,9    | us/op |
|  keySet        |    1000  |  10.411,25   |     10.199,35    |     10.542,5    | us/op |
|  keySet        |   10000  |  76.039,75   |     36.624,3     |     39.226,45   | us/op |
|  values        |     100  |   1.879,75   |      2.342,3     |      2.083,35   | us/op |
|  values        |    1000  |  10.511,45   |     10.630,05    |     11.374,2    | us/op |
|  values        |   10000  |  74.349,7    |     44.881,55    |     41.338,2    | us/op |

### ArrayMap
|     Action     |   Size   |  Java Score  |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|--------------|------------------|-----------------|-------|
|  put           |     100  |     N/A      |      5.159,4     |      7.568,05   | us/op |
|  put           |    1000  |     N/A      |    157.628,1     |     91.957,75   | us/op |
|  put           |   10000  |     N/A      | 17.715.129,95    |  6.193.244,55   | us/op |
|  putEmpty      |     100  |     N/A      |      8.300,5     |      9.299,4    | us/op |
|  putEmpty      |    1000  |     N/A      |    202.606,1     |     99.667,8    | us/op |
|  putEmpty      |   10000  |     N/A      | 17.701.902,2     |  5.762.799,55   | us/op |
|  containsKey   |     100  |     N/A      |      7.333,75    |      3.986      | us/op |
|  containsKey   |    1000  |     N/A      |     45.152,9     |     11.846,2    | us/op |
|  containsKey   |   10000  |     N/A      |    381.387,95    |     82.912,9    | us/op |
|  get           |     100  |     N/A      |      8.099,5     |      4.572,25   | us/op |
|  get           |    1000  |     N/A      |     44.556,45    |     11.239,55   | us/op |
|  get           |   10000  |     N/A      |    381.904,55    |     89.701,3    | us/op |
|  getOrDefault  |     100  |     N/A      |     11.782,85    |      4.650,65   | us/op |
|  getOrDefault  |    1000  |     N/A      |     73.206,55    |     11.931,05   | us/op |
|  getOrDefault  |   10000  |     N/A      |    604.774,75    |     84.302,25   | us/op |
|  remove        |     100  |     N/A      |      8.289,45    |      3.556,05   | us/op |
|  remove        |    1000  |     N/A      |     64.812,05    |     15.497,95   | us/op |
|  remove        |   10000  |     N/A      |    638.561,2     |    122.701,85   | us/op |
|  replace       |     100  |     N/A      |     10.167,35    |      4.269,55   | us/op |
|  replace       |    1000  |     N/A      |     76.689,55    |     11.612,4    | us/op |
|  replace       |   10000  |     N/A      |    543.292,35    |     93.118,25   | us/op |
|  clone         |     100  |     N/A      |      1.477,35    |      1.301,1    | us/op |
|  clone         |    1000  |     N/A      |      6.532,8     |      6.834,6    | us/op |
|  clone         |   10000  |     N/A      |     59.427,5     |     59.913,35   | us/op |
|  forEach       |     100  |     N/A      |      5.293,75    |      2.565,9    | us/op |
|  forEach       |    1000  |     N/A      |     33.386,7     |      7.781,95   | us/op |
|  forEach       |   10000  |     N/A      |    178.862,35    |     40.423,95   | us/op |
|  keySet        |     100  |     N/A      |      2.079,85    |      2.271,4    | us/op |
|  keySet        |    1000  |     N/A      |     11.048,1     |     10.418,85   | us/op |
|  keySet        |   10000  |     N/A      |     39.970,05    |     27.762,65   | us/op |
|  values        |     100  |     N/A      |      2.693,6     |      2.842,3    | us/op |
|  values        |    1000  |     N/A      |     11.269,85    |      9.477      | us/op |
|  values        |   10000  |     N/A      |     41.697,65    |     28.726,6    | us/op |

### AVLTreeMap
|     Action     |   Size   |  Java Score   |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|------------------|-----------------|-------|
|  put           |     100  |   13.180,25   |     16.246,65    |     13.355,65   | us/op |
|  put           |    1000  |  115.613,0    |    125.029,85    |     96.677,45   | us/op |
|  put           |   10000  |1.497.749,75   |  1.657.246,15    |  1.369.989,95   | us/op |
|  containsKey   |     100  |    4.553,35   |      4.266,05    |      3.889,15   | us/op |
|  containsKey   |    1000  |    6.587,55   |      4.080,15    |      4.548,4    | us/op |
|  containsKey   |   10000  |   10.197,6    |     11.516,2     |      6.681,0    | us/op |
|  get           |     100  |    4.224,85   |      3.682,6     |      3.384,5    | us/op |
|  get           |    1000  |    6.131,95   |      4.666,35    |      3.928,35   | us/op |
|  get           |   10000  |   10.045,55   |     10.687,7     |      7.432,65   | us/op |
|  getOrDefault  |     100  |    7.242,35   |      5.721,25    |      3.764,6    | us/op |
|  getOrDefault  |    1000  |    8.547,45   |      6.243,4     |      4.001,05   | us/op |
|  getOrDefault  |   10000  |   13.573,8    |     11.097,05    |      6.476,55   | us/op |
|  remove        |     100  |    3.985,0    |      8.388,75    |      3.136,5    | us/op |
|  remove        |    1000  |    6.529,65   |     11.464,2     |      3.666,05   | us/op |
|  remove        |   10000  |   13.493,85   |     22.669,2     |     15.350,15   | us/op |
|  replace       |     100  |    5.345,35   |      8.364,05    |      4.821,65   | us/op |
|  replace       |    1000  |    7.681,25   |     18.699,05    |      4.019,55   | us/op |
|  replace       |   10000  |   14.088,85   |     19.147,65    |     16.223,45   | us/op |
|  pollFirst     |     100  |      530,05   |        N/A       |        172,9    | us/op |
|  pollFirst     |    1000  |      497,5    |        N/A       |        258,5    | us/op |
|  pollFirst     |   10000  |      913,4    |        N/A       |        881,45   | us/op |
|  pollLast      |     100  |      290,05   |        N/A       |        136,75   | us/op |
|  pollLast      |    1000  |      844,35   |        N/A       |        210,85   | us/op |
|  pollLast      |   10000  |    2.558,3    |        N/A       |      2.143,4    | us/op |
|  clone         |     100  |    4.845,4    |      5.445,2     |      2.271,25   | us/op |
|  clone         |    1000  |   24.228,8    |     31.562,55    |     14.326,35   | us/op |
|  clone         |   10000  |  199.776,1    |    157.819,55    |    103.909,95   | us/op |
|  forEach       |     100  |    2.403,85   |      5.751,8     |      2.226,15   | us/op |
|  forEach       |    1000  |   13.713,9    |     27.804,8     |     10.600,25   | us/op |
|  forEach       |   10000  |  166.328,95   |    175.593,95    |     88.386,6    | us/op |
|  keySet        |     100  |    3.617,45   |      2.600,35    |      3.745,2    | us/op |
|  keySet        |    1000  |   13.933,65   |     12.515,9     |     12.220,15   | us/op |
|  keySet        |   10000  |  153.604,4    |     75.550,55    |     85.849,85   | us/op |
|  values        |     100  |    2.988,7    |      2.381,9     |      2.619,1    | us/op |
|  values        |    1000  |   14.497,1    |     12.000,75    |     12.977,9    | us/op |
|  values        |   10000  |  154.618,3    |     76.131,1     |     86.412,55   | us/op |

### RBTreeMap
|     Action     |   Size   |  Java Score   |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|------------------|-----------------|-------|
|  put           |     100  |   13.180,25   |     16.798,3     |     12.897,2    | us/op |
|  put           |    1000  |  115.613,0    |    118.766,6     |     82.362,2    | us/op |
|  put           |   10000  |1.497.749,75   |  1.482.966,15    |  1.048.327,75   | us/op |
|  containsKey   |     100  |    4.553,35   |      3.919,2     |      3.886,55   | us/op |
|  containsKey   |    1000  |    6.587,55   |      4.227,6     |      5.777,75   | us/op |
|  containsKey   |   10000  |   10.197,6    |      9.677,55    |      7.407,3    | us/op |
|  get           |     100  |    4.224,85   |      4.815,05    |      3.505,0    | us/op |
|  get           |    1000  |    6.131,95   |      4.027,75    |      6.078,85   | us/op |
|  get           |   10000  |   10.045,55   |      9.563,35    |      7.901,95   | us/op |
|  getOrDefault  |     100  |    7.242,35   |      5.793,85    |      3.545,2    | us/op |
|  getOrDefault  |    1000  |    8.547,45   |      5.744,75    |      3.968,4    | us/op |
|  getOrDefault  |   10000  |   13.573,8    |     11.412,0     |      5.925,85   | us/op |
|  remove        |     100  |    3.985,0    |     15.653,35    |      3.004,25   | us/op |
|  remove        |    1000  |    6.529,65   |     24.174,0     |      3.966,95   | us/op |
|  remove        |   10000  |   13.493,85   |     41.063,35    |     16.332,25   | us/op |
|  replace       |     100  |    5.345,35   |     10.848,9     |      3.880,35   | us/op |
|  replace       |    1000  |    7.681,25   |     17.859,2     |      4.014,85   | us/op |
|  replace       |   10000  |   14.088,85   |     12.779,45    |     15.175,75   | us/op |
|  pollFirst     |     100  |      530,05   |        N/A       |        159,5    | us/op |
|  pollFirst     |    1000  |      497,5    |        N/A       |        417,85   | us/op |
|  pollFirst     |   10000  |      913,4    |        N/A       |      1.170,65   | us/op |
|  pollLast      |     100  |      290,05   |        N/A       |        212,0    | us/op |
|  pollLast      |    1000  |      844,35   |        N/A       |        507,75   | us/op |
|  pollLast      |   10000  |    2.558,3    |        N/A       |      2.733,1    | us/op |
|  clone         |     100  |    4.845,4    |      5.826,05    |      2.446,3    | us/op |
|  clone         |    1000  |   24.228,8    |     31.751,7     |     14.679,1    | us/op |
|  clone         |   10000  |  199.776,1    |    154.558,7     |    105.373,25   | us/op |
|  forEach       |     100  |    2.403,85   |      7.087,35    |      2.257,55   | us/op |
|  forEach       |    1000  |   13.713,9    |     28.296,1     |      9.389,9    | us/op |
|  forEach       |   10000  |  166.328,95   |    185.673,55    |     89.453,65   | us/op |
|  keySet        |     100  |    3.617,45   |      2.840,8     |      2.399,7    | us/op |
|  keySet        |    1000  |   13.933,65   |     12.159,25    |     12.953,15   | us/op |
|  keySet        |   10000  |  153.604,4    |     76.540,3     |     95.418,55   | us/op |
|  values        |     100  |    2.988,7    |      2.486,8     |      2.434,5    | us/op |
|  values        |    1000  |   14.497,1    |     12.949,4     |     11.299,7    | us/op |
|  values        |   10000  |  154.618,3    |     84.931,6     |     96.302,5    | us/op |
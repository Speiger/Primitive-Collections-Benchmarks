## Benchmarks

### Info
Benchmarks were made using Jmh version 1.25 and Java OpenJDK 8 version 275-1 and the following libraries:
- Primitive Collections 0.5.2
- FastUtil 8.5.6
- HPPC 0.9.1
- Eclipse Collections 11.0.0
The results may differ for each JVM.

Each benchmark was created using SingleShotTime and BatchSizes of 1000 with 10 iterations and using Primitive Values (objects for Java Collections)
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
|      Action      |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  add             |     100  |     2.478,85  |      2.077,45   |      1.964,5    |       1.798,4    |      1.970,55   | us/op |
|  add             |    1000  |    19.693,7   |     13.441,85   |     10.556,1    |      10.293,55   |     13.047,95   | us/op |
|  add             |   10000  |    97.107,05  |     34.434,0    |     45.972,85   |      29.000,7    |     71.544,7    | us/op |
|  addEmpty        |     100  |     3.428,15  |      4.027,45   |      3.035,55   |       2.865,65   |      3.009,45   | us/op |
|  addEmpty        |    1000  |    24.374,5   |     14.855,55   |     15.547,8    |      15.024,45   |     15.988,35   | us/op |
|  addEmpty        |   10000  |   107.704,55  |     82.818,7    |     84.196,35   |      89.645,05   |     88.940,8    | us/op |
|  contains        |     100  |    10.388,05  |      5.314,35   |      5.133,6    |       4.751,0    |      5.719,95   | us/op |
|  contains        |    1000  |    63.029,35  |     16.752,6    |     17.059,1    |      16.934,7    |     17.010,15   | us/op |
|  contains        |   10000  | 1.274.520,3   |    129.340,3    |    124.875,3    |     128.932,8    |    124.179,15   | us/op |
|  get             |     100  |     1.634,7   |      1.569,6    |      1.338,65   |       1.620,05   |      1.633,85   | us/op |
|  get             |    1000  |     1.666,8   |      1.752,4    |      1.409,9    |       1.540,55   |      1.632,5    | us/op |
|  get             |   10000  |     1.964,6   |      1.886,45   |      1.327,85   |       2.313,3    |      1.929,95   | us/op |
|  indexOf         |     100  |    10.717,25  |      5.397,35   |      5.481,2    |       5.243,15   |      6.128,3    | us/op |
|  indexOf         |    1000  |    63.796,3   |     17.139,6    |     16.791,5    |      17.222,6    |     16.336,2    | us/op |
|  indexOf         |   10000  | 1.267.421,05  |    127.423,1    |    124.161,8    |     128.257,15   |    124.896,55   | us/op |
|  iterateForEach  |     100  |     1.942,9   |      1.556,15   |      3.527,3    |       1.444,25   |      1.468,35   | us/op |
|  iterateForEach  |    1000  |     8.108,45  |      6.257,5    |     13.793,6    |       6.508,15   |      6.430,15   | us/op |
|  iterateForEach  |   10000  |    58.958,55  |     30.422,1    |     58.258,4    |      30.021,5    |     30.408,95   | us/op |
|  iterateForLoop  |     100  |     2.476,55  |      2.546,6    |      3.073,0    |       2.370,4    |      3.321,5    | us/op |
|  iterateForLoop  |    1000  |    10.918,2   |      9.278,75   |     12.227,9    |      10.579,85   |     10.795,05   | us/op |
|  iterateForLoop  |   10000  |    60.317,65  |     35.665,9    |     55.270,1    |      36.657,6    |     39.395,3    | us/op |
|  iterateIndex    |     100  |     1.569,25  |      1.486,3    |      1.399,05   |       1.528,55   |      2.262,75   | us/op |
|  iterateIndex    |    1000  |     7.331,25  |      7.333,65   |      6.773,2    |       7.454,7    |      7.394,15   | us/op |
|  iterateIndex    |   10000  |    35.240,7   |     32.586,5    |     31.136,05   |      33.002,15   |     32.657,4    | us/op |
|  iterateStream   |     100  |     2.236,3   |      2.506,5    |      4.079,75   |       2.488,35   |      2.142,95   | us/op |
|  iterateStream   |    1000  |     8.595,45  |      6.543,4    |     14.262,05   |       7.610,8    |      6.597,85   | us/op |
|  iterateStream   |   10000  |    59.924,4   |     27.085,7    |     58.318,65   |      32.244,15   |     26.514,35   | us/op |
|  lastIndexOf     |     100  |    11.230,75  |      5.560,05   |      5.117,2    |       7.757,25   |      5.450,55   | us/op |
|  lastIndexOf     |    1000  |    58.935,0   |     17.354,75   |     16.524,9    |      38.712,95   |     16.261,5    | us/op |
|  lastIndexOf     |   10000  | 1.203.208,65  |    127.479,7    |    122.783,95   |     384.289,5    |    121.994,25   | us/op |
|  remove          |     100  |     6.604,35  |      4.113,15   |      3.815,3    |       3.859,7    |      4.761,5    | us/op |
|  remove          |    1000  |    95.077,1   |     23.312,7    |     22.376,95   |      21.563,8    |     23.066,85   | us/op |
|  remove          |   10000  | 2.181.932,7   |    188.180,1    |    185.945,85   |     187.086,0    |    196.613,5    | us/op |
|  toArray         |     100  |       658,5   |        451,75   |        468,65   |         593,6    |        548,95   | us/op |
|  toArray         |    1000  |     3.611,4   |      2.075,55   |      2.138,7    |       2.284,2    |      2.349,65   | us/op |
|  toArray         |   10000  |    40.521,6   |     19.982,3    |     18.967,2    |      20.003,35   |     19.122,3    | us/op |

### LinkedList
|      Action      |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  add             |     100  |     3.013,3   |          N/A    |          N/A    |           N/A    |      3.729,35   | us/op |
|  add             |    1000  |    26.994,65  |          N/A    |          N/A    |           N/A    |     18.024,2    | us/op |
|  add             |   10000  |   125.170,6   |          N/A    |          N/A    |           N/A    |     97.953,1    | us/op |
|  contains        |     100  |    16.030,9   |          N/A    |          N/A    |           N/A    |     13.652,65   | us/op |
|  contains        |    1000  |   266.219,6   |          N/A    |          N/A    |           N/A    |    107.103,15   | us/op |
|  contains        |   10000  | 4.211.392,2   |          N/A    |          N/A    |           N/A    |  1.182.636,25   | us/op |
|  iterateForEach  |     100  |     3.539,2   |          N/A    |          N/A    |           N/A    |      1.376,3    | us/op |
|  iterateForEach  |    1000  |    12.255,4   |          N/A    |          N/A    |           N/A    |      5.700,05   | us/op |
|  iterateForEach  |   10000  |    78.184,5   |          N/A    |          N/A    |           N/A    |     30.055,8    | us/op |
|  iterateForLoop  |     100  |     2.800,15  |          N/A    |          N/A    |           N/A    |      2.265,0    | us/op |
|  iterateForLoop  |    1000  |    11.727,7   |          N/A    |          N/A    |           N/A    |      9.596,75   | us/op |
|  iterateForLoop  |   10000  |    78.404,4   |          N/A    |          N/A    |           N/A    |     41.444,85   | us/op |
|  iterateStream   |     100  |     2.735,8   |          N/A    |          N/A    |           N/A    |      2.640,25   | us/op |
|  iterateStream   |    1000  |     9.465,65  |          N/A    |          N/A    |           N/A    |      7.723,1    | us/op |
|  iterateStream   |   10000  |    74.808,9   |          N/A    |          N/A    |           N/A    |     34.108,6    | us/op |
|  pollFirst       |     100  |       127,8   |          N/A    |          N/A    |           N/A    |         88,8    | us/op |
|  pollFirst       |    1000  |        98,4   |          N/A    |          N/A    |           N/A    |         94,1    | us/op |
|  pollFirst       |   10000  |       572,3   |          N/A    |          N/A    |           N/A    |        426,9    | us/op |
|  pollLast        |     100  |       162,8   |          N/A    |          N/A    |           N/A    |        138,85   | us/op |
|  pollLast        |    1000  |       115,4   |          N/A    |          N/A    |           N/A    |        103,55   | us/op |
|  pollLast        |   10000  |       552,25  |          N/A    |          N/A    |           N/A    |        449,15   | us/op |
|  remove          |     100  |     9.400,05  |          N/A    |          N/A    |           N/A    |      9.077,7    | us/op |
|  remove          |    1000  |   472.425,65  |          N/A    |          N/A    |           N/A    |    163.052,3    | us/op |
|  remove          |   10000  | 6.791.502,55  |          N/A    |          N/A    |           N/A    |  2.133.326,6    | us/op |
|  toArray         |     100  |     1.566,55  |          N/A    |          N/A    |           N/A    |      1.337,95   | us/op |
|  toArray         |    1000  |    10.290,55  |          N/A    |          N/A    |           N/A    |      5.562,35   | us/op |
|  toArray         |   10000  |    84.439,15  |          N/A    |          N/A    |           N/A    |     39.793,35   | us/op |

### FIFOQueue
|   Action    |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|-------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  add        |     100  |     2.304,95  |          N/A    |      1.764,1    |       1.378,7    |      2.005,65   | us/op |
|  add        |    1000  |    17.857,05  |          N/A    |      9.021,2    |       9.599,85   |     11.331,0    | us/op |
|  add        |   10000  |    97.671,95  |          N/A    |     32.848,15   |      33.702,85   |     82.201,05   | us/op |
|  addEmpty   |     100  |     3.171,95  |          N/A    |      3.626,35   |       2.520,4    |      1.917,45   | us/op |
|  addEmpty   |    1000  |    20.795,9   |          N/A    |     15.688,45   |      14.901,1    |     12.066,95   | us/op |
|  addEmpty   |   10000  |   102.940,45  |          N/A    |     85.276,8    |      85.186,5    |     86.895,95   | us/op |
|  contains   |     100  |    10.796,0   |          N/A    |          N/A    |           N/A    |          N/A    | us/op |
|  contains   |    1000  |    73.049,8   |          N/A    |          N/A    |           N/A    |          N/A    | us/op |
|  contains   |   10000  | 1.582.828,05  |          N/A    |          N/A    |           N/A    |          N/A    | us/op |
|  pollFirst  |     100  |        83,8   |          N/A    |        206,9    |         190,35   |        198,6    | us/op |
|  pollFirst  |    1000  |       127,9   |          N/A    |        121,25   |         126,3    |        126,8    | us/op |
|  pollFirst  |   10000  |       462,1   |          N/A    |        518,65   |         490,95   |        562,65   | us/op |
|  pollLast   |     100  |       122,1   |          N/A    |        143,5    |         226,9    |        125,75   | us/op |
|  pollLast   |    1000  |       180,15  |          N/A    |        114,75   |         105,6    |        124,3    | us/op |
|  pollLast   |   10000  |       478,9   |          N/A    |        740,0    |         478,25   |        576,15   | us/op |
|  remove     |     100  |         N/A   |          N/A    |          N/A    |           N/A    |     13.787,35   | us/op |
|  remove     |    1000  |         N/A   |          N/A    |          N/A    |           N/A    |    237.495,25   | us/op |
|  remove     |   10000  |         N/A   |          N/A    |          N/A    |           N/A    |  2.625.684,5    | us/op |
|  toArray    |     100  |       733,4   |          N/A    |          N/A    |           N/A    |        544,7    | us/op |
|  toArray    |    1000  |     4.245,5   |          N/A    |          N/A    |           N/A    |      2.373,7    | us/op |
|  toArray    |   10000  |    44.174,7   |          N/A    |          N/A    |           N/A    |     18.970,05   | us/op |

### HeapQueue
|   Action   |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  add       |     100  |         N/A   |          N/A    |        N/A    |       2.808,7    |      2.794,85   | us/op |
|  add       |    1000  |         N/A   |          N/A    |        N/A    |      11.570,2    |     13.186,65   | us/op |
|  add       |   10000  |         N/A   |          N/A    |        N/A    |     124.004,55   |    128.125,3    | us/op |
|  addEmpty  |     100  |         N/A   |          N/A    |        N/A    |       3.661,35   |      3.888,15   | us/op |
|  addEmpty  |    1000  |         N/A   |          N/A    |        N/A    |      18.979,5    |     19.780,95   | us/op |
|  addEmpty  |   10000  |         N/A   |          N/A    |        N/A    |     180.513,55   |    190.677,55   | us/op |
|  poll      |     100  |         N/A   |          N/A    |        N/A    |         255,3    |        164,3    | us/op |
|  poll      |    1000  |         N/A   |          N/A    |        N/A    |         187,5    |        220,65   | us/op |
|  poll      |   10000  |         N/A   |          N/A    |        N/A    |       1.161,7    |      1.270,9    | us/op |
|  remove    |     100  |         N/A   |          N/A    |        N/A    |           N/A    |      3.343,9    | us/op |
|  remove    |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |     24.846,9    | us/op |
|  remove    |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |    193.401,85   | us/op |
|  toArray   |     100  |         N/A   |          N/A    |        N/A    |           N/A    |        483,25   | us/op |
|  toArray   |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |      2.186,35   | us/op |
|  toArray   |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |     25.870,3    | us/op |

### ArrayQueue
|   Action   |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  add       |     100  |         N/A   |          N/A    |        N/A    |       1.433,35   |      1.514,2    | us/op |
|  add       |    1000  |         N/A   |          N/A    |        N/A    |       8.254,3    |      9.619,55   | us/op |
|  add       |   10000  |         N/A   |          N/A    |        N/A    |      32.929,2    |     33.085,05   | us/op |
|  addEmpty  |     100  |         N/A   |          N/A    |        N/A    |       2.592,65   |      2.577,2    | us/op |
|  addEmpty  |    1000  |         N/A   |          N/A    |        N/A    |      14.511,9    |     14.569,2    | us/op |
|  addEmpty  |   10000  |         N/A   |          N/A    |        N/A    |      85.547,45   |     90.201,15   | us/op |
|  poll      |     100  |         N/A   |          N/A    |        N/A    |         211,65   |        257,05   | us/op |
|  poll      |    1000  |         N/A   |          N/A    |        N/A    |       1.551,05   |        430,65   | us/op |
|  poll      |   10000  |         N/A   |          N/A    |        N/A    |      31.360,0    |     19.223,3    | us/op |
|  remove    |     100  |         N/A   |          N/A    |        N/A    |           N/A    |      3.172,6    | us/op |
|  remove    |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |     25.977,3    | us/op |
|  remove    |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |    196.516,3    | us/op |
|  toArray   |     100  |         N/A   |          N/A    |        N/A    |           N/A    |        687,0    | us/op |
|  toArray   |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |      2.213,4    | us/op |
|  toArray   |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |     19.416,3    | us/op |

### HashSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  add             |     100  |     6.098,55  |      4.711,75   |    7.884,9    |       8.030,45   |      5.390,55   | us/op |
|  add             |    1000  |    36.294,3   |     16.611,7    |   14.337,8    |      14.523,15   |     15.766,3    | us/op |
|  add             |   10000  |   228.105,0   |    159.149,0    |   95.790,5    |      97.793,6    |    100.388,35   | us/op |
|  addEmpty        |     100  |     7.753,95  |      6.340,7    |    7.884,2    |       9.078,4    |      8.793,2    | us/op |
|  addEmpty        |    1000  |    43.721,35  |     42.772,1    |   19.986,75   |      20.566,2    |     24.512,9    | us/op |
|  addEmpty        |   10000  |   384.687,5   |    355.320,35   |  297.539,75   |     305.352,45   |    326.207,3    | us/op |
|  contains        |     100  |     3.746,45  |      3.728,1    |    1.911,8    |       1.994,3    |      2.173,75   | us/op |
|  contains        |    1000  |     4.811,95  |      3.797,35   |    1.899,65   |       1.857,6    |      2.037,6    | us/op |
|  contains        |   10000  |     4.143,0   |      3.015,35   |    2.070,95   |       2.751,3    |      2.167,25   | us/op |
|  iterateForEach  |     100  |     3.135,5   |      2.194,85   |    4.648,7    |       2.583,1    |      2.142,15   | us/op |
|  iterateForEach  |    1000  |    12.091,3   |      9.316,35   |   22.050,6    |       9.430,2    |      7.699,8    | us/op |
|  iterateForEach  |   10000  |    86.618,9   |     82.668,85   |  128.213,9    |      87.955,95   |     96.742,9    | us/op |
|  iterateForLoop  |     100  |     2.898,4   |      3.647,75   |    3.800,6    |       2.946,75   |      2.820,6    | us/op |
|  iterateForLoop  |    1000  |    11.373,35  |     16.060,95   |   20.832,55   |      11.729,5    |     14.875,25   | us/op |
|  iterateForLoop  |   10000  |    87.595,8   |     95.341,15   |  127.013,65   |      91.200,65   |    107.182,65   | us/op |
|  iterateStream   |     100  |     2.789,55  |          N/A    |    5.064,3    |       3.841,25   |      4.494,6    | us/op |
|  iterateStream   |    1000  |    10.964,3   |          N/A    |   22.857,4    |      10.621,65   |     17.100,0    | us/op |
|  iterateStream   |   10000  |    93.691,85  |          N/A    |  124.477,4    |     107.692,85   |    112.249,75   | us/op |
|  remove          |     100  |     3.171,8   |      3.818,65   |    1.867,75   |       1.549,55   |      1.771,05   | us/op |
|  remove          |    1000  |     4.139,55  |      3.404,25   |    2.377,45   |       1.946,9    |      1.615,35   | us/op |
|  remove          |   10000  |     4.476,8   |      5.308,05   |    2.460,85   |       1.894,05   |      1.926,25   | us/op |
|  toArray         |     100  |     3.230,45  |      2.270,75   |    1.961,4    |       2.914,75   |      3.182,9    | us/op |
|  toArray         |    1000  |    16.081,95  |     12.593,3    |   10.617,0    |      13.096,8    |     13.740,6    | us/op |
|  toArray         |   10000  |    89.448,85  |     64.237,45   |   77.082,2    |      73.394,4    |     75.321,65   | us/op |

### LinkedHashSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  add             |     100  |     7.402,8   |          N/A    |    6.070,3    |       8.059,8    |      8.185,4    | us/op |
|  add             |    1000  |    42.110,65  |          N/A    |   19.914,0    |      23.458,15   |     25.684,55   | us/op |
|  add             |   10000  |   273.200,55  |          N/A    |  145.844,5    |     153.502,9    |    183.640,5    | us/op |
|  addEmpty        |     100  |     9.295,45  |          N/A    |   10.857,1    |      10.543,1    |      9.893,4    | us/op |
|  addEmpty        |    1000  |    49.914,4   |          N/A    |   53.121,25   |      34.631,4    |     37.144,55   | us/op |
|  addEmpty        |   10000  |   429.485,35  |          N/A    |  484.847,4    |     358.091,8    |    383.768,95   | us/op |
|  contains        |     100  |     3.486,9   |          N/A    |    2.755,45   |       2.077,35   |      2.141,95   | us/op |
|  contains        |    1000  |     4.741,8   |          N/A    |    2.372,35   |       1.885,8    |      2.069,35   | us/op |
|  contains        |   10000  |     5.228,8   |          N/A    |    2.574,2    |       2.856,35   |      2.486,25   | us/op |
|  iterateForEach  |     100  |     2.238,05  |          N/A    |    4.689,4    |       1.323,1    |      1.193,65   | us/op |
|  iterateForEach  |    1000  |     9.827,7   |          N/A    |   21.364,85   |       6.112,95   |      6.012,85   | us/op |
|  iterateForEach  |   10000  |    64.829,7   |          N/A    |  129.159,05   |      32.879,05   |     31.692,9    | us/op |
|  iterateForLoop  |     100  |     2.272,05  |          N/A    |    4.036,95   |       1.997,95   |      1.765,85   | us/op |
|  iterateForLoop  |    1000  |     9.142,6   |          N/A    |   20.885,0    |       9.219,95   |      9.239,35   | us/op |
|  iterateForLoop  |   10000  |    61.260,0   |          N/A    |  127.934,55   |      35.116,7    |     34.100,05   | us/op |
|  iterateStream   |     100  |     3.394,1   |          N/A    |    5.017,6    |       2.435,5    |      3.692,8    | us/op |
|  iterateStream   |    1000  |     9.586,55  |          N/A    |   23.359,0    |       8.885,45   |     10.203,35   | us/op |
|  iterateStream   |   10000  |    65.661,25  |          N/A    |  129.222,35   |      41.241,2    |     40.257,65   | us/op |
|  remove          |     100  |     2.930,7   |          N/A    |    2.490,55   |       1.877,5    |      2.305,4    | us/op |
|  remove          |    1000  |     3.643,4   |          N/A    |    2.826,6    |       1.907,95   |      1.937,45   | us/op |
|  remove          |   10000  |     3.846,65  |          N/A    |    2.635,75   |       2.037,5    |      2.048,25   | us/op |
|  toArray         |     100  |     2.475,9   |          N/A    |    3.732,9    |       2.174,5    |      2.756,15   | us/op |
|  toArray         |    1000  |    12.299,35  |          N/A    |   21.379,75   |      11.995,4    |     11.422,85   | us/op |
|  toArray         |   10000  |    81.716,7   |          N/A    |  134.373,4    |      47.529,3    |     47.883,15   | us/op |

### ArraySet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |    HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|------------------|------------------|-----------------|-------|
|  add             |     100  |         N/A   |          N/A    |           N/A    |       4.620,1    |      3.954,1    | us/op |
|  add             |    1000  |         N/A   |          N/A    |           N/A    |     186.504,1    |     78.229,2    | us/op |
|  add             |   10000  |         N/A   |          N/A    |           N/A    |  16.830.789,8    |  5.732.792,1    | us/op |
|  addEmpty        |     100  |         N/A   |          N/A    |           N/A    |       5.101,95   |      5.506,6    | us/op |
|  addEmpty        |    1000  |         N/A   |          N/A    |           N/A    |     190.082,15   |     84.251,4    | us/op |
|  addEmpty        |   10000  |         N/A   |          N/A    |           N/A    |  16.856.194,65   |  5.821.980,5    | us/op |
|  contains        |     100  |         N/A   |          N/A    |           N/A    |       7.648,55   |      5.827,8    | us/op |
|  contains        |    1000  |         N/A   |          N/A    |           N/A    |      39.071,5    |      9.863,35   | us/op |
|  contains        |   10000  |         N/A   |          N/A    |           N/A    |     379.261,8    |     84.041,9    | us/op |
|  iterateForEach  |     100  |         N/A   |          N/A    |           N/A    |       2.830,45   |      2.800,9    | us/op |
|  iterateForEach  |    1000  |         N/A   |          N/A    |           N/A    |      10.165,7    |      5.286,0    | us/op |
|  iterateForEach  |   10000  |         N/A   |          N/A    |           N/A    |      38.134,7    |     22.187,55   | us/op |
|  iterateForLoop  |     100  |         N/A   |          N/A    |           N/A    |       2.490,85   |      1.712,2    | us/op |
|  iterateForLoop  |    1000  |         N/A   |          N/A    |           N/A    |       8.916,3    |      8.410,5    | us/op |
|  iterateForLoop  |   10000  |         N/A   |          N/A    |           N/A    |      35.955,05   |     24.801,25   | us/op |
|  iterateStream   |     100  |         N/A   |          N/A    |           N/A    |       3.048,3    |      3.071,7    | us/op |
|  iterateStream   |    1000  |         N/A   |          N/A    |           N/A    |       8.781,7    |      9.225,5    | us/op |
|  iterateStream   |   10000  |         N/A   |          N/A    |           N/A    |      32.750,9    |     31.493,1    | us/op |
|  toArray         |     100  |         N/A   |          N/A    |           N/A    |         398,25   |        491,85   | us/op |
|  toArray         |    1000  |         N/A   |          N/A    |           N/A    |       2.167,15   |      1.516,75   | us/op |
|  toArray         |   10000  |         N/A   |          N/A    |           N/A    |      19.509,3    |     12.370,05   | us/op |

### AVLTreeSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  add             |     100  |    12.605,6   |          N/A    |          N/A    |      15.205,85   |     13.105,05   | us/op |
|  add             |    1000  |    95.793,05  |          N/A    |          N/A    |     116.336,5    |     98.552,1    | us/op |
|  add             |   10000  | 1.234.267,15  |          N/A    |          N/A    |   1.536.598,85   |  1.318.341,15   | us/op |
|  contains        |     100  |     4.659,3   |          N/A    |          N/A    |       3.927,45   |      3.327,6    | us/op |
|  contains        |    1000  |     6.470,2   |          N/A    |          N/A    |       4.475,0    |      4.449,8    | us/op |
|  contains        |   10000  |     9.031,45  |          N/A    |          N/A    |       7.829,7    |      5.090,6    | us/op |
|  iterateForEach  |     100  |     3.082,0   |          N/A    |          N/A    |       3.806,4    |      1.817,55   | us/op |
|  iterateForEach  |    1000  |    13.738,8   |          N/A    |          N/A    |      10.296,7    |      8.385,15   | us/op |
|  iterateForEach  |   10000  |   142.952,55  |          N/A    |          N/A    |      66.418,0    |     69.995,7    | us/op |
|  iterateForLoop  |     100  |     2.773,95  |          N/A    |          N/A    |       3.049,25   |      2.247,85   | us/op |
|  iterateForLoop  |    1000  |    12.609,9   |          N/A    |          N/A    |      10.740,05   |     10.193,5    | us/op |
|  iterateForLoop  |   10000  |   143.943,1   |          N/A    |          N/A    |      70.856,95   |     71.928,25   | us/op |
|  iterateStream   |     100  |     2.868,1   |          N/A    |          N/A    |       4.122,1    |      4.092,25   | us/op |
|  iterateStream   |    1000  |    11.552,9   |          N/A    |          N/A    |      11.571,15   |     12.455,85   | us/op |
|  iterateStream   |   10000  |   146.416,45  |          N/A    |          N/A    |      68.200,9    |     78.418,0    | us/op |
|  pollFirst       |     100  |       243,95  |          N/A    |          N/A    |           N/A    |        149,1    | us/op |
|  pollFirst       |    1000  |       796,8   |          N/A    |          N/A    |           N/A    |        746,3    | us/op |
|  pollFirst       |   10000  |     1.983,6   |          N/A    |          N/A    |           N/A    |      1.018,1    | us/op |
|  pollLast        |     100  |       441,45  |          N/A    |          N/A    |           N/A    |        206,15   | us/op |
|  pollLast        |    1000  |     1.144,65  |          N/A    |          N/A    |           N/A    |        255,6    | us/op |
|  pollLast        |   10000  |     1.576,35  |          N/A    |          N/A    |           N/A    |      1.977,1    | us/op |
|  remove          |     100  |     4.704,45  |          N/A    |          N/A    |           N/A    |      2.933,15   | us/op |
|  remove          |    1000  |     5.268,15  |          N/A    |          N/A    |           N/A    |      4.361,8    | us/op |
|  remove          |   10000  |    11.157,75  |          N/A    |          N/A    |           N/A    |     14.808,1    | us/op |
|  toArray         |     100  |     2.783,7   |          N/A    |          N/A    |       2.780,4    |      2.349,25   | us/op |
|  toArray         |    1000  |    17.588,4   |          N/A    |          N/A    |      11.308,6    |     10.896,2    | us/op |
|  toArray         |   10000  |   156.117,9   |          N/A    |          N/A    |      68.170,9    |     67.828,8    | us/op |

### RBTreeSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  add             |     100  |    12.605,6   |          N/A    |          N/A    |      15.384,4    |     13.021,25   | us/op |
|  add             |    1000  |    95.793,05  |          N/A    |          N/A    |     111.389,3    |     77.383,1    | us/op |
|  add             |   10000  | 1.234.267,15  |          N/A    |          N/A    |   1.362.143,1    |  1.060.790,75   | us/op |
|  contains        |     100  |     4.659,3   |          N/A    |          N/A    |       3.978,55   |      3.367,4    | us/op |
|  contains        |    1000  |     6.470,2   |          N/A    |          N/A    |       4.333,7    |      4.027,65   | us/op |
|  contains        |   10000  |     9.031,45  |          N/A    |          N/A    |       8.446,5    |      6.579,7    | us/op |
|  iterateForEach  |     100  |     3.082,0   |          N/A    |          N/A    |       3.375,2    |      1.795,95   | us/op |
|  iterateForEach  |    1000  |    13.738,8   |          N/A    |          N/A    |      10.635,95   |      7.821,7    | us/op |
|  iterateForEach  |   10000  |   142.952,55  |          N/A    |          N/A    |      69.710,3    |     67.929,15   | us/op |
|  iterateForLoop  |     100  |     2.773,95  |          N/A    |          N/A    |       2.446,55   |      2.576,3    | us/op |
|  iterateForLoop  |    1000  |    12.609,9   |          N/A    |          N/A    |      10.614,3    |     10.410,55   | us/op |
|  iterateForLoop  |   10000  |   143.943,1   |          N/A    |          N/A    |      66.633,05   |     83.422,7    | us/op |
|  iterateStream   |     100  |     2.868,1   |          N/A    |          N/A    |       3.973,25   |      3.726,7    | us/op |
|  iterateStream   |    1000  |    11.552,9   |          N/A    |          N/A    |      11.377,65   |     12.635,0    | us/op |
|  iterateStream   |   10000  |   146.416,45  |          N/A    |          N/A    |      68.244,95   |     77.255,7    | us/op |
|  pollFirst       |     100  |       243,95  |          N/A    |          N/A    |           N/A    |        173,45   | us/op |
|  pollFirst       |    1000  |       796,8   |          N/A    |          N/A    |           N/A    |        225,15   | us/op |
|  pollFirst       |   10000  |     1.983,6   |          N/A    |          N/A    |           N/A    |      1.203,35   | us/op |
|  pollLast        |     100  |       441,45  |          N/A    |          N/A    |           N/A    |        165,0    | us/op |
|  pollLast        |    1000  |     1.144,65  |          N/A    |          N/A    |           N/A    |        349,1    | us/op |
|  pollLast        |   10000  |     1.576,35  |          N/A    |          N/A    |           N/A    |      1.252,55   | us/op |
|  remove          |     100  |     4.704,45  |          N/A    |          N/A    |           N/A    |      3.117,3    | us/op |
|  remove          |    1000  |     5.268,15  |          N/A    |          N/A    |           N/A    |      8.314,6    | us/op |
|  remove          |   10000  |    11.157,75  |          N/A    |          N/A    |           N/A    |     14.344,65   | us/op |
|  toArray         |     100  |     2.783,7   |          N/A    |          N/A    |       2.537,0    |      3.076,85   | us/op |
|  toArray         |    1000  |    17.588,4   |          N/A    |          N/A    |      11.248,7    |     11.981,05   | us/op |
|  toArray         |   10000  |   156.117,9   |          N/A    |          N/A    |      66.280,5    |     75.547,05   | us/op |

### HashMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  clone         |     100  |     7.692,55  |          N/A    |    2.440,2    |       1.861,4    |      7.573,8    | us/op |
|  clone         |    1000  |    33.964,4   |          N/A    |   12.452,35   |      12.015,15   |     15.324,65   | us/op |
|  clone         |   10000  |   231.899,4   |          N/A    |   71.214,8    |      71.985,85   |     75.267,0    | us/op |
|  containsKey   |     100  |     3.685,45  |      2.456,05   |    1.960,9    |       2.323,3    |      2.575,7    | us/op |
|  containsKey   |    1000  |     4.302,6   |      2.381,15   |    1.810,0    |       1.879,6    |      2.327,35   | us/op |
|  containsKey   |   10000  |     5.231,65  |      2.321,85   |    1.909,8    |       2.931,15   |      2.251,55   | us/op |
|  forEach       |     100  |     2.157,3   |          N/A    |    5.588,65   |       5.157,4    |      2.685,75   | us/op |
|  forEach       |    1000  |    13.985,6   |          N/A    |   26.121,95   |      24.157,8    |      9.005,65   | us/op |
|  forEach       |   10000  |   119.617,1   |          N/A    |  147.999,05   |     189.704,85   |    107.511,9    | us/op |
|  get           |     100  |     3.749,4   |      3.333,35   |    2.112,15   |       2.194,1    |      2.752,4    | us/op |
|  get           |    1000  |     4.739,25  |      3.203,7    |    2.128,65   |       2.183,2    |      3.085,65   | us/op |
|  get           |   10000  |     5.606,65  |      3.084,35   |    2.197,55   |       2.282,1    |      2.140,3    | us/op |
|  getOrDefault  |     100  |     5.389,25  |          N/A    |    2.218,8    |       2.068,25   |      2.660,0    | us/op |
|  getOrDefault  |    1000  |     6.220,3   |          N/A    |    2.114,2    |       2.115,9    |      3.081,55   | us/op |
|  getOrDefault  |   10000  |     6.231,8   |          N/A    |    2.266,05   |       2.786,2    |      2.430,0    | us/op |
|  keySet        |     100  |     2.993,25  |      5.141,6    |    4.199,1    |       3.008,8    |      3.168,95   | us/op |
|  keySet        |    1000  |    13.630,0   |     18.672,1    |   22.139,1    |      12.642,1    |     15.419,1    | us/op |
|  keySet        |   10000  |    91.415,5   |     77.226,2    |  127.103,75   |      93.602,3    |    105.809,65   | us/op |
|  put           |     100  |     6.828,85  |      5.008,9    |    8.076,85   |       8.887,25   |      9.523,85   | us/op |
|  put           |    1000  |    47.709,8   |     22.972,7    |   21.524,3    |      23.234,7    |     22.534,0    | us/op |
|  put           |   10000  |   273.220,5   |    181.103,0    |  144.391,05   |     156.822,5    |    168.795,05   | us/op |
|  putEmpty      |     100  |     8.774,1   |      7.461,25   |    9.281,0    |      11.599,0    |      8.263,85   | us/op |
|  putEmpty      |    1000  |    54.487,5   |     53.650,8    |   30.403,1    |      32.011,3    |     31.773,1    | us/op |
|  putEmpty      |   10000  |   461.387,0   |    306.629,35   |  341.287,25   |     352.948,15   |    334.487,4    | us/op |
|  remove        |     100  |     4.275,3   |      3.393,15   |    1.974,6    |       1.966,65   |      2.554,7    | us/op |
|  remove        |    1000  |     4.077,3   |      4.128,35   |    2.599,95   |       2.249,3    |      2.429,6    | us/op |
|  remove        |   10000  |     4.060,5   |      2.843,75   |    2.090,95   |       2.053,95   |      2.519,75   | us/op |
|  replace       |     100  |     5.309,2   |          N/A    |        N/A    |       2.613,5    |      2.814,4    | us/op |
|  replace       |    1000  |     6.656,1   |          N/A    |        N/A    |       2.514,7    |      2.612,55   | us/op |
|  replace       |   10000  |     7.118,15  |          N/A    |        N/A    |       2.827,25   |      3.595,0    | us/op |
|  values        |     100  |     2.665,55  |      4.916,65   |        N/A    |       3.119,15   |      3.875,0    | us/op |
|  values        |    1000  |    13.406,1   |     20.935,95   |        N/A    |      12.615,45   |     17.762,8    | us/op |
|  values        |   10000  |    95.113,15  |     83.678,55   |        N/A    |      96.485,65   |    112.638,55   | us/op |

### LinkedHashMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  clone         |     100  |     6.196,75  |          N/A    |    2.294,55   |       3.106,4    |      8.220,75   | us/op |
|  clone         |    1000  |    31.097,2   |          N/A    |   13.137,55   |      22.744,55   |     24.081,55   | us/op |
|  clone         |   10000  |   187.590,1   |          N/A    |   72.795,75   |      98.817,15   |    116.427,2    | us/op |
|  containsKey   |     100  |     3.437,55  |          N/A    |    2.617,7    |       2.200,7    |      2.438,8    | us/op |
|  containsKey   |    1000  |     4.478,1   |          N/A    |    2.344,05   |       1.911,65   |      2.487,1    | us/op |
|  containsKey   |   10000  |     4.650,8   |          N/A    |    2.847,75   |       2.328,1    |      1.896,6    | us/op |
|  forEach       |     100  |     1.766,4   |          N/A    |    4.955,95   |       4.220,65   |      2.107,85   | us/op |
|  forEach       |    1000  |     8.068,0   |          N/A    |   24.692,95   |      22.231,85   |      8.028,25   | us/op |
|  forEach       |   10000  |    70.940,5   |          N/A    |  159.308,55   |     152.625,5    |     63.443,85   | us/op |
|  get           |     100  |     3.627,0   |          N/A    |    2.941,9    |       2.125,55   |      2.974,9    | us/op |
|  get           |    1000  |     4.536,95  |          N/A    |    2.929,55   |       2.036,9    |      2.787,15   | us/op |
|  get           |   10000  |     4.729,3   |          N/A    |    2.727,5    |       2.629,85   |      2.959,5    | us/op |
|  getOrDefault  |     100  |     5.494,25  |          N/A    |    3.624,05   |       2.307,45   |      2.572,0    | us/op |
|  getOrDefault  |    1000  |     6.241,9   |          N/A    |    3.397,85   |       2.083,95   |      2.371,5    | us/op |
|  getOrDefault  |   10000  |     7.253,3   |          N/A    |    3.372,45   |       2.418,4    |      2.780,2    | us/op |
|  keySet        |     100  |     1.968,5   |          N/A    |    4.697,35   |       2.267,05   |      2.382,6    | us/op |
|  keySet        |    1000  |    10.188,45  |          N/A    |   21.179,35   |      10.137,1    |     10.525,2    | us/op |
|  keySet        |   10000  |    58.384,5   |          N/A    |  133.835,75   |      34.879,55   |     33.564,75   | us/op |
|  put           |     100  |     8.725,5   |          N/A    |    8.133,45   |       9.031,5    |      7.744,45   | us/op |
|  put           |    1000  |    55.177,5   |          N/A    |   27.786,35   |      32.753,25   |     31.417,8    | us/op |
|  put           |   10000  |   336.067,85  |          N/A    |  189.931,75   |     197.798,65   |    208.497,2    | us/op |
|  putEmpty      |     100  |    10.380,55  |          N/A    |   11.192,05   |      12.088,15   |     12.050,2    | us/op |
|  putEmpty      |    1000  |    62.550,6   |          N/A    |   64.970,35   |      44.542,6    |     41.389,85   | us/op |
|  putEmpty      |   10000  |   527.963,1   |          N/A    |  499.414,3    |     440.066,0    |    415.183,25   | us/op |
|  remove        |     100  |     3.350,65  |          N/A    |    2.586,95   |       2.015,45   |      2.841,45   | us/op |
|  remove        |    1000  |     3.997,0   |          N/A    |    2.536,3    |       2.259,35   |      2.648,2    | us/op |
|  remove        |   10000  |     6.423,55  |          N/A    |    2.699,4    |       2.281,85   |      3.839,95   | us/op |
|  replace       |     100  |     5.216,15  |          N/A    |        N/A    |       2.497,75   |      2.639,0    | us/op |
|  replace       |    1000  |     7.178,75  |          N/A    |        N/A    |       2.883,95   |      2.610,45   | us/op |
|  replace       |   10000  |     7.448,0   |          N/A    |        N/A    |       2.943,0    |      3.457,05   | us/op |
|  values        |     100  |     1.953,8   |          N/A    |        N/A    |       2.038,95   |      2.076,65   | us/op |
|  values        |    1000  |     9.425,4   |          N/A    |        N/A    |       9.841,1    |     12.582,75   | us/op |
|  values        |   10000  |    65.255,7   |          N/A    |        N/A    |      39.295,4    |     49.934,1    | us/op |

### ArrayMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  clone         |     100  |         N/A   |          N/A    |          N/A    |       1.285,8    |      1.205,8    | us/op |
|  clone         |    1000  |         N/A   |          N/A    |          N/A    |       6.417,15   |      7.391,15   | us/op |
|  clone         |   10000  |         N/A   |          N/A    |          N/A    |      59.029,45   |     63.124,5    | us/op |
|  containsKey   |     100  |         N/A   |          N/A    |          N/A    |       7.433,25   |      4.169,9    | us/op |
|  containsKey   |    1000  |         N/A   |          N/A    |          N/A    |      43.912,8    |     10.600,45   | us/op |
|  containsKey   |   10000  |         N/A   |          N/A    |          N/A    |     374.654,75   |     78.790,35   | us/op |
|  forEach       |     100  |         N/A   |          N/A    |          N/A    |       4.641,7    |      1.784,45   | us/op |
|  forEach       |    1000  |         N/A   |          N/A    |          N/A    |      45.029,25   |      8.481,4    | us/op |
|  forEach       |   10000  |         N/A   |          N/A    |          N/A    |     169.649,4    |     39.330,0    | us/op |
|  get           |     100  |         N/A   |          N/A    |          N/A    |       8.107,3    |      4.152,85   | us/op |
|  get           |    1000  |         N/A   |          N/A    |          N/A    |      46.249,35   |     11.177,55   | us/op |
|  get           |   10000  |         N/A   |          N/A    |          N/A    |     361.021,2    |     79.052,15   | us/op |
|  getOrDefault  |     100  |         N/A   |          N/A    |          N/A    |      12.342,45   |      3.986,65   | us/op |
|  getOrDefault  |    1000  |         N/A   |          N/A    |          N/A    |      93.254,4    |     11.366,15   | us/op |
|  getOrDefault  |   10000  |         N/A   |          N/A    |          N/A    |     569.132,55   |     81.031,05   | us/op |
|  keySet        |     100  |         N/A   |          N/A    |          N/A    |       2.420,65   |      2.577,95   | us/op |
|  keySet        |    1000  |         N/A   |          N/A    |          N/A    |      10.758,1    |      9.386,45   | us/op |
|  keySet        |   10000  |         N/A   |          N/A    |          N/A    |      39.464,2    |     27.466,0    | us/op |
|  put           |     100  |         N/A   |          N/A    |          N/A    |       5.206,15   |      7.164,85   | us/op |
|  put           |    1000  |         N/A   |          N/A    |          N/A    |     150.454,2    |     89.304,25   | us/op |
|  put           |   10000  |         N/A   |          N/A    |          N/A    |  16.800.331,7    |  5.601.288,35   | us/op |
|  putEmpty      |     100  |         N/A   |          N/A    |          N/A    |       7.722,95   |      8.743,7    | us/op |
|  putEmpty      |    1000  |         N/A   |          N/A    |          N/A    |     193.334,25   |     96.960,75   | us/op |
|  putEmpty      |   10000  |         N/A   |          N/A    |          N/A    |  16.668.249,0    |  5.497.335,15   | us/op |
|  remove        |     100  |         N/A   |          N/A    |          N/A    |       8.151,85   |      3.198,6    | us/op |
|  remove        |    1000  |         N/A   |          N/A    |          N/A    |      59.754,95   |     30.150,5    | us/op |
|  remove        |   10000  |         N/A   |          N/A    |          N/A    |     568.410,85   |    134.112,15   | us/op |
|  replace       |     100  |         N/A   |          N/A    |          N/A    |       9.709,6    |      4.884,25   | us/op |
|  replace       |    1000  |         N/A   |          N/A    |          N/A    |      56.686,65   |     10.971,9    | us/op |
|  replace       |   10000  |         N/A   |          N/A    |          N/A    |     506.741,25   |     83.328,75   | us/op |
|  values        |     100  |         N/A   |          N/A    |          N/A    |       2.654,5    |      1.936,75   | us/op |
|  values        |    1000  |         N/A   |          N/A    |          N/A    |      10.813,0    |      9.417,1    | us/op |
|  values        |   10000  |         N/A   |          N/A    |          N/A    |      40.529,85   |     25.741,1    | us/op |

### AVLTreeMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  clone         |     100  |     5.481,0   |          N/A    |          N/A    |       5.276,1    |      2.192,05   | us/op |
|  clone         |    1000  |    24.308,8   |          N/A    |          N/A    |      29.111,9    |     14.275,95   | us/op |
|  clone         |   10000  |   193.860,2   |          N/A    |          N/A    |     146.481,2    |    112.057,55   | us/op |
|  containsKey   |     100  |     4.017,1   |          N/A    |          N/A    |       4.593,9    |      3.733,85   | us/op |
|  containsKey   |    1000  |     5.346,5   |          N/A    |          N/A    |       4.722,65   |      5.634,9    | us/op |
|  containsKey   |   10000  |     9.499,8   |          N/A    |          N/A    |      11.106,1    |      8.099,3    | us/op |
|  forEach       |     100  |     2.470,8   |          N/A    |          N/A    |       9.219,2    |      2.116,2    | us/op |
|  forEach       |    1000  |    12.592,8   |          N/A    |          N/A    |      26.003,85   |      9.952,4    | us/op |
|  forEach       |   10000  |   150.521,25  |          N/A    |          N/A    |     165.744,3    |     85.067,7    | us/op |
|  get           |     100  |     4.312,15  |          N/A    |          N/A    |       3.627,3    |      3.446,95   | us/op |
|  get           |    1000  |     5.890,55  |          N/A    |          N/A    |       4.035,15   |      4.231,3    | us/op |
|  get           |   10000  |    10.200,4   |          N/A    |          N/A    |       9.505,6    |      5.905,6    | us/op |
|  getOrDefault  |     100  |     6.447,65  |          N/A    |          N/A    |       4.799,3    |      3.291,9    | us/op |
|  getOrDefault  |    1000  |     8.408,3   |          N/A    |          N/A    |       5.983,4    |      3.943,35   | us/op |
|  getOrDefault  |   10000  |    13.727,75  |          N/A    |          N/A    |      14.560,5    |      5.911,3    | us/op |
|  keySet        |     100  |     2.922,0   |          N/A    |          N/A    |       3.237,45   |      2.724,75   | us/op |
|  keySet        |    1000  |    13.859,05  |          N/A    |          N/A    |      12.827,05   |     11.000,75   | us/op |
|  keySet        |   10000  |   142.419,45  |          N/A    |          N/A    |      68.788,05   |     73.627,9    | us/op |
|  pollFirst     |     100  |       332,2   |          N/A    |          N/A    |           N/A    |        156,6    | us/op |
|  pollFirst     |    1000  |       477,55  |          N/A    |          N/A    |           N/A    |        191,6    | us/op |
|  pollFirst     |   10000  |     1.176,35  |          N/A    |          N/A    |           N/A    |        836,0    | us/op |
|  pollLast      |     100  |       156,9   |          N/A    |          N/A    |           N/A    |        176,65   | us/op |
|  pollLast      |    1000  |       392,1   |          N/A    |          N/A    |           N/A    |        221,9    | us/op |
|  pollLast      |   10000  |     1.082,5   |          N/A    |          N/A    |           N/A    |        939,1    | us/op |
|  put           |     100  |    12.418,75  |          N/A    |          N/A    |      16.007,45   |     12.594,55   | us/op |
|  put           |    1000  |   110.940,55  |          N/A    |          N/A    |     118.316,1    |     92.205,5    | us/op |
|  put           |   10000  | 1.407.753,75  |          N/A    |          N/A    |   1.570.752,4    |  1.301.302,05   | us/op |
|  remove        |     100  |     4.645,05  |          N/A    |          N/A    |       7.673,6    |      3.771,85   | us/op |
|  remove        |    1000  |     6.359,25  |          N/A    |          N/A    |      10.358,45   |      3.566,4    | us/op |
|  remove        |   10000  |    14.233,3   |          N/A    |          N/A    |      11.348,65   |     16.156,8    | us/op |
|  replace       |     100  |     5.202,55  |          N/A    |          N/A    |       8.198,5    |      3.991,3    | us/op |
|  replace       |    1000  |     8.112,0   |          N/A    |          N/A    |      17.687,0    |      4.459,9    | us/op |
|  replace       |   10000  |    14.727,15  |          N/A    |          N/A    |      16.848,9    |     15.062,4    | us/op |
|  values        |     100  |     2.669,35  |          N/A    |          N/A    |       2.496,8    |      2.378,8    | us/op |
|  values        |    1000  |    13.133,1   |          N/A    |          N/A    |      11.275,35   |     11.051,85   | us/op |
|  values        |   10000  |   142.012,3   |          N/A    |          N/A    |      71.217,5    |     81.892,05   | us/op |

### RBTreeMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score    |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|-----------------|------------------|-----------------|-------|
|  clone         |     100  |     5.481,0   |          N/A    |          N/A    |       5.688,4    |      4.498,9    | us/op |
|  clone         |    1000  |    24.308,8   |          N/A    |          N/A    |      31.622,6    |     14.543,6    | us/op |
|  clone         |   10000  |   193.860,2   |          N/A    |          N/A    |     153.631,6    |    103.398,85   | us/op |
|  containsKey   |     100  |     4.017,1   |          N/A    |          N/A    |       4.777,1    |      3.352,85   | us/op |
|  containsKey   |    1000  |     5.346,5   |          N/A    |          N/A    |       5.264,8    |      3.633,2    | us/op |
|  containsKey   |   10000  |     9.499,8   |          N/A    |          N/A    |      10.713,45   |      6.460,15   | us/op |
|  forEach       |     100  |     2.470,8   |          N/A    |          N/A    |       6.238,6    |      2.368,9    | us/op |
|  forEach       |    1000  |    12.592,8   |          N/A    |          N/A    |      26.993,75   |      9.448,0    | us/op |
|  forEach       |   10000  |   150.521,25  |          N/A    |          N/A    |     168.969,65   |     80.284,3    | us/op |
|  get           |     100  |     4.312,15  |          N/A    |          N/A    |       3.867,25   |      3.295,75   | us/op |
|  get           |    1000  |     5.890,55  |          N/A    |          N/A    |       4.245,8    |      5.290,7    | us/op |
|  get           |   10000  |    10.200,4   |          N/A    |          N/A    |       9.606,8    |      5.807,05   | us/op |
|  getOrDefault  |     100  |     6.447,65  |          N/A    |          N/A    |       5.254,15   |      4.599,2    | us/op |
|  getOrDefault  |    1000  |     8.408,3   |          N/A    |          N/A    |       5.787,7    |      5.184,95   | us/op |
|  getOrDefault  |   10000  |    13.727,75  |          N/A    |          N/A    |      12.375,85   |      7.165,15   | us/op |
|  keySet        |     100  |     2.922,0   |          N/A    |          N/A    |       2.429,4    |      2.617,1    | us/op |
|  keySet        |    1000  |    13.859,05  |          N/A    |          N/A    |      11.612,8    |     11.232,2    | us/op |
|  keySet        |   10000  |   142.419,45  |          N/A    |          N/A    |      67.805,35   |     75.216,2    | us/op |
|  pollFirst     |     100  |       332,2   |          N/A    |          N/A    |           N/A    |        299,6    | us/op |
|  pollFirst     |    1000  |       477,55  |          N/A    |          N/A    |           N/A    |        672,0    | us/op |
|  pollFirst     |   10000  |     1.176,35  |          N/A    |          N/A    |           N/A    |      1.435,1    | us/op |
|  pollLast      |     100  |       156,9   |          N/A    |          N/A    |           N/A    |        230,7    | us/op |
|  pollLast      |    1000  |       392,1   |          N/A    |          N/A    |           N/A    |        314,85   | us/op |
|  pollLast      |   10000  |     1.082,5   |          N/A    |          N/A    |           N/A    |      1.214,8    | us/op |
|  put           |     100  |    12.418,75  |          N/A    |          N/A    |      17.020,1    |     12.886,9    | us/op |
|  put           |    1000  |   110.940,55  |          N/A    |          N/A    |     115.529,45   |     76.563,15   | us/op |
|  put           |   10000  | 1.407.753,75  |          N/A    |          N/A    |   1.370.076,45   |    988.408,65   | us/op |
|  remove        |     100  |     4.645,05  |          N/A    |          N/A    |      13.961,45   |      3.488,8    | us/op |
|  remove        |    1000  |     6.359,25  |          N/A    |          N/A    |      18.190,1    |      4.405,7    | us/op |
|  remove        |   10000  |    14.233,3   |          N/A    |          N/A    |      22.783,0    |     15.528,25   | us/op |
|  replace       |     100  |     5.202,55  |          N/A    |          N/A    |      10.814,65   |      3.680,25   | us/op |
|  replace       |    1000  |     8.112,0   |          N/A    |          N/A    |      16.704,65   |      3.936,4    | us/op |
|  replace       |   10000  |    14.727,15  |          N/A    |          N/A    |      14.106,25   |     11.620,85   | us/op |
|  values        |     100  |     2.669,35  |          N/A    |          N/A    |       2.680,3    |      2.376,8    | us/op |
|  values        |    1000  |    13.133,1   |          N/A    |          N/A    |      11.211,95   |     11.354,65   | us/op |
|  values        |   10000  |   142.012,3   |          N/A    |          N/A    |      70.077,25   |     86.945,5    | us/op |

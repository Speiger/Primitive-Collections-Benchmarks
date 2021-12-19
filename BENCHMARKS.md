## Benchmarks

### Info
Benchmarks were made using Jmh version 1.25 and Java OpenJDK 8 version 275-1 on a Intel I5-7500 and the following libraries:
- Primitive Collections 0.5.2
- FastUtil 8.5.6
- HPPC 0.9.1
- Eclipse Collections 11.0.0
The results may differ for each JVM.

Each benchmark was created using Average Time with a 10 second warmup time and using Primitive Values (objects for Java Collections)
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
|      Action      |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|------------------|----------|----------------|-----------------|---------------|------------------|--------------|-------|
|  add             |     100  |         88,635 |         19,461  |       71,941  |          10,759  |      65,118  | us/op |
|  add             |    1000  |      1.241,57  |        188,502  |      741,711  |          86,897  |     692,879  | us/op |
|  add             |   10000  |     11.189,414 |      2.058,557  |    7.026,398  |         959,896  |   6.167,507  | us/op |
|  addEmpty        |     100  |        128,805 |        106,386  |      104,189  |         106,291  |      87,491  | us/op |
|  addEmpty        |    1000  |      1.558,242 |        980,304  |      882,55   |         941,805  |     765,192  | us/op |
|  addEmpty        |   10000  |     13.270,167 |      9.125,737  |    9.057,533  |       8.997,325  |   7.655,464  | us/op |
|  contains        |     100  |        997,768 |        481,77   |      431,402  |         399,021  |     399,819  | us/op |
|  contains        |    1000  |      8.608,778 |      3.101,819  |    2.717,479  |       2.547,917  |   2.443,648  | us/op |
|  contains        |   10000  |    270.477,209 |     29.560,527  |   26.700,753  |      26.007,99   |  23.697,341  | us/op |
|  get             |     100  |         89,595 |         72,128  |       74,48   |          89,758  |      72,9    | us/op |
|  get             |    1000  |         90,887 |         72,245  |       75,763  |          77,653  |      73,99   | us/op |
|  get             |   10000  |         85,763 |         72,388  |       74,331  |          75,876  |      72,745  | us/op |
|  indexOf         |     100  |        947,875 |        456,062  |      501,266  |         472,136  |     463,754  | us/op |
|  indexOf         |    1000  |      9.363,28  |      3.050,317  |    3.430,985  |       3.259,071  |   3.030,429  | us/op |
|  indexOf         |   10000  |    270.389,032 |     29.331,453  |   31.307,266  |      29.347,311  |  29.454,338  | us/op |
|  iterateForEach  |     100  |         93,272 |         61,191  |       74,49   |          65,046  |      61,641  | us/op |
|  iterateForEach  |    1000  |        939,872 |        591,633  |      705,694  |         628,0    |     603,674  | us/op |
|  iterateForEach  |   10000  |     14.210,058 |      5.877,581  |    7.594,528  |       6.315,012  |   5.889,203  | us/op |
|  iterateForLoop  |     100  |         81,992 |         66,399  |       73,573  |          70,641  |      68,823  | us/op |
|  iterateForLoop  |    1000  |        930,381 |        677,927  |      714,221  |         616,915  |     745,748  | us/op |
|  iterateForLoop  |   10000  |     11.113,842 |      6.554,464  |    7.641,174  |       6.946,812  |   7.269,397  | us/op |
|  iterateIndex    |     100  |         73,393 |         65,509  |       75,046  |          70,249  |      69,608  | us/op |
|  iterateIndex    |    1000  |        714,553 |        639,829  |      661,035  |         686,194  |     667,672  | us/op |
|  iterateIndex    |   10000  |      6.908,254 |      6.440,354  |    6.273,136  |       6.702,941  |   6.652,631  | us/op |
|  iterateStream   |     100  |         56,748 |         59,309  |      100,467  |          78,586  |      59,018  | us/op |
|  iterateStream   |    1000  |        532,812 |        430,879  |      936,8    |         737,071  |     445,573  | us/op |
|  iterateStream   |   10000  |      7.447,437 |      4.670,54   |    9.296,852  |       7.439,109  |   4.579,44   | us/op |
|  lastIndexOf     |     100  |        884,547 |        379,055  |      391,589  |       1.004,735  |     418,411  | us/op |
|  lastIndexOf     |    1000  |      7.341,973 |      2.357,225  |    2.661,576  |       7.383,706  |   2.499,592  | us/op |
|  lastIndexOf     |   10000  |    247.315,149 |     24.844,645  |   26.490,323  |      80.720,647  |  25.551,74   | us/op |
|  remove          |     100  |        537,793 |        224,365  |      251,69   |         236,756  |     236,452  | us/op |
|  remove          |    1000  |     12.364,508 |      3.592,364  |    4.799,531  |       4.586,319  |   3.529,162  | us/op |
|  remove          |   10000  |    370.639,441 |     35.246,499  |   39.691,296  |      39.043,693  |  38.004,386  | us/op |
|  toArray         |     100  |         28,949 |          9,587  |        8,146  |          10,473  |       9,674  | us/op |
|  toArray         |    1000  |        263,035 |         86,903  |       82,217  |          92,194  |      88,074  | us/op |
|  toArray         |   10000  |      2.880,251 |        787,948  |      780,994  |         825,162  |     796,58   | us/op |

### LinkedList
|      Action      |   Size   |    Java Score    |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|------------------|----------|------------------|-----------------|---------------|------------------|---------------|-------|
|  add             |     100  |          108,93  |          N/A    |        N/A    |           N/A    |      109,205  | us/op |
|  add             |    1000  |        1.475,964 |          N/A    |        N/A    |           N/A    |    1.048,517  | us/op |
|  add             |   10000  |       14.253,216 |          N/A    |        N/A    |           N/A    |   10.264,612  | us/op |
|  contains        |     100  |        2.572,639 |          N/A    |        N/A    |           N/A    |    2.220,974  | us/op |
|  contains        |    1000  |       55.621,713 |          N/A    |        N/A    |           N/A    |   21.489,613  | us/op |
|  contains        |   10000  |      956.050,905 |          N/A    |        N/A    |           N/A    |  267.337,923  | us/op |
|  iterateForEach  |     100  |           86,841 |          N/A    |        N/A    |           N/A    |       57,515  | us/op |
|  iterateForEach  |    1000  |        1.136,283 |          N/A    |        N/A    |           N/A    |      569,933  | us/op |
|  iterateForEach  |   10000  |       14.731,647 |          N/A    |        N/A    |           N/A    |    5.994,678  | us/op |
|  iterateForLoop  |     100  |           85,711 |          N/A    |        N/A    |           N/A    |       67,934  | us/op |
|  iterateForLoop  |    1000  |        1.143,733 |          N/A    |        N/A    |           N/A    |      743,382  | us/op |
|  iterateForLoop  |   10000  |       15.001,003 |          N/A    |        N/A    |           N/A    |    7.850,294  | us/op |
|  iterateStream   |     100  |           65,109 |          N/A    |        N/A    |           N/A    |       58,683  | us/op |
|  iterateStream   |    1000  |          626,333 |          N/A    |        N/A    |           N/A    |      540,375  | us/op |
|  iterateStream   |   10000  |       13.957,985 |          N/A    |        N/A    |           N/A    |    5.498,092  | us/op |
|  pollFirst       |     100  |            0,32  |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  pollFirst       |    1000  |            0,297 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  pollFirst       |   10000  |            0,305 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  pollLast        |     100  |            0,295 |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  pollLast        |    1000  |            0,296 |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  pollLast        |   10000  |            0,29  |          N/A    |        N/A    |           N/A    |        0,296  | us/op |
|  remove          |     100  |        1.648,933 |          N/A    |        N/A    |           N/A    |    1.532,205  | us/op |
|  remove          |    1000  |       85.899,701 |          N/A    |        N/A    |           N/A    |   30.751,558  | us/op |
|  remove          |   10000  |    1.251.783,637 |          N/A    |        N/A    |           N/A    |  371.160,588  | us/op |
|  toArray         |     100  |           54,131 |          N/A    |        N/A    |           N/A    |       42,627  | us/op |
|  toArray         |    1000  |          587,028 |          N/A    |        N/A    |           N/A    |      410,034  | us/op |
|  toArray         |   10000  |        6.008,182 |          N/A    |        N/A    |           N/A    |    4.482,021  | us/op |

### FIFOQueue
|   Action    |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|-------------|----------|----------------|-----------------|---------------|------------------|---------------|-------|
|  add        |     100  |         42,283 |          N/A    |       20,958  |          21,427  |       84,75   | us/op |
|  add        |    1000  |        928,878 |          N/A    |      247,363  |         194,359  |      688,219  | us/op |
|  add        |   10000  |      9.272,132 |          N/A    |    2.274,1    |       2.185,433  |    6.595,205  | us/op |
|  addEmpty   |     100  |         95,775 |          N/A    |      162,748  |         136,712  |       82,896  | us/op |
|  addEmpty   |    1000  |      1.132,645 |          N/A    |    1.716,801  |         992,472  |      779,371  | us/op |
|  addEmpty   |   10000  |     12.979,03  |          N/A    |    8.322,493  |       8.098,618  |    6.585,552  | us/op |
|  contains   |     100  |      1.327,776 |          N/A    |        N/A    |           N/A    |        N/A    | us/op |
|  contains   |    1000  |     10.299,243 |          N/A    |        N/A    |           N/A    |        N/A    | us/op |
|  contains   |   10000  |    312.700,752 |          N/A    |        N/A    |           N/A    |        N/A    | us/op |
|  pollFirst  |     100  |          0,316 |          N/A    |        0,27   |           0,304  |        0,305  | us/op |
|  pollFirst  |    1000  |          0,323 |          N/A    |        0,296  |           0,321  |        0,307  | us/op |
|  pollFirst  |   10000  |          0,327 |          N/A    |        0,295  |           0,301  |        0,305  | us/op |
|  pollLast   |     100  |          0,344 |          N/A    |        0,286  |           0,308  |        0,304  | us/op |
|  pollLast   |    1000  |          0,333 |          N/A    |        0,304  |           0,291  |        0,306  | us/op |
|  pollLast   |   10000  |          0,349 |          N/A    |        0,304  |           0,292  |        0,305  | us/op |
|  remove     |     100  |          N/A   |          N/A    |        N/A    |           N/A    |    2.227,626  | us/op |
|  remove     |    1000  |          N/A   |          N/A    |        N/A    |           N/A    |   51.902,114  | us/op |
|  remove     |   10000  |          N/A   |          N/A    |        N/A    |           N/A    |  628.152,373  | us/op |
|  toArray    |     100  |         29,31  |          N/A    |        N/A    |           N/A    |       10,583  | us/op |
|  toArray    |    1000  |        263,764 |          N/A    |        N/A    |           N/A    |       93,577  | us/op |
|  toArray    |   10000  |      2.887,962 |          N/A    |        N/A    |           N/A    |      871,3    | us/op |

### HeapQueue
|   Action   |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|------------|----------|---------------|-----------------|---------------|------------------|--------------|-------|
|  add       |     100  |         N/A   |          N/A    |        N/A    |          72,998  |      78,156  | us/op |
|  add       |    1000  |         N/A   |          N/A    |        N/A    |         678,38   |     653,195  | us/op |
|  add       |   10000  |         N/A   |          N/A    |        N/A    |      21.053,134  |  21.056,53   | us/op |
|  addEmpty  |     100  |         N/A   |          N/A    |        N/A    |         179,672  |     177,092  | us/op |
|  addEmpty  |    1000  |         N/A   |          N/A    |        N/A    |       2.279,275  |   1.539,308  | us/op |
|  addEmpty  |   10000  |         N/A   |          N/A    |        N/A    |      27.879,469  |  28.043,251  | us/op |
|  poll      |     100  |         N/A   |          N/A    |        N/A    |           0,328  |       0,313  | us/op |
|  poll      |    1000  |         N/A   |          N/A    |        N/A    |           0,309  |       0,311  | us/op |
|  poll      |   10000  |         N/A   |          N/A    |        N/A    |           0,299  |       0,302  | us/op |
|  remove    |     100  |         N/A   |          N/A    |        N/A    |           N/A    |     227,921  | us/op |
|  remove    |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |   3.349,579  | us/op |
|  remove    |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |  34.186,746  | us/op |
|  toArray   |     100  |         N/A   |          N/A    |        N/A    |           N/A    |       9,804  | us/op |
|  toArray   |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |      87,984  | us/op |
|  toArray   |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |     785,123  | us/op |

### ArrayQueue
|   Action   |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|------------|----------|---------------|-----------------|---------------|------------------|--------------|-------|
|  add       |     100  |         N/A   |          N/A    |        N/A    |          20,921  |      19,198  | us/op |
|  add       |    1000  |         N/A   |          N/A    |        N/A    |         195,809  |     185,423  | us/op |
|  add       |   10000  |         N/A   |          N/A    |        N/A    |       2.222,382  |   2.011,528  | us/op |
|  addEmpty  |     100  |         N/A   |          N/A    |        N/A    |         138,239  |     124,97   | us/op |
|  addEmpty  |    1000  |         N/A   |          N/A    |        N/A    |         836,328  |     872,341  | us/op |
|  addEmpty  |   10000  |         N/A   |          N/A    |        N/A    |       7.863,325  |   8.174,879  | us/op |
|  poll      |     100  |         N/A   |          N/A    |        N/A    |           0,337  |       0,293  | us/op |
|  poll      |    1000  |         N/A   |          N/A    |        N/A    |           0,335  |       0,297  | us/op |
|  poll      |   10000  |         N/A   |          N/A    |        N/A    |           0,35   |       0,306  | us/op |
|  remove    |     100  |         N/A   |          N/A    |        N/A    |           N/A    |     230,72   | us/op |
|  remove    |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |   3.567,469  | us/op |
|  remove    |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |  37.477,389  | us/op |
|  toArray   |     100  |         N/A   |          N/A    |        N/A    |           N/A    |       9,588  | us/op |
|  toArray   |    1000  |         N/A   |          N/A    |        N/A    |           N/A    |      88,295  | us/op |
|  toArray   |   10000  |         N/A   |          N/A    |        N/A    |           N/A    |     779,421  | us/op |

### HashSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|------------------|----------|---------------|-----------------|---------------|------------------|--------------|-------|
|  add             |     100  |       205,826 |         60,228  |       51,707  |          52,018  |      50,162  | us/op |
|  add             |    1000  |     3.155,551 |        680,669  |      439,7    |         418,315  |     406,185  | us/op |
|  add             |   10000  |    35.483,236 |     17.922,87   |   13.920,005  |      13.137,235  |  12.693,929  | us/op |
|  addEmpty        |     100  |       241,009 |        191,425  |      232,001  |         176,657  |     158,346  | us/op |
|  addEmpty        |    1000  |     3.506,695 |      3.201,179  |    1.302,215  |       1.274,07   |   1.471,318  | us/op |
|  addEmpty        |   10000  |    68.106,221 |     61.974,014  |   50.983,535  |      52.824,498  |  52.651,848  | us/op |
|  contains        |     100  |       147,88  |        117,43   |      104,117  |         100,181  |      88,495  | us/op |
|  contains        |    1000  |       164,169 |        117,245  |       93,392  |         111,939  |      81,889  | us/op |
|  contains        |   10000  |       166,589 |        134,406  |       96,355  |         104,998  |      86,703  | us/op |
|  iterateForEach  |     100  |        73,461 |         41,363  |      138,034  |          82,115  |      57,303  | us/op |
|  iterateForEach  |    1000  |       767,83  |        545,134  |    1.928,227  |         699,724  |     579,375  | us/op |
|  iterateForEach  |   10000  |    15.569,624 |     15.306,872  |   25.080,77   |      16.656,495  |  18.619,515  | us/op |
|  iterateForLoop  |     100  |        76,806 |         71,141  |      133,333  |          66,505  |      63,511  | us/op |
|  iterateForLoop  |    1000  |       873,361 |        678,394  |    2.323,776  |         672,875  |     760,67   | us/op |
|  iterateForLoop  |   10000  |    16.596,837 |     16.860,38   |   25.825,325  |      18.928,447  |  18.560,226  | us/op |
|  iterateStream   |     100  |        77,608 |          N/A    |      134,499  |         120,057  |      88,458  | us/op |
|  iterateStream   |    1000  |     1.001,015 |          N/A    |    2.197,958  |       1.059,922  |     835,591  | us/op |
|  iterateStream   |   10000  |    19.624,548 |          N/A    |   23.250,685  |      22.744,742  |  20.470,447  | us/op |
|  remove          |     100  |        30,215 |         79,387  |       52,339  |          49,736  |      48,306  | us/op |
|  remove          |    1000  |        84,697 |        109,582  |       64,929  |          54,046  |      58,94   | us/op |
|  remove          |   10000  |        92,184 |        128,881  |       57,713  |          58,621  |      58,852  | us/op |
|  toArray         |     100  |        45,037 |         24,206  |       77,785  |          41,259  |      39,194  | us/op |
|  toArray         |    1000  |       887,375 |        321,331  |    1.055,216  |         369,698  |     346,713  | us/op |
|  toArray         |   10000  |     8.699,07  |     10.568,59   |   13.718,153  |      10.094,122  |   9.044,295  | us/op |

### LinkedHashSet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|------------------|----------|---------------|-----------------|---------------|------------------|--------------|-------|
|  add             |     100  |       279,597 |          N/A    |      126,365  |         114,956  |     146,656  | us/op |
|  add             |    1000  |     3.756,708 |          N/A    |    1.047,695  |         760,986  |   1.197,397  | us/op |
|  add             |   10000  |    43.883,267 |          N/A    |   23.314,952  |      18.340,306  |  23.242,144  | us/op |
|  addEmpty        |     100  |       302,617 |          N/A    |      395,678  |         250,011  |     236,197  | us/op |
|  addEmpty        |    1000  |     4.701,233 |          N/A    |    5.445,487  |       2.841,744  |   2.094,693  | us/op |
|  addEmpty        |   10000  |    76.382,189 |          N/A    |   87.080,072  |      66.091,526  |  60.473,254  | us/op |
|  contains        |     100  |       147,276 |          N/A    |      104,306  |         107,931  |      87,197  | us/op |
|  contains        |    1000  |       162,778 |          N/A    |      102,015  |          89,602  |      88,803  | us/op |
|  contains        |   10000  |       169,232 |          N/A    |      104,533  |          99,912  |      90,806  | us/op |
|  iterateForEach  |     100  |        55,605 |          N/A    |      142,058  |          46,558  |      44,0    | us/op |
|  iterateForEach  |    1000  |       513,042 |          N/A    |    2.276,625  |         479,703  |     435,518  | us/op |
|  iterateForEach  |   10000  |    13.246,255 |          N/A    |   24.809,941  |       6.114,915  |   5.966,779  | us/op |
|  iterateForLoop  |     100  |        51,229 |          N/A    |      142,228  |          54,307  |      51,283  | us/op |
|  iterateForLoop  |    1000  |       512,205 |          N/A    |    2.394,924  |         532,265  |     502,65   | us/op |
|  iterateForLoop  |   10000  |    12.249,461 |          N/A    |   25.340,442  |       6.392,802  |   5.954,497  | us/op |
|  iterateStream   |     100  |        49,146 |          N/A    |      143,723  |          53,58   |      55,44   | us/op |
|  iterateStream   |    1000  |       459,17  |          N/A    |    2.217,962  |         463,045  |     522,038  | us/op |
|  iterateStream   |   10000  |    12.087,256 |          N/A    |   24.202,111  |       6.606,537  |   6.250,793  | us/op |
|  remove          |     100  |        63,337 |          N/A    |       55,089  |          49,387  |      41,676  | us/op |
|  remove          |    1000  |        91,679 |          N/A    |       61,366  |          51,625  |      48,64   | us/op |
|  remove          |   10000  |        91,046 |          N/A    |       61,984  |          56,237  |      52,522  | us/op |
|  toArray         |     100  |        24,383 |          N/A    |       67,404  |          23,234  |      25,411  | us/op |
|  toArray         |    1000  |       420,022 |          N/A    |    1.050,56   |         252,761  |     258,013  | us/op |
|  toArray         |   10000  |     4.672,8   |          N/A    |   23.012,482  |       5.772,709  |   5.343,964  | us/op |

### ArraySet
|      Action      |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|------------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  add             |     100  |         N/A   |          N/A    |        N/A    |         419,792  |        191,261  | us/op |
|  add             |    1000  |         N/A   |          N/A    |        N/A    |      36.264,146  |     13.577,774  | us/op |
|  add             |   10000  |         N/A   |          N/A    |        N/A    |   4.171.001,742  |  1.181.855,237  | us/op |
|  addEmpty        |     100  |         N/A   |          N/A    |        N/A    |         544,509  |        201,703  | us/op |
|  addEmpty        |    1000  |         N/A   |          N/A    |        N/A    |      39.572,186  |     13.477,87   | us/op |
|  addEmpty        |   10000  |         N/A   |          N/A    |        N/A    |   5.008.420,275  |  1.182.254,358  | us/op |
|  contains        |     100  |         N/A   |          N/A    |        N/A    |       1.266,961  |        292,1    | us/op |
|  contains        |    1000  |         N/A   |          N/A    |        N/A    |       9.236,625  |      1.789,129  | us/op |
|  contains        |   10000  |         N/A   |          N/A    |        N/A    |      80.100,027  |     15.846,218  | us/op |
|  iterateForEach  |     100  |         N/A   |          N/A    |        N/A    |          66,748  |         39,018  | us/op |
|  iterateForEach  |    1000  |         N/A   |          N/A    |        N/A    |         681,199  |        373,302  | us/op |
|  iterateForEach  |   10000  |         N/A   |          N/A    |        N/A    |       6.774,975  |      3.743,67   | us/op |
|  iterateForLoop  |     100  |         N/A   |          N/A    |        N/A    |          66,51   |         47,021  | us/op |
|  iterateForLoop  |    1000  |         N/A   |          N/A    |        N/A    |         677,259  |        425,829  | us/op |
|  iterateForLoop  |   10000  |         N/A   |          N/A    |        N/A    |       6.663,073  |      4.151,295  | us/op |
|  iterateStream   |     100  |         N/A   |          N/A    |        N/A    |          79,012  |         48,749  | us/op |
|  iterateStream   |    1000  |         N/A   |          N/A    |        N/A    |         746,937  |        441,404  | us/op |
|  iterateStream   |   10000  |         N/A   |          N/A    |        N/A    |       7.327,341  |      4.374,618  | us/op |
|  toArray         |     100  |         N/A   |          N/A    |        N/A    |           7,935  |          7,204  | us/op |
|  toArray         |    1000  |         N/A   |          N/A    |        N/A    |          75,765  |         62,921  | us/op |
|  toArray         |   10000  |         N/A   |          N/A    |        N/A    |         740,887  |        525,225  | us/op |

### AVLTreeSet
|      Action      |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|------------------|----------|----------------|-----------------|---------------|------------------|---------------|-------|
|  add             |     100  |        367,349 |          N/A    |        N/A    |         498,076  |      508,306  | us/op |
|  add             |    1000  |     14.334,253 |          N/A    |        N/A    |      21.007,505  |   16.025,023  | us/op |
|  add             |   10000  |    247.010,209 |          N/A    |        N/A    |     317.765,311  |  241.251,035  | us/op |
|  contains        |     100  |        297,991 |          N/A    |        N/A    |         287,611  |      252,891  | us/op |
|  contains        |    1000  |        438,113 |          N/A    |        N/A    |         428,837  |      326,194  | us/op |
|  contains        |   10000  |        827,609 |          N/A    |        N/A    |         715,811  |      568,387  | us/op |
|  iterateForEach  |     100  |         62,321 |          N/A    |        N/A    |          55,897  |       53,854  | us/op |
|  iterateForEach  |    1000  |        942,838 |          N/A    |        N/A    |         593,843  |      610,451  | us/op |
|  iterateForEach  |   10000  |     29.326,234 |          N/A    |        N/A    |      13.932,238  |   11.898,789  | us/op |
|  iterateForLoop  |     100  |         61,786 |          N/A    |        N/A    |          58,239  |       65,739  | us/op |
|  iterateForLoop  |    1000  |        864,974 |          N/A    |        N/A    |         628,303  |      762,604  | us/op |
|  iterateForLoop  |   10000  |     25.407,468 |          N/A    |        N/A    |      12.971,717  |   13.971,143  | us/op |
|  iterateStream   |     100  |         69,146 |          N/A    |        N/A    |          68,571  |       69,961  | us/op |
|  iterateStream   |    1000  |        703,692 |          N/A    |        N/A    |         612,32   |      660,74   | us/op |
|  iterateStream   |   10000  |     29.026,876 |          N/A    |        N/A    |      12.698,031  |   14.097,821  | us/op |
|  pollFirst       |     100  |          0,307 |          N/A    |        N/A    |           N/A    |        0,296  | us/op |
|  pollFirst       |    1000  |          0,422 |          N/A    |        N/A    |           N/A    |        0,296  | us/op |
|  pollFirst       |   10000  |          0,296 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  pollLast        |     100  |          0,291 |          N/A    |        N/A    |           N/A    |        0,307  | us/op |
|  pollLast        |    1000  |          0,289 |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  pollLast        |   10000  |          0,289 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  remove          |     100  |        207,202 |          N/A    |        N/A    |           N/A    |      162,698  | us/op |
|  remove          |    1000  |        356,525 |          N/A    |        N/A    |           N/A    |      292,013  | us/op |
|  remove          |   10000  |        876,713 |          N/A    |        N/A    |           N/A    |      579,155  | us/op |
|  toArray         |     100  |         48,341 |          N/A    |        N/A    |          41,854  |       52,653  | us/op |
|  toArray         |    1000  |        774,996 |          N/A    |        N/A    |         491,142  |      562,88   | us/op |
|  toArray         |   10000  |     12.589,749 |          N/A    |        N/A    |       6.390,993  |    7.667,193  | us/op |

### RBTreeSet
|      Action      |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|------------------|----------|----------------|-----------------|---------------|------------------|---------------|-------|
|  add             |     100  |        367,349 |          N/A    |        N/A    |         674,125  |      310,557  | us/op |
|  add             |    1000  |     14.334,253 |          N/A    |        N/A    |      18.387,501  |   12.470,986  | us/op |
|  add             |   10000  |    247.010,209 |          N/A    |        N/A    |     278.203,63   |  208.871,491  | us/op |
|  contains        |     100  |        297,991 |          N/A    |        N/A    |         363,276  |      253,587  | us/op |
|  contains        |    1000  |        438,113 |          N/A    |        N/A    |         391,78   |      310,719  | us/op |
|  contains        |   10000  |        827,609 |          N/A    |        N/A    |         769,859  |      543,236  | us/op |
|  iterateForEach  |     100  |         62,321 |          N/A    |        N/A    |          58,751  |       59,37   | us/op |
|  iterateForEach  |    1000  |        942,838 |          N/A    |        N/A    |         612,837  |      629,524  | us/op |
|  iterateForEach  |   10000  |     29.326,234 |          N/A    |        N/A    |      12.296,669  |   13.091,201  | us/op |
|  iterateForLoop  |     100  |         61,786 |          N/A    |        N/A    |          57,947  |       70,73   | us/op |
|  iterateForLoop  |    1000  |        864,974 |          N/A    |        N/A    |         640,571  |      771,578  | us/op |
|  iterateForLoop  |   10000  |     25.407,468 |          N/A    |        N/A    |      12.536,037  |   13.624,462  | us/op |
|  iterateStream   |     100  |         69,146 |          N/A    |        N/A    |          67,676  |       65,225  | us/op |
|  iterateStream   |    1000  |        703,692 |          N/A    |        N/A    |         611,788  |      661,78   | us/op |
|  iterateStream   |   10000  |     29.026,876 |          N/A    |        N/A    |      12.633,224  |   14.135,143  | us/op |
|  pollFirst       |     100  |          0,307 |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  pollFirst       |    1000  |          0,422 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  pollFirst       |   10000  |          0,296 |          N/A    |        N/A    |           N/A    |        0,302  | us/op |
|  pollLast        |     100  |          0,291 |          N/A    |        N/A    |           N/A    |        0,295  | us/op |
|  pollLast        |    1000  |          0,289 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  pollLast        |   10000  |          0,289 |          N/A    |        N/A    |           N/A    |        0,294  | us/op |
|  remove          |     100  |        207,202 |          N/A    |        N/A    |           N/A    |      161,395  | us/op |
|  remove          |    1000  |        356,525 |          N/A    |        N/A    |           N/A    |      483,538  | us/op |
|  remove          |   10000  |        876,713 |          N/A    |        N/A    |           N/A    |      576,674  | us/op |
|  toArray         |     100  |         48,341 |          N/A    |        N/A    |          41,154  |       56,307  | us/op |
|  toArray         |    1000  |        774,996 |          N/A    |        N/A    |         445,51   |      631,544  | us/op |
|  toArray         |   10000  |     12.589,749 |          N/A    |        N/A    |       6.700,423  |    8.332,332  | us/op |

### HashMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|----------------|----------|---------------|-----------------|---------------|------------------|--------------|-------|
|  clone         |     100  |       196,448 |          N/A    |       56,104  |          59,646  |      59,041  | us/op |
|  clone         |    1000  |     2.411,45  |          N/A    |      437,268  |         462,185  |     431,001  | us/op |
|  clone         |   10000  |    31.065,224 |          N/A    |    3.588,1    |       3.731,635  |   3.390,223  | us/op |
|  containsKey   |     100  |       121,455 |         80,466  |       88,629  |          94,264  |      89,439  | us/op |
|  containsKey   |    1000  |       137,539 |         80,23   |       86,354  |          98,822  |      90,8    | us/op |
|  containsKey   |   10000  |       146,38  |         88,84   |       92,123  |          95,8    |      92,086  | us/op |
|  forEach       |     100  |        91,594 |          N/A    |      175,405  |         180,511  |      80,397  | us/op |
|  forEach       |    1000  |     1.054,926 |          N/A    |    2.225,144  |       2.238,897  |   1.487,138  | us/op |
|  forEach       |   10000  |    20.103,647 |          N/A    |   28.860,181  |      30.471,231  |  20.530,818  | us/op |
|  get           |     100  |       118,757 |        106,095  |       95,506  |         100,891  |      94,089  | us/op |
|  get           |    1000  |       162,168 |         90,448  |       96,685  |         101,604  |     111,482  | us/op |
|  get           |   10000  |       168,053 |         93,062  |       99,57   |          96,04   |     112,772  | us/op |
|  getOrDefault  |     100  |       172,779 |          N/A    |      110,694  |         100,202  |      98,819  | us/op |
|  getOrDefault  |    1000  |       158,483 |          N/A    |      116,455  |         107,507  |     105,887  | us/op |
|  getOrDefault  |   10000  |       170,473 |          N/A    |       94,353  |         107,762  |     111,1    | us/op |
|  keySet        |     100  |        83,569 |         74,78   |      143,271  |          70,242  |      66,981  | us/op |
|  keySet        |    1000  |       973,3   |        687,445  |    2.103,115  |         580,903  |     636,611  | us/op |
|  keySet        |   10000  |    14.555,49  |     13.340,344  |   25.172,903  |      16.870,523  |  20.257,377  | us/op |
|  put           |     100  |       288,468 |        120,339  |      114,367  |         110,184  |     108,383  | us/op |
|  put           |    1000  |     3.223,663 |        896,163  |      779,467  |         758,0    |     778,495  | us/op |
|  put           |   10000  |    44.194,731 |     20.088,675  |   20.018,77   |      20.364,613  |  20.832,362  | us/op |
|  putEmpty      |     100  |       326,935 |        234,935  |      291,615  |         278,182  |     218,088  | us/op |
|  putEmpty      |    1000  |     4.023,867 |      3.203,363  |    2.118,068  |       2.755,928  |   1.938,954  | us/op |
|  putEmpty      |   10000  |    79.075,423 |     53.398,283  |   59.230,401  |      60.676,192  |  54.538,129  | us/op |
|  remove        |     100  |       102,954 |         78,973  |       93,743  |          97,07   |     102,189  | us/op |
|  remove        |    1000  |       134,179 |         87,764  |      104,319  |         105,958  |     105,594  | us/op |
|  remove        |   10000  |       126,975 |         94,472  |      112,017  |         101,724  |     108,598  | us/op |
|  replace       |     100  |       172,749 |          N/A    |        N/A    |         121,275  |     121,68   | us/op |
|  replace       |    1000  |       185,46  |          N/A    |        N/A    |         119,133  |     134,615  | us/op |
|  replace       |   10000  |       199,948 |          N/A    |        N/A    |         154,722  |     128,418  | us/op |
|  values        |     100  |        64,01  |         72,407  |        N/A    |          95,657  |      72,58   | us/op |
|  values        |    1000  |       859,757 |        762,276  |        N/A    |         688,339  |     738,523  | us/op |
|  values        |   10000  |    16.070,391 |     13.962,558  |        N/A    |      20.529,085  |  19.965,824  | us/op |

### LinkedHashMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |   HPPC Score   |  FastUtil Score  |   PC Score   | Units |
|----------------|----------|---------------|-----------------|----------------|------------------|--------------|-------|
|  clone         |     100  |       225,441 |          N/A    |        60,702  |          99,59   |      92,641  | us/op |
|  clone         |    1000  |     2.227,338 |          N/A    |       475,012  |         769,221  |     698,831  | us/op |
|  clone         |   10000  |    23.844,807 |          N/A    |     3.833,786  |       6.259,112  |   5.669,26   | us/op |
|  containsKey   |     100  |       118,638 |          N/A    |        97,767  |          93,535  |      89,385  | us/op |
|  containsKey   |    1000  |       139,125 |          N/A    |        94,268  |          98,693  |      89,809  | us/op |
|  containsKey   |   10000  |       145,235 |          N/A    |        96,125  |          96,514  |      91,898  | us/op |
|  forEach       |     100  |        73,675 |          N/A    |       197,492  |         123,826  |      73,878  | us/op |
|  forEach       |    1000  |       857,936 |          N/A    |     2.693,859  |       1.514,777  |     725,515  | us/op |
|  forEach       |   10000  |    12.178,913 |          N/A    |    31.356,903  |      18.961,658  |  11.588,686  | us/op |
|  get           |     100  |       125,699 |          N/A    |       108,893  |          98,64   |     104,623  | us/op |
|  get           |    1000  |       195,829 |          N/A    |       111,895  |         107,912  |     109,107  | us/op |
|  get           |   10000  |       198,378 |          N/A    |       117,975  |         103,009  |     111,338  | us/op |
|  getOrDefault  |     100  |       169,298 |          N/A    |       104,775  |         103,842  |      99,841  | us/op |
|  getOrDefault  |    1000  |       160,513 |          N/A    |       103,054  |         109,125  |     108,464  | us/op |
|  getOrDefault  |   10000  |       176,723 |          N/A    |       111,893  |         113,871  |     108,085  | us/op |
|  keySet        |     100  |        51,339 |          N/A    |       138,037  |          49,886  |      53,56   | us/op |
|  keySet        |    1000  |       740,929 |          N/A    |     2.603,173  |         585,5    |     593,173  | us/op |
|  keySet        |   10000  |    11.135,77  |          N/A    |    24.960,98   |       6.186,347  |   6.170,609  | us/op |
|  put           |     100  |       385,221 |          N/A    |       223,895  |         191,391  |     169,176  | us/op |
|  put           |    1000  |     3.590,704 |          N/A    |     1.693,532  |       1.247,295  |   1.246,788  | us/op |
|  put           |   10000  |    54.105,259 |          N/A    |    33.365,207  |      27.727,883  |  28.362,985  | us/op |
|  putEmpty      |     100  |       416,501 |          N/A    |       423,043  |         329,444  |     312,972  | us/op |
|  putEmpty      |    1000  |     4.901,34  |          N/A    |     7.489,334  |       3.494,965  |   2.308,11   | us/op |
|  putEmpty      |   10000  |    88.579,611 |          N/A    |   104.217,618  |      82.702,841  |  68.760,716  | us/op |
|  remove        |     100  |       104,671 |          N/A    |        97,434  |          95,104  |     110,427  | us/op |
|  remove        |    1000  |       132,516 |          N/A    |       104,008  |         132,29   |     104,287  | us/op |
|  remove        |   10000  |       136,27  |          N/A    |       104,628  |         102,626  |     108,645  | us/op |
|  replace       |     100  |       186,28  |          N/A    |         N/A    |         133,758  |     124,698  | us/op |
|  replace       |    1000  |       184,599 |          N/A    |         N/A    |         127,778  |     115,869  | us/op |
|  replace       |   10000  |       194,422 |          N/A    |         N/A    |         128,7    |     118,103  | us/op |
|  values        |     100  |        50,812 |          N/A    |         N/A    |          56,162  |      55,487  | us/op |
|  values        |    1000  |       711,362 |          N/A    |         N/A    |         557,056  |     591,438  | us/op |
|  values        |   10000  |    11.846,008 |          N/A    |         N/A    |       6.659,009  |   6.472,67   | us/op |

### ArrayMap
|     Action     |   Size   |  Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |    PC Score     | Units |
|----------------|----------|---------------|-----------------|---------------|------------------|-----------------|-------|
|  clone         |     100  |         N/A   |          N/A    |        N/A    |          24,264  |         26,923  | us/op |
|  clone         |    1000  |         N/A   |          N/A    |        N/A    |         224,062  |        209,456  | us/op |
|  clone         |   10000  |         N/A   |          N/A    |        N/A    |       2.245,975  |      2.083,848  | us/op |
|  containsKey   |     100  |         N/A   |          N/A    |        N/A    |         998,665  |        275,617  | us/op |
|  containsKey   |    1000  |         N/A   |          N/A    |        N/A    |       8.311,15   |      1.916,552  | us/op |
|  containsKey   |   10000  |         N/A   |          N/A    |        N/A    |      76.440,663  |     15.954,193  | us/op |
|  forEach       |     100  |         N/A   |          N/A    |        N/A    |         193,395  |         67,486  | us/op |
|  forEach       |    1000  |         N/A   |          N/A    |        N/A    |       2.283,906  |        659,771  | us/op |
|  forEach       |   10000  |         N/A   |          N/A    |        N/A    |      21.681,494  |      6.818,133  | us/op |
|  get           |     100  |         N/A   |          N/A    |        N/A    |         976,107  |        278,747  | us/op |
|  get           |    1000  |         N/A   |          N/A    |        N/A    |       7.923,427  |      1.986,321  | us/op |
|  get           |   10000  |         N/A   |          N/A    |        N/A    |      73.613,477  |     16.942,345  | us/op |
|  getOrDefault  |     100  |         N/A   |          N/A    |        N/A    |       1.485,711  |        288,904  | us/op |
|  getOrDefault  |    1000  |         N/A   |          N/A    |        N/A    |      16.931,415  |      1.956,484  | us/op |
|  getOrDefault  |   10000  |         N/A   |          N/A    |        N/A    |     121.353,377  |     16.007,801  | us/op |
|  keySet        |     100  |         N/A   |          N/A    |        N/A    |          73,221  |         45,751  | us/op |
|  keySet        |    1000  |         N/A   |          N/A    |        N/A    |         742,199  |        461,213  | us/op |
|  keySet        |   10000  |         N/A   |          N/A    |        N/A    |       7.740,94   |      4.381,44   | us/op |
|  put           |     100  |         N/A   |          N/A    |        N/A    |         491,933  |        357,546  | us/op |
|  put           |    1000  |         N/A   |          N/A    |        N/A    |      30.887,539  |     15.841,015  | us/op |
|  put           |   10000  |         N/A   |          N/A    |        N/A    |   5.009.622,3    |  1.112.285,933  | us/op |
|  putEmpty      |     100  |         N/A   |          N/A    |        N/A    |         582,001  |        473,678  | us/op |
|  putEmpty      |    1000  |         N/A   |          N/A    |        N/A    |      37.788,872  |     15.941,148  | us/op |
|  putEmpty      |   10000  |         N/A   |          N/A    |        N/A    |   5.010.441,75   |  1.251.500,931  | us/op |
|  remove        |     100  |         N/A   |          N/A    |        N/A    |       1.369,995  |        200,968  | us/op |
|  remove        |    1000  |         N/A   |          N/A    |        N/A    |      16.639,856  |      2.308,866  | us/op |
|  remove        |   10000  |         N/A   |          N/A    |        N/A    |     127.530,862  |     24.242,714  | us/op |
|  replace       |     100  |         N/A   |          N/A    |        N/A    |       1.990,348  |        309,989  | us/op |
|  replace       |    1000  |         N/A   |          N/A    |        N/A    |      15.804,103  |      1.972,674  | us/op |
|  replace       |   10000  |         N/A   |          N/A    |        N/A    |     109.408,717  |     16.182,942  | us/op |
|  values        |     100  |         N/A   |          N/A    |        N/A    |          76,16   |         47,493  | us/op |
|  values        |    1000  |         N/A   |          N/A    |        N/A    |         796,858  |        478,179  | us/op |
|  values        |   10000  |         N/A   |          N/A    |        N/A    |       8.041,366  |      4.536,606  | us/op |

### AVLTreeMap
|     Action     |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|----------------|----------|----------------|-----------------|---------------|------------------|---------------|-------|
|  clone         |     100  |        110,917 |          N/A    |        N/A    |         132,607  |      110,792  | us/op |
|  clone         |    1000  |      1.253,208 |          N/A    |        N/A    |       1.332,364  |      814,473  | us/op |
|  clone         |   10000  |     18.121,912 |          N/A    |        N/A    |      18.378,946  |    8.588,336  | us/op |
|  containsKey   |     100  |        258,199 |          N/A    |        N/A    |         307,043  |      223,254  | us/op |
|  containsKey   |    1000  |        372,996 |          N/A    |        N/A    |         399,749  |      299,054  | us/op |
|  containsKey   |   10000  |        760,284 |          N/A    |        N/A    |         804,608  |      583,397  | us/op |
|  forEach       |     100  |         85,866 |          N/A    |        N/A    |         135,272  |       69,538  | us/op |
|  forEach       |    1000  |      1.107,227 |          N/A    |        N/A    |       1.622,669  |      771,151  | us/op |
|  forEach       |   10000  |     26.933,632 |          N/A    |        N/A    |      21.640,552  |   15.051,354  | us/op |
|  get           |     100  |        340,697 |          N/A    |        N/A    |         272,908  |      239,387  | us/op |
|  get           |    1000  |        490,591 |          N/A    |        N/A    |         380,494  |      306,464  | us/op |
|  get           |   10000  |      1.302,211 |          N/A    |        N/A    |         746,201  |      622,505  | us/op |
|  getOrDefault  |     100  |        367,997 |          N/A    |        N/A    |         558,243  |      240,028  | us/op |
|  getOrDefault  |    1000  |        559,487 |          N/A    |        N/A    |         744,154  |      302,348  | us/op |
|  getOrDefault  |   10000  |      1.064,723 |          N/A    |        N/A    |       1.269,711  |      627,932  | us/op |
|  keySet        |     100  |         68,348 |          N/A    |        N/A    |          57,241  |       67,568  | us/op |
|  keySet        |    1000  |        914,533 |          N/A    |        N/A    |         695,371  |      696,741  | us/op |
|  keySet        |   10000  |     26.312,534 |          N/A    |        N/A    |      14.221,858  |   13.978,499  | us/op |
|  pollFirst     |     100  |          0,261 |          N/A    |        N/A    |           N/A    |        0,297  | us/op |
|  pollFirst     |    1000  |          0,292 |          N/A    |        N/A    |           N/A    |        0,298  | us/op |
|  pollFirst     |   10000  |          0,287 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  pollLast      |     100  |          0,257 |          N/A    |        N/A    |           N/A    |        0,298  | us/op |
|  pollLast      |    1000  |          0,282 |          N/A    |        N/A    |           N/A    |        0,298  | us/op |
|  pollLast      |   10000  |          0,283 |          N/A    |        N/A    |           N/A    |        0,3    | us/op |
|  put           |     100  |        391,844 |          N/A    |        N/A    |         482,631  |      496,151  | us/op |
|  put           |    1000  |     15.316,938 |          N/A    |        N/A    |      20.279,016  |   17.866,859  | us/op |
|  put           |   10000  |    285.871,176 |          N/A    |        N/A    |     334.192,624  |  270.661,907  | us/op |
|  remove        |     100  |        272,795 |          N/A    |        N/A    |         258,154  |      211,571  | us/op |
|  remove        |    1000  |        457,817 |          N/A    |        N/A    |         436,581  |      333,18   | us/op |
|  remove        |   10000  |      1.217,004 |          N/A    |        N/A    |         950,246  |      781,045  | us/op |
|  replace       |     100  |        336,032 |          N/A    |        N/A    |         483,277  |      243,671  | us/op |
|  replace       |    1000  |        469,061 |          N/A    |        N/A    |         758,857  |      307,7    | us/op |
|  replace       |   10000  |        956,808 |          N/A    |        N/A    |       1.759,657  |      619,941  | us/op |
|  values        |     100  |         62,573 |          N/A    |        N/A    |          64,558  |       72,09   | us/op |
|  values        |    1000  |        918,869 |          N/A    |        N/A    |         799,682  |      772,808  | us/op |
|  values        |   10000  |     27.910,042 |          N/A    |        N/A    |      14.202,04   |   14.682,227  | us/op |

### RBTreeMap
|     Action     |   Size   |   Java Score   |  Eclipse Score  |  HPPC Score   |  FastUtil Score  |   PC Score    | Units |
|----------------|----------|----------------|-----------------|---------------|------------------|---------------|-------|
|  clone         |     100  |        110,917 |          N/A    |        N/A    |         137,236  |       79,511  | us/op |
|  clone         |    1000  |      1.253,208 |          N/A    |        N/A    |       1.340,455  |      854,37   | us/op |
|  clone         |   10000  |     18.121,912 |          N/A    |        N/A    |      20.170,3    |    8.526,745  | us/op |
|  containsKey   |     100  |        258,199 |          N/A    |        N/A    |         299,921  |      226,088  | us/op |
|  containsKey   |    1000  |        372,996 |          N/A    |        N/A    |         417,268  |      298,363  | us/op |
|  containsKey   |   10000  |        760,284 |          N/A    |        N/A    |         791,46   |      571,89   | us/op |
|  forEach       |     100  |         85,866 |          N/A    |        N/A    |         131,021  |       68,443  | us/op |
|  forEach       |    1000  |      1.107,227 |          N/A    |        N/A    |       1.566,284  |      785,056  | us/op |
|  forEach       |   10000  |     26.933,632 |          N/A    |        N/A    |      20.580,736  |   16.230,27   | us/op |
|  get           |     100  |        340,697 |          N/A    |        N/A    |         267,371  |      262,81   | us/op |
|  get           |    1000  |        490,591 |          N/A    |        N/A    |         383,296  |      367,36   | us/op |
|  get           |   10000  |      1.302,211 |          N/A    |        N/A    |         766,273  |      613,351  | us/op |
|  getOrDefault  |     100  |        367,997 |          N/A    |        N/A    |         362,062  |      233,29   | us/op |
|  getOrDefault  |    1000  |        559,487 |          N/A    |        N/A    |         602,202  |      317,797  | us/op |
|  getOrDefault  |   10000  |      1.064,723 |          N/A    |        N/A    |       1.081,251  |      580,778  | us/op |
|  keySet        |     100  |         68,348 |          N/A    |        N/A    |          58,578  |       66,044  | us/op |
|  keySet        |    1000  |        914,533 |          N/A    |        N/A    |         711,62   |      711,424  | us/op |
|  keySet        |   10000  |     26.312,534 |          N/A    |        N/A    |      13.283,418  |   15.495,8    | us/op |
|  pollFirst     |     100  |          0,261 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  pollFirst     |    1000  |          0,292 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  pollFirst     |   10000  |          0,287 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  pollLast      |     100  |          0,257 |          N/A    |        N/A    |           N/A    |        0,298  | us/op |
|  pollLast      |    1000  |          0,282 |          N/A    |        N/A    |           N/A    |        0,304  | us/op |
|  pollLast      |   10000  |          0,283 |          N/A    |        N/A    |           N/A    |        0,299  | us/op |
|  put           |     100  |        391,844 |          N/A    |        N/A    |         680,536  |      294,131  | us/op |
|  put           |    1000  |     15.316,938 |          N/A    |        N/A    |      17.918,549  |   12.642,462  | us/op |
|  put           |   10000  |    285.871,176 |          N/A    |        N/A    |     275.398,259  |  192.547,835  | us/op |
|  remove        |     100  |        272,795 |          N/A    |        N/A    |         463,972  |      176,946  | us/op |
|  remove        |    1000  |        457,817 |          N/A    |        N/A    |         841,494  |      311,624  | us/op |
|  remove        |   10000  |      1.217,004 |          N/A    |        N/A    |       1.333,427  |      645,172  | us/op |
|  replace       |     100  |        336,032 |          N/A    |        N/A    |         730,339  |      264,04   | us/op |
|  replace       |    1000  |        469,061 |          N/A    |        N/A    |       1.068,717  |      394,108  | us/op |
|  replace       |   10000  |        956,808 |          N/A    |        N/A    |       2.377,221  |      577,285  | us/op |
|  values        |     100  |         62,573 |          N/A    |        N/A    |          75,094  |       71,019  | us/op |
|  values        |    1000  |        918,869 |          N/A    |        N/A    |         776,027  |      748,005  | us/op |
|  values        |   10000  |     27.910,042 |          N/A    |        N/A    |      14.217,492  |   14.934,646  | us/op |


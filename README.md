# Primitive-Collections-Benchmarks
Benchmarks for Primitive Collections

These Benchmarks test Primitive Collections against Java8 and FastUtil using Jmh

There is a raw and a Fancified version of the Benchmarks.     
[[Raw Results]](benchmarkResults.txt), [[Fancy Results]](BENCHMARKS.md)

Also Primitive Collections provides Query Functions that replace Streams by directly implementing them into the Collection.

Here are the results for these.
|        Action          | Mode | Java Score | PC Score | Units |
|------------------------|------|------------|----------|-------|
| distinctFilterForEach  | avgt |   182,420  |  131,351 | us/op |
| distinctForEach        | avgt |   183,699  |  135,598 | us/op |
| filterForEach          | avgt |   191,786  |  145,659 | us/op |
| forEach                | avgt |    44,320  |   51,279 | us/op |

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

If you want to try out these benchmarks yourself.      

The command for that would be 
```
gradlew.bat jmh --no-daemon
```
The No daemon fixes a bug in Jmh where it allows you to interrupt the benchmark process otherwise the tasks will remain alive if you interrupt it.

By default it will generate the json statistic which is not really readable.      
You have 3 options to work with.      
- 1: go into the build.gradle and disable mark out the line "resultFormat = 'json'" with "//" so it is disabled
- 2: go into the build.gradle and change the result format. (one of csv, json, scsv, text)
- 3: After the benchmarks are done you generate the fancy statistics out of the json file.

How to generate the Fancy Table Markdown file automatically      
```
gradlew.bat generateFancyStatistics
```
This must be done once you have run the Benchmark at least once and the results.json file exists.      
Its located under: "build/reports/jmh"

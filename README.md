
## Getting started

```
git clone https://github.com/gshaw-pivotal/spring-batch-with-http.git
```

## Overview

A simple example of using spring-batch (`spring-boot-starter-batch`) as an ETL to move data from one system to another.

In this specific example we are moving ships from one HTTP accessible application to another HTTP accessible application.

In spring-batch, the work that the batch is supposed to do is defined by a Job, built using the `JobBuilderFactory` which contains one or more flows. The flows are built using the `StepBuilderFactory`. Each flow contains a reader, a processor and a writer step.

In this example both the reader and writer implemented use a RestTemplate to make a HHTP call to either get a ship (reader) or post a ship (writer).

## Notes

Both of the applications are just endpoints hosted within the same application as the batch job, however all access is do via REST calls to the endpoints.
# concurrent-matrices-multiplication

This application is an example how can be organized multiplication of two matrices in the concurrent way. 

Mainly it uses ExecutorService to calculate value for each cell in parallel. It uses amount of threads that user(developer) set. The actual multiplying happens in this class `com.github.hronom.concurrentmatricesmultiplication.ThreadedMatrixMultiplier`.

In the `com.github.hronom.concurrentmatricesmultiplication.App` you can see the api usage.

Also there `JUnit` tests for testing functionality, see `/src/test/java/com/github/hronom/concurrentmatricesmultiplication` package.

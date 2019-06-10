# redis
### scala example of connecting redis

### Problem
You want a simple way to run one or more tasks concurrently in a Scala application, including a way to handle their results when the tasks finish. For instance, you may want to make several web service calls in parallel, and then work with their results after they all return.

### Solution
A Future gives you a simple way to run an algorithm concurrently. A future starts running concurrently when you create it and returns a result at some point, well, in the future. In Scala, it’s said that a future returns “eventually.”

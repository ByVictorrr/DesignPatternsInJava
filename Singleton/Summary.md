# Summary 

* Making a 'safe' singleton is easy: construct a stack Lazy<T> and return its value
* Singletons are difficult to test
* Instead of directly using a singleton consider depending on an abstraction (
an interface)
* Consider defining singleton lifetime in DI container

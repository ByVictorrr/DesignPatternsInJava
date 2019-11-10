# Motivation

* Objects creation logic becomes to convoluted
* Constructor is not descriptive
	* Name mandated by name of containing type
	* Cannot overload the same sets of args with different names
	* Can turn into overloading hell
	
* Wholesale object creation (non-piecewise, unlike builder) can be outsourced to 
	* A separate function (factory Method)
	* That may exist in a separate class (Factory)
	* Can create hierarchy of factories with Abstract Factory

Factory: a component responsible soley for the whole sale create objects.

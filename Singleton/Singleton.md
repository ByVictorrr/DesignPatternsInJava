# Singleton
* A component which is instantiated only once
## Motivation
* For some components it only makes sense to have one in the system
	* Database repository ( a class loads stuff from db)
	* Object Factory 
* E.g., the constructor calls is expensive 
	* We only do it once
	* We provide everyone with the same instance
* We want to prevent anyone creating additional copies
* Need to take care of lazy instantiation and thread safety

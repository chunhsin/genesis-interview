# genesis-interview

## Question 

```text
Imagine you have a call center with three levels of employees: 
fresher, technical lead (TL), product manager (PM). 
There can be multiple employees, but only one TL or PM. 
An incoming telephone call must be allocated to a fresher who is free. 
If no freshers are free, 
or if the current fresher is unable to solve the caller's problem (determined by a simple dice roll), 
he or she must escalate the call to technical lead. 
If the TL is not free or not able to handle it, 
then the call should be escalated to the PM.
```


What we would like to see:

1. Create an object-oriented design for this problem. Flexible design which can be extend is preferred.
1. Do this in an object-oriented programming language that you're comfortable with.
1. Do this with multi-threading.
1. Compilable runnable and testable code.
1. Document your code.


## Structures

### CallCenter

1. Create a single CallCenter instance with one TechnicalLeader and ProductManager.
1. Create a fix thread pool to handle call async.
1. Init all Fresher here, and find free Fresher to answer call.
1. When receive a call, allocate a free fresher and start new thread to run CallProcess.

### CallProcess

1. Each CallProcess has at least one fresher to handle.
1. If problem was to difficult to current fresher, then fresher will throw a `CanNotHandleCallException`
1. If TechnicalLeader is free, then TechnicalLeader will handle the call,
otherwise will waiting until ProductManager is free to answer the call.
1. If TechnicalLeader is free, but this problem was still too hard for TechnicalLeader to solve, then the TechnicalLeader will also throw a `CanNotHandleCallException`
, then the call will waiting until ProductManager is free to answer it.
1. If TechnicalLeader is not free, the call will waiting until ProductManager is free to answer it.

### Constants

1. Define the difficulty each role can handle.
1. Define the problem solve time for each role. (easily for testing).  

### Employee

1. An interface define the employee's behavior, status, such as `answerCall`, `isFree`, etc.

### BasicEmployee

1. A basic implement of employee, Fresher, TechnicalLeader, ProductManager were all extends it.
1. Implement a basic answer call flow.
1. Using `AtomicBoolean` to ensure Thread-Safe.

### Fresher

1. Implement `canHandleCall` and `trySolveProblem` according the params in `Constants`.
1. If fresher can't handle the call, it will throw a `CanNotHandleCallException`.

### TechnicalLeader

1. Basically same with fresher, besides the params in `Constants`.


### ProductManager

1. Basically same with fresher, besides the params in `Constants`.


1. implement `canHandleCall` and `trySolveProblem` according the params in Constants.
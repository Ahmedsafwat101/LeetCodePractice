For one thing, it's more sensible in terms of inheritance. The fact that Stack extends Vector is really strange, in my view. Early in Java, inheritance was overused IMO - Properties being another example.
​
For me, the crucial word in the docs you quoted is consistent. Deque exposes a set of operations which is all about being able to fetch/add/remove items from the start or end of a collection, iterate etc - and that's it. There's deliberately no way to access an element by position, which Stack exposes because it's a subclass of Vector.
​
Oh, and also Stack has no interface, so if you know you need Stack operations you end up committing to a specific concrete class, which isn't usually a good idea.
​
Also as pointed out in the comments, Stack and Deque have reverse iteration orders:
​
```
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(new ArrayList<>(stack)); // prints 1, 2, 3
​
​
Deque<Integer> deque = new ArrayDeque<>();
deque.push(1);
deque.push(2);
deque.push(3);
System.out.println(new ArrayList<>(deque)); // prints 3, 2, 1
```
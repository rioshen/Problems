All problems come from [Stanford CS Library](http://cslibrary.stanford.edu/), especially `linked list` and `binary tree` related problems.

Should say I planed to use pure OOP to implement all problems, but carefully review all problems, you will find that a reasonable implementations should be function based solutions. So the classes are function based, not OOP.

### Binary Tree Notes

+ On average, binary search tree can locate a node in log(N) time but the worst case could be O(N) due to the list-like shape.
+ Any binary tree problems can be done using recursion.

### Binary Tree Problems

+ `lookup`: return `true` if contains the given value
+ `size`: in Java, add a private member as counter is trivial, but also we can use traversal to do this.
+ `maxDepth`: Given a binary tree, compute its "maxDepth" -- the number of nodes along the longest path from the root node down to the farthest leaf node. 
+ `minValue`: Given a non-empty binary search tree (an ordered binary tree), return the minimum data value found in that tree.
+ `hasPathSum()`: We'll define a "root-to-leaf path" to be a sequence of nodes in a tree starting with the root node and proceeding downward to a leaf (a node with no children). We'll say that an empty tree contains no root-to-leaf paths.
+ `printPaths()`: Given a binary tree, print out all of its root-to-leaf paths as defined above. This problem is a little harder than it looks, since the "path so far" needs to be communicated between the recursive calls.
+ ``

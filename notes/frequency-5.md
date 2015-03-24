+ First ask general case then design a general solution
+ Then for corner cases: design a special handlers

Word Ladder II
------------------------

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

+ Only one letter can be changed at a time
+ Each intermediate word must exist in the dictionary

For example,

Given:

start = `"hit"`

end = `"cog"`

dict = `["hot","dot","dog","lot","log"]`

Return

```
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
```

Note:

+ All words have the same length.
+ All words contain only lowercase alphabetic characters.

**Solution**

We can formulate this problem as a graph problem, because when we're checking the available transformation words of `start`, we are finding whether there is an edge between two nodes in the graph.

First, I may consider to process the dictionary, let all the words in the dictionary be the nodes of the graph, and there is an undirected edge between two nodes if one word could be converted to another by a single transformation. For example, there will be an edge between *"hit"* and *"hot"* since we can change one character. *Adjacent List* is good enough to build this graph and in Java we implement it as a `Hashmap`, the *key* is the *word*, and the *value* is a list of words.

After that, we can initiate a breadth first search from the `start` word and once we reach the `end` word, then store this path. Because our goal is to find all shortest path, we must use Breadth First Search to traverse the graph. 

**Code**

```java

```

**Analysis**

+ Time Complexity: 

`pow(x, n)`
---------------

Implement pow(x, n).

**Background**

+ *a^b* say as: a to the power b, a is called base number, b is called exponent.

**Solution**

This is an example in the lecture while learning Divide and Conquer algorithm paradigm. 

If *b* is even, let *b* equals to *2n*, we get this *a^b = a^n * a^n*, otherwise, if *b* is odd, let *b* equals to *2n+1*, we get that *a^b = a^n * a^n * a*. 

For a divide and conquer solution, this is the repeated  pattern of the recursion, the method will terminate when b equals to 0.

And now we have a general solution, what I gonna do is, design some corner cases. 

1. (Normal case should be) : pow(2, 2) => *4*
2. (Exponent is smaller than 1): pow(2, -2) => *1/4*

**Code**

```java
    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, n);
        } else{
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
```

**Analysis**

+ *T(n) = T(n / 2) + 2* so that time complexity is *O(logn)*.

Validate Binary Search Tree
-----------------------------------

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

+ The left subtree of a node contains only nodes with keys less than the node's key.
+ The right subtree of a node contains only nodes with keys greater than the node's key.
+ Both the left and right subtrees must also be binary search trees.

**Solution I**

We can do an inorder traversal and store each node's value in an array, because the output of inorder traversal is always an ordered sequence, if  the result array is in ascending order, it is valid otherwise it's not. The time complexity is *O(n)* and space complexity is also *O(n)* because we need auxiliary space for the array.

**Code I**

```java
    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(inorder(root.left));
        result.add(root.val);
        result.addAll(inorder(root.right));

        return result;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        List<Integer> sortedBST = inorder(root);
        for (int i = 1; i < sortedBST.size(); i++) {
            if (sortedBST.get(i) <= sortedBST.get(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
```

**Solution II**

To do it better, we can also recursively compare the current node value with its ancestors' value, for a valid binary search tree, the left child is smaller than all its ancestors and right child is greater than all its ancestors. It means that the children of a specific node are always limited by an upper and lower bound, so that a binary search tree can happen.

**Code II**

```java

```

Climbing Stairs
--------------------

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Solution**

The problem is closely related to *Fibonacci sequence* problem,  like can be reached from either two steps below *n-2* or one step below *n-1*, thus the number of possibilities to reach that step is the sum of the possibilities to reach those other two steps.

And same like *Fibonacci* problem, a simple recursion method will cause overlapping problem as we need to recalculate many cases. To avoid that, I may consider to use bottom up approach. We start from *n* equals to 0 and *n* equals to 1, if *n*equals to 0, we have only 1 way, if *n* equals to 1, we still only have 1 way, for any other *n* value, we calculate the possible ways based on this bottom.

**Code**

```java
    public int climbStairs(int n) {
    	if (n < 0) {
    	    throw new IllegalArgumentException();
    	}
        int a = 1; // n = 0;
        int b = 1; // n = 1;
        while (n > 1) {
            int temp = a + b;
            a = b;
            b = temp;
            n--;
        }
        return b;
    }
```

String to Integer `(atoi)`
-------------------------------

Implement `atoi` to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Question**

1. What if the input string contains leading spaces? I think the function should discard until meet the first non-space character. And also for those additional characters that after the numeric character.
2. What if no valid conversion is performed, like only special characters or white spaces? Return 0.
3. Is leading sign allow such as '+' or '-'
4. What if the number is greater than maximum integer value? Throw exception or just return the maximum integer value.

**Solution**

The general idea is we initialize the variable result as 0, and each time we meet a meaningful character, update the `result` multiply by 10 plus the new character. There are two more cases we need to consider, one is the string is a negative number, so also we need to a `flag` to remember that, and the other is, to avoid integer overflow, if the result  type should be `long`, and if it's greater than max value, set it to max value.

**Code**

```java
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
    
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int position = 0;
        boolean negative = false;
        if (str.charAt(position) == '-') {
            negative = true;
            position++;
        } else if (str.charAt(position) == '+') {
            position++;
        }
        
        double result = 0;
        while (position < str.length()) {
            if (str.charAt(position) < '0' || str.charAt(position) > '9') {
                break;
            }

            result = result * 10 + str.charAt(position) - '0';
            if (!negative && result > Integer.MAX_VALUE) {
                break;
            }
            
            position++;
        }
        
        if (!negative && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(negative && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        if (negative) {
            result = -result;
        }
        return (int)result;
    }
```

Valid Number 
------------------

Validate if a given string is numeric.

Some examples:

+ `"0"` => `true`
+ `" 0.1 "` => `true`
+ `"abc"` => `false`
+ `"1 a"` => `false`
+ `"2e10"` => `true`

**Question**

1. Is exponent notation allowed? Such as "2e10"?
2. Is leading sign allowed?
3. Is additional leading spaces allowed?
4. What if the input string in hexadecimal format?

**Solution**

A simple solution is use built-in method of Double class, double dot `valueOf`, we try to convert the input string to a double type, if we catch the exception, return `false`, otherwise, return `true`. But it doesn't handle the case that string contains special but legal characters. 

It's more like an *ad hoc* problem, that no general algorithm paradigm we can use but just take care and consider different corner cases. I may consider user different `flag` to remember whether it has *exponential notation* or *decimal point* while iterating the string.

**Code**

```java
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // remove leading whitespaces
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }

        int position = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        boolean foundDigit = false;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        while (position < s.length()) {
            char c = s.charAt(position);
            if (Character.isDigit(c)) {
                foundDigit = true;
            } else if (c == '.') {
                if (hasDecPoint || hasExp) {
                    return false;
                }
                hasDecPoint = true;
            } else if (c == 'e') {
                if (hasExp || !foundDigit) {
                    return false;
                }
                hasExp = true;
                foundDigit = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(position - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            position++;
        }
        return foundDigit;
    }
```

Merge Intervals
------------------

Given a collection of intervals, merge all overlapping intervals.

For example,

Given `[1,3],[2,6],[8,10],[15,18]`,

return `[1,6],[8,10],[15,18]`.

**Solution**

A simple approach is, iterate over the list, and compare it with others for overlapping. If it overlaps with any other interval, remove the other and merge it into the current interval. The time complexity is *O(n^2)*. 

To optimize it, first sort the list according to the `start`, it take *O(nlogn)*. Once we have the sorted intervals, we can combine them in linear time because we only consider the current interval with the next one and this can be done in one pass.

**Code**

```java
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
    
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        
        List<Interval> result = new LinkedList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) { 
                prev.end = Math.max(prev.end, curr.end);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        
        return result;
    }
```

Insert Interval
---------------------

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals `[1,3]`, `[6,9]`, insert and merge `[2,5]` in as `[1,5]`, `[6,9]`.

Example 2:

Given `[1,2],[3,5],[6,7],[8,10],[12,16]`, insert and merge `[4,9]` in as `[1,2],[3,10],[12,16]`. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

**Solution**

Three cases we need to consider:

1. If the new interval's *end* time is smaller than the current interval's *start* time in the list, then simply insert it to the head of the list then terminate the program.
2. If the new interval's *start* time is greater than the current interval's *end* time, then move one step further.
3. Otherwise, if the new interval intersects with the current one, merge them and delete it from the list.

**Code**

```java

```

Merge Two Sorted Lists
--------------------------------

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Solution**

It's like the merge operation of *merge sort*, after dividing the entire unsorted list, we get two sorted sublists and then we merge them into one. 

But for a linked list problem, we need a redundant dummy node to store the result head pointer. After that, iterate two lists at the same time, in each iteration, compare their values, and append it to the tail. After we're done, the result is the `dummy.next`.

One more thing is, if two lists, let's say a and b, they have different length, we need to avoid the `null` pointer within the loop.

**Code**

```java
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        
        return dummy.next;
    }
```
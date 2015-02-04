import java.util.*;

class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }

    // here's a bug of OJ its own, return type should be `int`
    public int pop() {
        int x = stack.pop();
        if (x == minStack.peek()) minStack.pop();
        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
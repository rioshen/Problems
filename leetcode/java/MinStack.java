import java.util.*;

/**
 * If leverage the built-in Stack container, things gonna be easy.
 */
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }

    // here's a bug of OJ, return type should be `int`
    public int pop() {
        int x = stack.pop();
        if (x == minStack.peek()) minStack.pop();
        return x;
    }

    public int top() { return stack.peek(); }

    public int getMin() { return minStack.peek(); }
}

/**
 * Also we can implement all this from scratch
 */
class MyStack {
    LNode tail;

    static class LNode {
        int val;
        LNode next;

        public LNode(int x) { this.val = x; }
    }

    public void push(int value) {
        LNode node = new LNode(value);
        if (tail == null) {
            tail = node;
        } else {
            node.next = tail;
            tail = node;
        }
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException();

        int value = tail.val;
        tail = tail.next;
        return value;
    }

    public boolean isEmpty() { return tail == null; }

    public int peek() {
        if (tail == null) throw new NoSuchElementException();
        return tail.val;
    }
}

class MinStackScratch {
    MyStack stack = new MyStack();
    MyStack minStack = new MyStack();

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() >= value) minStack.push(value);
    }

    public int pop() {
        int value = stack.pop();
        if (!minStack.isEmpty() && value == minStack.peek()) minStack.pop();
        return value;
    }

    public int top() { return stack.peek(); }

    public int min() { return minStack.peek(); }
}

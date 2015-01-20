// Minimum Stack
// http://www.fusu.us/2013/06/p8-minimum-stack.html
//
// Solution:
// Maintain two stacks, one for common operations such as push, pop, the other
// only stores the current minimum value in the stack.
// When pushing, we compare the new value whether it is smaller, if so, push on to
// the min stack. When poping, first pop from the common stack then compare it with
// the peek of min stack, if equals it means we are poping the minimum value from
// the stack, pop it from min stack too.

import java.util.*;

public class MinStack<E extends Comparable<E>> {
    private Stack<E> stack = new Stack<E>();
    private Stack<E> minStack = new Stack<E>();
    
    public void push(E item) {
        stack.push(item);

        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            if (item.compareTo(minStack.peek()) < 0) {
                minStack.push(item);
            }
        }
    }
    
    public E pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        E item = stack.pop();
        if (item.equals(getMin())) {
            minStack.pop();
        }

        return item;
    }
    
    public E getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new NoSuchElementException();
    }
    
    public E peek() {
        return stack.peek();
    }
    
    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.getMin()); // 1
        stack.push(0);
        System.out.println(stack.getMin()); // 0
        stack.pop();
        System.out.println(stack.getMin()); // 1
        
    }
}
/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * we could instead have two Stackss inside our MinStack. The main Stack should keep track of the order numbers arrived (a standard Stack), and the second Stack should keep track of the current minimum. 
 * We'll call this second Stack the "min-tracker" Stack for clarity.
 * 
 * The push(...) method for this implementation of MinStack is straightforward. Items should always be pushed onto the main Stack, but they should only be pushed onto the min-tracker Stack if they are smaller than the current top of it. Well, that's mostly correct. There's one potential pitfall here that we'll look at soon.

MinStack's two getter methods, top(...) and getMin(...) are also straightforward with this approach. top(...) returns (but doesn't remove) the top value of the main Stack, whereas getMin(...) returns (but doesn't remove) the top of the min-tracker Stack.

This leaves us still needing to implement MinStack's pop(...) method. The value we actually need to pop is always on the top of the main underlying Stack. However, if we simply popped it from there, the min-tracker Stack would become incorrect once its top value had been removed from the main Stack.

A logical solution would be to do the following additional check and modification to the min-tracker Stack when MinStack's pop(...) method is called.

If top of main_stack == top of min_tracker_stack:
    min_tracker_stack.pop()
This way, the new minimum would now be the top of the min-tracker Stack. If you're confused about why this is, think back to the previous approach, and remember when the minimum changed.



Time Complexity : O(1)
Space Complexity : O(n)

    NOTE: There is another method where we can do in TIME and SPACE of O(1). Refer GFG Self paced DSA course. Also refer "stacksandqueues --> Stack with getmin.java"
 * 
 */

package Amazonlist;

import java.util.Stack;

public class StackWithGetMin {

    // logic is here we take 2-stacks. 
    // one stack to just push elements while other stack maintains the min  elements seen always.

    Stack<Integer> stk; // main stack
    Stack<Integer> min_stack;   // min stack
    
    public StackWithGetMin() {
             stk = new Stack<>();
             min_stack = new Stack<>();
    }
    
    public void push(int val) {

        // while pushing, push element directly into main stack
        // while pushing into min stack, check if min_stack is empty or current value is <= top of min stack the push on to it.

        
        stk.push(val);
        
        if(min_stack.size()==0 || val <= min_stack.peek())
            min_stack.push(val);
        
        
    }
    
    public void pop() {

        // while popping, pop from min stack if top element of min stack and main stack are same then pop from min stack.
        // always pop from main stack.
        
        if(min_stack.peek().equals(stk.peek()))
                min_stack.pop();
        
        stk.pop();
        
        
    }
    
    public int top() {
        
        return stk.peek();
        
    }
    
    public int getMin() {
        
        return min_stack.peek();
        
    }
    
}

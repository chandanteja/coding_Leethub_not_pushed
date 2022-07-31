import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 */

public class ImplementQueueUsingStacks {

    Stack<Integer> s1,s2;
    
    public ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        
        return s2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
        
    }
    
}

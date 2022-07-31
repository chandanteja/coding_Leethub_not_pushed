/**
 * 
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * Logic is we take 2 stacks, say s1 and s2.
 * 
 * If we want to enqueue into queue, we push to s1.
 * 
 * If we want to deque from queue, we check if s2 is empty then we transfer all elemenets from s1 to s2 and pop the top ele.
 * else
 * we just delete top ele frm s2.
 * 
 * same as pop for peek()
 * 
 * if both s1 and s2 are empty then q is empty else not.
 * 
 * 
 * 
 */

package MorganStanleyList;

import java.util.Stack;

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

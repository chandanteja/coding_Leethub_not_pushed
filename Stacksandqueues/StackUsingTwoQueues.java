/**
 * 
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
 * 
 * In push operation, the new element is always enqueued to q1. In pop() operation, if q2 is empty then all the elements except the last, are moved to q2. 
 * Finally the last element is dequeued from q1 and returned.
 * 
 * 
 */

package Stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
   
    int size=0;
    
    // Here POP operation is made costly.
    // Push operation is O(1).
    
    void push(int a)
    {
	    q1.add(a);
	    size++;
    }
    
    
    int pop()
    {
        if (q1.isEmpty())
            return -1;
        
	        while(q1.size()!=1)
	            q2.add(q1.remove());
	       
	    int ele = q1.remove();
	    size--;
        
        // after adding elements to 2nd queue, we exchange the pointers. So that always in q1 we have elements.
	    Queue<Integer> q =q1;
	    q1=q2;
	    q2=q;
	    size = q1.size();
	    return ele;
    }
    
}

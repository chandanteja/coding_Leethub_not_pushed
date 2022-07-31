/**
 * 
 * https://www.geeksforgeeks.org/reversing-first-k-elements-queue/
 * 
 *  The idea is to use an auxiliary stack. 

    1. Create an empty stack.
    2. One by one dequeue first K items from given queue and push the dequeued items to stack.
    3. Enqueue the contents of stack at the back of the queue
    4. Dequeue (size-k) elements from the front and enque them one by one to the same queue. 
 * 
 */

package Stacksandqueues;

import java.util.*;

public class ReverseFirstKEleOfQueue {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> s = new Stack<>();
        int n = q.size()-k;
        
        for(int i=0;i<k;i++)
        {
            s.push(q.poll());
        }
        
        for(int i=0;i<k;i++)
        {
            q.add(s.pop());
        }
        
        for(int i=0;i<n;i++)
        {
            q.add(q.poll());
        }
        return q;
    }
    
}

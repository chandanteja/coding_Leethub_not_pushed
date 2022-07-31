package Stacksandqueues;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingStack {

    public Queue<Integer> rev(Queue<Integer> q){
    
        Stack<Integer> s = new Stack<>();
      
        while(!q.isEmpty())
        {
            s.push(q.poll());
        }
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
        return q;
      }
    
}

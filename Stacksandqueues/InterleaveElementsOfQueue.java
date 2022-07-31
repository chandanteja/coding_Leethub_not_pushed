/**
 * 
 * Two methods are possible for this.
 * 1. Using auxiliary stack
 * 2. Using auxiliary queue.
 * 
 *  1. Using stack
 * ----------------
 *  1.Push the first half elements of queue to stack.
    2.Enqueue back the stack elements.
    3.Dequeue the first half elements of the queue and enqueue them back.
    4.Again push the first half elements into the stack.
    5.Interleave the elements of queue and stack.

    2. Using queue
    ---------------
    1. To interleave using queue DS only, we need 2-queues
    2. Push first half of elements to q1 and 2nd half of elements to q2.
    3. Now push back elements of q1 and q2 to Original queue (q) in interleaved fashion i.e push element of q1 to q then push element of q2 to q.
    4. Repeat step-3
 * 
 */

package Stacksandqueues;

import java.util.Queue;
import java.util.Stack;

public class InterleaveElementsOfQueue {

    static void interLeaveQueue(Queue<Integer>q)
{
    // To check the even number of elements
    if (q.size() % 2 != 0)
        System.out.println("Input even number of integers." );
  
    // Initialize an empty stack of int type
    Stack<Integer> s = new Stack<>();
    int halfSize = q.size() / 2;
  
    // Push first half elements into the stack
    // queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
    for (int i = 0; i < halfSize; i++)
    {
        s.push(q.peek());
        q.poll();
    }
  
    // enqueue back the stack elements
    // queue: 16 17 18 19 20 15 14 13 12 11
    while (!s.empty()) 
    {
        q.add(s.peek());
        s.pop();
    }
  
    // dequeue the first half elements of queue
    // and enqueue them back
    // queue: 15 14 13 12 11 16 17 18 19 20
    for (int i = 0; i < halfSize; i++) 
    {
        q.add(q.peek());
        q.poll();
    }
  
    // Again push the first half elements into the stack
    // queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
    for (int i = 0; i < halfSize; i++)
    {
        s.push(q.peek());
        q.poll();
    }
  
    // interleave the elements of queue and stack
    // queue: 11 16 12 17 13 18 14 19 15 20
    while (!s.empty())
    {
        q.add(s.peek());
        s.pop();
        q.add(q.peek());
        q.poll();
    }
}
 
    
}

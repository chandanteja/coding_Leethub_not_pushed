/**
 * 
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * Logic is we use Deque to store negative numbers in every window.
 * 
 * 1. We create a Dequeue, Di of capacity k, that stores only useful elements of the current window of k elements. 
 * 2. An element is useful if it is in the current window and it is a negative integer. 
 * 3. We process all array elements one by one and maintain Di to contain useful elements of current window and these useful elements are all negative integers. 
 * 4. For a particular window, if Di is not empty then the element at front of the Di is the first negative integer for that window, else that window does not contain a negative integer.
 * 
 * 
 * 
 */

package Stacksandqueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntegerInWindowSizeK {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> res = new ArrayList<>();
            
        // A Double Ended Queue, Dq that will
    // store indexes of useful array elements
    // for the current window of size k.
    // The useful elements are all negative integers.
        Deque<Long> dq = new LinkedList<>();        // In deque we store indices of negative numbers but not elements of given array
        
        int i=0;

         // Process first k (or first window)
        // elements of array
        for(i=0;i<K;i++)
        {
            if(A[i]<0)
                dq.add((long)i);
        }
        
         // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for(;i<N;i++)
        {
        // if Dq is not empty then the element
        // at the front of the queue is the first
        // negative integer of the previous window
            if(!dq.isEmpty())
                res.add(A[dq.peek().intValue()]);
            // else the window does not have a
        // negative integer
            else
                res.add(0L);
            
                // Remove the elements which are
        // out of this window
            while(!dq.isEmpty() && dq.peek() < i-K+1)
                dq.removeFirst();   // Remove from front of queue
            
                // Add current element at the rear of Di
            // if it is a negative integer
            if(A[i]<0)
                dq.add((long)i);
            
            
        }
     
     long retval [] = new long[res.size()+1];
     
     for( i=0;i<res.size();i++)
        retval[i] = res.get(i);
        
      // add the first negative
    // integer of last window  
    if(!dq.isEmpty())
        retval[i] = A[dq.peek().intValue()];    // adding last window negative element
     else
        retval[i] = 0;
     
     return retval;   
    }
    
}

/**
 * 
 *  Watch GFG self paced DSA course video.
 * 
 *  Logic is we calculate next smaller and previous smaller elements for all elements in array and find area as below
 * 
 *  area formed by element arr[i] = arr[i] *(nextsmaller[i] - previoussmaller[i] - 1). We are doingg -1 bcz we are adding arr[i] twice (once in next smaller and 2nd in prev smaller).
 *  where arr[i] gives length and (nextsmaller[i] - previoussmaller[i] - 1) --> GIVES BREADTH
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class MaxRectangularAreaInHistogram {

    public static long getMaxArea(long hist[], long n)
    {
    
        long ps [] = new long [(int)n]; // previous smaller array
        long ns [] = new long [(int)n]; // next smaller array
        
        // finding next smaller and previous smaller ele.
        prevSmaller(ps,hist,n);
        nextSmaller(ns,hist,n);
        
        long maxArea = 0;
        
        for(int i = 0 ; i < n ; i++)
        {
        
            long area = hist[i] * (ns[i] - ps[i] - 1);  // nextsmaller[i] - prevsmaller[i] -1 (-1 as we need to remove current ele arr[i] as it is added twice)
            //where hist[i] gives length and (nextsmaller[i] - previoussmaller[i] - 1) --> GIVES BREADTH
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }

static void prevSmaller(long [] a , long hist[], long n)
{

    Stack<Integer> st = new Stack<>();
    st.push(0);
    a[0] = -1;  // here we are storing indices of prev smaller ele instead of values. If prev smaller ele doesnt exist, we put it as -1
    
    
    for(int i = 1 ; i < n ; i++)
    {
    
        while(!st.isEmpty() && hist[i] <= hist[ st.peek() ] )
        {
             st.pop();
        }
        
        if(!st.isEmpty())
        {
        
             a[i] = st.peek();
        }
        else 
        {
             a[i] = -1;
        }
        st.push(i);
    }
}

static void nextSmaller(long [] a , long hist[], long n)
{


    Stack<Integer> st = new Stack<>();
    st.push((int)n-1);
    a[(int)n-1] = n;    // here we are storing indices of next smaller ele instead of values. If next smaller doesnt exist, we put it as 'n' ( which is greater than last index [n-1] possible of array)
    
    
    for(int i = (int) n-2 ; i >= 0 ; i--)
    {
    
        while(!st.isEmpty() && hist[st.peek()] >= hist[i])
        {
             st.pop();
        }
        
        if(!st.isEmpty())
        {
        
             a[i] = st.peek();
        }
        else
        {
             a[i] = n;
        }
        
        st.push(i);
    }

}
    
}

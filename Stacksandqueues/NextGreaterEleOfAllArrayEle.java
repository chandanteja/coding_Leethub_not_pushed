/**
 * 
 *  refer GFG self paced DSA course video.
 * 
 * Logic is we start from last for 'next greater ele' and from first for 'previous greater ele.'
 * For last ele there will be no next greater ele. So it will be -1.
 * No push the last ele on to stack and traverse in array from last to first.
 * Check if top of stack is < current ele in array then pop the top ele. Repeat this till we find an ele on top of stack which is greater than curr ele of array or stack is empty 
 *  
 * push the current array ele on to stack, as for upcoming elements in array, this can be the greatest ele which is near to them.
 */

package Stacksandqueues;

import java.util.Stack;

public class NextGreaterEleOfAllArrayEle {

    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> s = new Stack<>();
            
        long res[] = new long[n];
        
        
        res[n-1] = -1;
        s.push(arr[n-1]);
        
        for(int i=n-2;i>=0;i--)
        {
           while(s.isEmpty()==false && s.peek()<=arr[i])
                s.pop();
            if(s.isEmpty()==true)
                res[i] = -1;
            else    
                res[i] = s.peek();
                
            s.push(arr[i]); // we are pushing this element as for upcoming elements in array, this can be the greatest ele which is near to them
            
        }
        return res;
            
        
    } 
    
}

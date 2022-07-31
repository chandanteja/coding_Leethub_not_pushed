/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * https://www.youtube.com/watch?v=CiiXBvrX-5A
 * 
 *  Celebrity is one known to every one and celebrity doesnt know anyone.
 * 
 *  m[i][j] = 1 means  'i' knows 'j' but 'j' doesnt know 'i'.
 * 
 *  
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class CelebrityProblem {

    int celebrity(int m[][], int n)
    {
    	Stack<Integer> s = new Stack<>();
    	
    	for(int i=0;i<n;i++)
    	{
    	    s.push(i);
    	}
    	
    	while(s.size()>1)
    	{
    	    int a = s.pop();
    	    int b = s.pop();
    	    
    	    if(m[a][b]==1)      // if m[a][b] ==1 means 'a' knows 'b' means 'a' cant be celebrity as celebrity doesnt know anyone. But 'b' may be celebrity (so to verify that we push 'b' again)
    	        s.push(b);
    	    else
    	        s.push(a);
    	   if(s.isEmpty())
    	        return -1;
    	        
    	}
    	
    	int a=-1;
    	
    	if(s.size()==1)
    	 {
    	     a=s.pop();
    	     for(int i=0;i<n;i++)
    	     {
    	         if(i!=a && (m[a][i]!=0 || m[i][a]!=1))
    	            return -1;
    	     }
    	 }
    	 
    	 return a;
    }
    
}

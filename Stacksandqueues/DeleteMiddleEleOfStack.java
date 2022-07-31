/**
 * 
 * https://www.geeksforgeeks.org/delete-middle-element-stack/
 * 
 * Logic is we pop all elements one by one and keep track of number of elements popped using a counter and if mid element is reached, then we dont push back that element
 * Remaining elements we push back to stack.
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class DeleteMiddleEleOfStack {

    public void midEleRemove(Stack<Integer>s,int sizeOfStack, int curr)
    {
        if(curr==sizeOfStack || s.isEmpty())
            return ;
            
        int currEle= s.pop();
        
        midEleRemove(s,sizeOfStack,curr+1);
        
        if(curr != Math.floor(sizeOfStack/2.0))
                s.push(currEle);
        
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack)
    {
            midEleRemove(s,sizeOfStack,0);
    } 


    
}

/**
 * 
 * https://leetcode.com/problems/validate-stack-sequences/solution/
 * 
 * For each value, push it to the stack.

Then, greedily pop values from the stack if they are the next values to pop.

At the end, we check if we have popped all the values successfully.


    Time Complexity: O(N), where N is the length of pushed and popped.

    Space Complexity: O(N).
 * 
 */

package Amazonlist;

import java.util.Stack;

public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> s = new Stack<>();
        int i=0;

    // logic is first we push an element to stack , after pushing
    // we check if stack is not empty and if top of stack is same as current element in popped[], then we pop top ele, and increment the index used for popped[].
    //  we continue in this way
    // if at the end stack is not empty then return false.
    
       for(int j=0;j<pushed.length;j++)
       {
           s.push(pushed[j]);
           while(!s.isEmpty() && s.peek()==popped[i])
           {
               s.pop();
               i++;
           }
       }
       
        if(s.isEmpty())
                return true;
        return false;
        
    }
    
}

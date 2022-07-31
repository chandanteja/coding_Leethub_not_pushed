/**
 * 
 * This is a variation of "Validate Stack Sequence". 
 * 
 *  -----------------------------------
   
    ------------        ---------------
                |       |
                |       |
		

1,3,2,5,4   --> I/P

1,2,3,4,5   --> O/P --> valid O/p.
1,4,5,3,2   --> O/P invalid.


cars come in from left in the order given in input.
we shud tell if they can be released in the order given in the output or not.
We can use the diversion given on right, to re-arrange cars in the order we need.
  
 * 
 */

package Amazonlist;

import java.util.Stack;

public class VariationOfValidateStackSequence {

    boolean cars(int ip[], int n)
    {
        int count=1; // to track output
        Stack<Integer> s = new Stack<>();
        //'s'   is stack.

        for(int i=0;i<ip.length;i++)
        {
            if(ip[i]==count) // if ith car == the car that is to be released, then release it and move to next car to release.
            {
                count++; // so increment the count.
            }
            else
            {
                s.push(ip[i]); // else push the current car to stack. means we cant release it immediately
                // and all the cars that cant be released immediately go into opening to the bottom. i.e. consider it as stack.
                // if 5,4,3,2,1 are the order of input but output is 1,2,3,4,5
                // so we will put all till 1 in the stack.
                // stack will be 
                //   5  4   3   2
                //              top
            }

            while(!s.isEmpty() && s.peek()==count) // now check if the stack is not empty and if the top matches the count.
            { // if it matches pop till top and count doesnt match or the stack becomes empty.
                s.pop();
                count++;
            }
        }
        

        if(s.isEmpty()) // at the end if the stack becomes empty then we can get the cars out in sorted order
            return true;
        else // else we cant.
            return false;
    }
    
}

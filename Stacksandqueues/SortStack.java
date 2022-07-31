/**
 * Using recursion (or) extra stack stack
 * -----------------------------
 * T.C : O(N^2)
 * S.C : O(N)
 * 
 *  https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 *  https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
 * 
 * Logic is using extra stack.
 * Using extra stack, we will maintain the sorted order in 2nd stack.
 * 
 *  S1          S2
 *  ----------------
 *  41
 *  3
 *  32
 *  2
 *  11
 * -------------------  
 *  3             41
 *  32
 *  2
 *  11
 * -------------------
 * As 3<41, we pop 41 from 2nd stack and push it into i/p stack and push '3' onto 2nd stack. We repeate the same process for all elements
 * If the top of 2nd stack is greater than popped element from 1st stack then we pop all such elements from 2nd stack and insert them in 1st(i/p) stack.
 * In 2nd stack smallest number will be at bottom and biggest number will be at top.    
 * 
 *  41             3
 *  32
 *  2
 *  11
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sortstack(Stack<Integer> 
                                             input)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();
          
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek() 
                                                 > tmp)
            {
                // pop from temporary stack and 
                // push it to the input stack
            input.push(tmpStack.pop());
            }
              
            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public static void main(String args[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
      
        // This is the temporary stack
        Stack<Integer> tmpStack=sortstack(input);
        System.out.println("Sorted numbers are:");
      
        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        } 
    }
    
}

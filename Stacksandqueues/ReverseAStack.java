/**
 * 
 * https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/   --> refer this.
 *  
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class ReverseAStack {

   
    
    static Stack<Integer> reverse(Stack<Integer> s)
    {
       Stack<Integer> temp = new Stack<>();

        while(!s.isEmpty())
        {
            temp.push(s.pop());
        }
        return temp;

    }

    public static void main(String[] args) 
    {
        Stack<Integer> s = new Stack<>();
        // push elements into
        // the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
          
        System.out.println("Original Stack");
          
        System.out.println(s);
          
        // function to reverse 
        // the stack
        s = reverse(s);
          
        System.out.println("Reversed Stack");
          
        System.out.println(s);
    }
    
}

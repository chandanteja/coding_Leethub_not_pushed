/**
 * 
 * Logic is first push the numbers on to stack and if we get any operator apply that to top 2 ele of stack and push the result on to stack.
 * 
 * if top ele is 'a' and top 2nd ele is 'b' then we need to do as b-a or b/a or b*a or b+a. i.e the first popped ele will be the right operand and 2nd popped ele will be left operand.
 * 
 *  Watch gfg DSA course video if needed.
 * 
 *  https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class EvaluationOfPostfix {

    public static int evaluatePostFix(String S)
    {
        Stack<String> s = new Stack<>();
        
        for(int i=0;i<S.length();i++)
        {
            if( Character.isDigit( S.charAt(i) ) == true )
            {
                s.push(String.valueOf(S.charAt(i)));
                //System.out.println("top is: "+s.peek());
            }
            else
            {
                int c1 = Integer.parseInt(s.pop());
                int c2 = Integer.parseInt(s.pop());
                
                if(S.charAt(i)=='*')
                {
                  c1 = c2*c1;
                  s.push(Integer.toString(c1));
                 // System.out.println("top is *: "+s.peek());
                  
                }
                else if(S.charAt(i)=='/')
                {
                    c1 = c2/c1;
                    s.push(Integer.toString(c1));
                   // System.out.println("top is /: "+s.peek());
                    
                }
                else if(S.charAt(i)=='-')
                {
                   // System.out.println("c1:" +c1+"  c2: "+c2);
                    c1 = c2-c1;
                    
                    s.push(Integer.toString(c1));
                  //  System.out.println("top is -: "+s.peek());
                }
                else
                {
                    c1 = c2+c1;
                    s.push(Integer.toString(c1));
                  //  System.out.println("top is +: "+s.peek());
                }
                
            }
        }
        return Integer.parseInt(s.peek());
    }
    
}

/**
 * 
 * No reference is needed
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class ParanthesisChecker {

    static boolean ispar(String x)
    {
        Stack<Character> stk = new Stack<>();
        int n = x.length();
        
        for(int i=0;i<n;i++)
        {
                char curr = x.charAt(i);
                if(curr == '[' || curr == '{' || curr=='(')
                {
                    stk.push(curr);
                 //   System.out.println("curr: "+curr);
                }
                 if(curr == ']' )
                {
                    if(stk.isEmpty())
                        return false;
                        
                    char temp = stk.peek();
                  //  System.out.println("temp1: "+temp);
                    if(temp!='[')
                        return false;
                    stk.pop();
                    
                  //  System.out.println("peek1(): "+stk.peek());
                    
                }
                
                 if(curr == '}' )
                {
                    if(stk.isEmpty())
                        return false;
                        
                    char temp = stk.peek();
                  //  System.out.println("temp2: "+temp);
                    if(temp!='{')
                        return false;
                    stk.pop();
                   // System.out.println("peek2(): "+stk.peek());
                    
                }
                 if(curr == ')' )
                {
                    if(stk.isEmpty())
                        return false;
                        
                    char temp = stk.peek();
                //    System.out.println("temp3: "+temp);
                    if(temp!='(')
                        return false;
                    stk.pop();
                  //  System.out.println("peek3(): "+stk.peek());
                    
                } 
        }
        
         return stk.isEmpty()? true : false ;
    }
    
}

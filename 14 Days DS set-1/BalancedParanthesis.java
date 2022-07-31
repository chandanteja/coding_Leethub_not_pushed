/**
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 */

import java.util.Stack;

public class BalancedParanthesis {

    public boolean isValid(String s) {
        
        if(s.length()==0)
                return true;
        Stack<Character> stk = new Stack<>();
        
        int i;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stk.push(s.charAt(i));
            else if(s.charAt(i) == ')' )
            {
                if(!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else return false;
            }
            else if(s.charAt(i) == '}' )
            {
                if(!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else return false;
            }
            else
            {
                if(!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else return false;
            }
            
            
        }
       return stk.isEmpty() ? true : false;
        
    }
    
}

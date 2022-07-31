/**
 * 
 * Watch DSA course video 
 * 
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 * 
 * 
    1. Scan the infix expression from left to right. 
    2. If the scanned character is an operand, output it. 
    3. Else, 
        1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it. 
        2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. 
        (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.) 
    4. If the scanned character is an ‘(‘, push it to the stack. 
    5. If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
    6. Repeat steps 2-6 until infix expression is scanned. 
    7. Print the output 
    8. Pop and output from the stack until it is not empty.
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class InfixToPostfix 
{

    private static boolean IsOperator(char ch)
    {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^')
        {
            return true;
        }

        return false;
    }

    private static boolean IsOperand(char ch)
    {
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))
        {
            return true;
        }
        return false;
    }

    private static int PrecedenceValue(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            case '(':
                return 100;
            default:
                break;
        }

        return -1;
    }

    // checks if character a has higher precedence than b
    private static boolean HasHigherOrSamePrecedence(char a, char b)
    {
        return PrecedenceValue(a) >= PrecedenceValue(b);
    }

    private static boolean IsRightParanthesis(char ch)
    {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean IsLeftParanthesis(char ch)
    {
        return ch == '(' || ch == '{' || ch == '[';
    }

    public static String infixToPostfix(String exp) 
    {
        String res = "";
        if (exp == null || exp.isEmpty())
        {
            return res;
        }

        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if (IsOperand(ch))
            {
                res = res + ch;
            }
            else if (IsRightParanthesis(ch))
            {
                while (!st.isEmpty())
                {
                    char temp = st.pop();
                    if (IsLeftParanthesis(temp))
                    {
                        break;
                    }
                    res = res + temp;
                }
            }
            else if (IsOperator(ch) || IsLeftParanthesis(ch))
            {
                while (!st.isEmpty() && !IsLeftParanthesis(st.peek()) && HasHigherOrSamePrecedence(st.peek(), ch))
                {
                    res = res + st.pop();
                }

                st.push(ch);
            }
        }

        while (!st.isEmpty())
        {
            res = res + st.pop();
        }

        return res;
    }
    
}

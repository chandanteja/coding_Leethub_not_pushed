/**
 * 
 * https://www.geeksforgeeks.org/program-to-insert-an-element-at-the-bottom-of-a-stack/
 * 
 * Using recursion pop all elements of stack and hold them in temp variable, now when the stack becomes empty, now insert the new element and return
 *  
 *  Now, after the recursive  call completion, push the popped element on to stack .
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class InsertElementAtBottomOfAStack {

    static void insertToBottom(Stack<Integer> s, int N)
    {
        if(s.size()==0)
        {
            s.push(N);
            return;
        }

        int temp = s.pop();
        insertToBottom(s,N);
        s.push(temp);
        return ;

    }

    public static void main(String[] args)
{
     
    // Given Binary Tree
    Stack<Integer> S = new Stack<>();
    S.push(5);
    S.push(4);
    S.push(3);
    S.push(2);
    S.push(1);
 
    int N = 7;
    int m = 6;
 
    insertToBottom(S, N); 
    insertToBottom(S, m);

    while(!S.isEmpty())
    {
        System.out.print(S.pop()+" ");
    }
}

    
}

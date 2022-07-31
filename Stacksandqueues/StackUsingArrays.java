/**
 * 
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 * 
 */

package Stacksandqueues;

public class StackUsingArrays {

    final int MAX_SIZE;
    int top;
    int stack[];

    StackUsingArrays()
    {
        MAX_SIZE = 100;
        top = -1;
        stack = new int[MAX_SIZE];
    }


    public boolean isEmpty()
    {
        if(top==-1)
            return true;
        return false;

    }

    public void push(int x)
    {
        if(top >= MAX_SIZE-1)
        {
            System.out.println("Stack overflow");
            return ;
        }

        stack[++top] = x;
        System.out.println(x + " pushed into stack");

    }
    
    public int pop()
    {
        if(top<0)
        {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int temp = stack[top--];

        System.out.println("Popped ele is: "+ temp);
        return temp;

        
    }

    public int peek()
    {
        if(top<0)
        {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        
        return stack[top];
    }

    public static void main(String args[])
    {
        StackUsingArrays s = new StackUsingArrays();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        
        System.out.println(s.peek() + " Top ele on stack");
        System.out.println("Is Stack empty: "+s.isEmpty());


    }

    
}

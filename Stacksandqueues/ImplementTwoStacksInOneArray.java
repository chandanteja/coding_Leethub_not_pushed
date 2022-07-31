/**
 * 
 * If want refer GFG self paced DSA course video. 
 * But dont need any reference.
 * 
 */

package Stacksandqueues;


class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[100];

	TwoStack()
	{
		size = 100;
		top1 = -1;
		top2 = size;
	}
}

public class ImplementTwoStacksInOneArray {

    void push1(int x, TwoStack sq)
    {
        if(sq.top1+1 == sq.top2)
            return;
        
        sq.arr[++sq.top1]=x;
        return;
        
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
         if(sq.top1+1 == sq.top2)
                    return;
                    
        sq.arr[--sq.top2]=x;
        return;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
            if(sq.top1==-1)
                return -1;
            int ele = sq.arr[sq.top1--];
            return ele;
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if(sq.top2==sq.size)
            return -1;
        int ele = sq.arr[sq.top2++];
        return ele;
        
            
    }
    
}

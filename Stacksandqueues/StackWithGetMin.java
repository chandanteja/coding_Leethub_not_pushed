/**
 * Watch gfg course video, for clear understanding of logic.
 * 
 *  Naive: O(n) - T.C  & O(n) - S.C
 * 
 *  Efficient:
 * --------------
 *  1) O(1) time and O(n) space (extra stack is used)
 *  2) O(1) time and O(1) space with nice logic
 * 
 * Logic is we maintain a variable which keeps track of 'current min' in stack at any point of time.
 * If we get an ele=x which is <= min, we push (2(x)-min) into stack rather than original ele. and update min with x.
 * When we pop, we check if popped ele is <=min then it means we pushed (2x - min), so we store min in temp variable and update min as 2(min)-popped value.
 * 
 * This works bcz,
 *  if x <= min ==> x-min <= 0
 *  Add 'x' on both sides ==> 2x-min <= x.
 * 
 * 
 * 
 */

package Stacksandqueues;

import java.util.Stack;

public class StackWithGetMin {

    int min = Integer.MAX_VALUE;
    
    
	public void push(int a,Stack<Integer> s)
	{
	    if(s.isEmpty())
	    {
	        s.push(a);
	        min=a;
	    }
	    else if(a<=min) 
        /*
            if x <= min ==> x-min <=0
            ==> 2x-min <= x
        */
	    {
	        s.push(2*a-min);
	        min = a;
	    }
	    else
	        s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
            int temp = s.pop();
            if(temp<=min)
            /*
                let popped ele be 'temp'
                if (temp<= min) it means when pushing this element we got an element which was smaller than min ele at that time, so we pushed 2x-min instead of the original ele
                so to get min element at that point of time before pushing the ele, we do as below.

                we subtract the currently popped value to 2*min.
                Let min1=5, x =2
                we push 2(2) - 5 ==> -1 is pushed when we get '2' and min1=5

                Now min1=2
                when '-1' is popped from stack, then we need to recover the element that actually shuld be pushed (but pushed 2x-min) and also previous min before pushing 'x'
                popped-ele = 2*min - prev_min
                prev_min = 2*min-popped-ele

                ex:
                -1 = 2*2-5
                5 = 2*2-(-1)

            */

            {
                int res = min;
                min = 2*min-temp;
                return res;
                
            }
            else
                return temp;
	}
	public int min(Stack<Integer> s)
    {
            return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
               if(s.size()==n)
                return true;
            return false;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        if(s.isEmpty())
            return true;
        return false;
	}
    
}

/**
 * 
 * Refer GFG video or Naven garg sir Nptel video
 * 
 * Logic is we use stack for this problem to maintain previous largest elements on stack
 * We need not maintain all elements on stack, we just need to maintain which are visible/tall elements in previous iterations.
 * 
 * Let arr[] = {13,15,12,14,16,8,6,18}
 * 
 * we first push 13 on stack and when 15 comes we pop 13 and push 15
 * Now we push 12 on stack and when 14 comes we pop 12 and put 14
 * Now when '16' comes, stack will have 15,14 as 16 is larger than 15 and 14 we pop all these and push 16
 * 
 * span(16) = span(15) + span(14) ==> bcz span(15) contains all consective days on or before 'price:15'
 * 
 * Logic here is if any number after '16' in above array, if we get 18, then we need to count till 16 only as , span(16) will be stored already, we can add that to span(18)
 *
 * 
 * 
 */

package Stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int price[], int n)
    {
        int res[] = new int[n];
        Arrays.fill(res,0);
        Stack<Integer> s = new Stack<>();
        
        
        res[0] = 1;
        s.push(0);
        
        
        for(int i=1;i<n;i++)
        {
              int span = 1;
              while(!s.isEmpty() && price[i] >= price[s.peek()])
              {
                  span = span+res[s.peek()];
                  s.pop();
              }
              s.push(i);
              res[i] = span;
        }
        return res;
    }
    
}

/**
 * 
 *  https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/ 
 * 
 *  we traverse two times bcz if string is ((()() if string is like this then the longest "SUBSTRING" wont be discovered in forward iteration where 
 *  'open' will be greater than 'close' so, the case 'open==close' wont be satisfied and hence the 'maxlen' wont be updated.
 * 
 *  So the above one will detected only when we traverse from right to left.
 * 
 */

package Stacksandqueues;

public class LengthOfValidSubstring {

    static int findMaxLen(String S) {
        int n = S.length();
        
        int open=0,close=0,maxlen=0;

        // here we are making 2 traversals - left to right and other right to left.

        // left to right - to catch balanced paranthesis when we have more closing braces.
        // using this case we cant catch balanced paranthesis when we have more opening braces.
        //      (   (   )   )   ) 
        //  o   1   2   2   2   2->0
        //  c   0   0   1   2   3->0
        //  ml  0   0   0   4   4

        //      (   (   (   )   )
        //  o   1   2   3   3   3   
        //  c   0   0   0   1   2
        //  ml  0   0   0   0   0 ==> this has valid substring of length = 4 but from left to right we cudnt find it. 
        // so we have to traverse from right to left also.
        // this also handles case of )(  when close>open -> make both 0.

        //      (   (   (   )   )
        //  o   2   2   1   0   0
        //  c   3   2   2   2   1
        //  ml  4   4   0   0   0 ==> this maxLength = 4.
        
        for(int i=0;i<n;i++)
        {
            if(S.charAt(i)=='(')
                 open++;
             else
                 close++;
             
             if(open==close)
                 maxlen = Math.max(maxlen,2*close);
             else if(close>open) 
             {
                 open=0;
                 close=0;
             }
        }
        open=close=0;

        // right to left - to catch balanced paranthesis when we have more opening braces.
        // using this case we cant catch balanced paranthesis when we have more closing braces.

        for(int i=n-1;i>=0;i--)
        {
            if(S.charAt(i)=='(')
                 open++;
             else
                 close++;
             
             if(open==close)
                 maxlen = Math.max(maxlen,2*open);
             else if(open>close) 
             {
                 open=0;
                 close=0;
             }
        }
        return maxlen;
     }
    
}

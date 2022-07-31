/**
 * 
 * https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1
 * 
 */

package Strings;

public class MinNumberOfFlips {

    public int minFlips(String S) {
       
        int startZero=0;
        int startOne=0;
        
        for(int i=0;i<S.length();i++)   // starting with 0. 01010101. at even positions we shud have 0 and at odd positions we have 1.
        // so it either is violated then we shud flip. increment flips.
        {
            if(( i%2==0 && S.charAt(i)!='0' ) || ( i%2!=0 && S.charAt(i)=='0' ))
                     startZero++;
                     
        }
         for(int i=0;i<S.length();i++)  // starting with 1. 101010101. at even positions we shud have 1 and at odd positions we have 0.
         // so it either is violated then we shud flip. increment flips.
        {
            if(( i%2==0 && S.charAt(i)!='1' ) || ( i%2!=0 && S.charAt(i)=='1' ))
                     startOne++;
                     
        }
        return Math.min(startZero,startOne);
     }
    
}

/**
 * https://leetcode.com/problems/ugly-number-ii/discuss/1172022/Java-or-O(n)-or-DP-or-Easy-and-Short-Solution
 * 
 * See leetcode discussion for this solution.
 */

package DP;

public class UglyNumbers {

    public static int nthUglyNumber(int n) {

        if(n==1) return 1;      //1 is 1st ugly number

        // here dp[i] stores the number of ugly numbers till i+1th number.
	    // these are the subproblems.
        // Ugly number(n) is stored in dp[n-1].
        int dp[]=new int [n];
        dp[0]=1;         // dp[0] is the number of ugly numbers till N=1.
	    // dp[n-1] is the number of ugly numbers till N.
        
        // p2, p3, p5 tracks the factors count for 2,3,5 i.e if a number has only '2' factor  then p2 count increases and if a number has '2' & '3' as  factor  then p2 and p3 count increases.
	    // intially for N=1, 1 has no factors in 2/3/5. so all 3 are initially 0.
	    // ugly number is the one which has all factors as 2/3/5 only.
        int p2=0;
        int p3=0;
        int p5=0;
        
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            
            // if the current number has a factor as 2 then p2 increases as p2 keeps track of count of factor-2 (in factors of number i).
            if(dp[i]==dp[p2]*2) p2++;
            // if the current number has a factor as 3 then p3 increases as p3 keeps track of count of factor-3 (in factors of number i).
            if(dp[i]==dp[p3]*3) p3++;
            // if the current number has a factor as 5 then p5 increases as p5 keeps track of count of factor-5 (in factors of number i).
            if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1]; // return the #ugly numbers of n.
    }

    public static void main(String args[])
    {
        int no = nthUglyNumber(150);
       
        // Function call
        System.out.println("150th ugly "  + "no. is " + no);
    }
    
}

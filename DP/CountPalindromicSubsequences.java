/**
 * https://www.youtube.com/watch?v=vlbA8oUxSV0 --> refer this video for clear understanding.
 * 
 * S.C :O(n^2)
 * T.C : O(n^2)
 */

package DP;

import java.util.Arrays;

public class CountPalindromicSubsequences {

    long mod = 1000000007L;
    long count(String s,int i,int j,long dp[][])
    {
        if(i==j)        //if i==j single character is always a palindrome so return 1.
            return 1;
        if(i>j) // during recursion i and j may cross each other then u cant form lps so return 0 as we have traversed entire string.
            return 0;
        if(dp[i][j]!=-1)    //if dp[i][j]!=-1 means it has already been filled then return it.
            return dp[i][j];

    // if both chars are same then number of palindromes = 
    // aba = ab+ba+1.
    // s[i+1,...j] + s[i...j-1] + 1
    // here b is common in both - counted twice - wont we remove it?
    // no. bcoz 1st b accounts for single b palindrome. 2nd b account for aba total palindrome.
    // + 1 for aa

    // ab - single palindrome a + single palindrome b 
    // ba - single palindrome aba + single palindrome a
    // +1 - palindrome aa.

    // if both chars are equal then we check once by doing (i+1) and 2nd time by doing (j-1) and we add both values+1 and store in dp[][]
        if(s.charAt(i)==s.charAt(j))
        {
            long a =count(s,i+1,j,dp);
            long b = count(s,i,j-1,dp);
            dp[i][j] = ((1L + a%mod + b%mod) +mod)%mod;
        }
        else
        {
    // abc = ab + bc - b
    // here ab accounts for single palindrome a + single palindrome b
    // bc accounts for single palindrome b + single palindrome c
    // here single palindrome b is counted twice so remove 1.
            long a = count(s,i+1,j,dp);
            long b = count(s,i,j-1,dp);
            long c = count(s,i+1,j-1,dp);
            
            dp[i][j] = ((a%mod + b%mod - c%mod)+mod)%mod;
        }
        return dp[i][j];
    }
    
    long countPS(String str)
    {
        int n = str.length();
         // dp[i][j] ==> dp state == #palindromes in the string of length s[i...j] i.e starts at i and ends at j.
        long dp[][] = new long[n][n];
        for(long arr[]:dp)
            Arrays.fill(arr,-1);
            
        return count(str,0,n-1,dp);
    }
    
}

/**
 * Logic is same as LCS of 2-strings. No reference link is referred. 
 * Logic is same as LCS for 2-strings so just modify that.
 * 
 * Refer (if needed): https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
 * 
 * T.C : O(n1*n2*n3).
 * S.C : O(n1*n2*n3).
 * 
 * The idea is to take a 3D array to store the  length of common subsequence in all 3 given  sequences i. e., L[m + 1][n + 1][o + 1]

    1- If any of the string is empty then there is no common subsequence at all then
           L[i][j][k] = 0

    2- If the characters of all sequences match (or X[i] == Y[j] ==Z[k]) then
        L[i][j][k] = 1 + L[i-1][j-1][k-1]

    3- If the characters of both sequences do  not match (or X[i] != Y[j] || X[i] != Z[k]  || Y[j] !=Z[k]) then
        L[i][j][k] = max(L[i-1][j][k], L[i][j-1][k], L[i][j][k-1])
 * 
 */

package DP;

public class LCS3Strings {

    static int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int dp[][][] = new int[n1+1][n2+1][n3+1];
        for(int i=0;i<=n1;i++)
        {
            for(int j=0;j<=n2;j++)
                dp[i][j][0] = 0;
        }
        for(int i=0;i<=n1;i++)
        {
            for(int j=0;j<=n3;j++)
                dp[i][0][j]=0;
        }
        
        for(int i=0;i<=n2;i++)
        {
            for(int j=0;j<=n3;j++)
                dp[0][i][j]=0;
        }
        
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                for(int k=1;k<=n3;k++)
                {
                    if( (A.charAt(i-1)==B.charAt(j-1)) &&  (A.charAt(i-1)== C.charAt(k-1)) )
                        dp[i][j][k] = 1+dp[i-1][j-1][k-1];
                    else
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                }
            }
        }
        return dp[n1][n2][n3];
    }

    public static void main(String args[])
    {
        String X = "AGGT12";
        String Y = "12TXAYB";
        String Z = "12XBA";
      
        int m = X.length();
        int n = Y.length();
        int o = Z.length();
      
        System.out.println("Length of LCS is " + LCSof3(X, Y,Z, m, n, o));
      
    }
    
}

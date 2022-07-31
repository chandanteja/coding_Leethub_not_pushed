/**
 * https://www.youtube.com/watch?v=823Grn4_dCQ
 * 
 * SuperSequence: Given 2-strings, a super sequence is a sequence which contains both the given strings 
 * Shortest common supersequence is a supersequence which contains both the given strings and is shortest.
 * 
 * Logic is we need to create a supersequence using given 2-strings in such a way that the common characters in string appears only once in supersequence.
 * So, the common characters means LCS of two strings shuld appear only once and other characters appear and order is maintained.
 * So, length of SCS is length of str-1 + length of str-2 - length of LCS ( as LCS will be added twice in str-1 and str-2).
 * 
 */

package DP;

public class LengthOfShortestCommonSuperSequence {

    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        // the below logic is completely same as LCS.
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++)
        {
            dp[0][i] = 0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        
        return m+n-dp[m][n];    // this is the only part different from LCS. Here we do len(X) + len(Y) - len(LCS). we subtract len of lcs bcz lcs will be added twice in len(x) + len(y)
    }

    public static void main(String args[])
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println( "Length of the shortest supersequence is " + shortestCommonSupersequence(X, Y, X.length(), Y.length()));
    }
    
}

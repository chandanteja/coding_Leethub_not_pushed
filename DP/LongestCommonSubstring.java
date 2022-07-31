/**
 * 
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 * https://www.youtube.com/watch?v=NvmJBCn4eQI
 * https://www.youtube.com/watch?v=BysNXJHzCEs
 * 
 * Also Go thru the space optimized solution also.
 * 
 * The idea is to find length of the longest common suffix for all substrings of both strings and store these lengths in a table. 
 * 
 * The longest common suffix has following optimal substructure property. 
 * If last characters match, then we reduce both lengths by 1 
 * LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1] 
 * If last characters do not match, then result is 0, i.e., 
 * LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])
 * Now we consider suffixes of different substrings ending at different indexes.The maximum length Longest Common Suffix is the longest common substring. 
 * LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j <= n 
 * 
 * T.C: O(m*n) 
 * S.C : O(m*n)
 * 
 * dp[i][j] --> contains Longest common substring/suffix length of X[0,1...i-1] and Y[0,1,...j-1]
 */

package DP;

public class LongestCommonSubstring {

    public static int lengthOfLongestCommonSubstring(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        // Create a table to store lengths of longest common suffixes of substrings.
        int dp[][] = new int[m+1][n+1]; // stores dp states

        // Note that LCSuff[i][j] contains length of longest common suffix of X[0..i-1] and Y[0..j-1].
        //basecases
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] =0;
        int max = dp[0][0];     // To store length of the longest common substring

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(max<dp[i][j])
                        max=dp[i][j];
                }
                else
                {
                    dp[i][j] = 0;
                }
                
            }
        }
        return max;    

    }
    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        System.out.println("LCSubStr length is: "+lengthOfLongestCommonSubstring(X,Y));
    }
}



/**
 * refer DP slides downloaded in Algos.
 *  https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 *  https://www.geeksforgeeks.org/longest-common-subsequence-dp-using-memoization/
 * 
 * T.C :O(mn) --> m- length of s1 and n is length of s2.
 * S.C : O(mn) --> can be optimized to linear space.
 * 
 * Logic is if arr1[i]==arr2[j] --> for any i,j if ith character in arr1 is equal to jth char in arr2, then we got one element of subsequence,
 * which adds to our max length of common subsequence. Now, we need to recur in remaining part of string (by removing the matched characters from both strings) for maximum length subsequence.
 * 
 * If arr1[i]!=arr2[j] --> it means either character at -i or character at -j can be part of subsequence. We need to recur by removing either char. at i or j and take max of these two.
 *  max(arr[i-1][j], arr[i][j-1]).
 * 
 * Base case is if one of the string has been exhausted, then and other is not exhausted, then other string can't to contribute to maximum length of commom subsequence as other string was over.
 * So, if either of string is exhausted, and other is not then they contribute '0' to max length.
 * 
 */

package DP;

public class LongestCommonSubsequence {

    public static int maxLengthOfCommonSubsequence(String s1, String s2)
    {
        int x = s1.length();
        int y = s2.length();
        // This array is used for storing max lengths of all subsequences, from (0,0) to (x,y).
        int dp[][] = new int[x+1][y+1]; // dp[i][j] --> this gives the max length of common subsequence till (i,j),, 'i' is used for looping in s1 and 'j' is used for s2.
        
        // dp[i][j] --> length of LCS from 0..i-1 in s1 and 0..j-1 in s2.
        // To find max length common subsequence in strings of length (x,y), we find the max lengh common subsequence in (x-1,y-1) sub strings.
        // So dp[x-1][y-1] gives max length of common subsequence till (x-1,y-1), while dp[x][y] gives max length of common subsequence till (x,y).


        // Base case, when s1 is exhausted and s2 is not, then s2 doesnt contribute to lengh of max subsequence.
        // Same case for s2 is exhausted and s1 is not then s1 doesnt contribute to lengh of max subsequence.
        // So, initializing (i,0) and (0,j) to 0 in matrix.
        for(int i=0;i<=x;i++)
            dp[i][0] = 0;
        for(int j=0;j<=y;j++)
            dp[0][j]=0;
        
            // As 0th row and column are alreadt traversed, we now start from (i,j) = (1,1).
        for(int i=1;i<=x;i++)
        {
            
            for(int j=1;j<=y;j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))    // if (i,j) = (1,1) , but we need to start matching characters from (0,0) in s1 and s2. So, we check always (i-1,j-1).
                    dp[i][j] = 1+ dp[i-1][j-1];         // if char at (i-1) in s1 and (j-1)in s2 are same then this char contributes to length of max subsequence, 
                    //so we add '1' to previously found max length subsequence as this character will also contribute to max length subsequence

                 else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); // if char at (i-1) in s1 and (j-1)in s2 are not same then the max length common subseq can have either (i-1)th character or (j-1)th character from respective strings.
                    // So we will recurr in (i-1,j) and (i,j-1) and take max of them.
                    
            }
        }
        return dp[s1.length()][s2.length()];    // dp[x][y] (last cell)--> gives the length of max common subsequence.
    }
    public static void main(String[] args)
    {
      String s1 = "AGGTAB";
      String s2 = "GXTXAYB";

      System.out.println("Length of LCS is" + " " + maxLengthOfCommonSubsequence(  s1,s2 ) );
      System.out.println("Length of LCS is (Space optimized)" + " " + spaceOptimizedLCS(  s1,s2 ) );
    }


    // in space optimized LCS, we jy=ust need 2-rows only and columns can be same as length of any string given
    public static int spaceOptimizedLCS(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[2][n+1];

        // initialization of first column and first row with 0.
        for(int i=0;i<n+1;i++)
        {
            dp[0][i] = 0;
        }
        dp[1][0] =0;

        int b=0;
        for(int i=1;i<m+1;i++)
        {
            b = (1-b);  // as we have only 2-rows, 'b' shuld change for every iteration bcz we need to consider differeent rows for every iteration in 'i' value.
            for(int j=1;j<n+1;j++)
            {
                if(s1.charAt(j-1) == s2.charAt(i-1))
                {
                    dp[b][j] = 1+dp[(1-b)][j-1];
                    
                }
                else
                    dp[b][j] = Math.max(dp[ 1-b ][j], dp[b][j-1]);

                System.out.print("b="+b+" s1="+s1.charAt(j-1)+" s2="+s2.charAt(i-1)+" "+dp[b][j]+"----------");
            }
            System.out.println();

        }
        return dp[b][n];

    }
    
}

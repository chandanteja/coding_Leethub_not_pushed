/**
 * 
 * https://www.youtube.com/watch?v=oL7GCrcdaJI --> watch this video for clear understanding of what does Longest repeating subsequence mean.
 * 
 * 
 * Logic is same as LCSubseq, except for in LCS we are given 2 strings but in LRS we will have only one string.
 * We need to check repeating subsequence in same string, so we can use the same string as string-1 and string-2.
 * LCS(str1,str2) == LRS(str,str) . Also in LRS when checking for a character match, we need to see that if two characters are matched, their indices are not same.
 * BCZ, in LRS characters at same index can't be considered for repeating substring.
 * 
 * https://www.geeksforgeeks.org/longest-repeating-subsequence/
 *  
 */

package DP;

public class LongestRepeatingSubsequence {


    public static int longestRepeatingSubsequence(String str)
    {
        int x= str.length();
        int y = x;
        int dp[][] = new int[x+1][y+1];
        
        for(int i=0;i<=x;i++)
            dp[i][0] = 0;
        for(int j=0;j<=y;j++)
            dp[0][j]=0;
        
        for(int i=1;i<=x;i++)
        {
            for(int j=1;j<=y;j++)
            {   // here everything is same as LCS, in addition to LCS, we also check that if 2-characters matched, then their indices are not same in both strings.
                if(str.charAt(i-1) == str.charAt(j-1) && (i-1)!=(j-1))  // check indices shuld not be same.
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    
            }
        }
        return dp[x][y];
    }

    static public void main(String[] args) {
        String str = "aabb";
        System.out.println("The length of the largest subsequence that" + " repeats itself is : "  + longestRepeatingSubsequence(str));
 
    }
    
}

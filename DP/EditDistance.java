/**
 * 
 * Refer UCB edit distance notes.
 * 
 * 2 strings so 2d dp.
    dp[i][j] = min number of operations to transform s[0...i-1] to t[0...j-1]
    to cover base case like when s==0 then #operations = length of string t. insert characters.
    if t==0 then #operations = length of string s. delete all characters in string s.
 * 
 */

package DP;

public class EditDistance {

    public int editDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        int dp[][] = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0)        // s==0 then #operations = length of string t. insert characters.
                    dp[i][j] = j;
                else if(j==0)   // t==0 then #operations = length of string s. delete all characters in string s.
                    dp[i][j] = i;
                else if(s.charAt(i-1)==t.charAt(j-1))   // if characters are same then i.e x1,x2,...,xn and y1,y2,...,ym if xn==ym then recur in x1,x2,..xn-1 and y1,y2,...ym-1
                    dp[i][j] = dp[i-1][j-1];
                else    // delete, insert, replace 
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));

                    /*
                        when s[i]!=t[j] then 
                            insert = s[0...i, <t[j]>] t[0...j] ==> s[0...i] t[0...j-1] = dp[i][j-1] + 1
                            delete = s[0...i-1, i] t[0...j-1, j] ==> s[0...i-1] t[0...j] = dp[i-1][j] + 1
                            replace = s[0...i-1, i] t[0...j-1, j] ==> s[0...i-1] t[0...j-1] = dp[i-1][j-1] + 1

                        we have to perform any 1 of these 3 and choose min. 
    
                    */    
                    
            }
        }
        return dp[len1][len2];
        
        
    }
    
}

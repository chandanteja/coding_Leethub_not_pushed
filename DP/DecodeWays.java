/**
 * 
 * Qns: https://leetcode.com/problems/decode-ways/description/
 * 
 * https://leetcode.com/problems/decode-ways/editorial/
 * 
 * Watch the editorial video for understanding the concept.
 * 
 */

public class DecodeWays {

    /*
     * DP State:
     * ========
     * dp[i] - total number of ways of decoding the substring  0..(i-1)
     */
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2;i<n+1;i++)
        {
            if(s.charAt(i-1) != '0')  // single digit encoding is possible.
                dp[i] = dp[i-1];        // at ith index of 's' we are checking if (i-1)th character is not '0' then single digit encoding is possible
                                        // This is because dp[i] at ith index we store the # of ways of decoding substring 0 to (i-1).
                                        // dp[i] =  dp[i-1] bcz if single digit encoding is possible, we just append that single digit to already running char sequence. 
                                        // watch the LeetCode Editorial video for clearly understanding this.
            int twoDigit =  Integer.parseInt(s.substring(i-2,i));   // 2 digit encoding.

            if(twoDigit >=10 && twoDigit <=26 )
                dp[i] = dp[i] + dp[i-2];
        }
        return dp[n];
        
    }
    
}

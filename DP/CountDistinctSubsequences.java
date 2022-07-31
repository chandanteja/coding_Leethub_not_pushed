/**
 *  https://www.youtube.com/watch?v=9UEHPiK53BA --> watch this video for explaination on Count of distinct subsequences
 * 
 * https://www.geeksforgeeks.org/count-distinct-subsequences/
 */

package DP;

import java.util.HashMap;

public class CountDistinctSubsequences {

    int distinctSubsequences(String S) {
        int mod = 1000000007;
        int n = S.length();
        int dp[] = new int[n+1];    // dp[i] - #distinct subsequences for string from s [0 to i].
        // when 0 then no characters. "" is also a subsequence so dp[0]=1;
        HashMap<Character,Integer> hm = new HashMap<>();
        dp[0] = 1;  // null character is also considered as 1 subsequene.


        // loop for all characters of the string. s[0] value will be stored in dp[1] because dp[1] means
        // #distinct subsequences for the string S[0 to 1]. only 1 character.
        // each character can be taken into the subsequence or it need not be taken. so 2 choices for each character.
        // so multiply the previous value with 2.

        /*
            s=ab 
            dp  0   1                                           2
                1   {"","a"}=2 = dp[i-1]*2 = dp[1]*2 = 2        {"","a","b", "ab"} = dp[i-1]*2 = dp[1]*2 = 4.

            s=aba
                0           1           2                       3
                {""}     {"", "a"}      {"","a","b", "ab"}      {"","a","b","ab","ba","aba"}
                1      2 = dp[i-1]*2    4 = dp[2]*2             7 = dp[i-1]*2 - dp[index of before character of last occured a]
                        dp[0]*2 = 2                                 dp[2]*2 - dp[0] = 8-1 = 7.

            we are doing dp[i-1]*2 - dp[index of before character of last occured a] this because

            we have a character at jth position. but this character has previously occured at position i.
            so when it had occured at i for the first time, we have already computed all subsequences with 
            its previous part of the string i.e. [0...i-1]

            so when we are computing subsequences at jth position (i<j)
            then this will include string [0...j] which also includes [0...i-1]
            so if we add them again it will be 2 times. so we first add it - by blindly multiplying by 2 and then removing 
            subsequences for 0 to i-1. 
            number of subsequences for 0 to i-1 are stored in dp[i-1] so we are dng that only.
        */
        for(int i=1;i<=n;i++)
        {
            dp[i] = ((2*dp[i-1])%mod + mod)%mod;    // watch video if have any doubt.
            char ch = S.charAt(i-1);
            
            if(hm.containsKey(ch))  // if last for that character is present in map then that character has already occured then subtract that part.
            {
                int j = hm.get(ch);
                dp[i] = (dp[i]%mod - dp[j-1]%mod + mod)%mod;
            }
            hm.put(ch,i);
        
        }
        return dp[n];
    }
    
    
}

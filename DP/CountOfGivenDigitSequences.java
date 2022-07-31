/**
 * 
 * https://ide.geeksforgeeks.org/mhJeqM99zP --> soln
 * 
 * https://www.youtube.com/watch?v=jFZmBQ569So&t=216s   --> refer this video for logic.
 * 
 * 
 */

package DP;

public class CountOfGivenDigitSequences {

    public int CountWays(String str)
    {
        int dp[]=new int[str.length()];
        dp[0]=1;   // 1st digit will always  single character possibility. So, we will have 1.
        if(str.charAt(0)=='0')
        {
            return 0;   //if starting char is '0' then we need to return total count itself as 0.
        }
        for(int i=1;i<dp.length;i++)
        {
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0')
            {
                dp[i]=dp[0]%1000000007;
                return 0;
            }
            else if(str.charAt(i-1)!='0' && str.charAt(i)=='0')
            {
                if(Integer.parseInt(str.substring(i-1,i+1))<=26)
                {
                    dp[i]= (i>=2?dp[i-2]%1000000007:1); // as we are starting with i=1, if  i=1 the (i-2) == -1 so and (i-1, i+1) <= 26 then we will have a single char from alphabet also, so we need to take care of that
                            /*
                                    21 ==> BA, U  are possible so, if there are only 2-length string given and if its <=26 then we can have string  in these ways, 
                                    so to accommodate 'U' also, we add '1' to dp[i];
                            */
                }       
                else
                {
                    dp[i]=0;
                }
            }
            else if(str.charAt(i-1)=='0' && str.charAt(i)!='0')
            {
                    dp[i]=dp[i-1]%1000000007;
            }
            else
            {
                if(Integer.parseInt(str.substring(i-1,i+1))<=26)
                {
                    dp[i]=dp[i-1]%1000000007 + (i>=2?dp[i-2]%1000000007:1);
                }
                else
                {
                    dp[i]=dp[i-1]%1000000007;
                }
            }
        }
        
        return dp[str.length()-1]%1000000007;
    }
    
}

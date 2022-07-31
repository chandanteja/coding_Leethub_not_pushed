/**
 * https://www.geeksforgeeks.org/friends-pairing-problem/       --> refer this.
 * 
 * Any person can either be single or paired with another person.
 * ways(n) = ways(n-1) + (n-1)*ways(n-2).
 * To find number of ways of pairing 'n' ppl as per constraints given , 1st person will have below choices.
 *  1. Can be single (unpaired) -->  then we recur for remaining (n-1) ppl i.e ways(n-1)
 *  2. Now when the nth person will be paired, there will be (n-1) possibilities for pairing. So there will be (n-1) ways of pairing nth person.
 *  3. After selecting a person and paired say (n,n-1) then we need to find the same for remaining (n-2) persons. So recur for ways(n-2).
 *  4. But this ways(n-2) will be possible only (n-1) times as pairing can be done (n-1) times only from n-persons.
 * So, ways(n) = ways(n-1) + (n-1)*ways(n-2).
 * 
 * T.C: O(n)
 * S.C: O(n)
 * 
 */

package DP;

public class FriendsPairingProblem {
    
    public static long pairing(int n)
    {
        long dp[] = new long[n+1];  // dp[i] --> stores the number of ways pairing can be done for i-persons.
        final long MOD = 1000000007;
      
        for(int i=0;i<=n;i++)       // we are storing number of ways from 0 to n in bottom up fashion.
        {   //dp[i] = gives the number of ways of pairing for i-people.
                if(i<=2)
                    dp[i] = i;  // f(0) = 0, f(1) = 1 and f(2) = 2 else f(i) = f(i-1)+ (i-1)*f(i-2). Here f() is same as dp[].
                else
                     dp[i] = (( dp[i-1])%MOD + ( ((i-1)%MOD)*((dp[i-2])%MOD)) )%MOD;    // for very big values, we are doing  %(10^9 + 7)
        }
        return dp[n];

    }

    static int[] dp1 = new int[1000];
    // Returns count of ways n people
    // can remain single or paired up.
    static int countFriendsPairings(int n)
    {
        if (dp1[n] != -1)
            return dp1[n];
 
        if (n > 2)
            return dp1[n] = countFriendsPairings(n - 1) + (n - 1) * countFriendsPairings(n - 2);
        else
            return dp1[n] = n;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        for (int i = 0; i < 1000; i++)
            dp1[i] = -1;
        int n = 4;
        System.out.println("Recursive: "+countFriendsPairings(n));
        System.out.println("Iterative.: "+pairing(n));
    }

}

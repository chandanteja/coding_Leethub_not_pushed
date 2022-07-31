/**
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * T.C: O(n^2)
 * S.C: O(n)
 * 
 */

package DP;

public class RodCutting {

    public static int cutRod(int price[], int n)
    {
        int dp[] = new int[n+1];    // dp[i] keeps track of max possible price that can be obtained for rod of length = i.
        dp[0] = 0;
        for(int i=1;i<=n;i++)   // this runs over different possible rod-lengths.
        {
            int maxValue = Integer.MIN_VALUE;   // max-value of length-i.
            for(int j=0;j<i;j++)    // this runs over all different cuts possible for rod-length=i. And adds up cost[jth cut] .
            {
                maxValue = Math.max(maxValue,price[j]+dp[i-j-1]);   // taking different possible values and max among them.
                    // price[j] + dp[i-j-1] means we employed cut of length-j and hence the price we would get by selling length-j rod segment is taken.
                    // also after cutting the rod into segment of length-j, we need to add the sub-problem cost i.e when rod of length-i is cut into rod of length=j, then 
                    // then sub problem would be (i-j-1) ['-1' i bcz of 0-indexing].

                // Instead of using maxValue (as used above), we can also do as below.
                // dp[i] = Math.max(dp[i],price[j]+dp[i-j-1]);  instead of taking a variable.
            }
            dp[i] = maxValue;   // updating the max possible price for rod of length=i.
        }
        return dp[n];
    }

    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
    }
    
}

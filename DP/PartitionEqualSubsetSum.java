/**
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * Here, we are give, an array, we need to check if it is possible to partition array into tow halves, where, the sum of elements in those 2 are same.
 * 1. Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false. 
 * 2. If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2. This can be solved either using recursion or Dynamic Programming.
 * 
 * Recursive, solution: O(2^n).
 * 
 * This problem is same as 0/1 knapsack problem.
 * 
 */

package DP;

public class PartitionEqualSubsetSum {
    // Logic, is we take a 2D array which maintains record for all possible sums from 0 to sum/2 and for all elements of array, is it possible to partition or not.
    // let the 2d array be dp[][] which maintains dp-state. 
    //dp[i][j] = true if a subset of elements from 0...j-1 i.e {arr[0], arr[1], ..arr[j-1]} has sum=i, otherwise false.
    
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i=0;i<N;i++)
            sum+=arr[i];
        if(sum%2!=0)
            return 0;
        boolean dp[][] = new boolean[sum/2+1][N+1];
       
        // sum = 0, will be possible given any number of elements bcz 'empty set' is subset of every set.
        for(int i=0;i<=N;i++)
            dp[0][i] = true;   // sum=0 with elements from {0 .. j-1 } set  of ele i.e i.e {arr[0], arr[1], ..arr[j-1]}.
            
        for(int i=1;i<=sum/2;i++)
            dp[i][0] = false;   // sum=i with 0-elements is not possible.

        // The above 2-are base cases.
        for(int i=1;i<=sum/2;i++)
        {
            for(int j=1;j<=N;j++)
            {
                dp[i][j] = dp[i][j-1];      //if an element is not included then dp[i][j] = dp[i][j-1] i.e for sum=i using 'j' elements of array is same as for sum=i, using 'j-1' elements of array.
                // if the element-j i.e arr[j] is <= sum-i then   dp[i][j] will be either include the element 'j' and reduce the sum OR don't include the element 'j'.
               
                if(arr[j-1]<=i)     // if jth element is <= sum=i, then we can consider it for required sum. 
                 dp[i][j] =  dp[i][j] || dp[i-arr[j-1]][j-1];   // either include the element 'j' and reduce the sum by arr[j] or dont include element-j.
                 // Sub problem is every element of the given array has 2-choices, whether it can be included in array or not included.
                 // So, if included, then reduce the 'sum' by the value of included element or if not included then dont consider the element.

            }
        }
        
        if(dp[sum/2][N])
            return 1;
        else
            return 0;
    }

    // T.C of above code : O(sum*n)
    // S.C of above code : O(sum*n) n--> number of array ele.

    // optimized space complexity will hae only 1d array. FOr this solution, refer GFG link above.
    // DP state is: dp[j] = true if there is a subset with sum equal to j, otherwise false. i. dp[j] represents different possible sums.
    public static void main(String[] args)
{
    int arr[] = { 1, 3, 3, 2, 3, 2 };
    int n = 6;
 
    // Function call
    if (equalPartition(n,arr) == 1)
        System.out.println("Can be divided into two " + "subsets of equal sum");
    else
        System.out.println("Can not be divided into " + "two subsets of equal sum");
}

}

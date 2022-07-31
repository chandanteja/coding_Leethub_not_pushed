/**
 * 
 * This problem is same as 0/1 knapsack.
 * 
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 * Logic is we maintain DP state in 2d array.
 * dp[i][j] --> tells count of subsets for sum=j using first i-elements i.e 0,1,...i-1.
 * dp[i][C] = dp[i – 1][C – arr[i]] + dp[i – 1][C]  --> either select the element 'i' or dont select it. If selected then subract its value from sum.
 * Here, dp[i][C] stores the number of subsets of the sub-array arr[i…N-1] such that their sum is equal to C. 
 * 
 * T.C = O(n*sum) n--> number of elements in aray.
 * S.C = O(n*sum).
 */

package DP;

public class CountOfSubsetsWithGivenSum {

    public static int subsetSum(int arr[],int n, int sum) 
	{ 
	    int count[][] = new int[sum+1][n+1];    // maintains dp-state i.e count[i][j] tells for sum=i, using first j-ele i.e 0,1,...j-1, min count.
	    
        // sub problem is for sum=i, to find minimum count, we need to find min count for sub problem with sum= i-arr[j] for all elements-j of array, when arr[j]<=i.

	    for(int i=0;i<=n;i++)
	        count[0][i] = 1;    // sum=0 with elements from {0 .. j-1 } set  of ele i.e i.e {arr[0], arr[1], ..arr[j-1]}.
	    
	    for(int i=1;i<=sum;i++)
	        count[i][0] = 0;    // sum=i with 0-elements is not possible.
	        
             // The above 2-are base cases.
	    
	    for(int i=1;i<=sum;i++)	// i- iterates on all possible sums i.e from 1..sum
	    {
	        for(int j=1;j<=n;j++)	// j- iterates on all possible elements of given array.
	        {
	         // if jth element is <= sum=i, then we can consider it for required sum.
			// we will see if any of the previous states have already experienced the sum=’i’ and any previous states experienced a value ‘i – arr[j]’ which will solve our purpose
	            if(arr[j-1]<=i) // if jth element is included, then we reduce number of ele by 1 and also sum by the value of jth element.
	                count[i][j] = (count[i][j-1] % 1000000007 + count[i-arr[j-1]][j-1]% 1000000007)% 1000000007;
                else    // // if jth element is not considered then we reduce the number of elements by 1.
                    count[i][j] = count[i][j-1]% 1000000007;
	        }
	    }
	    return count[sum][n];
	} 
    public static void main(String[] args)
    {
        int n = 4;
        int a[] = { 3, 3, 3, 3 };
        int sum = 6;
     
        System.out.print(subsetSum(a, n, sum));
    }
    
}

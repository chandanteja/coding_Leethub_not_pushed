/**
 * https://www.geeksforgeeks.org/count-subsequences-product-less-k/ --> refer this,
 * 
 * https://www.youtube.com/watch?v=OBLvQwkhej0
 * 
 * This problem is same as Count of subsets having sum == given sum.
 * dp[i][j] = number of subsequences having product less than 'i' using first 'j' terms of the array. 
 * dp[i][j] = number of subsequences using first j-1 terms + number of subsequences that can be formed using j-th term. 
 * dp[i][j] = dp[i][j-1] ( # of subseq using first j-1 terms) + dp[i/arr[j-1]][j-1]+1
 * Here, every element has 2-possibilities (same as in subset sum)
 *  1. element can be used/included in our count to form product < K, then we need to divide product 'K' by the element considered currently and 
 *      we need to find the count possible for remaining product by using remianing elements, by not considering the current element i.e dp[K/ele][n-1]
 *  2. If element is not considered then we need to drop the element and recur for product <K in remaining set of ele.
 * 
 *  This problem is same as count of subset sum and also 0/1 knapsack.
 * 
 * T.C : O(nk)
 * S.C : O(nk).
 */

package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfSubseqWithProductLessthanK {

    // Function to count numbers of such
    // subsequences having product less than k.
    public static int productSubSeqCount(ArrayList<Integer> arr, int k)
    {
        int n = arr.size();
        int dp[][] = new int[k+1][n+1]; // dp-state: dp[i][j] --> keeps track of count of subsequences having product < i, using first 'j' ele.
        // sub problems are , every element has two options, either consider the element or dont consider. When considered the remove the value of that considered element from overall product and also remove the considered ele
        // from set of ele to be considered and solve problem.
        // if element is not considered then drop the element and recur on elements set reduced by 1, for same value of product.
        for(int arrs[]:dp)
        {
                Arrays.fill(arrs,0);    // fill all elements with '0'.
        } 
        for(int i=1;i<=k;i++)  // i- iterates on different values of products possible i.e 1..k
        {
            for (int j=1;j<=n;j++)  // j- iterates on elements given
            {
                // number of subsequence using j-1 terms
                dp[i][j] = dp[i][j-1];  // we are setting the count of current product=i using first 'j' ele is same as product = i, obtained using first 'j-1'ele.

                 // if arr[j-1] > i it will surely make product greater thus it won't contribute then dp[i][j] = dp[i][j-1] (previous value will only propogate), this we have seta bove.
                if(arr.get(j-1)<=i && arr.get(j-1) >0)
                {
                    // if arr[j-1]<=i then product=i, can be divided by arr[j-1] and we will count the number of ways of the remaining value i.e value we get after i/arr[j-1] with only (j-1) elements not 'j' elements.
                    // number/count of subsequence using 1 to j-1 terms and j-th term
                    dp[i][j] = dp[i][j] + dp[i/arr.get(j - 1)][j - 1]+1;  //  we are adding +1, bcz there is 1-way for getting from 'i/arr.get(j-1)' to 'i'  is by multipliying 'i' with arr.get(j-1) which is 1-way. 
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String args[])
    {
        ArrayList<Integer> A = new ArrayList<Integer>();
        // A.add(1);
        // A.add(2);
        // A.add(3);
        // A.add(4);
        // int k = 10;
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        int k=5;
        System.out.println("Count is: "+ productSubSeqCount(A, k));
    }
}

/**
 * Logic is same as Longest increasing subsequence, but in LIS, we keep track of length of LIS, here instead of adding count(length), we need to add element values at particular position.
 * DP state: MIS[i] --> maximum sum increasing subseq till element-'i', in given set of elements. We need to iterate over all possible elements i.e i= 0..n-1
 * Subproblems: to find mis[i], we find subproblem mis[i-1] and add arr[i](array element value at index-i) , if element at arr[i-1] < arr[i].
 * 
 */

package DP;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    
    public int maxSumIS(int arr[], int n)  
	{  
	    int mis[] = new int[n]; // stores dp-state i.e mis[i] --> sum of max increasing sub sequence till element at index-i. we need to iterate all elements i.e 0..n-1
	    Arrays.fill(mis,0); // initialized all elements with 0.

	    mis[0] = arr[0];   // initialized 1st element in mis[] with 1st element of array, bcz every element itself can be max sum increasing subsequence individually.
                            // and 1st element is also max sum increasing subsequence individually. So we have updated it as max sum increasing subseq.
	    int max=mis[0]; // we use max variable to keep track of max sum. used to return value at the end.
	    for(int i=1;i<n;i++)        // i- points to some element in arr[] at any time .
	    {
	        mis[i] = arr[i];    //initialized i- element in mis[] with i element of array, bcz every element itself can be max sum increasing subsequence individually. 
	        for(int j=0;j<i;j++)    // j- works on all elements before index-i. 'j' keeps track of all subproblems before 'i'.
	        {
	            if(arr[j]<arr[i])       // if element at 'j' is smaller than element at-i
	            {
                    // same as above mis[i] = mis[i-1] (subproblem) +arr[i] i.e here 'j' keeps track of all subproblems before 'i'.
	                if(mis[i]<mis[j]+arr[i])    // same as lis, but here insteading of adding +1, we add element value itself.
	                    mis[i] = mis[j]+arr[i];     // if above condition is met, we update the mis[i]. 
	               if(max<mis[i])   // updating max value with mis[i].
	                    max=mis[i];
	            }
	        }
	    }
	    return max;
	}  

}

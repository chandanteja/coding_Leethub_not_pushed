/**
 * Logic is same as Longest Bitonic subsequence and Maximum sum increasing subsequence 
 * 
 * We find Max sum increasing subseq from left to right
 * and max sum decreasing subseq from right to left and add them and find sum.
 * logic is same as Max increasing subseq and longest bitonic subseq.
 */

package DP;

public class MaximumSumBitonicSubsequence {
    
    public static int maxSumBS(int arr[], int n)
    {
        int lis[] = new int[n];
        for(int i=0;i<n;i++)
            lis[i] = arr[i];
        // MIS
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j] < arr[i] && lis[i] < lis[j]+arr[i])   
                        lis[i] = lis[j]+arr[i];
            }
        }
        
        int lds[] = new int[n];
        for(int i=0;i<n;i++)
            lds[i] = arr[i];
        // MDS
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i; j<n;j++)
            {
                if(arr[j] < arr[i] && lds[i] < lds[j]+arr[i])   
                        lds[i] = lds[j]+arr[i];
            }
        }
        int maxBS = lis[0] + lds[0] - arr[0];   // mis[i] + mds[i] - arr[i] gives max sum bitonic sub seq.

        
        for(int i=1;i<n;i++)
        {
            if(maxBS < lis[i]+lds[i]-arr[i])
                maxBS = lis[i]+lds[i]-arr[i];
        }
        return maxBS;
        
        
    }

}

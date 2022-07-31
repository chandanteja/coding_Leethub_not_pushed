/**
 * 
 * https://www.geeksforgeeks.org/maximize-array-sun-after-k-negation-operations/
 * 
 * Input : arr[] = {9, 8, 8, 5} 
        K = 3
    Output: 20      -->> bcz we change 5-> (-5 -> 5-> -5 )  --> 3-times (since k=3) so if we add 9+8+8-5=20

 * 
 */

package Greedy;

import java.util.Arrays;

public class MaxSumAfterKNegotiations {

    public static long maximizeSum(long a[], int n, int k)
    {
       int negcount=0;
       
       Arrays.sort(a);
       for(int i=0;i<n;i++)
        {
            if(a[i]<0)
                negcount++;
        }
        
      
        for(int i=0;i<Math.min(negcount,k);i++)
        {
            if(a[i]<0)
                a[i] = -a[i];
        }
        
        int rem = negcount-k;
        
        Arrays.sort(a);
        
        if(rem<0)   // means negcount is less
        {
            for(int i=0;i<Math.abs(rem);i++)
                a[0] = -a[0];
        }
        
        long sum=0;
        for(int i=0;i<n;i++)
            sum = sum+a[i];
            
        return sum;
        
    }
    
}

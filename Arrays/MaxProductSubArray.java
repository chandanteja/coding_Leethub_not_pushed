/**
 * 
 * Logic is same as kadanes algorithm.
 * But here, we maintain min and max as product can go negative any time, so we keep track of both negative and positive products in min and max.
 * 
 * https://www.youtube.com/watch?v=x7YW7MAvMiY  --> watch this.
 * 
 */

package Arrays;

public class MaxProductSubArray {

    long maxProduct(int[] arr, int n) {
        long max=arr[0];    // keeps track of max product found till arr[i];
        long min=arr[0];    
        long prod = arr[0];
        
        for(int i=1;i<n;i++)
        {
            if(arr[i]<0)    // we exchange max and min if arr[i] is negative.
            // consider example of {6,-3,-10,0,2} --> if max= -3 and min =-18 and when arr[i]=-10 then -3(-10) ==30 but -18(-10) = 180.
            // so for this reason if arr[i] is negative then we exchange max and min so that max will always have max product
            {
                // swap max and min
                long temp=max;
                max=min;
                min = temp;
            }
            max = Math.max(arr[i],max*arr[i]);
            min = Math.min(arr[i],min*arr[i]);
            prod =Math.max(prod,Math.max(min,max));
        }
        return prod;    // result
    }
    
}

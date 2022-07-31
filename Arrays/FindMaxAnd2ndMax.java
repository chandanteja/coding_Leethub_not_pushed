/**
 * 
 * No reference is used.
 * 
 * 
 */

package Arrays;

import java.util.ArrayList;

public class FindMaxAnd2ndMax {

    public static ArrayList<Integer> largestAndSecondLargest(int n, int arr[])
    {
        int max=arr[0];
        int secmax=-1;
        
        for(int i=1;i<n;i++)
        {
            
            if(arr[i]>max)
            {
                secmax=max;
                max=arr[i];
                
            }
            else if(arr[i]>secmax && arr[i]<max)
                    secmax=arr[i];   
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(max);
        res.add(secmax);
        return res;
        
    }
    
}

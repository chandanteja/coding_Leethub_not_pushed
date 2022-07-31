/**
 * 
 * https://www.youtube.com/watch?v=FkJZlZHWUyk  --> refer this.
 * 
 * 
 * Logic here is we find max number of trains that will be at a station and yet to departure. Those are the max number of platforms needed.
 * 
 */

package Greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    static int findPlatform(int arr[], int dep[], int n)
    {
        // we sort both arrays but the arr and dep values need not be corresponding after sorting. Here corresponding values are not needed.
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms=0,maxTrains=0;
        
        int i=0,j=0;
        
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                maxTrains++;
                i++;
            }
            else
            {
                maxTrains--;
                j++;
            }
            platforms =  Math.max(maxTrains,platforms);
        }
    
        return platforms;
    }
    
    
    
}

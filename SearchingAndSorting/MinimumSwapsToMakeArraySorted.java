/**
 * 
 * https://www.youtube.com/watch?v=1BxbBgNSwHo&t=938s       --> refer this.
 * 
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 * 
 */


package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Comparator;



class pair{
    
    int value;
    int index;
    
    pair(int value,int index)
    {
        this.value = value;
        this. index=index;
    }
}


public class MinimumSwapsToMakeArraySorted {

    private static final String Collections = null;

    public int minSwaps(int nums[])
    {
        ArrayList<pair> arr = new ArrayList<>();
        
        int n  = nums.length;
        
        for(int i=0;i<n;i++)
            arr.add(new pair(nums[i],i));
        
        arr.sort(new Comparator<pair>()
        {
            public int compare(pair p1,pair p2)
            {
                if(p1.value <p2.value)
                    return -1;
                else if(p1.value==p2.value)
                    return 0;
                else 
                    return 1;
            }
        });
        
        int swaps=0;
        
        for(int i=0;i<n;i++)
        {
            pair p=arr.get(i);
            
            if(p.index==i)
                continue;
            else
            {
                swaps++;
                Collections.swap(arr,i,p.index);
                i--;
                
            }
        }
        return swaps;
        
    }   
    
}

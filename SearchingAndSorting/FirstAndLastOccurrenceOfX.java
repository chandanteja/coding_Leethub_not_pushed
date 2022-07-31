/**
 * 
 * No reference is used.
 * 
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1        -->qns
 * 
 * T.c : O(logn)
 * 
 */

package SearchingAndSorting;

import java.util.ArrayList;

public class FirstAndLastOccurrenceOfX {

    ArrayList<Long> find(long arr[], int n, int x)
    {
        long start=-1,end=-1;
        int mid;
        
        int low=0,hi=n-1;
       
        // binary search to find start index
        while(low<=hi)
        {
            mid = (low+hi)/2;
           
            if(arr[mid]==x) // when mid hits
            {
                start=mid;  // store its index.
            }
            if(x<=arr[mid])     // when x==arr[mid] then also move to left as we want start index.
                    hi=mid-1;
            if(x>arr[mid])
                    low=mid+1;
                
        }
        low =0 ;
        hi=n-1;
        
        // binary search to find end index
        while(low<=hi)
        {
            mid = (low+hi)/2;
           
            if(arr[mid]==x)     // when mid hits
            {
                end=mid;        // store its index.
            }
            if(x<arr[mid])
                    hi=mid-1;
            if(x>=arr[mid])     //  when x==arr[mid] then also move to right as we want end index.
                    low=mid+1;
        }
        
        ArrayList<Long> res = new ArrayList<>();
        
       res.add(start);
       res.add(end);
       return res;
       
    }
    
}

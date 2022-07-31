/**
 * 
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * 
 * https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1#
 * 
 * Also there is another variant of this model qns in Leetcode folder, check that also once.
 * 
 * 
 */

package Arrays;

public class FindKClosestElements {

    int[] printKClosest(int[] arr, int n, int k, int x) {
        int l = binarysearch(arr,0,n-1,x);  // Find the crossover point
        int r = l+1;        // Right index to search
        int res[] = new int[k];
        
        int i=0;
        
        // If x is present in arr[], then reduce left index
        // Assumption: all elements in arr[] are distinct
        if(arr[l]==x)
            l--;    // as we dont need 'x' as part of o/p
        
        int cnt=0;      // To keep track of count of elements
                        // already found
        
        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while(l>=0 && r<n && cnt<k)
        {
            if(x-arr[l] < arr[r]-x) // left side is closer than right side to 'x'
            {
                res[i] =  arr[l--];
                i++;
                cnt++;
            }  
            else
            {
                res[i]= arr[r++];
                i++;
                cnt++;
            }
                
        }

        // If there are no more elements on right side, then
        // print left elements
        
        while(cnt<k && l>=0)
        {
            res[i++] = arr[l--];
            cnt++;
            
        }
        
        // If there are no more elements on left side, then
        // print right elements
        while(cnt<k && r<n)
        {
            res[i++] = arr[r++];
            cnt++;
        }
        
       return res; 
    }
    
     /* Function to find the cross over point (the point before
       which elements are smaller than or equal to x and after
       which greater than x)*/
    int binarysearch(int arr[],int l,int r,int x)
    {
        // Base cases
        if(arr[r]<=x)    // x is greater than all
            return r;
        if(arr[l]>x)    // x is smaller than all
            return l;
        
        int mid = (l+r)/2;
        
         /* If x is same as middle element or greater than mid and mid+1 is greater than x, then return mid */
        if(arr[mid]<=x && arr[mid+1]>x)
            return mid;
        
            /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] */
        if(arr[mid]<x)
            return binarysearch(arr,mid+1,r,x);
        else
            return binarysearch(arr,l,mid-1,x);
    }
    
}

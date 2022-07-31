/**
 * 
 * https://www.youtube.com/watch?v=NTop3VTjmxk      --> refer this video.
 * 
 * 
 * Logic is we will do binary search in two given arrays.
 * 
 * When we merge the two given arrays into one array the median will be the middle ele or middle 2 ele.
 * 
 * But while merging the 2 arrays some elements will come from array-1 and some come from array-2.
 * So we need to find how many elements will come from array-1 before the median of 2-sorte arrays and how many will come from arr-2
 * 
 * If after merging 2-arrs, if number of ele will be (n1+n2) then first half of merged will have (n1+n2)/2, and if among these 'x' elements come from arr-1,
 * then (n1+n2)/2-x will come from arr-2.
 * 
 * Also we dont need all elements from merged array, we just need (mid,mid+1) elements from both arr-1 and arr-2.
 * 
 *
 * 
 */

package Amazonlist;

public class MedianOf2SortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n2<n1)
            return findMedianSortedArrays(nums2,nums1);
        
        int lo =0;
        int hi =n1;
        
        while(lo<=hi)
        {
            int cut1 = (lo+hi)/2;
            int cut2 = (n1+n2+1)/2 -cut1;
            
            int left1 = (cut1==0)? Integer.MIN_VALUE:nums1[cut1-1];
            int left2 = (cut2==0)? Integer.MIN_VALUE:nums2[cut2-1];

            int right1 = (cut1==n1)? Integer.MAX_VALUE:nums1[cut1];
            int right2 = (cut2==n2)? Integer.MAX_VALUE:nums2[cut2];
            
            if(left1<=right2 && left2<=right1)
            {
                if((n1+n2)%2==0)
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                else
                    return Math.max(left1,left2);
            }
            else if(left1>right2)
            {
                hi=cut1-1;
            }
            else
                lo = cut1+1;
        }
        return 0.0;
            
        
    }
    
}

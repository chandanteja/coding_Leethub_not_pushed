import java.util.*;

/**
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * 
 * Logic is We add all the elements of smaller array to hashmap. Then after adding, we iterate in other array and check if every element is present in hashmap(i.e array-1) and if present then add to result array and decrement count.
 * 
 */

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        // first we add the elements of array-1 to hashmap and maintain the count of elements in array-1 accordingly.
        for(int i=0;i<nums1.length;i++)
        {
           if( hm.containsKey(nums1[i]) )   // if element is already there then increment the count
                hm.put(nums1[i], hm.get(nums1[i])+1);
            else    // else add the element to hashmap.
                hm.put(nums1[i],1);
        }
        
        
        ArrayList<Integer> res = new ArrayList<>();
        
        // now we iterate in array-2
        for(int i=0;i<nums2.length;i++)
        {
            // if the current element in array-2 is present in hashmap and if its count is >0 then add that element to resultant array and decrement the count of that element in hashmap.
            if(hm.containsKey(nums2[i])  && hm.get(nums2[i])>0)
            {
                res.add(nums2[i]);
                hm.put(nums2[i],hm.get(nums2[i])-1);
            }
        }
        
        int arr[] = new int[res.size()];
        
        for(int i=0;i<res.size();i++)
            arr[i] = res.get(i);
    
        return arr;
        
    }
    
}

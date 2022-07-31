/**
 * 
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 *  Logic:  Binary Search + Sliding Window
 * 
 * Let's start by finding the closest number to x in arr. 
 * Logically, the second closest number to x must be directly beside the first number, either to the left or right. 
 * Then, the third closest number to x must be either to the left of the first number or to the right of the second number. 
 * This pattern continues, and is true because the input is sorted.

    Using two pointers, we can maintain a sliding window that will expand to contain the k closest elements to x. 
    Let's use binary search to efficiently find the closest number to x in arr, and start our pointers there. 
    Then, we should expand our window by moving the pointers either left or right depending on which number is closer to x.


 * 
 */

package AugChallenge;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestEle {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res = new ArrayList<>();
        
        if(arr.length==k)   // if total number of elements in array are k only then no need to do binary search, directly return all elmnts.
        {
            for(int i=0;i<k;i++)
                res.add(arr[i]);
            return res;
        }
        int left=0;
        int right=arr.length-1;
        
        // binary search to find closest element.
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            
            if(arr[mid] <x)
                    left=mid+1;
            else if(arr[mid]>x)
                    right=mid-1;
            else
                break;
        }
        
        //  elt is not in array: left and right - point to same elt (next smallest / next greatest)
        // after this, left will point to closest elt less than x and right will point to closest elt greater than x
        left = left-1;
        right=left+1;
        
        while(right-left-1<k)       // checking number of elements b/w left and right is <k or not
        {
            if(left==-1)    // after binary search, left=0, so after steps 55, 56 => left=-1 right=0 
            // this case covers taking first k elements.
            {   
                right+=1;   // right keeps increasing.
                continue;
            }
            else
            { 
                
              if(right==arr.length || Math.abs(arr[left]-x) <= Math.abs(arr[right]-x))  
              {
                  // case - 1: right==arr.size() 
                // let after binary search, left point to n then after updation in step 55 and 56 - u will get:
                // left=n-1, right = n.
                // so this case covers considering last k elements.

                // case - 2: abs(arr[left]-x)<=abs(arr[right]-x)
                // when left is closer to x or at same distance as right then expand range on left side.
                  left-=1;
                  
              }
             else
            {
                // if left is not closer to x, then expand range to right side.
                right+=1;
            }
        }
    }
        
        for(int i=left+1;i<right;i++)   // put all elements in the range [left+1, right-1] into result vector.
        {
            res.add(arr[i]);
        }
        
        return res;
    }
    
}

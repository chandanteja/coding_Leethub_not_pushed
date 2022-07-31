/**
 * 
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/     --> refer this article where we consider array elements as indices and modify values at those indices.
 * 
 * Here we consider array elements as indices instead of elements.
 * 
 */

package SearchingAndSorting;

public class FindMissingAndRepeatingEle {
    int[] findTwoElement(int arr[], int n) {
        int res[] = new int[2];
        

        // to find the repeating element.
        // here we are considering elt as index. here elts are b/w 1 to N whereas
        // indices are b/w 0 to N-1. so we do arr[i]-1
        
        // for repeating elt the trick is:
        // when u traverse the array, for each elt go to that index and change that elt into -ve
        // so when it gets repeated it will be -ve and it wont go into if part. 
        // when it goes to else part -- it means that elt is repeated.
        for(int i=0;i<n;i++)
        {
            if(arr[Math.abs(arr[i])-1]>0)
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            else
                res[0] = Math.abs(arr[i]);
        }


         // to find the missing element:
        // so when an elt is present we will visit it and change it to -ve using above for loop.
        // so if an elt is +ve, it means its index is not visited.
        // so index values element is the missing element.
        // as the elts are 1 indexed and arr is 0 indexed, store i+1.
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
                res[1] = i+1;
        }
        
        return res;
    }
    
}

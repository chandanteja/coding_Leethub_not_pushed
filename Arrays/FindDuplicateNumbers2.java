
/**
 * 
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/   --> refer the hashing based soln.
 * https://www.youtube.com/watch?v=kV37sZV9pgk      --> solution.
 * 
 * As it is given the array contains all numbers only b/w 0 to n-1 only. 
 * Also there can be multiple numbers which are repeated.
 * 
 * As it is given the array contains elements b/w only 0 to n-1, it means we can use the same array as hased array.
 * 
 * 
 * Logic here is we consider given array of elements as array of indices.
 * 
 * as it is given elements in array lie b/w 0,n-1 so ,we can safely consider this way.
 * For every element/index in given array we go to that index and increment value at that index by 'n'.
 * 
 * So at the end when we are checking back, we can get the elements whose value >1 that index will be repeated morethan once.
 * 
 * 
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FindDuplicateNumbers2 {

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        
        for(int i=0;i<n;i++)
        {
            // here array elements are not considered as elements/values they are considered as array indices.
            // because arr[i] lies between 0 and n-1.
            // so when u are dng arr[arr[i]%n]+n it means arr[i] is an index. (if it goes beyond n to bring it within range we do
            // %n) we are gng to that index 
            // if i=2, arr[arr[i]%n] == arr[arr[2]%n] and arr[2] is 3 and n=6==> arr[3%6] = arr[3]
            // we are adding +n to this arr[3]. 
            // so at some other point if we get some elmt pointing to arr[3] it means arr[3] is incremented twice.
            // means 2 elts pointed to this arr[3].
            // and these 2 elts must be same. because arr[i] lies b/w 0 to n-1
            // so this elt which is repeated twice so duplicate.

            arr[arr[i]%n] = arr[arr[i]%n]+n;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            // now each elmt is divided by n.. when will some elmt be more than n, when it has been added with n more than once.
            // when will it be added more than once? when 2 elts are pointing to same index, it will be added more than once.
            // and these 2 elts are same.. so duplicates... so add this index.
            if(arr[i]/n >1)
                res.add(i);     // as we are treating elements of array in previous step as indices, we store indices in resultant list.
        }
        
        if(res.size()==0)
        {
            res.add(-1);
            return res;
            
        }  
        
        Collections.sort(res);
        
        return res;
    }   
    
}

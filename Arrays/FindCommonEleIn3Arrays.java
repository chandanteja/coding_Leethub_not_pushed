/**
 * 
 * https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
 * 
 * https://www.youtube.com/watch?v=ajWCEu1razQ
 * 
 * if i/p is 
 *  3 3 3 
 *  3 3 3 --> arr1
 *  3 3 3 --> arr2
 *  3 3 3 --> arr3
 *  In above case o/p shuld be 3, but not 3 3 3.
 *  To avoid such cases we maintain prev1,prev2,prev3.
 *  If x = prev1, move ahead in ar1[] and repeat the procedure until x != prev1. Similarly apply the same for the ar2[] and ar3[].
 *  If x, y and z are same, we can simply print any of them as common element ,update prev1, prev2 and prev3 and move ahead in all three arrays.
    Else If (x < y),  move ahead in ar1[] as x cannot be a common element.
    Else If (y < z),  move ahead in ar2[] as y cannot be a common element.
    Else If (x > z and y > z),  we move ahead in ar3[] as z cannot be a common element.
 */

package Arrays;

import java.util.ArrayList;

public class FindCommonEleIn3Arrays {

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i=0,j=0,k=0;
        int prev1,prev2,prev3;
        prev1 = prev2 = prev3 = Integer.MIN_VALUE;

        
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i] == B[j] && B[j]==C[k])
            {
                
                res.add(A[i]);
                prev1 = A[i];
                prev2 = B[j];
                prev3 = C[k];
                i++;
                j++;
                k++;
            }
            else if(A[i]<B[j])
                i++;
            else if(B[j]<C[k])
                j++;
            else
                k++;
            
        while (i < n1 && A[i] == prev1)
            i++;
 
        while ( j < n2 && B[j] == prev2 )
            j++;
      
        while (k < n3 && C[k] == prev3 )
            k++;    
        }
        if(res.size()==0)
          {
              res.add(-1);
              return res;
          }
        return  res;
        
    }
    
}

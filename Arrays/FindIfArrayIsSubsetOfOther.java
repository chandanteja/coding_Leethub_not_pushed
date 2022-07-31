/**
 * 
 * https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 * 
 * https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1  --> qns
 * 
 * Take a set and add all elements  of array-1 and iterate in array-2 checking if all elements of array-2 are presnet in set or not.
 * 
 * 
 */

package Arrays;

import java.util.HashSet;

public class FindIfArrayIsSubsetOfOther {

    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashSet<Long> hs = new HashSet<>();
        int flag=0;
        
        for(int i=0;i<n;i++)
            hs.add(a1[i]);
            
        for(int i=0;i<m;i++)
        {
            if(!hs.contains(a2[i]))
            {
                flag=1;
                break;
            }
        }
        
        if(flag==1)
            return "No";
        return "Yes";
        
    }
    
}

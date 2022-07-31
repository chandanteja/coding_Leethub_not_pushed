/**
 * 
 * https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 * 
 */

package Arrays;

import java.util.HashSet;

public class FindUnionAndIntersection {

    public static int doUnion(int a[], int n, int b[], int m) 
    {
        HashSet<Integer> res = new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            res.add(a[i]);
        }
        for(int i=0;i<m;i++)
        {
            res.add(b[i]);
        }
        
        return res.size();
    }

    public static int NumberofElementsInIntersection(int a[],int b[],int n,int m)
    {
       HashSet<Integer> hs = new HashSet<>();
       
           for(int i=0;i<n;i++)
                hs.add(a[i]);
            
            int cnt=0;
            
            for(int i=0;i<m;i++)
            {
                if(hs.contains(b[i]))
                {
                    cnt++;  
                    hs.remove(b[i]);
                }
            }
            return cnt;
    }
    
}

/**
 * 
 * https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 * 
 * https://www.youtube.com/watch?v=QmXDAdqJU40
 * 
 * T.C : O(logn + logm)
 * 
 * 
 */

package SearchingAndSorting;

public class KthElementOfTwoSortedArrays {

    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(k> m+n)
            return -1;
        return kth(arr1,arr2,0,0,n-1,m-1,k);
    }
    
    public int kth(int arr1[],int arr2[],int l1,int l2,int r1,int r2,int k)
    {
        if(l1>r1)
            return arr2[l2+k-1];
        if(l2>r2)
            return arr1[l1+k-1];
        
        int m1 = (l1+r1)/2;
        int m2 = (l2+r2)/2;
        int kc = (m1-l1+1)+(m2-l2+1);
    
        if(kc<=k)
        {
            if(arr1[m1]<arr2[m2])
                return kth(arr1,arr2,m1+1,l2,r1,r2,k-(m1-l1+1));
            else
                return kth(arr1,arr2,l1,m2+1,r1,r2,k-(m2-l2+1));
        }
        else
        {
            if(arr1[m1]<arr2[m2])
                return kth(arr1,arr2,l1,l2,r1,m2-1,k);
            else
                return kth(arr1,arr2,l1,l2,m1-1,r2,k);
        }
    }
    
}

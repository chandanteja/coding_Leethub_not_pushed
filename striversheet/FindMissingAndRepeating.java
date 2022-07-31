/**
 * 
 * https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#
 * 
 * Solution:
 * 
 * https://www.youtube.com/watch?v=5nMGY4VUoRY
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * 
 * 
 * Approach::
 * ==========
 *  Let x and y be the desired output elements.
    Calculate XOR of all the array elements.

         xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]

    XOR the result with all numbers from 1 to n
        xor1 = xor1^1^2^…..^n
    
    In the result xor1, all elements would nullify each other except x and y. 
    All the bits that are set in xor1 will be set in either x or y. 
    So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and divide the elements of the array in two sets – one set of elements with the same bit set and other set with same bit not set. 
    By doing so, we will get x in one set and y in another set. Now if we do XOR of all the elements in first set, we will get x, and by doing same in other set we will get y. 
 * 
 */

public class FindMissingAndRepeating {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        int res[] = new int[2];
        int x = 0;
        int y = 0;
        int xor = arr[0];
        int setBitNum;
        
        for(int i=1;i<n;i++)
            xor = xor ^ arr[i];
        
        for(int i=1;i<=n;i++)
            xor = xor ^ i;
        
        setBitNum = xor & ~(xor-1);     // this is for finding the rightmost set bit in the resultant  xor variable.
        
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same 
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The 
    following two for loops serve the purpose */
        for(int i=0;i<n;i++)
        {
            if((arr[i] & setBitNum)!=0)
                x = x ^ arr[i];     /* arr[i] belongs to first set */
            else
                y = y ^ arr[i];     /* arr[i] belongs to second set*/
        }
        
        for(int i=1;i<=n;i++)
        {
            if((i & setBitNum)!=0)    
                x = x ^ i;      /* i belongs to first set */
            else 
                y = y ^ i;      /* i belongs to second set*/
        }
        
        // The below code is for putting the repeating element at the first index in the resultant array. This is needed as GFG online judge verified the o/p this way else it is not needed.
       int flag=0;
       for(int i=0;i<n;i++)
       {
           if(x==arr[i])
            {
                flag=1;
                break;
            }
       }
       
       if(flag==1)
       {
           res[0] = x;
           res[1] =  y;
       }
       else
       {
           res[0] = y;
           res[1] = x;
       }
       
       return res;
    }
}

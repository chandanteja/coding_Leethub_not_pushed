/**
 * 
 * 
 * Here, we need to preserve the order of elements and  use constant space.
 * 
 * https://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/  --> here we dont preserve order of elements. (Other variant)
 * 
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/    (not clearly explained.)
 * 
 * https://www.youtube.com/watch?v=5MeI5Kk8KTQ  --> O(1)space and order of elements preserved. Watch this.
 * 
 * https://www.youtube.com/watch?v=7WqN5LoI2I8&t=345s       --> other variant.
 * 
 * 
 * Logic is we assume all negative ele will be in even-indices and all positive ele in odd indices. So, if we find any element out of place, we will right rotate all ele by one from out of place ele to where we found opposite signed ele.
 */

package Arrays;

public class AlternativePositiveAndNegativeWithConstantSpace {

    void rightRotate(int arr[],int from, int to)
    {
        int temp = arr[to];
        for(int i = to;i>from;i--)  // if we find any element out of place, we will right rotate by one all elements from the place where we found out of element to place where we found opposite signed ele.
            arr[i] = arr[i-1];
        arr[from] = temp;
        
    }

    void rearrange(int arr[],int n)
    {
        int wrongIdx = -1;
        for(int i=0;i<n;i++)
        {
            if(wrongIdx!=-1)
            {
                if ( (arr[wrongIdx]>=0 &&  arr[i]<0) || (arr[wrongIdx] < 0 && arr[i] >=0) )
                {
                    rightRotate(arr, wrongIdx, i);

                    // we are doing this because, if we get wrongIdx = 2 and i = 5 then it means the elements in indices 3,4  will be of same sign as element in wrongIdx if not then 'i' would have stopped at 3 or 4 not at 5.
                    // So, there can be wrongindx at elements b/w wrongidx and i. So, we continue our probe further if there are elements further after i=5.
                    if(i-wrongIdx >=2)
                        wrongIdx = wrongIdx+2;
                    else
                        wrongIdx=-1;
                }
            }
            else 
            {   // this is the case where we dont find any wrong indx. So, we check if negative is in even index and positive is in odd indx, if not then wrongindx can be updated.
                if((arr[i]<0 && i%2==1) || (arr[i]>=0 && i%2==0))
                {
                    wrongIdx = i;
                }
            }
        }
    }

    
}

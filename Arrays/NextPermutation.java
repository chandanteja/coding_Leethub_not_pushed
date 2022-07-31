/**
 * 
 * https://www.youtube.com/watch?v=TOvWyFT0xCw      --> watch this video.
 * 
 * https://www.youtube.com/watch?v=LuLCLgMElus  --> (TUF channel) watch this also
 * 
 * Logic is as below.
 *  {1, 2, 3, 6, 5, 4}      --> the next permutation of given array is 1, 2, 4, 3, 5, 6. If we  see clearly,  with 1,2,3 there are no other permutations will be possible with 4,5,6 .
 * As no permutations are possible with 4,5,6 with 1,2,3 fixed, now we will go for next permutation with 1,2,4 fixed and first permutation as 3,5,6.
 * 
 * Logic is we start traversing from right side to left side.
 *  
 * as we will be given elements will be in continuous sequence only for permutation (lexicographic order), first permutation will be 1,2,3,...n
 * So we traverse from right to left checking if at any place a[i] > a[i-1] happens i.e curr_value is greater than prev_value.
 * 
 * We note FIRST such index  and break out of loop. If no such index exists then we reverse(bcz if no such indx exists then elements are sorted in descending order) the array (sort in ascending order) and return.
 * 
 * Now from that index ( we got in above step), to end of array we find smallest element which is greater than arr[indx-1]. We note that element index.
 * We swap the ele obtained in prev step with arr[indx-1] and reverse the array from indx to end of array.
 * 
 *  
 * 
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    static List<Integer> nextPermutation(int N, int arr[]){
        int idx=-1;
        List<Integer> res = new ArrayList<>();
        
        
        for(int i=N-1;i>0;i--)
        {
            if(arr[i]>arr[i-1])
            {
                idx=i;
                break;
            }
            
        }
        if(idx==-1)
        {
            //return Collections.reverse(Arrays.asList(arr));
            for(int i=N-1;i>=0;i--)
                res.add(arr[i]);
            return res;
            
        }
        else
        {
            int prev = idx;
            
            for(int i=idx+1;i<N;i++)
            {
                if(arr[i] > arr[idx-1] && arr[i]<arr[prev])
                {
                    prev = i;
                }
            }
            int temp = arr[idx-1];
            arr[idx-1] = arr[prev];
            arr[prev] = temp;
            
            reverse(arr,idx,N-1);
           
        }
        
        for(int i=0;i<N;i++)
                res.add(arr[i]);
            return res;
        
        // return Arrays.asList(arr);
    }
    
   static void reverse(int arr[],int start,int end)
    {
       
        
        while(start<=end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
}

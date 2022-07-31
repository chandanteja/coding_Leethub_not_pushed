/**
 * 
 * https://www.youtube.com/watch?v=ptIRm-GTUdw      --> watch this video for logic.
 * 
 * We take two pointers (left,right) and one iterator (i).
 * 
 * if arr[i] < a (left end of interval) then exchange arr[i] with arr[left] value
 * if arr[i] >b (right end of interval) then exchange arr[i] with arr[right] value. When any value is exchanged with arr[right] then dont move the iterator forward.
 * So to not move iterator forward in case of arr[i]>b we do i-- so that 'i' will be at same place. [ Check video for reasoning of this ].
 * 
 * 
 * 
 * 
 * 
 */

package Arrays;

public class ThreeWayPartitioning {

    public void threeWayPartition(int array[], int a, int b)
    {
       int left=0;
       int right = array.length-1;
       
       for(int i=0;i<=right;i++)
       {
           if(array[i]<a)
           {
               int temp = array[i];
               array[i] = array[left];
               array[left] = temp;
               left++;
           }
           else if(array[i]>b)
           {
               int temp = array[i];
               array[i] = array[right];
               array[right]= temp;
               right--;
               i--; // this is to stop the iterator from moving forward.
           }
       }
    }
    
}

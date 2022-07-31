/**
 * 
 * create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
   Note: Array should start with positive number.

   Logic is take all positive numbers (including 0) to one array and all negative nums to another array.
   Now loop until there are elements in positive and negative arrays and add first positive and then negative numbers sequentially.
 * 
 * Note: here array starts always with positive number.
 * 
 */

package Arrays;

import java.util.ArrayList;

public class AlternatePositiveAndNegative {

    void rearrange(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(arr[i] >= 0)
            {
                pos.add(arr[i]);
            }
            else
            {
                neg.add(arr[i]);
            }
        }
        
        
        for(int i=0,j=0,k=0;i<n;)
        {
            // Adding positive and negative numbers sequentially so that first positive nums will be added then negative nums will be added.
            // Check if there are positive numbers present in list (j<pos.size())  and same with negative numbers too i.e lists are not empty().
            if(j<pos.size())
                arr[i++] = pos.get(j++);
            if(k<neg.size())
                arr[i++] = neg.get(k++);
        }
}
    
}

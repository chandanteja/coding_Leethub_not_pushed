/**
 * 
 * We  need to maintain order of array elements too. As, we need to maintain order of elements, so we will first copy all elements to temp array,
 * next if negative element, it will be added to end of array and if positive ele, it will be added to start of array.
 * 
 * 
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/     --> other modification to qns.
 * https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/                    --> original solution
 * 
 * 
 * 
 * 
 */

package Arrays;

public class MoveAllNegatieveEleToArrayEnd {

    public void segregateElements(int arr[], int n)
    {
         int temp[] = new int[n];
 
        
        int j = 0;
         
        for (int i = 0; i < n; i++)
            if (arr[i] >= 0)
                temp[j++] = arr[i];
 
        
        if (j == n || j == 0)   // either only all positive ele are there or else only all negative ele are there then we will do nothing.
            return;
 
        
        for (int i = 0; i < n; i++)
            if (arr[i] < 0)
                temp[j++] = arr[i];
 
        
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
    
}

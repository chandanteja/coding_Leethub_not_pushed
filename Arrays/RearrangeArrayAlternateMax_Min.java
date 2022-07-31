/**
 * 
 *  https://www.youtube.com/watch?v=kQrezgskpho  --> watch this video for very good explaination.
 * 
 *  https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 * 
 * Logic is we need to store two ele. in one cell of array so that we can get them back later.
 * 
 *  Dividend = (Divisor*quotient)+remainder ---> using this concept we store 2-ele in one cell.
 * 
 *  each cell will contain (quotient & remainder) combined. And divisor here is largest_ele in array +1.
 * 
 *  let array be {1,2,3,4,5,6}.
 *  Here divisor = 6+1 = 7
 *  quotient will always be new-value and arr[i] will be old value.
 *  i.e we take two pointers to keep track of 'min_index' and 'max_index' elements.
 *  so quotient will always be either arr[min_index]  or arr[max_index].
 *  remainder will be arr[i].
 * 
 * 
 */

package Arrays;

public class RearrangeArrayAlternateMax_Min {

    public static void rearrange(int arr[], int n){
        
        int max_indx=n-1;   // points to max ele 
        int min_indx=0; // points to min ele
        int max = arr[n-1] +1;  // for division purpose we take max_value +1.
        
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                // here quotient is arr[max_index] and divisor = max and remainder is arr[i].
                // we again do quotient % max bcz the value of any cell can go beyond max value as we are storing two ele in one cell.
                arr[i] = (arr[max_indx]%max)*max+arr[i];    
                max_indx--;
            }
            else
            {
                // here quotient is arr[min_indx] and divisor = max and remainder is arr[i].
                // we again do quotient % max bcz the value of any cell can go beyond max value as we are storing two ele in one cell.
               arr[i] = (arr[min_indx]%max)*max+arr[i] ;
               min_indx++;
            }
        }
        for(int i=0;i<n;i++)
        {
            arr[i] = arr[i]/max;    // getting the elements back.
        }
        
    }
    
}

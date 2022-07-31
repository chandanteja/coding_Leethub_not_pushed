/**
 * 
 * https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
 * 
 */

package Arrays;

public class CyclicallyRotateArrayBy1 {

    // clockwise rotation
    public void rotate(long arr[], long n)
    {
        long last_ele = arr[(int)n-1];
        
        for(int i=(int)n-1;i>0;i--)
        {
           
            arr[i] =arr[i-1];
        }
        arr[0]= last_ele;
        
    }
    
}

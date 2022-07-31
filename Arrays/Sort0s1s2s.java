/**
 * 
 * Refer Cornell univ Dutch 3 flag problem notes
 * 
 * https://www.cs.cornell.edu/courses/JavaAndDS/files/sort9DutchFlag.pdf
 * 
 */

package Arrays;

public class Sort0s1s2s {

    public static void sort012(int arr[], int n)
    {
        int h=0,k=0,t=n-1;  // h-->Points to 0s, k--> points to current ele / red and t points to blue (refer cornell univ notes.)
        while(k<=t)
        {
            if(arr[k] == 0)
            {
              int temp = arr[k];
              arr[k] = arr[h];
              arr[h] = temp;
              h++;
              k++;
              
            }
            else if(arr[k] ==1)
                k++;
            else
            {   // arr[k] == 2
                int temp = arr[k];
                arr[k]=arr[t];
                arr[t] = temp;
                t--;
            }
                
        }
    }
    
}

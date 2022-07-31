/**
 * 
 * Refer Self Paced DSA course --> searching section
 * 
 * Logic is we apply moores voting algo.
 * 
 * Here algo proceeds in 2-phases.
 *  1st phase, algo just finds a majority ele (if it exists)
 *  2nd phase actually verifies whether the ele found by first phase is majority or not.
 * 
 *  1st phase
 * --------------
 *  1. first take 0th ele as majority ele index (in res) and count as 1.
 *  2. Now check if ele at i == ele pointed by majority ele index (res) then increase count.
 *  3. else decrease count and if count becomes '0' then reset majority ele index (res) to 'i' and reset count to '1'.
 * 
 *  2nd phase
 *  -----------
 *  1. take the ele pointed by 'res' and count the nimber of occurrences in the array.
 *  2. if they are <= n/2 return -1 else return ele pointed by 'res'.
 */


package SearchingAndSorting;

public class FindMajorityEle {

    //1st phase
    static int majorityElement(int arr[], int size)
    {
        int res=0,count=1;
        
        for(int i=1;i<size;i++)
        {
            if(arr[res]==arr[i])
                count++;
            else
                count--;
            
            if(count==0)
            {
                
                res=i;
                count=1;
                
            }
            
        }
        

        //2nd phase.
        count=0;
        
        for(int i=0;i<size;i++)
        {
          if(arr[res]==arr[i])
            count++;
            
        }
        if(count<=size/2)
            return -1;
        
        return arr[res];
    }
    
}

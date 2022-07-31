/**
 * 
 * https://www.youtube.com/watch?v=TJNVBGUt5hY
 * 
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 * 
 * Segregate all negatives to one side and all positives to oneside.
 * 
 * Change the sign (i.e positives numbers to negative numbers) of all positive numbers by considering them as indices in the array.
 * 
 */


package SearchingAndSorting;

public class SmallestPositiveMissingNumber {

    static int missingNumber(int arr[], int size)
    {
        
        int pindex = 0;
        // segregate negative ele to one side and positive to other side.

        for (int i = 0; i < size; i++)
            if (arr[i] > 0) 
            {
            
                int temp = arr[i];
                arr[i] = arr[pindex];
                arr[pindex] = temp;
                pindex++;
            }

        // for all positive numbers do this.
        for (int i = 0; i < pindex; i++) 
        {
            int ele = Math.abs(arr[i]); // take ele at index-i
            // check if ele is < pindex and also ele is >=0. --> then change the sign to negative.
            if (ele-1 <= pindex && arr[ele-1] >= 0) // here we are doing ele-1 as indices start from '0', so for any ele, we do ele-1 so that it will can be indexed.
                arr[ele-1] = -arr[ele-1];
        }
        
        int i;
        // 'pIndex' points to first negative number and pIndex-1 is the last positive number.
        // loop from '0' to 'pIndex' and checck if there is any positive number. If present then the index of that number+1 will be our ans.
        // as we are doing arr[arr[i]] = -arr[arr[i]]   --> means using arr[i] as index we are negating the element at arr[arr[i]]. So if any +ve element is not negated then it means there is no element to reach that index.
        for( i=0;i<pindex;i++)
        {
            if(arr[i]>0)
                return i+1;
        }
        // this happens when all positive numbers at the front of arr[] above got changed to negative numbers and hence next largest ele is pIndex.  
        // i.e if all positive nums at front of arr is negated then next positive number will be the index value of last positive number +1.
        // {1,4,2,3,-2,-4,0,-5} --> {-1,-4,-2,-3,-2,-4,0,-5} --> now pIndex would have been pointing to 2nd '-2' in modified arr.
        // so that is the reason why we will return i+1
        if(pindex>0)
            return i+1;
        
        return 1;   // if all elemsgiven are negative number in array i.e given array doesnt have positive ele. 
        
    }
    
}

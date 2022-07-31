/**
 * * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

/*

* key point: should be divisible by 60.
! To Do: create an array of size 60.

* array indices will be: 0 1 2 3 4 5 6 7 8 9 ... 59
now how is 60 formed?
0 + 60
1 + 59
2 + 58
3 + 57
...
30 + 30

* case-1: for all indices other than 0 and 30
 count[i]*count[60-i] will be the number of pairs whose sum is divisible by 60.

* case-2: when indices are 0 or 30
but we dont have 60 index in array. we only have 0. and when we have 2 elements in 30 or 0 then those 2 elements can combine 
with them selves to give a sum which is divisible by 60. 
eg: [30, 150] => 30+150 = 180
    [60, 60] => 120

similarly if we have 4 elements mapping to 30 or 0 then possible pairs will be 6
eg: [30, 150, 210, 270] -> all map to 30
pairs:  30+150, 30+210, 30+270
        150+210, 150+270
        210+270
    
now if we formulate it we will get => (n*(n-1))/2  where n is the number of elements mapping to 30 or 0.

*/

import java.util.Arrays;


public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        
        int countArray[]=new int[60];
        
        Arrays.fill(countArray, 0);
        
        for(int i=0;i<time.length;i++)
        {
            countArray[time[i]%60]++;
        }
        
        int count=0;
        for(int i=0;i<31;i++)
        {
            
            if(i!=30 && i!=0)   // case 1
            {
                count += countArray[i]*countArray[60-i];
                
            }
            else // case 2
            {
                count += (countArray[i]*(countArray[i]-1))/2;
               
            }
        }
        
        return count;
        
    }
}

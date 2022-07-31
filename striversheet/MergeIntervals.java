import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * https://leetcode.com/problems/merge-intervals/solution/
 * https://www.geeksforgeeks.org/merging-intervals/
 * 
 * 
 * 
 * T.c: O(nlogn)
 * Space complexity : O(logN) (or O(n))

If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(logn) space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 * 
 * 
 */

public class MergeIntervals {
 
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0)   // base-case check
            return res.toArray(new int[res.size()][]);
        
        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));        // sorting the array based on first field.
        
        /*
            Logic:
            ======
            1. first sort the intervals based on first column/value of the array.
            2. now we will take the start and end value of first interval into 2 variables.
            3. we will iterate the intervals array by picking one interval at a time and comparing if the start value of current interval with the end variable ( which will have the end value of previously selected interval)
            4. if the start value of current interval is smaller than the end of previously selected interval (in end var.), then we will update the end var. but we won't store the value {start,end} in final array yet, bcz if the next interval in the array can also be merged with the previous interval (start,end), then we will do that and then add the pair {start,end} to final array when we get a new interval whose first column value is greater than the end value. i.e when the if(end>=nterval[0]) fails then we will store the previously merged interval in the final array and then update the start and end with new interval values. 
        */
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int interval[] : intervals)
        {
          if(end >= interval[0])        // checking if end of currenti interval is greater than start of next interval,
              end = Math.max(end,interval[1]);  // if so then we are taking the max of end of current interval and end of next interval. For cases like [1,10] & [3,6] so we need to update with max of (10,6). 
          else
          {
              // we will come here when if condition fails and then we will store the previously merged intervals into result array and then update the start and end variables with new interval values
              res.add(new int[]{start,end});        
              start = interval[0];
              end =interval[1];
              
          }
            
        }
        res.add(new int[]{start,end});  // this is needed for the last interval after the end of loop to be stored into the result array 
        
        return res.toArray(new int[res.size()][]);  // here we are converting the List<int[]> to 2d array.
        
    }
    
}

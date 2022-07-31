/**
 * 
 * https://www.youtube.com/watch?v=2JzRBPFYbKE
 * https://leetcode.com/problems/merge-intervals/discuss/1288519/Very-straightforward-faster-than-95-of-Java-submissions-solution
 * https://leetcode.com/problems/merge-intervals/solution/
 * 
 * 
 *  1) Sort all intervals in increasing order of start time.
    2) Traverse sorted intervals starting from first interval, 
    do following for every interval.
        a) If current interval is not first interval and it 
            overlaps with previous interval, then merge it with
            previous interval. Keep doing it while the interval
            overlaps with the previous one.         
        b) Else add current interval to output list of intervals.
 * 
 */

package Stacksandqueues;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        
        
       List<int[]> merged = new ArrayList<>();
        
        if(intervals==null || intervals.length ==0)
                return merged.toArray(new int[intervals.length][]);
        

                // we sort array based on start-times of intervals. i.e is the reason why we are checking 0th indexed ele in all arrays.
                // comparator is based on 1D array and compare() takes 1D array and compares them based on 1st element and sorts them.
        Arrays.sort(intervals,new Comparator<int[]>()   // here comparator is based on 1D array as we need to sort arrays based on 1st ele of array.
                    {
                       public int compare(int []a,int b[])
                       {
                           if(a[0] < b[0])
                                return -1;
                            if(a[0] > b[0])
                                    return 1;
                            return 0;
                       }
                    });
        
        // Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));  // for sorting

        // we take starting interval start and end points in 2-variables.

        int start = intervals[0][0];
        int end = intervals[0][1];
        
        // this gives 1D array in each 2D array i.e we take 1D array in 2D array and process.

        for(int interval[] : intervals)
        {
            // (start,end) points to prev interval and interval[i][0/1] points to curr interval.

            // if merging is possible then we update only end value else we update both start and end values.

            // start time of current interval is <= end time of prev interval
            if(interval[0]<=end)    // merging of 2-intervals is possible
                end = Math.max(end,interval[1]);    // if intervals are [1,5] & [2,3] then after merging we get [1,5] hence we take max of {5,3} i.e arr[0][1] and arr[1][1]
            else    // merging not possible as intervals are not overlapping. So we add them to resultant list.
            {
                merged.add(new int[]{start,end});   // creating and initializing array and storing values in restultant list i.e new int[]{a,b} --> creates an array of size-2
                start = interval[0];
                end = interval[1];
                    
            }
        }
        merged.add(new int[]{start,end});   //don't forget the interval we were trying to merge i.e last interval
        return merged.toArray(new int[merged.size()][]);
        
    }
    
}

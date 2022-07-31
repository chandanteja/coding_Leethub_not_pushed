/**
 * 
 * https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * Approach #1 Brute Force [Time Limit Exceeded]    
 * 
 * T.C : O(2^n) and S.C : O(n) --> depth of recursion
 * ==================================================
In the brute force approach, we try to remove the overlapping intervals in different combinations and then check which combination needs the minimum number of removals. 
To do this, firstly we sort the given intervals based on the end point. Then, we make use of a recursive function eraseOverlapIntervals which takes the index of the previous interval prev and the index of the current interval curr (which we try to add to the list of intervals not removed), and returns the count of intervals that need to be removed from the current index onwards.

We start by using prev=-1 and curr=0. In each recursive call, we check if the current interval overlaps with the previous interval. If not, we need not remove the current interval from the final list and we can call the function eraseOverlapIntervals with prev=curr and curr=curr + 1. The result of this function call in which we have included the current element is stored in taken variable.

We also make another function call by removing the current interval because this could be overlapping with the upcoming intervals in the next function call and thus, its removal could eventually require lesser total number of removals. Thus, the recursive call takes the arguments prev=prev and curr=curr + 1.
 Since, we have removed one interval, the result if the current interval isn't included is the sum of the value returned by the function call incremented by 1, which is stored in notTaken variable.
 While returning the count of removals following a particular index, we return the minimum of taken and notTaken.

 CODE
 ======

 class myComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      return a[1] - b[1];
    }
  }
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, new myComparator());
    return erase_Overlap_Intervals(-1, 0, intervals);
  }
  public int erase_Overlap_Intervals(int prev, int curr, int[][] intervals) {
    if (curr == intervals.length) {
      return 0;
    }
    int taken = Integer.MAX_VALUE, nottaken;
    if (prev == -1 || intervals[prev][1] <= intervals[curr][0]) {
      taken = erase_Overlap_Intervals(curr, curr + 1, intervals);
    }
    nottaken = erase_Overlap_Intervals(prev, curr + 1, intervals) + 1;
    return Math.min(taken, nottaken);
  }


  taken -> [prev, curr] considered in non-overlapping intervals sequence means taken will keep track of what are the non-overlapping intervals
  not-taken -> [prev, curr] not considered in non-overlapping intervals because it is overlapping so move curr to curr+1 and do +1 as this is overlapping and we want minimum count of intervals which are not overlapping.
  not-taken --> keeps track of overlapping intervals and their count. 


 * 
 */

 /*

  Approach #4 Using Greedy Approach based on starting points [Accepted]
    Algorithm
    ==================================================================

    Case-1
    ========

    ----------------
                      -----------------
    Case-2
    =======
    
    -------------------------------------------------------     (1st interval)
            ---------------------------     (2nd interval)
    Case-3
    ======

    ----------------------
                    --------------------

If we sort the given intervals based on starting points, the greedy approach works very well. While considering the intervals in the ascending order of starting points, we make use of a pointer prevprev pointer to keep track of the interval just included in the final list.



Case 1:

The two intervals currently considered are non-overlapping:

In this case, we need not remove any interval and we can continue by simply assigning the prev pointer to the later(2nd) interval and the count of intervals removed remains unchanged.

Case 2:

The two intervals currently considered are overlapping and the end point of the later interval falls before the end point of the previous interval:

In this case, we can simply take the later interval. The choice is obvious since choosing an interval of smaller width will lead to more available space labelled as A and B, in which more intervals can be accommodated. Hence, the prev pointer is updated to current interval (2nd interval) and the count of intervals removed is incremented by 1.

Case 3:

The two intervals currently considered are overlapping and the end point of the later interval falls after the end point of the previous interval:

In this case, we can work in a greedy manner and directly remove the later interval. To understand why this greedy approach works, we need to see the figure below, which includes all the subcases possible. It is clear from the figures that we choosing interval 1 (1st interval) always leads to a better solution in the future. Thus, the prev pointer remains unchanged (point to 1st interval only) and the count of intervals removed is incremented by 1.

 */


 //    https://www.geeksforgeeks.org/find-non-overlapping-intervals-among-a-given-set-of-intervals/      --> go thru this qns also.

package Amazonlist;

import java.util.Arrays;

public class MinimumRemovalsToMakeIntervalsNon_Overlapping {


    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length==0)
                return 0;
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        
        int prev = 0;   // keeps track of the interval just included in the final list of non-overlapping intervals
        int minRemoval=0;   // keeps track of min number of removals to make given set of intervals non overlapping

        
        for(int i=1;i<intervals.length;i++)
        {
            // if prev interval endtime > current interval start time --> it means 2-intervals are overlapping
            if(intervals[prev][1] > intervals[i][0])
            {
                // if 2-intervals are overlapping, we check if previous interval end time is also greater than current interval (ith interval)end time
                // if so we will make prev to point 'i'th interval.
                if(intervals[prev][1] > intervals[i][1])
                    prev = i;
                minRemoval++;       // increment count of min intervals to be removed.
            }
            else        // this is the case of prev-interval end time <= curr interval start time.
                prev = i;
            
        }
        
        return minRemoval;
        
    }
    
    
}

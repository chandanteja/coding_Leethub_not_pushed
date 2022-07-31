/*
        https://leetcode.com/problems/minimum-number-of-refueling-stops/

        Brute force solutions needs us to try all possible combinations of refueling stations and pick up minimum one.
        T.C of Brute force : exponential as we need to try all combinations
        
        Using DP:
        ------------
        dp[i], the farthest location we can get to using i refueling stops. This is motivated by the fact that we want the smallest i for which dp[i] >= target

        Intuition:
        -----------
        if we could reach a distance of 15 with 1 refueling stop, and now we added a station at location 10 with 30 liters of fuel, then we could potentially reach a distance of 45 with 2 refueling stops.


        DP SOln
        ==========

        public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int n = stations.length;
        long dp[] = new long[n+1];  // dp[i] is max distance that can be travelled using first 'i' re-fueling stations.
        
        dp[0] = startFuel;  // using '0' re-fueling stations, we can reach max distance which is reachable using startfuel only..
        
        for(int i=0;i<n;i++)
        {
            for(int j=i;j>=0;j--)
            {
                if(dp[j] >= stations[i][0]) // i.e if dp[j] has more dist that can be reached which is  greater than ith stations' position, then (j+1)th station can be reached by adding the fuel at ith station
                    dp[j+1] = Math.max(dp[j+1], dp[j]+(long)stations[i][1]);
            }
        }
        
        // if we find any 'i' in dp[] whre dp[i]>= target then 'i' is the min number of refueling stops
        for(int i=0;i<=n;i++)
            if(dp[i]>= target)
                return i;
        return -1;

        }

        DP based
        ---------
        T.C : O(n^2)
        S.c : O(n)


        Another approach -- Heap based
        ==============================

        https://www.youtube.com/watch?v=tAdMNnd3CII     --> refer this for basic idea.

        Logic is we maintain Max heap based on fuel available at stations i.e 

    Intuition
    ------------
When driving past a gas station, let's remember the amount of fuel it contained. 
We don't need to decide yet whether to fuel up here or not - for example, there could be a bigger gas station up ahead that we would rather refuel at.

When we run out of fuel before reaching the next station, we'll retroactively fuel up: greedily choosing the largest gas stations first.

This is guaranteed to succeed because we drive the largest distance possible before each refueling stop, and therefore have the largest choice of gas stations to (retroactively) stop at.


Algorithm
===============
pq ("priority queue") will be a max-heap of the capacity of each gas station we've driven by. We'll also keep track of tank, our current fuel.

When we reach a station but have negative fuel (ie. we needed to have refueled at some point in the past), we will add the capacities of the largest gas stations we've driven by until the fuel is non-negative.

If at any point this process fails (that is, no more gas stations), then the task is impossible.

*/

package MorganStanleyList;

import java.util.Collections;
import java.util.PriorityQueue;

// using heaps --   https://www.youtube.com/watch?v=tAdMNnd3CII 
public class MinimumNumOfRefuelingStations {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
   
       // (1 unit dist need 1 unit fuel).
        int currFuel = startFuel;    // this keeps track of current position
        int noOfRefills=0;      // keeps track of number of refills
        
        for(int station[] : stations)
        {
            int nextPos = station[0];
            int stationFuel = station[1];
            
            while(currFuel < nextPos)        // if current fuel is not sufficient to reach next position  
            // to reach next position from current pos, the fuel shuld be 
            {
                if(pq.isEmpty())
                        return -1;
                int maxFuel = pq.poll();    // as we have reached a point where our current fuel is less than next station position. so we cant reach next station unless we refill tank at previous stations.
                
                currFuel = currFuel+maxFuel;    // if at anytime current fuel is smaller than what is need to reach next position, then we add max available fuel i.e top of heap ele.
                noOfRefills++;
                
            }
            
            pq.add(stationFuel);    //add next stations fuel to heap.
            
        }
        
        // IMP CASE. DONT FORGET.
        // this is needed when (current Fuel is < target) and there are some fueling stations left in heap. So, we can process those stations in heap and reach target.
       while(currFuel<target)
        {
            if(pq.isEmpty())
                    return -1;
            int maxFuel = pq.poll();
            currFuel = currFuel+maxFuel;
           noOfRefills++;
        }
        return noOfRefills;
    }
    
}

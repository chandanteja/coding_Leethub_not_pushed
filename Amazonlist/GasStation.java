/**
 * https://leetcode.com/problems/gas-station/
 * 
 * Refer Leetcode solution.
 * 
 * Also watch GFG self-paced DSA --> Deque section.
 * 
 * compute total amount of gas in the tank total_tank = sum(gas) - sum(cost) during the round trip, and then return -1 if total_tank < 0.
 * It's impossible to start at a station i if gas[i] - cost[i] < 0, because then there is not enough gas in the tank to travel to i + 1 station.
 * 
 * Let's introduce curr_tank variable to track the current amount of gas in the tank. If at some station curr_tank is less than 0, that means that one couldn't reach this station.
    Next step is to mark this station as a new starting point, and reset curr_tank to zero since one starts with no gas in the tank.
 * 
 * 
 * Algorithm
==================
    Now the algorithm is straightforward :

    Initiate total_tank and curr_tank as zero, and choose station 0 as a starting station.

    Iterate over all stations :

    Update total_tank and curr_tank at each step, by adding gas[i] and subtracting cost[i].

    If curr_tank < 0 at i + 1 station, make i + 1 station a new starting point and reset curr_tank = 0 to start with an empty tank.

    Return -1 if total_tank < 0 and starting station otherwise.
 * 
 */

package Amazonlist;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
     
        // currGas variable to track the current amount of gas in the tank. If at some station currGas is less than 0, that means that one couldn't reach this station.

	// Next step is to mark this station as a new starting point, and reset currGas to zero since one starts with no gas in the tank.

        int currGas=0;
        int totalGas=0;     //To compute total amount of gas in the tank totalGas = sum(gas) - sum(cost) during the round trip, and then return -1 if totalGas < 0.
        int startStation=0;
        
        int n=gas.length;
        
       
        for(int i=0;i<n;i++)
        {
            totalGas += gas[i]-cost[i];
            currGas += gas[i]-cost[i];
            
            if(currGas<0)
            {
                startStation=i+1;
                currGas=0;
            }
            
           
        }
        return totalGas>=0 ? startStation:-1;   // if total gas>=0 then we can reach start station in circular fashion
    }
    
}

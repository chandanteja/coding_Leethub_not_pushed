/**
 * 
 * https://leetcode.com/problems/gas-station/
 * 
 * Watch self paced  DSA course --> Deque section for this problem.
 * 
 * Logic is let p0,p1,p2,p3,....pi-1,pi,pi+1,.....pn-1 be 'n' petrol pumps.
 * 
 * let say, we start out tour from p0 and let 'pi' be the petrol pump at which the petrol becomes in negative quantity. Hence, we cant continue our journey forward.
 * 
 * Claim is if we start from any of the pumps p0,p1,p2,...pi-1, we cant complete tour. So we continue our probing further from 'pi+1'.
 * 
 * We track remaining amount of petrol after visiting any petrol pump in 'curr_petrol' and also we maintain a variable called previous petrol in 'prev_petrol'.
 * 
 * prev_petrol is needed as in above case, if 'pi' is where our petrol quantity goes negative then we start our next tour from 'pi+1', as we need to reach 'pi+1' after completing entire tour,
 * 
 * we need to track prev_petrol so that when we reach 'pn-1', we can verify that whether we can reach 'pi+1' or not with current petrol and prev_petrol combined.
 * 
 */

package Stacksandqueues;

// follow leetcode soln
public class CircularTourOfPetrolPumps {

    int tour(int petrol[], int distance[])
    {
	    int curr_petrol=0;
	    int prev_petrol=0;
	    int start =0;
	    
	    for(int i=0;i<petrol.length;i++)
	    {
	        curr_petrol = curr_petrol + (petrol[i] - distance[i]);
	        if(curr_petrol<0)
	        {
	            prev_petrol = prev_petrol + curr_petrol;
	            start = i+1;
	            curr_petrol=0;
	        }
	        
	    }
	    if(curr_petrol+prev_petrol > 0) // to check whether can we reach 'pi+1' from 'pn-1' if we start our new tour from 'pi+1'.
	        return start;
	    else
	        return -1;
    }
    
}

// Leetcode solution is much simpler

/*	

Algorithm
============
Now the algorithm is straightforward :

Initiate total_tank and curr_tank as zero, and choose station 0 as a starting station.

Iterate over all stations :

Update total_tank and curr_tank at each step, by adding gas[i] and subtracting cost[i].

If curr_tank < 0 at i + 1 station, make i + 1 station a new starting point and reset curr_tank = 0 to start with an empty tank.

Return -1 if total_tank < 0 and starting station otherwise.


IMPLEMENTATION
----------------

public int canCompleteCircuit(int[] gas, int[] cost) {
     

	// currGas variable to track the current amount of gas in the tank. If at some station currGas is less than 0, that means that one couldn't reach this station.

	// Next step is to mark this station as a new starting point, and reset currGas to zero since one starts with no gas in the tank.


        int currGas=0;
        int totalGas=0;		//To compute total amount of gas in the tank totalGas = sum(gas) - sum(cost) during the round trip, and then return -1 if totalGas < 0.
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




*/
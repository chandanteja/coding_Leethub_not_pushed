/**
 * 
 * https://www.youtube.com/watch?v=XaayRYdKG0I  --> refer this.
 * 
 * Logic is, here num of days (n) can be 10^9, but we need not calculate the cell values for 10^9 times.
 * 
 * Here, we are given there will be '8' cells, of which first and last cell will be 0 as they dont have 2-adjacent cells.
 * 
 * So we have as below
 * 
 *  0 x x x x x x 0 --> here 'x' means it can be either 0 or 1. ==> 2^6 possibilities i.e 64 possibilities.
 *  But here all 64 are not feasible solutions. 
 * 
 * Let us enumerate for cells = 5
 *  
 * 0 x x x 0    --> 2^3 possibilities
 *  
 * 0 000  0    -> not valid
 * 0 001  0   -> not valid
 * 0 010  0
 * 0 011  0
 * 0 100  0 
 * 0 101  0
 *  110
 *  111
 * 
 *  only 1-pattern will be valid among all 8 above. So, in same way out of all 64 only some patterns will be valid and form cycle
 * 
 *   a --> b--> c--> d--> a  ==> every pattern will have one incoming edge and one outgoing. So all the valid patterns will be in cycle.
 *  So, we will find this cycle length and we use a map to store the (pattern,index), here index is the first time at which pattern is seen.
 * 
 *  In below for-loop, we calculate the remaining days as,
 * 
 *  currently we are at day = i
 *  Total days = n
 *  (n-i) gives remaining days but as we need (n-i) to be within cycle length/loop length we do (n-i)%loop_length
 *                                  
 *                                                      OR
 *  currently we are at 'i', let there be 'kl' length loop and 'c' is remaining days after completing 'kl' days
 * 
 *  so, i+kl+c = N
 *  kl+c = N-i      --> take mod L on both sides.
 * 
 * 
 */

package Amazonlist;

import java.util.*;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {
        
        HashMap<String,Integer> hm = new HashMap<>();   // stores all possible states of cells[] in string format in hashmap along with the index-i at which it has occurred for first time. 
        //So, that we can use the index  later for calculating the loop length.
        
        for(int i=0;i<n;i++)
        {
            String s = Arrays.toString(cells);
            
            if(hm.containsKey(s))   // already occured state
            {
                // i- is curr index and if string 's' has occurred before 'i' then it means its first occurrence is saved. So, we calculate (i-prev_indx_occurrence).
                // We get the distance b/w current occurrence and previous occurrence....
                int loop_length = i-hm.get(s);  // as 's' has been occured already, curr-index 'i' - previously occurred value(hm.get(s)) will give us loop length.
                int rem_days = (n-i)%loop_length;   //(i+KL)+c = N (here 'kl' is some multiple of loop_length and 'c' is remaining days after completing 'kl' and 'c' will be less than 'l')
                //--> kl+c = N-i --> (kl+c)%l = (N-i)%l --> c = (N-i)%l (bcz kl%l will be '0' as it is exact multiple of 'l' and c%l will be 'c' as c is lessthan 'l').
                
                return prisonAfterNDays(cells,rem_days);
                
            }
            else
            {
                hm.put(s,i);
                int prev=cells[0]; 
                // cell[i] = cell[i-1]==cell[i+1] ? 1:0;
                // that is why we take cell[i-1] in prev and cell[i+1] in next and cell[i] in curr and move prev always.
                for(int j=1;j<7;j++)
                {
                    int next=cells[j+1];
                    int curr = cells[j];
                    cells[j] = (prev==next)?1:0;
                    prev=curr;  // update prev    
                }
                
            }

            // as first and last cells will have '0' always
            cells[0] = 0;
            cells[7] = 0;
        }
        return cells;
        
    }
    
}

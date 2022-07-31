/**
 * 
 *  https://www.geeksforgeeks.org/power-set/
 * 
 * Logic is first we find the size of power-set.
 * Now we will loop for the size of powerset size, and check if any of the bit is set using inner loop.
 * If size of powerset is: 2^n then we need n-bits to represent it.
 * So, we loop for n-times (inner loop) and check the set bits and in the value of outer loop and generate those elements inside if condition.
 * 
 */
package BitManipulation;

import java.util.*;

public class FindAllPossibleSubsets_PowerSet {

    // this is for integers.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        long powsize = (long)Math.pow(2, nums.length);

        /*Run from counter 000..0 to
        111..1*/
        for(int c=0;c<powsize;c++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<nums.length;j++)
            {
                if((c & (1<<j)) >0) // checking if jth bit is set in 'c'
                    list.add(nums[j]);
                
            }
            res.add(list);
        }
        return res;
        
    }

    // this is for strings.
    public List<String> AllPossibleStrings(String s)
    {
        long pow_set_size = (long)Math.pow(2, s.length());
        int counter, j;
     
       List<String> res = new ArrayList<>();

       /*Run from counter 000..0 to
        111..1*/
        for(counter = 0; counter <
                pow_set_size; counter++)
        {
          String temp="";
            for(j = 0; j < s.length(); j++)
            {
                
                if((counter & (1 << j)) > 0)        // checking if jth bit is set in 'counter'.
                        temp = temp+s.charAt(j);
            }
 
        if(!temp.isEmpty())
             res.add(temp);        
        }
        Collections.sort(res);
        return res;
    }
}

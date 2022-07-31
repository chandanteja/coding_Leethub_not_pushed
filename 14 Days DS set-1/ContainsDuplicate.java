/**
 * 
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * we use HashMap or HashSet to track duplicate elements. If we use HashSet, and while inserting element if we come across an element which is already existing in HashSet, we return true.
 * 
 * T.C : O(n)
 * S.C : O(n)
 * 
 * 
 */

import java.util.HashMap;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int flag=0;
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))   
            {
                flag=1;
                break;
            }
            else
                hm.put(nums[i],1);
        }
        
        return (flag==1);
    }
    
}


/**
 * Bit manipulation method from one of the comments. ( Trace with example [1,2,3,4,1])
 * 
 * https://leetcode.com/problems/contains-duplicate/discuss/60937/3ms-Java-Solution-with-Bit-Manipulation
 * 
 * 
 * 
 * This solution is very interesting. (From comments)

For this problem, one of the simplest solutions is to create a big lookup table k. The value of each element in the table is to determine whether the index value has appeared before. The solution with Bit Manipulation is similar to that. Instead of using 0 or 1 in each element to show whether the number exit, it uses 8 bits of each element to indicate the existence of 8 numbers.

For a number A, assume k1 = A/8, k2 = A%8+1. It uses k1 as the index for the lookup table to get a element. And then the k2-th bit of the element is checked to find out whether A appeared before. If the bit is 1, return true. Or if the bit is 0, set the bit to 1 (add A to the lookup table).

For example, now we get a number 0x800 (k1 = 0x100, k2 = 1). Then we get the 0x100-th byte in the table ( table[0x100] = 0b10000111). The 1st bit is 1. So we know 0x800 appeared before. Moreover, 0b10000111 means 0x800, 0x801, 0x802 and 0x807 has appeared before.
 * 
 */

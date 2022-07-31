/**
 * 
 * https://leetcode.com/problems/majority-element/
 * 
 * Watch GFG self paced DSA --> Arrays.
 * 
 * Logic is here we use Moore's voting algo. 
 * 
 * The essence of the algo is to have majority votes, there shuld be votes > half i.e > n/2 ==> n/2+1 is the minimum criteria for majority.
 * 
 * So,here we initially pick starting ele as majorityele and its votes as '1'.
 * 
 * When we see same element then we increment the votes of the majorityele. If we see different ele then we decrement the count/votes.
 * If at anypoint of time the count/votes becomes '0', then we will consider the current element as majorityele and update count to '1'.
 * 
 * This works bcz if there is a majority ele then it will occur n/2+1 times and hence if there are other ele, they will cancel out the votes of majority ele for n/2 time but as majority ele occurs n/2+1 times, at last the count will be '1' and majority ele will be found.
 * 
 * This operates in 2-phases
 * 
 * 1. Find majority ele
 * 2. check if the ele found above is actually majority or not. (this step is needed when we are not given that majority ele will be for sure in array.)
 *  
 */

package Amazonlist;

public class MajorityEle {

    public int majorityElement(int[] nums) {
        
        // start with 1st ele as majority and its votes/count as '1'
        int voteCount=1;
        int majorEle = nums[0];
        
        // if we find same ele as majority increment the count.
        // else decrement the count and if count becomes '0' then take the majority ele as the ele at which count became '0'.
        for(int i=1;i<nums.length;i++)
        {
               if(nums[i]==majorEle)
                   voteCount++;
                else
                {
                    voteCount--;
                    if(voteCount==0)
                    {
                        majorEle=nums[i];
                        voteCount++;
                    }
                }
                   
        }
        
        /*
        Below code is only needed if we dont know whether majority element exists or not for sure. In leetcode problem above, it is mentioned that majority ele always exist.
        
            voteCount=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==majorEle)
                    voteCount++;
                    
            }
            
            if(voteCount <= nums.length/2)
                return -1;
                
            return majorEle;
        
        */
        
        return majorEle;
    }
    
}

/**
 * 
 * https://leetcode.com/problems/partition-labels/
 * 
 * https://www.youtube.com/watch?v=EUk1oibBmx0      --> watch this video.
 * 
 * Logic is we take an array which keeps track of last occurrence of every character in the string.
 * 
 * Ex: s = abaete
 * 
 * last occurrence
 * [
 *  a:2
 *  b:1
 *  e:5
 *  t:4
 * ]
 *  
 * Now we take 2-variables, start=0, end=0;
 * 
 * 'start' and 'end' point to ends of current partition.
 * 
 * we will loop for every char in given string and do as below.
 * 
 *  If we are at a char-c (ith index) whose  last occurrence is at some index after j, we'll extend the partition j = lastoccurrence[c].
 *  If we are at the end of the partition (i == j) then we'll append a partition size to our answer, and set the start of our new partition to i+1.
 * 
 * We get partition size from (i-start+1) bcz start and end points to current partition end points. 
 *  
 * 
 */

package Amazonlist;

import java.util.*;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        
        int lastoccur[] = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            lastoccur[s.charAt(i)-'a'] = i;
        }
        
        int start=0,end=0;  // points to end of current partition.
        
        List<Integer> res= new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            // we check if the last occurrence of chat at index-i is having index value after the current value pointed by 'end', then we update the end with new value as it is the max value now.
            // else we update the end with old value (as old value itself is larger, since the char at index-i is not having its last occurrence after cuurent index pointed by 'end').
            end = Math.max(end,lastoccur[s.charAt(i)-'a']); 
            
            if(i==end)
            {
                res.add(i-start+1);
                start=i+1;
            }
        }
        
        return res;
        
    }
    
}

/**
 * 
 * No reference is used.
 * 
 * 
 */

package LinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class CountPairsIn2GivenLL {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        if(head1==null || head2==null)
            return 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        // we store all elements of one of the list in set.
        for(int i=0;i<head1.size();i++)
        {
            hs.add(head1.get(i));
        }
        
        int cnt=0;
        // for each ele of this list, check the remainder (x-temp->data) is present in other list (or set), if present then cnt++
        for(int i=0;i<head2.size();i++)
        {
            int t = x-head2.get(i);
            if(hs.contains(t))
                cnt++;
            
        }
        return cnt;
        
    }
    
}

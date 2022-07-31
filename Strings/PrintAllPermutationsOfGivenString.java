/**
 * 
 * https://www.youtube.com/watch?v=sPAT_DbvDj0      --> watch this video.
 * 
 * T.C : O(n! * n)
 * 
 * S.C : O(n).
 * 
 */


package Strings;

import java.util.*;

public class PrintAllPermutationsOfGivenString {

    List<String> res = new ArrayList<>();
    
    public List<String> find_permutation(String S) {
        
        
        
        int n = S.length();
        if(n==0)
            return res;
        
         permutations(S,"");
         Collections.sort(res);
         return res;
    }
    
    public void permutations(String s,String res_str)
    {
        if(s.length()==0)
        {
            res.add(res_str);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            String left_part = s.substring(0,i);
            String right_part = s.substring(i+1);
            String rem_string = left_part+right_part;
            permutations(rem_string,res_str+c);
            
        }
        return ; 
    }
    
}

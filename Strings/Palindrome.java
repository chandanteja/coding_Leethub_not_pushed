/**
 * 
 * No reference is used.
 * 
 */

package Strings;

public class Palindrome {

    int isPlaindrome(String S) {
        
        if(S.length()==0 || S.length()==1)
            return 1;
        
       int i=0,j=S.length()-1;
       
       while(i<=j)
       {
           if(S.charAt(i)==S.charAt(j))
           {
               i++;
               j--;
               
           }
           else
            return 0;
       }
       return 1;
    }
    
}

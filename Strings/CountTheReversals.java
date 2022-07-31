/**
 * 
 * https://www.techiedelight.com/minimum-number-inversions-expression-balanced/     --> refer this article. 
 * 
 * https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1
 * 
 */

package Strings;

public class CountTheReversals {

    int countRev (String s)
    {
            // if the expression has an odd length, it cannot be balanced
         if (s.length() %2!=0) 
                 return -1;
        
    int inversions = 0;     // stores total inversions needed 
    int open = 0;             // stores the total number of opening braces
 
    // if even length we can do any #reversals and balance it.
    for (int i = 0; i < s.length(); i++)
    {
        // if the current character is an opening brace
        if (s.charAt(i) == '{') 
        {
            open++;
        }  
        else            // if the current character is a closing brace.  if u see a close brace
        {
            // if an opening brace is found before, close it
            if (open!=0) {
                open = open - 1;    // decrement opening brace count  
            }

            // invert the closing brace, i.e., change `}` to `{`
            else {      // and before there is no open brace. then convert this close brace to open brace.
                inversions++;       // increment total inversions needed by 1   as we converted it. 
                open += 1;          // increment opening brace count ,and we converted this close brace to open brace so open brace count increases.  
            }
        }
    }
 
    // at the end, we will have even number of open braces. so if we reverse half of them they will become
    // close braces so we can match them with open ones.
    // so total reversals = inv+(open/2)
    return inversions + open/2;     // for `n` opened braces, exactly `n/2` inversions are needed
    }
    
}

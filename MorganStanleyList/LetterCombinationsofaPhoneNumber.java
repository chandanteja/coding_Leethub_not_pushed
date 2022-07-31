/*

https://leetcode.com/problems/letter-combinations-of-a-phone-number/    --> this qns has very small inputs. Henc Bruteforce works

The below approach is bruteforce solution. As the input for this qns is very small bruteforce soln works.


solving the 1-digit case is trivial, and solving the 2-digit case is just solving the 1-digit case twice.
The same reasoning can be extended to n digits. For the 3-digit case, solve the 2-digit case to generate all combinations of the first 2 letters, and then solve the 1-digit case for the final digit.


As mentioned previously, we need to lock-in letters when we generate new letters. The easiest way to save state like this is to use recursion. Our algorithm will be as follows:

If the input is empty, return an empty array.

Initialize a data structure (e.g. a hash map) that maps digits to their letters, for example, mapping "6" to "m", "n", and "o".

Use a backtracking function to generate all possible combinations.

The function should take 2 primary inputs: the current combination of letters we have, path, and the index we are currently checking.
As a base case, if our current combination of letters is the same length as the input digits, that means we have a complete combination. Therefore, add it to our answer, and backtrack.
Otherwise, get all the letters that correspond with the current digit we are looking at, digits[index].
Loop through these letters. For each letter, add the letter to our current path, and call backtrack again, but move on to the next digit by incrementing index by 1.
Make sure to remove the letter from path once finished with it.

T.C : O(4^N)
S.C : O(n)

*/

package MorganStanleyList;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    // map of strings for each number i.e here map[2] = "abc", map[3] = "def" ==> 2 -> "abc", 3-> "def". This is how its stored.

    String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};   
    
    public List<String> letterCombinations(String digits) {
       
        
        List<String> res = new ArrayList<>();
        
        // base case if given string is empty
        if(digits.length()==0)
                return res;
        
        StringBuilder op = new StringBuilder();
        
        makeCombinations(digits,op,res);
        return res;
        
    }
    
    //this method is for making combinations of different strings possible, using the given digits
    public void makeCombinations(String digits, StringBuilder op, List<String> res)
    {
        if(digits.length()==0 ) // if digits length become '0' i.e all characters in digits is visited. Then we can add the current string formed to o/p.
        {
            
            res.add(op.toString());
            return;
        }
        
        char curr_digit = digits.charAt(0); // take 0th char in digits. This is the locked-in character. We fix this char and iterate on remaining char.
        String rem_str = digits.length()>=2 ? digits.substring(1) : ""; // taking the remaining part of string from digits after fixing the 1st char from the string bove.
        
        String curr_map_str = map[curr_digit-'0'];  // getting the mapped value for the locked-in character.
        
        // iterate for the length of the mapped string.
        for(int i=0;i<curr_map_str.length();i++)
        {
            op.append(curr_map_str.charAt(i));      // append i-th char to o/p string.
            makeCombinations(rem_str,op,res);       // recurse on remaining part of string.
            op.deleteCharAt(op.length()-1);     // remove the last char of the string. Removes last most char of string.
            
        }
        
    }
    
}

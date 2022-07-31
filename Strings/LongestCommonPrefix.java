/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * https://leetcode.com/problems/longest-common-prefix/solution/        --> solution.
 * 
 * Logic is first take one of the string in array as prefix, and check if that is prefix of other string.
 * If the string is not prefix of other string then remove one character at the end  and check the new string will be prefix of the string or not.
 * Continue in this way.
 * 
 */

package Strings;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) 
                return "";
   String prefix = strs[0];
       
   for (int i = 1; i < strs.length; i++)
       while (strs[i].indexOf(prefix) != 0)     // check if prefix (string) is prefix of str[i] i.e ith string, if not then remove one character at the end and check again.
       {
           prefix = prefix.substring(0, prefix.length() - 1);
           if (prefix.isEmpty()) return "";
       }        
   return prefix;
       
   }
    
}

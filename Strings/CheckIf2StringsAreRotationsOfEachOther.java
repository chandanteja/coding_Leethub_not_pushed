/**
 * 
 * 
 * 1. Create a temp string and store concatenation of str1 to
       str1 in temp.
                        temp = str1+str1
    2. If str2 is a substring of temp then str1 and str2 are 
       rotations of each other.

    Example:                 
                     str1 = "ABACD"
                     str2 = "CDABA"

     temp = str1+str1 = "ABACDABACD"
     Since str2 is a substring of temp, str1 and str2 are 
     rotations of each other.


        https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
 * 
 */

package Strings;

public class CheckIf2StringsAreRotationsOfEachOther {

    public static boolean areRotations(String s1, String s2 )
    {
        String temp = s1+s1;
        
         // There lengths must be same and str2 must be 
        // a substring of str1 concatenated with str1.
        if(s1.length()==s2.length() && temp.indexOf(s2)!=-1)
            return true;
        return false;
    }
    
}

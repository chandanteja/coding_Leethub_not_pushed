/**
 * 
 * https://practice.geeksforgeeks.org/problems/power-set-using-recursion/1/?track=sp-recursion&batchId=105#     --> qns
 * 
 * 
 * https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
 * 
 * https://www.geeksforgeeks.org/print-subsequences-string/
 * 
 * Logic is we have 2-choices for every character, either pick the character and dont pick the character.
 * 
 *  T.C : O(2^n)
 */

package Strings;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesOfAString {
    

     // Declare a global list
     static List<String> al = new ArrayList<>();
 
     public static void main(String[] args)
     {
         String s = "abcd";
         findsubsequences(s, ""); // Calling a function
         System.out.println(al);
     }
  
     private static void findsubsequences(String s,String ans)
     {
         if (s.length() == 0) {
             al.add(ans);
             return;
         }
  
         // We add adding 1st character in string
         findsubsequences(s.substring(1), ans + s.charAt(0));
  
         // Not adding first character of the string
         // because the concept of subsequence either
         // character will present or not
         findsubsequences(s.substring(1), ans);
     }

}

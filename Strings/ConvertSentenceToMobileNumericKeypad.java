/**
 * 
 * https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/
 * 
 */

package Strings;

public class ConvertSentenceToMobileNumericKeypad {

    String str[] = {"2","22","222",
                        "3","33","333",
                        "4","44","444",
                        "5","55","555",
                        "6","66","666",
                        "7","77","777","7777",
                        "8","88","888",
                        "9","99","999","9999"
                    };
    String printSequence(String S) 
    { 
        String output = "";   
        int n = S.length();
        for (int i = 0; i < n; i++)
        {
            if (S.charAt(i) == ' ')
                output = output + "0";
            else
            {
                int position = S.charAt(i) - 'A';
                output = output + str[position];
            }
        }
     
        return output;
    }
    
}

/**
 * 
 * https://www.geeksforgeeks.org/reverse-a-string-using-recursion/
 * 
 */

package Stacksandqueues;

public class ReverseStringUsingStack {

    String res="";
    
    public String reverse(String s){
        
        if(s == "" || s.length()==0)
            return s;
        res = res + s.charAt(s.length()-1);
        reverse(s.substring(0,s.length()-1));
        return res;
    }
    
}

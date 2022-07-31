/**
 * 
 * https://leetcode.com/problems/roman-to-integer/discuss/1283708/Java-Without-Map-or-3ms
 * https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * 
 */

package Strings;

public class RomanNumbertoInteger  {

    int valueOf(char c)
    {
        if(c=='I')
            return 1;
        if(c=='V')
            return 5;
        if(c=='X')
            return 10;
        if(c=='L')
            return 50;
        if(c=='C')
            return 100;
        if(c=='D')
            return 500;
        if(c=='M')
            return 1000;
        return -1;
    }
    
    public int romanToDecimal(String str) {
        // code here
        
        int res=0;
        for(int i=0;i<str.length()-1;i++)
        {
            
            int a = valueOf(str.charAt(i));
            int b = valueOf(str.charAt(i+1));
            if(a<b)
            {
                res-=a;
            }
            else
            {
                res+=a;
            }           
        }
        res += valueOf(str.charAt(str.length()-1)); 
        
        return res;
    }
    
}

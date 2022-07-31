/**
 * Refer C- in Depth, Srivasthava T.B -- Pg:378.
 * 
 * https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/
 * 
 * logic is if n is power of '2' then there will be only one-bit set, and if  do (n-1) then all the bits to right of that one set bit will be flipped.
 * If we do and of (n), (n-1), then if result is 0 then 'n' is power of '2' else not.
 *  For example for 4 ( 100) and 16(10000), we get the following after subtracting 1 
    3 –> 011 
    15 –> 01111
 */

package BitManipulation;

public class CheckIfGivenNumberIsPowerOf2 {
    
    public static boolean isPowerofTwo(long n){
        
        if(n<=0)    // if n <= 0, it means the number is not power of 2.
            return false;
        
        // logic is if n is power of '2' then there will be only one-bit set, and if  do (n-1) then all the bits to right of that one set bit will be flipped.
        // If we do and of (n), (n-1), then if result is 0 then 'n' is power of '2' else not.
        return((n&(n-1))==0);   
    }

    public static void main(String[] args)
    {
         System.out.println(isPowerofTwo(31L) ? "Yes" : "No");
         System.out.println(isPowerofTwo(64L) ? "Yes" : "No");
         
    }
}

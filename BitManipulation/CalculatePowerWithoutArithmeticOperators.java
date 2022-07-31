/**
 * 
 * https://www.geeksforgeeks.org/calculate-square-of-a-number-without-using-and-pow/  --> see the approach of bitwise operators.
 * 
 *          If n is even, it can be written as
                    n = 2*x     --> even number can be written as 2*x
                    n2 = (2*x)2 = 4*x2
            If n is odd, it can be written as 
                    n = 2*x + 1     --> odd number can be written as 2*x+1
                    n2 = (2*x + 1)2 = 4*x2 + 4*x + 1

    square(n) = 0 if n == 0
    if n is even 
        square(n) = 4*square(n/2) 
    if n is odd
        square(n) = 4*square(floor(n/2)) + 4*floor(n/2) + 1 
 */
package BitManipulation;

public class CalculatePowerWithoutArithmeticOperators {

    
    public static int square(int n)
    {
        // Base case    
        if(n ==0 )
            return n;

        // Handle negative number
        if(n <0)
            n=-n;
        
        // Get floor(n/2) using
        // right shift
       int  x= n>>1;

       // If n is odd
        if(n%2!=0)
            return ((square(x)<<2) + ((x)<<2) +1);
        else // If n is even
            return (square(x)<<2);
    }

    public static void main(String args[])
    {
        // Function calls
        for (int n = 1; n <= 5; n++)
            System.out.println("n = " + n  + " n^2 = " + square(n));
    }

}

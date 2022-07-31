/**
 * We need to count number of bits to be flipped to convert A to B.
 * Logic is, We do XOR of A,B and store the result in temp variable.
 * Now we count the set bits in result of A^B.  
 * 
 * https://www.geeksforgeeks.org/count-number-of-bits-to-be-flipped-to-convert-a-to-b/
 */

package BitManipulation;

public class CountBitsToBeFlippedFromAToB {

    public static int countBitsFlip(int a, int b){
        
        int xorRes = a^b;
        int count =0;
        while(xorRes>0)
        {
            xorRes = xorRes & (xorRes-1);
            count++;
        }
        return count;
        
    }
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        System.out.print("#Bits to flip: "+countBitsFlip(a, b));
    }


}

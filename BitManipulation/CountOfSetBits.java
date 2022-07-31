/**
 * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * Refer 1st logic and brian-Kernighan’s logic
 */


package BitManipulation;

public class CountOfSetBits {

    // logic is if last bit is set and if that is anded with '1' we get count as '1'. If last bit is 0 and if that is anded with 1, we get '0'
    // So, we check last bit every time by anding with '1' and right shift the number everytime by '1'. So if number is greater than 0, then this proceeds forward.
    // T.C == O(logn) --> bcz if the number is 'n' then 'logn' bits will be set.
    public static int countSetBits(int n)
    {
        int count =0;
        while(n != 0)       // this counts for negative numbers also. If we put n>0, this wont work for negative numbers.
        {
            count = count + (n&1);
            n = n>>1;
        }
        return count;
    }

    // 1  Initialize count: = 0
    // 2  If integer n is not zero
    //   (a) Do bitwise & with (n-1) and assign the value back to n
    //       n: = n&(n-1)
    //   (b) Increment count by 1
    //   (c) go to step 2
    // 3  Else return count

    // if we do n&(n-1), when we do (n-1), all set bits to the right of rightmost '1' will be flipped including the rightmost '1' itself. 
    // So 10 in binary is 00001010 and  9 in binary is 00001001 . Now if we do n&(n-1), then we will unset all those bits which are flipped by doing n-1.
    // We repeat this process by assigning n&(n-1) to 'n' itself and looping

    // 2nd method
    public static int countSetBits2ndMethd(int n)
    {
        int count =0;
        while(n != 0)   // this counts for negative numbers also. If we put n>0, this wont work for negative numbers.
        {
            count++;
            n =  n&(n-1);
        }
        return count;
    }
    public static void main(String args[])
    {
        int i = 9;
        System.out.println("1st: "+countSetBits(i));
        System.out.println("2nd : "+countSetBits2ndMethd(i));
    }
    
}



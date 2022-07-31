/**
 * https://www.youtube.com/watch?v=pnx5JA9LNM4      ---> watch this video for clear understanding.
 * https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 * 
 * Logic is we xor all elements in array and store in a variable. Repeated elements will cancel out eachother.
 * Now we will find the rightmost set bit of the above obtained xor of all elements.
 * As all th repeated ele will be canceled out,only two numbers which are not repeated will be in the result of above XOR.
 * So, if you & the above resulting xor with negative value of itself, we get a number which will have the rightmost bit set.
 * And if a bit is set in Xor of the above result it means, that bit is set in one of the non-repeating numbers, while not set in one of thr non-repeating numbers.
 * So, now using this result of & with negative value of itself, we can segregate the numbers in array as the rightmost bit set and rightmost bit not set.
 * So, We will loop again and segregate the numbers.
 * 
 */

package BitManipulation;

public class FindTwoNonRepeatingEle {

    public static int[] singleNumber(int[] nums)
    {
        int arrayXor=0;
        int res [] = new int [2];
        for(int i: nums)
        {
            arrayXor= arrayXor^i;
        }
        
        arrayXor = arrayXor & (-arrayXor);  // it will give us the only rightmost set bit.
        
        int rbs=0;
        int rbns=0;
        
        for(int i : nums)
        {
            if((arrayXor&i )> 0)
                rbs = rbs^i;
            else
                rbns = rbns^i;
        }
        if(rbs<rbns)
        {
            res[0]=rbs;
            res[1]= rbns;
        }
        else
        {
            res[0]=rbns;
            res[1]=rbs;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 3, 7, 9, 11, 2, 3, 11};
       
        int res[] =singleNumber(arr);
        for(int i : res)
        {
            System.out.println("The non-repeating element "+ i);
        }
    }
    
}

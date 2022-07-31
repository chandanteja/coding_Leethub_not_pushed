/**
 * Logic is we 'and' the last bit and do right shift of 'n', we count the number of 1s and also position.
 * 
 *  https://www.geeksforgeeks.org/find-position-of-the-only-set-bit/ --> refer this.
 */

package BitManipulation;

public class FindPositionOfSetBit {
    
    static int findPosition(int n) {
        int count=0;
        int pos=0;
        
        while(n>0)
        {
            if((n&1) == 1  && count <=1)
            {
                count++;
            }
            n = n>>1;
             pos++;
            
        }
        if(count ==1)
            return pos;
        else 
        return -1;
    }

    public static void main(String[] args)
    {
        int n = 16;
        int pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
 
        n = 12;
        pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
 
        n = 128;
        pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
    }
}

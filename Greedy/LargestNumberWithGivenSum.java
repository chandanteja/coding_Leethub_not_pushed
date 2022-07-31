/**
 * 
 *  https://www.youtube.com/watch?v=J6LI2wW8FCw     --> watch this.
 * 
 * 
 */

package Greedy;

public class LargestNumberWithGivenSum {

    static String largestNumber(int n, int sum)
    {
        StringBuffer res=new StringBuffer();
        for(int i=0;i<n;i++)
        {
            int val=0;
            if(sum>9)
            {
                val=9;
                sum = sum-9;
            }
            else
            {
                val=sum;
                sum=0;
            }
            res.append(Integer.valueOf(val).toString());
        }
        if(sum>0)
            return "-1";
        return res.substring(0);
    }
    
}

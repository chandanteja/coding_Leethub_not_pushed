/**
 * 
 * We use binary search to find square root of a number.
 * 
 * Refer Self paced DSA course.
 * 
 */

package SearchingAndSorting;

public class SquareRoot {

    long floorSqrt(long x)
	 {
	        long ans=0L;
	        long low=0;
	        long hi=x;
	        
	     
	        while(low<=hi)
	        {
	            long mid = (low+hi)/2;
	            
	            long mid_sqr = mid*mid;
	            
	            if(mid_sqr==x)
	                return mid;
	            else if(mid_sqr>x)
	            {
	                hi=mid-1;
	            }
	            else
	            {
	                low=mid+1;
	                ans=mid;
	            }
	        }
	        return ans;
	 }
    
}

/**
 * 
 *  refer Self paced DSA course --> searching topic.
 * 
 * 
 * 
 */

package SearchingAndSorting;

public class MedianOf2SortedArrays {

    public static int findMedian(int arr[], int n, int brr[], int m)
    {
        
        return median( arr, n, brr, m);
    }
    static int median(int a1[],int n,int a2[],int m)
    {
        int begin1=0;
        int end1=n;
        
        while(begin1<=end1)
        {
           int i1 = (begin1 + end1) / 2;
			int i2 = ((n + m + 1) / 2 )- i1;

			int min1 = (i1 == n)?Integer.MAX_VALUE:a1[i1];
			int max1 = (i1 == 0)?Integer.MIN_VALUE:a1[i1 - 1];
			
			int min2 = (i2 == m)?Integer.MAX_VALUE:a2[i2];
			int max2 = (i2 == 0)?Integer.MIN_VALUE:a2[i2 - 1];
			
            if(max1<=min2 && max2<=min1)
            {
                if((n + m) % 2 == 0)
					return (int)Math.floor((/*(double)*/Math.max(max1, max2) + Math.min(min1, min2)) / 2);
				else
					return /*(double)*/ (int)Math.floor(Math.max(max1, max2));
            }
            else if(max1>min2)
                end1=i1-1;
            else
                begin1 = i1+1;
                
            
        }
        return -1;
    }
    
}

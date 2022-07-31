/**
 * 
 * https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * 
 */

package Arrays;

class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

public class FindMaxAndMinEle {

    static pair getMinMax(long a[], long n)  
    {
        long min= a[0];
        long max=a[0];
        
        for(int i=1;i<n;i++)
        {
            if(a[i]>max)
                max = a[i];
            else if(a[i]<min) 
                min=a[i];
        }
        
        return new pair(min,max);
    }
    
}

/**
 * 
 * https://www.youtube.com/watch?v=kKEX4P53MyY  --> refer this video for logic.
 * 
 * 
            https://www.youtube.com/watch?v=kKEX4P53MyY

            1. fix a row and calculate global max for row, then calculate for [row, row+1], then [row, row+1, row+2], then [row, row+1 ....  row+n-1]
            2. this row can vary from 0 to n.
            3. among all global max find the overall global max.
       
 * 
 * 
 */

package DP;

import java.util.Arrays;

public class MaxSumRectangeIn2DMatrix {


    int kadanes(int ans[])
    {
        int n = ans.length;
        int localmax=ans[0];
        int globalmax= ans[0];
        
        for(int i=1;i<n;i++)
        {
            localmax= Math.max(ans[i],localmax+ans[i]);
            globalmax = Math.max(localmax,globalmax);
        }
        return globalmax;
    }
    
    int maximumSumRectangle(int R, int C, int M[][]) {
        int max= Integer.MIN_VALUE;
        for(int i=0;i<R;i++)
        {
            // ArrayList<Integer> ans = new ArrayList<>(C);
            // Collections.fill(ans,0);
            int ans[] = new int[C];
            Arrays.fill(ans,0);
            
            for(int j=i;j<R;j++)
            {
                for(int k=0;k<C;k++)
                {
                    ans[k] = ans[k]+M[j][k];
                    
                }
                max = Math.max(max,kadanes(ans));
            }
        }
        return max;
    }
    
}

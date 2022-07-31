/**
 * 
 * Refer GFG Self paced DSA course --> Matrix.
 * 
 * We take 4-pointers and move the pointers as per how we need to traverse the matrix i.e say, 1st row then last col then last row(reverse) and then first col (reverse).
 * We move the pointers accordingly.
 * 
 */

package Matrix;

import java.util.ArrayList;

public class SpiralTraversalOfMatrix {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int top=0,left=0,right=c-1, bottom=r-1; // 4-pointers pointing to 4-corners of matrix and will be used to print the matrix spirally.
        
        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
            {
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
                res.add(matrix[i][right]);
            right--;
            
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                    res.add(matrix[bottom][i]);
                
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
    
}

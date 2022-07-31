/**
 * 
 * https://leetcode.com/problems/reshape-the-matrix/
 * 
 * 
 * https://leetcode.com/problems/reshape-the-matrix/solution/       --> solution
 */
public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if((m*n)!=(r*c))
                return mat;
        int res[][] = new int[r][c];
        
        int colPtr=0,rowPtr=0;
        
         // given matrix is traversed row wise i.e row-1 then row-2 and also the resultant matrix shud also be filled row wise.
        // so first column_pointer must be incremented then when it reaches till the end of the given column size then only we should go to
        // next row, means then only we should increment row_pointer.
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(colPtr == c) // if colPtr reaches the column size given for resultant matrix we will reset column ptr and increment row ptr
                {
                    colPtr=0;
                    rowPtr++;
                }
                // in all other usual cases increment column pointer first.
                colPtr++;
                res[rowPtr][colPtr-1] = mat[i][j];            
            }
        }
        
        return res;
    }
    
}


/**
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/solution/
 * 
 * 
 * Approach-1:  
 * 
 * We use extra space in form of set where we store row and col. numbers of (row,col) where we find '0'.
 * 
 * We will traverse the matrix again and we check with the set if the cell content needs to be made as '0'. If either row number or column number is found in the set we will set the cell value to 0.
 * 
 * Approach-2:
 * 
 * The idea is that we can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero. This means for every cell instead of going to M+N cells and setting it to zero we just set the flag in two cells. 
 * If the first cell of a row is set to zero this means the row should be marked zero. If the first cell of a column is set to zero this means the column should be marked zero.
 * But we will get issue with cell[0][0] bcz it will be the same cell for row-0 and column-0. So if we assume cell[0][0] acts as row-0 flag then we need to take another variable to check if column-0 needs to be made 0 or not.
 * 
 */


class Solution {

    public void setZeroes(int[][] matrix) {
      Boolean firstCol = false;
      int R = matrix.length;
      int C = matrix[0].length;
  
      for (int i = 0; i < R; i++) {
  
        // Since first cell for both first row and first column is the same i.e. matrix[0][0]
        // We can use an additional variable for either the first row/column.
        // For this solution we are using an additional variable for the first column.
        // and using matrix[0][0] for the first row.
        if (matrix[i][0] == 0) {
                firstCol = true;
        }
        
        // here we are starting from j=1 column, bcz if j=0 then the case i=0,j=0 matrix[0][0] is covered in the above if-condition where we set firstCol value. 
        for (int j = 1; j < C; j++) {
          // If an element is zero, we set the first element of the corresponding row and column to 0
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            matrix[i][0] = 0;
          }
        }
      }
  
      // Iterate over the array once again and using the first row and first column, update the elements.
      for (int i = 1; i < R; i++) {
        for (int j = 1; j < C; j++) {
          if (matrix[i][0] == 0 || matrix[0][j] == 0) {
            matrix[i][j] = 0;
          }
        }
      }
  
      // See if the first row needs to be set to zero as well
      if (matrix[0][0] == 0) {
        for (int j = 0; j < C; j++) {
          matrix[0][j] = 0;
        }
      }
  
      // See if the first column needs to be set to zero as well
      if (firstCol) {
        for (int i = 0; i < R; i++) {
          matrix[i][0] = 0;
        }
      }
    }
  }
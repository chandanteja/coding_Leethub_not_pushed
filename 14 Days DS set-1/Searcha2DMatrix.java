/**
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * 
 */

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        // finalize the row i.e we need to find the row in which the target can be there if it is present in given matrix.
        // to finalize the row: search in which row the target element is present in. for this first element of the row must be smaller than
        // target and last element of the row must be larger than the target.
        int resultRow = -1;
        int c = matrix[0].length;
        
        for(int i=0;i<matrix.length;i++)
        {
            if(target>= matrix[i][0] && target<= matrix[i][c-1])
            {
                resultRow=i;
                break;
            }
        }
        if(resultRow == -1)           // if resultRow is not found then it means all elements are either larger than target or smaller than target.
                return false;         // and you cant find the target. thus return false.
                
        
        int low = 0;
        int hi = c-1;
        int mid;
        
        // once the resultRow is found then perform binary search on that row.
        // binary search in the row.
        while(low <= hi)
        {
            mid = low+(hi-low)/2;
            
            if(target==matrix[resultRow][mid])
                    return true;
            else if(target > matrix[resultRow][mid])
                    low = mid+1;
            else
                hi = mid-1;
        }
        return false;
    }
    
}

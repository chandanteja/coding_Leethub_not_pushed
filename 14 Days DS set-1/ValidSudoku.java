import java.util.HashSet;

/**
 * 
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * We are given a 9x9 sudoku board and given rules, we need to tell whether given sudoku board is valid or not.
 * 
 * 
 * 
 */

public class ValidSudoku {

         // for the given sudoku we have to check if the filled cells are valid or not. means 
        // no 2 cells have same number in each row/col/3x3 grid.
        // so we check this in 3 steps:
        // 1. row wise
        // 2. col wise
        // 3. 3x3 grid wise

    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character> hs = new HashSet<>();
        
        // row wise verification
        
        for(int i=0;i<board.length;i++) // for each row.
        {
            hs.clear(); // clear the set after each row.
            
            for(int j=0;j<board[i].length;j++)  // for the above choosen row - search all cols
            {
                if( board[i][j]!='.' && hs.contains(board[i][j]) )  // '.' means no number. ignore that cell and if the number is already there in hashset then return false as its not valid sudoku
                {
                    return false;
                }
                else 
                    if(board[i][j]!='.')
                         hs.add(board[i][j]);
            }
        }
        
        
        // column wise
        for(int i=0;i<board.length;i++) 
        {
             hs.clear();    // clear the map after each col.
            for(int j=0;j<board[i].length;j++)  // search col wise.
            {
                // here we do board[j][i] --> this will search column wise as elements will be accessed column wise.
                if( board[j][i]!='.' && hs.contains(board[j][i]) )  // '.' means no number. ignore that cell and if the number is already there in hashset then return false as its not valid sudoku
                {
                    return false;
                }
                else if(board[j][i]!='.')
                    hs.add(board[j][i]);
                
            }
            
        }
        
        // 3x3 sub-boards
        for(int row=0;row<9;row+=3) // check each 3x3 grid row wise.
        {
            for(int col=0;col<9;col+=3)
            {
                hs.clear(); // clear the map after each 3x3 grid.
                
                for(int i=0+row;i<3+row;i++)
                {
                    for(int j=0+col;j<3+col;j++)
                    {
                        if( board[i][j]!='.' && hs.contains(board[i][j]) )  // '.' means no number. ignore that cell and if the number is already there in hashset then return false as its not valid sudoku
                        {
                            return false;
                        }
                        else if(board[i][j]!='.')
                            hs.add(board[i][j]);
                    }
                }
            }
        }
        
        
        return true;
    }
    
}


/**
 * 
 * https://leetcode.com/problems/valid-sudoku/solution/ --> solution
 * 
 * Leetcode editorial solution
 * ===========================
 * Algorithm

Initialize a list containing 9 hash sets, where the hash set at index r will be used to store previously seen numbers in row r of the sudoku. Likewise, initialize lists of 9 hash sets to track the columns and boxes too.

Iterate over each position (r, c) in the sudoku. At each iteration, if there is a number at the current position:

Check if the number exists in the hash set for the current row, column, or box. If it does, return false, because this is the second occurrence of the number in the current row, column, or box.

Otherwise, update the set responsible for tracking previously seen numbers in the current row, column, and box. The index of the current box is (r / 3) * 3 + (c / 3) where / represents floor division.

If no duplicates were found after every position on the sudoku board has been visited, then the sudoku is valid, so return true.
 * 
 * 
 * class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
 * 
 * 
 */

/*
  
  https://leetcode.com/problems/design-tic-tac-toe/solution/ --> premium qns

  QNS:
  ----
  
Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
Follow up:
Could you do better than O(n2) per move() operation?

 

Example 1:

Input
["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
Output
[null, 0, 0, 0, 0, 0, 0, 1]

Explanation
TicTacToe ticTacToe = new TicTacToe(3);
Assume that player 1 is "X" and player 2 is "O" in the board.
ticTacToe.move(0, 0, 1); // return 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

ticTacToe.move(0, 2, 2); // return 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

ticTacToe.move(2, 2, 1); // return 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

ticTacToe.move(1, 1, 2); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

ticTacToe.move(2, 0, 1); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

ticTacToe.move(1, 0, 2); // return 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
  
  
 */

/*
Brute force:

Approach 1: Optimized Brute Force
Intuition

The simplest and most intuitive approach is to check on every move if the current player has won. Each player makes a move by marking a cell on the board. The given cell is located at row row and column col. The 4 ways in which a player can win are as follows:

Player has marked the entire row given by row.
Player has marked the entire column given by col.
Player has marked the diagonal beginning at the top left corner of the board and ending at the bottom right corner.
Player has marked the anti-diagonal beginning at the top right corner of the board and ending at the bottom left corner.

How do we identify which cells lie on the diagonal or anti-diagonal?

Every cell on the main diagonal has a unique property; the row index equals the column index. Similarly, for every cell on the anti-diagonal, the value of the column index is equal to n - row - 1.


Every move, we will check if any of the above conditions are true. If yes, we declare the current player as the winner and finish the game.

Algorithm

For a given n, initialize a 2-dimensional array board of size n * n with the values of all elements set to 0.

Every move, mark the row and col on the board with the current player's id player.

Now, we will check the following conditions to see if the current player has won.

Check if all of the cells for the given row are marked by the current player. To do so, we must iterate over all the columns ranging from index 0 to n - 1, keeping the row index constant.

Check if all of the positions for the given col are marked by the current player. To do so, we must iterate over all the rows ranging from index 0 to n - 1, keeping the col index constant.

Check if the main diagonal is completely marked by the current player.

From the above intuition, we know that for each cell on the main diagonal, the row and col indices are equal. Thus, every cell on the diagonal can be given by board[row][row].

Check if the anti-diagonal is completely marked by the current player.

From the above intuition for each cell in the anti-diagonal, the value of the col index is equal to n - row - 1. Thus, every cell in the anti-diagonal could be given by board[row][n - row - 1].

If the current player wins the game, then return player. Otherwise, return 0 indicating that no one has won the game.

class TicTacToe {

    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        // check if the player wins
        if ((checkRow(row, player)) ||
            (checkColumn(col, player)) ||
            (row == col && checkDiagonal(player)) ||
            (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        // No one wins
        return 0;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }
}

Complexity Analysis

Time Complexity: O(n), as for every move we are iterating over n cells 4 times to check for each of the column, row, diagonal row, and anti-diagonal. This gives us time complexity of O(4⋅n) which is equivalent to O(n).

Space Complexity: O(n^2)  as we are using 2-dimensional array board of size n * n.

*/

/*

Approach 2: Optimised Approach
Intuition

Our goal is to find if a player has won by marking an entire row, column, diagonal, or anti diagonal cells. Can we find this in constant time without iterating over each of the horizontal, vertical, and diagonal rows on every move? Yes! Let's find out how.

Let's break the problem into 2 parts,

First, on every move, we must determine whether a player has marked all of the cells in a row or column. In other words, we could say that, if there are n rows and n columns on a board, the player must have marked a certain row or column n times.

From the given conditions, we know that a move is always valid and placed on an empty cell. Hence, we can be certain that if a player has marked any row n times, they must have marked a different column each time.

Second, on every move, we must determine whether a player has marked all of the cells on the main diagonal or anti-diagonal. Irrespective of the size of the board, there can only be one diagonal and one anti-diagonal.

Also, there are always n cells on the diagonal or anti-diagonal. Thus, to win by either of these, a player must have marked the cells on the diagonal or anti-diagonal n times.

Let's understand how can we implement this approach.

Algorithm

From the above intuition, we understand that we must use a data structure to count how many times a player has marked a particular row, column, or diagonal.

To implement the first part, for each player, we will build an array rows of size n, where rows[i] stores the number of times a player has marked a cell on the i^{th}i 
th
  row. Likewise, for each player, we will also build an array cols of size n.

Winning Condition: The player will win if either rows[i] or cols[j] is equal to n after the player has marked the cell on the i^{th}i 
th
  row and j^{th}j 
th
  column.

Let player1Rows and player1Cols be the rows and cols array for player 1. Likewise, let player2Rows and player2Cols be the rows and cols for player 2. The following figure illustrates the process for move(0, 0, 1) and move(0, 2, 2).


To implement the second part, we can use a similar idea as above. Since there is only one diagonal and one anti-diagonal, for each player, we only need 2 integer variables diagonal and antiDiagonal. These variables will store how many times a cell has been marked on each of the diagonals.

Winning Condition: After a player has marked a cell on a diagonal row, we check if the value of variable diagonal for that player is equal to n. Similarly, after a player has marked a cell on an anti-diagonal row, we check if the value of variable antiDiagonal for that player is equal to n.

Let player1Diagonal and player1AntiDiagonal be the diagonal and antiDiagonal variables for player 1. Likewise, let player2Diagonal and player2AntiDiagonal be the diagonal and antiDiagonal for player 2. The following figure illustrates the process for move(1, 1, 1) and move(2, 0, 2).



Question - Can we further optimize this algorithm?"

Yes, we can. Since there are only 2 players, when implementing part 1, we can use the same data structure to store the marked row and column values for both players.

One way to implement this is to increment the count when player 1 marks a cell and decrement the count when player 2 marks a cell. With this, we can say that, if the value of rows[i] is equal to n, player 1 has marked i^{th}i 
th
  row n times. Similarly, if the value of rows[i] is equal to -n, then player 2 has marked the i^{th}i 
th
  row n times.

Similar logic applies to the columns and diagonals.


The ALGORITHM can be IMPLEMENTED as follows:

For a given n, initialize arrays rows and cols of size n with the value of every element set to 0.

For each move, we must increment/decrement the row, column, diagonal, and anti-diagonal according to who is the current player and which cell was marked. If the current player is player 1, we increment the value and if it is player 2, we decrement the value.

Note: If we apply simple math rules, we can increment or decrement the values irrespective of the player.

We can use an additional variable currentPlayer with the value 1 for player 1 and -1 for player 2, and add the value of currentPlayer to the current row, column, diagonal and anti-diagonal.

As a final step, we must determine whether the current player has won the game. If any row, column, diagonal, or anti-diagonal is equal to n (for player 1) or -n (for player 2) then the current player has won the game.

Also, rather than having separate conditions to check whose turn it is, we can check the absolute values.

*/

package Amazonlist;

public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}


import java.util.Arrays;

public class NQueens {

    // Function to solve the N-Queens problem
    public boolean solveNQueens(int board[][], int col) {
        // Base case: If all queens are placed
        if (col >= board.length) {
            return true;
        }

        // Try placing the queen in each row of the current column
        for (int i = 0; i < board.length; i++) {
            // Check if placing a queen at (i, col) is safe
            if (isSafe(board, i, col)) {
                // Place queen at (i, col)
                board[i][col] = 1;

                // Recursively place queens in the rest of the columns
                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                // If placing the queen at (i, col) leads to a dead-end,
                // backtrack by removing the queen from (i, col)
                board[i][col] = 0;
            }
        }
        
        // If the queen cannot be placed in any row for this column, return false
        return false;
    }

    // Function to check if placing a queen at (row, col) is safe
    private boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Safe to place queen at (row, col)
        return true;
    }

    // Utility function to print the solution
    public void printSolution(int board[][]) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Main function to initialize and solve the N-Queens problem
    public static void main(String[] args) {
        int N = 8; // N-Queens problem (N=8)

        // Initialize the chessboard with 0s (empty)
        int[][] board = new int[N][N];

        NQueens nQueens = new NQueens();

        // Try solving the problem and print the solution if exists
        if (nQueens.solveNQueens(board, 0)) {
            System.out.println("Solution found:");
            nQueens.printSolution(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}

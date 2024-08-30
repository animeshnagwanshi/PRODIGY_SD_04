public class task4 {
    

        public static void main(String[] args) {
            // Example Sudoku puzzle (0 represents empty cells)
            int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
    
            if (solveSudoku(board)) {
                System.out.println("Sudoku solved successfully:");
                printBoard(board);
            } else {
                System.out.println("Sudoku puzzle cannot be solved.");
            }
        }
    
        // Method to solve Sudoku puzzle using backtracking
        public static boolean solveSudoku(int[][] board) {
            int n = board.length;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == 0) {
                        for (int num = 1; num <= 9; num++) {
                            if (isValid(board, row, col, num)) {
                                board[row][col] = num;
                                if (solveSudoku(board)) {
                                    return true;
                                } else {
                                    board[row][col] = 0; // Reset if num does not lead to a solution
                                }
                            }
                        }
                        return false; // No valid number found
                    }
                }
            }
            return true; // All cells are filled
        }
    
        // Method to check if placing a number is valid
        public static boolean isValid(int[][] board, int row, int col, int num) {
            // Check row
            for (int x = 0; x < board.length; x++) {
                if (board[row][x] == num) {
                    return false;
                }
            }
    
            // Check column
            for (int x = 0; x < board.length; x++) {
                if (board[x][col] == num) {
                    return false;
                }
            }
    
            // Check 3x3 sub-grid
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i + startRow][j + startCol] == num) {
                        return false;
                    }
                }
            }
    
            return true;
        }
    
        // Method to print the Sudoku board
        public static void printBoard(int[][] board) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        }
    
    
    
}

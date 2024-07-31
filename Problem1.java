//Time = O(n!)
//Space = O(n)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>(); 
        int[] queens = new int[n]; 
        Arrays.fill(queens, -1); // Fill the array with -1, indicating that no queen has been placed yet
        solveNQueens(solutions, queens, 0, n); // Call the recursive helper function to find all solutions
        return solutions;
    }
    
    private void solveNQueens(List<List<String>> solutions, int[] queens, int row, int n) {
        if (row == n) { // If all rows have been filled with queens, a solution has been found
            solutions.add(generateBoard(queens, n)); // Add the solution to the list of solutions
        } else {
            for (int col = 0; col < n; col++) { // Try placing a queen in each column of the current row
                if (isValid(queens, row, col)) { // If the placement is valid, proceed
                    queens[row] = col; // Place the queen in the current column of the current row
                    solveNQueens(solutions, queens, row + 1, n); // Recursively try to place queens on the next row
                    queens[row] = -1; // Remove the queen from the current row and backtrack
                }
            }
        }
    }
    
    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) { // Check all previously placed queens
            int j = queens[i]; // Get the column position of the queen on the i-th row
            if (j == col || Math.abs(j - col) == Math.abs(i - row)) { // If the new queen is in the same column or diagonal as a previously placed queen, it is an invalid placement
                return false;
            }
        }
        return true; // The placement is valid
    }
    
    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>(); // Initialize a list to represent the solution board
        for (int i = 0; i < n; i++) { // For each row
            char[] row = new char[n];
            Arrays.fill(row, '.'); // Fill the row with empty cells
            row[queens[i]] = 'Q'; // Place a queen in the column specified by the queens array
            board.add(new String(row)); // Add the row to the board list
        }
        return board; // Return the completed board
    }
}

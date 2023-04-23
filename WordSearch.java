//Time = 
//Space = O(n), n is the length of the input word

class Solution {
    public boolean exist(char[][] board, String word) {
        // Get the number of rows and columns in the board
        int m = board.length;
        int n = board[0].length;
        
        // Loop through every cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell contains the first letter of the word
                if (board[i][j] == word.charAt(0)) {
                    // Check if the word can be found starting from this cell
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        // The word cannot be found on the board
        return false;
    }
    
    // Helper method to search for the word starting from a particular cell
    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        int m = board.length;
        int n = board[0].length;
        // If the current cell is out of bounds or does not contain the k-th letter of the word
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(k)) {
            return false;
        }
        // If the entire word has been found
        if (k == word.length() - 1) {
            return true;
        }
        // Temporarily mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';
        // Recursively search for the remaining letters of the word in the adjacent cells
        boolean res = dfs(board, i + 1, j, word, k + 1) ||
                      dfs(board, i - 1, j, word, k + 1) ||
                      dfs(board, i, j + 1, word, k + 1) ||
                      dfs(board, i, j - 1, word, k + 1);
        // Restore the original value of the current cell
        board[i][j] = temp;
        return res;
    }
}

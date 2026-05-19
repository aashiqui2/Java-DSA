public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";
        System.out.println("Brute Force Result: " + exist(board, word));

        System.out.println("Optimal Result: " +exist(board, word));
    }

    /*public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word,
        int r, int c, int idx, boolean[][] vis) 
    {
        if (idx == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;

        if (vis[r][c] || board[r][c] != word.charAt(idx))
            return false;

        vis[r][c] = true;

        boolean found = dfs(board, word, r + 1, c, idx + 1, vis) ||
                dfs(board, word, r - 1, c, idx + 1, vis) ||
                dfs(board, word, r, c + 1, idx + 1, vis) ||
                dfs(board, word, r, c - 1, idx + 1, vis);

        vis[r][c] = false; // backtrack
        return found;
    }*/

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;

        if (board[r][c] != word.charAt(idx))
            return false;

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(board, word, r + 1, c, idx + 1) ||
                dfs(board, word, r - 1, c, idx + 1) ||
                dfs(board, word, r, c + 1, idx + 1) ||
                dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp; // backtrack
        return found;
    }
}

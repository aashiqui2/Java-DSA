public class NumberOfIsland {
    public static void dfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {
        // boundary + water + visited check
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] != '1') {
            return;
        }

        vis[i][j] = true;

        // Explore 4 directions
        dfs(i - 1, j, vis, grid, n, m); // top
        dfs(i, j + 1, vis, grid, n, m); // right
        dfs(i + 1, j, vis, grid, n, m); // bottom
        dfs(i, j - 1, vis, grid, n, m); // left
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, vis, grid, n, m); // visit this entire island
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        System.out.println("Output 1: " + numIslands(grid1));
        // Expected: 1

        // -------- Test Case 2 --------
        char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println("Output 2: " + numIslands(grid2));

    }
}

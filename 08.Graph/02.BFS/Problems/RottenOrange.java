import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class RottenOrange {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        int ans = 0;

        // Push all initially rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            int time = p.tm;

            ans = Math.max(ans, time);

            // Top
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                q.add(new Pair(i - 1, j, time + 1));
                vis[i - 1][j] = true;
            }
            // Right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                q.add(new Pair(i, j + 1, time + 1));
                vis[i][j + 1] = true;
            }
            // Bottom
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                q.add(new Pair(i + 1, j, time + 1));
                vis[i + 1][j] = true;
            }
            // Left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                q.add(new Pair(i, j - 1, time + 1));
                vis[i][j - 1] = true;
            }
        }

        // Check for remaining fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int grid[][] = { { 0, 1, 2 }, 
        //                  { 0, 1, 2 }, 
        //                  { 2, 1, 1 } 
        //                };

        int grid[][] = { { 2, 1, 1 }, 
                         { 1, 1, 0 }, 
                         { 0, 1, 1 } 
                       };
        int ans = orangesRotting(grid);
        System.out.println(ans);
    }
}

//! Link(994.Rotten Oranges)[https://leetcode.com/problems/rotting-oranges/description/]
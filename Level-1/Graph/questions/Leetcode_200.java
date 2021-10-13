package questions;

public class Leetcode_200 {
    class Solution {

        public void dfs(char[][] grid, int[][] dir, int sr, int sc) {
            // 1 ke group ko 0 kar rhe h 
            grid[sr][sc] = '0';
            for (int d = 0; d < 4; d++) {
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1')
                    dfs(grid, dir, r, c);
            }
        }

        public int numIslands(char[][] grid) {
            int n = grid.length, m = grid[0].length, componentCount = 0;

            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

            // Iterating the matrix
            // and finding the position where there is '1'
            // and calling dfs and incrementing the count
            // count = kitne 1 k thukre hai matrix me
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, dir, i, j);
                        componentCount++;
                    }
                }
            }
            return componentCount;
        }
    }
}

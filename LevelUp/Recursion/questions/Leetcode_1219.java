package questions;

public class Leetcode_1219 {
    // TC : O(n^4)
    class Solution {
        public int getMaximumGold(int[][] grid) {
            int maxGold = 0;
            int n = grid.length, m = grid[0].length;
            int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > 0) {
                        maxGold = Math.max(maxGold, getMaximumGold_(grid, i, j, dir));
                    }
                }
            }

            return maxGold;
        }

        public int getMaximumGold_(int[][] grid, int sr, int sc, int[][] dir) {
            int maxGold = 0;

            int val = grid[sr][sc];
            grid[sr][sc] = -grid[sr][sc];
            for (int d = 0; d < dir.length; d++) {
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] > 0) {
                    int recGold = getMaximumGold_(grid, r, c, dir);
                    if (recGold > maxGold)
                        maxGold = recGold;
                }
            }
            grid[sr][sc] = -grid[sr][sc];

            return maxGold + val;
        }
    }
}

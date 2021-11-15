public class Leetcode_1351 {
    class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0;
            int i = grid.length - 1;
            int j = grid[0].length - 1;
            while (i >= 0 && j >= 0) {
                if (grid[i][j] < 0) {
                    count++;
                    if (j - 1 < 0) {
                        i--;
                        j = grid[0].length - 1;
                    } else {
                        j--;
                    }
                } else {
                    i--;
                    j = grid[0].length - 1;
                }
            }
            return count;
        }
    }
}

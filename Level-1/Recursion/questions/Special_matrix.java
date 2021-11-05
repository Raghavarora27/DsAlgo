// https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
// This solution will not be passed in GFG Compiler (Time Limit Exceeded)
// Dp solution will be passed 

class Solution {
    int mod = 1e9 + 7;

    public int FindWays(int n, int m, int[][] blocked_cells) {
        int[][] dir = { { 0, 1 }, { 1, 0 } };
        int[][] board = new int[n][m];
        for (int[] cell : blocked_cells) {
            int i = cell[0] - 1;
            int j = cell[1] - 1;

            board[i][j] = 1;
        }
        if (board[0][0] == 1 || board[n - 1][m - 1] == 1)
            return 0;
        int count = maze(0, 0, board, dir);
        return count;
    }

    public int maze(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if (sr == n - 1 && sc == m - 1) {
            return 1;
        }

        int count = 0;
        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0) {
                count = (count % mod + maze(r, c, board, dir) % mod) % mod;
            }
        }
        board[sr][sc] = 0;
        return count;
    }
}
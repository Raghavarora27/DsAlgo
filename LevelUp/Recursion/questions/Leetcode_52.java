package questions;

public class Leetcode_52 {
    class Solution {
        public int totalNQueens(int n) {
            boolean[][] box = new boolean[n][n];
            return NQueen(0, n, box);
        }

        public int NQueen(int bno, int tnq, boolean[][] box) {
            if (tnq == 0)
                return 1;

            int count = 0;
            int n = box.length, m = box[0].length;
            for (int b = bno; b < n * m; b++) {
                int r = b / m;
                int c = b % m;

                if (IsSafeToPlaceQueen(box, r, c)) {
                    box[r][c] = true;
                    count += NQueen(b + 1, tnq - 1, box);
                    box[r][c] = false;
                }
            }
            return count;
        }

        public boolean IsSafeToPlaceQueen(boolean[][] box, int sr, int sc) {
            int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

            int n = box.length, m = box[0].length;
            for (int d = 0; d < dir.length; d++) {
                for (int rad = 1; rad < n; rad++) {
                    int r = sr + rad * dir[d][0];
                    int c = sc + rad * dir[d][1];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        if (box[r][c])
                            return false;
                    } else
                        break;
                }
            }
            return true;
        }
    }
}

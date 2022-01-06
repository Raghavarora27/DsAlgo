import java.util.*;

public class Leetcode_51 {
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public boolean isSafeToPlaceQueen(boolean[][] box, int sr, int sc) {
            int[][] dir = { { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };
            int n = box.length, m = box[0].length;
            for (int i = 0; i < dir.length; i++) {
                for (int rad = 1; rad < n; rad++) {
                    int r = sr + rad * dir[i][0];
                    int c = sc + rad * dir[i][1];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        if (box[r][c]) {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
            return true;
        }

        public void nQueen_01(boolean[][] box, int bno, int tnq, List<String> asf) {
            if (tnq == 0) {
                List<String> base = new ArrayList<>();
                for (int r = 0; r < box.length; r++) {
                    String x = "";
                    for (int c = 0; c < box.length; c++) {
                        if (box[r][c]) {
                            x += "Q";
                        } else {
                            x += ".";
                        }
                    }
                    base.add(x);
                }
                res.add(base);
                return;
            }

            int n = box.length, m = box[0].length;
            for (int i = bno; i < n * m; i++) {
                int r = i / m;
                int c = i % m;
                if (isSafeToPlaceQueen(box, r, c)) {
                    box[r][c] = true;
                    nQueen_01(box, i + 1, tnq - 1, asf);
                    box[r][c] = false;
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            List<String> asf = new ArrayList<>();
            int tnq = n;
            boolean[][] box = new boolean[n][n];
            nQueen_01(box, 0, tnq, asf);
            return res;
        }
    }
}

package questions;

public class Leetcode_52 {
    // 381 ms
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

    // 91 ms
    class Solution2 {

        public boolean[] row, col, diag, adiag;

        public int totalNQueens(int n) {
            row = new boolean[n];
            col = new boolean[n];
            diag = new boolean[n + n - 1];
            adiag = new boolean[n + n - 1];
            return Nqueen_05(0, n, n, n);
        }

        public int Nqueen_05(int bno, int tnq, int n, int m) { // single combination
            if (tnq == 0)
                return 1;

            int count = 0;
            for (int b = bno; b < n * m; b++) {
                int r = b / m;
                int c = b % m;
                if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                    row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                    count += Nqueen_05(b + 1, tnq - 1, n, m);
                    row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
                }
            }

            return count;
        }
    }

    // 1 ms
    class Solution3 {
        // ek row me queen place karne ke baad direct next row me ja rhe h
        // and place karne se phele col diag and adiag check kar rhe h safe h ya nhi

        public boolean[] row, col, diag, adiag;

        public int totalNQueens(int n) {
            row = new boolean[n];
            col = new boolean[n];
            diag = new boolean[n + n - 1];
            adiag = new boolean[n + n - 1];
            return Nqueen_06(0, n, n, n);
        }

        public int Nqueen_06(int floor, int tnq, int n, int m) { // single combination
            if (tnq == 0)
                return 1;

            int count = 0;
            for (int room = 0; room < m; room++) {
                int r = floor, c = room;
                if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                    col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                    count += Nqueen_06(floor + 1, tnq - 1, n, m);
                    col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
                }
            }

            return count;
        }
    }
}

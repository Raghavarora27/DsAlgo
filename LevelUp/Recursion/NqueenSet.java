public class NqueenSet {
    public static int Nqueen_01(boolean[][] box, int bno, int tnq, String asf) { // single combination
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (IsSafeToPlaceQueen(box, r, c)) {
                box[r][c] = true;
                count += Nqueen_01(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }

        return count;
    }

    public static boolean IsSafeToPlaceQueen(boolean[][] box, int sr, int sc) {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        
        int n = box.length, m = box[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) { // checking in line
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (box[r][c]) // means another queen is sitting in the way
                        return false;
                } else
                    break;
            }
        }

        return true; // no other queen is in the way and hence this is safe to place the queen
    }
    
    // permutation
    public static int Nqueen_02(boolean[][] box, int tnq, String asf) { // single permutation
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!box[r][c] && IsSafeToPlaceQueen2(box, r, c)) {
                // checking phele se queen ho nhi h && safe bhi h queen
                // ko baithna - by checking all the directions of queen
                box[r][c] = true;
                count += Nqueen_02(box, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }

        return count;
    }

    public static boolean IsSafeToPlaceQueen2(boolean[][] box, int sr, int sc) {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = box.length, m = box[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
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

    static boolean[] row, col, diag, adiag;

    // Is Safe Optimization, combination
    public static int Nqueen_03(int bno, int tnq, String asf, int n, int m) { // single combination
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += Nqueen_03(b + 1, tnq - 1, asf + "(" + r + "," + c + ") ", n, m);
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    // Is Safe Optimization, Permutation
    public static int Nqueen_04(int tnq, String asf, int n, int m) { // single Permutation
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += Nqueen_04(tnq - 1, asf + "(" + r + "," + c + ") ", n, m);
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    // Stop/break as we get the first answer/combination of queens
    public static int Nqueen_05(int bno, int tnq, String asf, int n, int m) { // single combination
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (count == 1)
                break;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += Nqueen_05(b + 1, tnq - 1, asf + "(" + r + "," + c + ") ", n, m);
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    /// Combination Optimised
    public static int Nqueen_06(int n, int m, int floor, int tnq, String asf) {
        // if (tnq == 0 || floor >= n) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }
        // return 0;
        // }

        int count = 0;

        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += Nqueen_06(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        // count += Nqueen_06(n, m, floor + 1, tnq, asf);
        return count;
    }

    /// permutation Optimised
    public static int Nqueen_07(int floor, int tnq, String asf, int n, int m) {
        if (tnq == 0 || floor >= n) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += Nqueen_07(0, tnq - 1, asf + "(" + r + "," + c + ") ", n, m);
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        count += Nqueen_07(floor + 1, tnq, asf, n, m);
        return count;
    }

    static int r = 0, c = 0, d = 0, ad = 0;

    // using bits (fully optimised)
    public static int Nqueen_08(int n, int m, int floor, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int room = 0; room < m; room++) {
            int row = floor, col = room;
            if ((c & (1 << col)) == 0 && (d & (1 << (row + col))) == 0 && (ad & (1 << (row - col + m - 1))) == 0) {
                c ^= (1 << col);
                d ^= (1 << (row + col));
                ad ^= (1 << (row - col + m - 1));
                count += Nqueen_08(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                c ^= (1 << col);
                d ^= (1 << (row + col));
                ad ^= (1 << (row - col + m - 1));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // boolean[][] box = new boolean[4][4];
        // int bno = 0;
        // int tnq = 4;
        // String asf = "";
        // System.out.println(Nqueen_01(box, bno, tnq, asf));
        // System.out.println();
        // System.out.println();
        // System.out.println(Nqueen_02(box, tnq, asf));

        // nqueen3
        int n = 4, tnq = 4;
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[n + n - 1];
        adiag = new boolean[n + n - 1];
        String asf = "";
        // System.out.println(Nqueen_03(0, tnq, asf, row.length, col.length));
        // System.out.println(Nqueen_05(0, tnq, asf, row.length, col.length));
        System.out.println(Nqueen_06(row.length, col.length, 0, tnq, asf));
        // System.out.println(Nqueen_07(0, tnq, asf, row.length, col.length));
    }
}
import java.util.*;

// Leetcode_37
public class sudoku {
    public class pair {
        int r = 0;
        int c = 0;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public boolean isValidToPlaceNumber(char[][] board, int r, int c, int num) {
        // row
        for (int i = 0; i < 9; i++)
            if (board[r][i] - '0' == num)
                return false;

        // col
        for (int i = 0; i < 9; i++)
            if (board[i][c] - '0' == num)
                return false;

        // mat
        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] - '0' == num)
                    return false;
            }
        }

        return true;
    }

    public boolean solveSudoku(char[][] board, int idx, ArrayList<pair> arr) {
        if (idx == arr.size()) {
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for (int num = 1; num <= 9; num++) {
            if (isValidToPlaceNumber(board, r, c, num)) {
                board[r][c] = (char) (num + '0');
                if (solveSudoku(board, idx + 1, arr))
                    return true;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<pair> arr = new ArrayList<>();
        // we are storing all the empty places of sudoku board in the arr
        // taki hum directly unhi places pe jaye jo empty hai
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    arr.add(new pair(i, j)); // i * 9 + j
                }
            }
        }

        solveSudoku(board, 0, arr);
    }

    public static int[] rows, cols;
    public static int[][] mat;

    public boolean solveSudokuBits(char[][] board, int idx, ArrayList<pair> arr) {
        if (idx == arr.size()) {
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for (int num = 1; num <= 9; num++) {
            int mask = (1 << num);
            if ((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                board[r][c] = (char) (num + '0');
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

                if (solveSudoku(board, idx + 1, arr))
                    return true;

                board[r][c] = '.';
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;
            }
        }

        return false;
    }

    public void solveSudokuBits(char[][] board) {
        ArrayList<pair> arr = new ArrayList<>();
        rows = new int[9];
        cols = new int[9];
        mat = new int[3][3];    

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    arr.add(new pair(i, j)); // i * 9 + j
                } else {
                    int mask = 1 << (board[i][j] - '0');
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                }
            }
        }

        solveSudokuBits(board, 0, arr);
    }
}
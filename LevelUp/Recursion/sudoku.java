import java.util.ArrayList;

public class sudoku {

    public static class pair {
        int r = 0;
        int c = 0;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isValidToPlaceNumber(char[][] board, int r, int c, int num) {
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

    public static boolean solveSudoku(char [][] board,int idx,ArrayList<pair> arr) {
        if(idx == arr.size())
            return true;
        
        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for(int num = 1; num <= 9;num++){
            if(isValidToPlaceNumber(board, r, c, num)){
                board[r][c] = (char)(num + '0');
                if(solveSudoku(board, idx + 1, arr))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static void solveSudoku(char [][] board){
        ArrayList<pair> arr = new ArrayList<>();
        //  we are storing all the empty places of sudoku board in the arr
        // taki hum directly unhi places pe jaye jo empty hai
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.')
                    arr.add(new pair(i,j));
            }
        }

        solveSudoku(board, 0, arr);
    }
}
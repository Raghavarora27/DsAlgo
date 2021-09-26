import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int [][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        String [] dirS = {"t","l","d","r"};
        floodfill(0, 0,arr, "",dir,dirS);
        scn.close();
    }
    
    public static int floodfill(int sr, int sc,int[][] board, String ans,int [][]dir,String [] dirS) {
        if(sr == board.length-1 && sc == board[0].length-1){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        board[sr][sc] = 1;
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0){
                count += floodfill(r,c,board,ans + dirS[d],dir,dirS);
            }
        }
        board[sr][sc] = 0;
        return count;

    }
}

import java.util.*;

public class ShortestLength_Floodfill{
    public static int Shortest_Length(int sr,int sc,int [][] board,int [][] dir){
        int m=board[0].length,n=board.length;
        if(sr == n-1 && sc == m-1){
            return 0;
        }
        
        int ShortestLen = (int)1e9;
        board[sr][sc] = 1;
        
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length){
                if(board[r][c] == 0){
                    int recAns = Shortest_Length(r,c,board,dir);
                    if(recAns != (int)1e9 && recAns + 1 < ShortestLen){
                        ShortestLen = recAns + 1;
                    }
                }
            }
        }
        board[sr][sc] = 0;
        return ShortestLen;
    }
    
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int [][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        int [][] board = {{0,0,0},{0,0,1},{0,0,0}};
        System.out.println(Shortest_Length(0,0,board,dir));
    }
}
import java.util.*;

public class FloodFill_Jumps{
    // we can have n no of directions
    // we are also blocking the paths and then unblocking it 
    // we can have any radius(or can make n no of jumps)
    public static int floodfill_jumps(int sr,int sc,int [][] board,String ans,String [] dirS,int [][] dir){
        int m=board[0].length,n=board.length;
        if(sr == n-1 && sc == m-1){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        board[sr][sc] = 1;
        for(int d=0;d<dir.length;d++){
            for(int rad=1;rad<=Math.max(n,m);rad++){
                int r = sr + rad*dir[d][0];
                int c = sc + rad*dir[d][1];
                
                if(r >= 0 && c >= 0 && r < board.length && c < board[0].length){
                    if(board[r][c] == 0)
                        count += floodfill_jumps(r,c,board,ans + rad + dirS[d],dirS,dir);
                }
            }
        }
        board[sr][sc] = 0;
        return count;
    }
    
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int [][] dir4 = {{0,1},{0,-1},{-1,0},{1,0}};
        String [] dir4S = {"r","l","t","d"};
        int [][] board = new int[3][3];
        int [][] dir8 = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        String [] dir8S = {"r","l","t","d","n","s","w","e"};
        System.out.println(floodfill_jumps(0,0,board,"",dir8S,dir8));
    }
}
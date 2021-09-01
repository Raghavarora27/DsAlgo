import java.io.*;
	import java.util.*;

	public class Print_MazePath {

	    public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            printMazePaths(0,0,n-1,m-1,"");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static int printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr == dr && sc == dc){
	            System.out.println(psf);
	           return 1;
	        }
	        
	        int count = 0;
	        
	        if(sc + 1 <= dc){
	            count += printMazePaths(sr,sc+1,dr,dc,psf + 'h');
	        }
	        
	        if(sr + 1 <= dr){
	            count += printMazePaths(sr+1,sc,dr,dc,psf + 'v');
	        }
	        
	        return count;
	    }

	}

// Common and easy Method for Maze path and similar questions
// same code can be used , we just have to change the direction array

// public class Main{
    
//     public static int mazePath(int sr,int sc,int er,int ec,String ans,String [] dirS,int [][] dir){
//         if(sr == er && sc == ec){
//             System.out.println(ans);
//             return 1;
//         }
        
//         int count = 0;
        
//         for(int d=0;d<dir.length;d++){
//             int r = sr + dir[d][0];
//             int c = sc + dir[d][1];
            
//             if(r >= 0 && c >= 0 && r <= er && c <= ec){
//                 count += mazePath(r,c,er,ec,ans + dirS[d],dirS,dir);
//             }
//         }
//         return count;
//     }
    
    
//     public static Scanner sc = new Scanner(System.in);
//     public static void main(String [] args){
//         int [][] dir = {{1,0},{0,1},{1,1}};
//         String [] dirS = {"V","H","D"};
//         System.out.println(mazePath(0,0,2,2,"",dirS,dir));
//     }
// }
import java.io.*;
	import java.util.*;

	public class Print_MazePathWithJumps {

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
	        
	        for(int jump = 1;sc + jump <= dc;jump++){
	            count += printMazePaths(sr,sc+jump,dr,dc,psf + 'h' + jump);
	        }
	        for(int jump = 1;sr + jump <= dr;jump++){
	            count += printMazePaths(sr+jump,sc,dr,dc,psf + 'v' + jump);
	        }
	        
	        for(int jump = 1;sc + jump <= dc && sr + jump <= dr;jump++){
	            count += printMazePaths(sr+jump,sc+jump,dr,dc,psf + 'd' + jump);
	        }
	        return count;
	    }

	}
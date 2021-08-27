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
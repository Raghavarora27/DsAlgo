import java.io.*;
import java.util.*;

public class Get_MazePathWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> ans = getMazePathswithjumps(0,0,n-1,m-1);
        System.out.print(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePathswithjumps(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> myans = new ArrayList<>();
        for(int jump = 1;sc + jump <=  dc;jump++){
            ArrayList<String> horizontal = getMazePathswithjumps(sr,sc+jump,dr,dc);
            
            for(String s : horizontal){
                myans.add("h" + jump + s);
            }        
        }
        
        for(int jump = 1;sr + jump <=  dr;jump++){
            ArrayList<String> vertical = getMazePathswithjumps(sr+jump,sc,dr,dc);
            
            for(String s : vertical){
                myans.add("v" + jump + s);
            }        
        }
        
        for(int jump=1;sr + jump <=  dr && sc + jump <= dc;jump++){
            ArrayList<String> diagonal = getMazePathswithjumps(sr+jump,sc+jump,dr,dc);
            
            for(String s : diagonal){
                myans.add("d" + jump + s);
            }        
        }
        
        
        return myans;
    }

}
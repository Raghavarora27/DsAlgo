import java.lang.reflect.Array;
import java.util.*;
// 3 Directions - H,D,V
public class Get_MazePathFollowUp{
    
    public static ArrayList<String> get_mazePath(int sr,int sc,int dr,int dc){
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(sc + 1 <= dc){
            ArrayList<String> rec1 = get_mazePath(sr, sc + 1, dr, dc);
            for(String s : rec1)
                ans.add('h' + s);
        }
        if(sc + 1 <= dc && sr + 1 <= dr){
            ArrayList<String> rec2 = get_mazePath(sr + 1, sc + 1, dr, dc);
            for(String s : rec2)
                ans.add('d' + s);
        }
        if(sr + 1 <= dr){
            ArrayList<String> rec3 = get_mazePath(sr + 1, sc, dr, dc);
            for(String s : rec3)
                ans.add('v' + s);
        }

        return ans;
    }

    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> ans = get_mazePath(0,0,n-1,m-1);
        System.out.println(ans);
    }
}
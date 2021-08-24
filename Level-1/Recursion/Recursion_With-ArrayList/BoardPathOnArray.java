import java.io.*;
import java.util.*;

// when no.of jumps are given in array and rest question is same
public class BoardPathOnArray {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int [] moves = {2,4,6,5};
        ArrayList<String> ans = getStairPaths(n,moves);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n,int [] moves) {
        if(n <= 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0;i <= moves.length  && (n-moves[i]) >= 0; i++){
            ArrayList<String> myrec = getStairPaths(n-moves[i],moves);
            
            for(String s : myrec)
                ans.add(moves[i] + s);
        }
        
        return ans;
    }

}
import java.io.*;
import java.util.*;

public class BoardPath {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n <= 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(int dice = 1;dice <= 6  && (n-dice) >= 0; dice++){
            ArrayList<String> myrec = getStairPaths(n-dice);
            
            for(String s : myrec)
                ans.add(dice + s);
        }
        
        return ans;
    }

}
import java.io.*;
import java.util.*;

public class PrintStairpath {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(printStairPaths(n,""));
    }

    public static int printStairPaths(int n, String path) {
        if(n == 0){
            System.out.println(path);
            return 1;
        }
        
        int count = 0;
        
        for(int jump = 1;jump <= 3 && n-jump >= 0;jump++){
            count += printStairPaths(n - jump,path + jump);
        }
        return count;
    }

}
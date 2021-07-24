import java.io.*;
import java.util.*;

public class printDecreasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printdecreasing(n);
    }

    public static void printdecreasing(int n){
        if(n < 1)
            return;
        
        System.out.println(n);
        printdecreasing(n-1);
    }

}
import java.io.*;
import java.util.*;

public class Print_Subsequence {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        printSS(str,"");
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.print(ans);
            System.out.println();
            return;
        }
        
        char ch = str.charAt(0);
        String code = str.substring(1);
        
        printSS(code,ans + ch);
        printSS(code,ans);
    }

}
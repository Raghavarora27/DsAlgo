import java.util.*;

// Void Type Recursion
// upar jate hue answer create karke print kar rhe h
public class Print_Subsequence {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        printSS(str,"");
        // System.out.println(printSS1(str,""));
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
    

    // In this we are returning the number of answers made while going up in recursion
    public static int printSS1(String str, String ans) {
        if(str.length() == 0){
            System.out.print(ans);
            System.out.println();
            return 1;
        }
        
        char ch = str.charAt(0);
        String code = str.substring(1);
        int count = 0;

        count += printSS1(code,ans + ch);
        count += printSS1(code,ans);
        return count;
    }

}
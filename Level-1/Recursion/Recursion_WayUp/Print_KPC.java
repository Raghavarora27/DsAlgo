import java.util.*;

public class Print_KPC{
    
    public static int KPC(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        char ch = str.charAt(0); // 4
        String code = keypad[ch - '0']; // pqrs
        
        for(int i=0;i<code.length();i++){
            count += KPC(str.substring(1),ans + code.charAt(i));
        }
        
        return count;
    }
    
    public static String [] keypad = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        String str = sc.nextLine();
        int count = KPC(str,"");
        // System.out.println(count);
    }
}
import java.util.*;

public class Encoding{
    
    public static int encoding(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        char ch = str.charAt(0);
        
        if(ch == '0')
            return 0;
        
        count += encoding(str.substring(1),ans + (char)('a' + ch - '1'));
            
            
        if(str.length() > 1){
            int num = (ch - '0')*10 + (str.charAt(1) - '0');
            if(num <= 26){
                count += encoding(str.substring(2),ans + (char)('a' + num - 1));    
            }
        }    
        return count;
    }
    
    public static Scanner sc  = new Scanner(System.in);
    public static void main(String [] args){
        String str = sc.nextLine();
        System.out.println(encoding(str,""));
    }
    
}
import java.util.*;

public class DecodeWays{
    
    public static ArrayList<String> DecodeWays(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        if(str.charAt(0) == '0')
            return new ArrayList<>();
        
        char ch1 = str.charAt(0);
        ArrayList<String> myrec1 = DecodeWays(str.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for(String s : myrec1){
            ans.add((char)('a' + (ch1 - '0') - 1 ) + s);
        }
        
        if(str.length() > 1){
            int num = ((ch1 - '0')*10 + (str.charAt(1) - '0'));
            if(num <= 26){
                ArrayList<String> myrec2 = DecodeWays(str.substring(2));
                for(String ss : myrec2){
                    ans.add((char)('a' + num - 1 ) + ss);
                }
            }
        }
    
        return ans;
    }
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        String str = sc.nextLine();
        ArrayList<String> ans = DecodeWays(str);
        System.out.println(ans);
    }
}
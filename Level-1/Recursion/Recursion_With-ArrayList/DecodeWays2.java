import java.util.*;

public class DecodeWays2 {
    public static String [] nokiakeyPad= {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> DecodeWays(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch1 = str.charAt(0);
        String word = nokiakeyPad[ch1 - '0'];
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> myrec1 = DecodeWays(str.substring(1));
        for (int i = 0; i < word.length(); i++) {
            for (String s : myrec1) {
                ans.add(word.charAt(i) + s);
            }
        }

        if (str.length() > 1) {
            char ch2 = str.charAt(1);
            int num = ((ch1 - '0') * 10 + (ch2 - '0'));
            if (num == 10 || num == 11) {
                ArrayList<String> myrec2 = DecodeWays(str.substring(2));
                word = nokiakeyPad[num];
                for (int i = 0; i < word.length(); i++) {
                    for (String s : myrec2) {
                        ans.add(word.charAt(i) + s);
                    }
                }
            }
        }

        return ans;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        ArrayList<String> ans = DecodeWays(str);
        System.out.println(ans);
    }
}
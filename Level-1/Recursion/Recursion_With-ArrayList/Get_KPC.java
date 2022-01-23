import java.util.*;

public class Get_KPC {

    public static String[] nokiakeyPad = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> GetKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String code = nokiakeyPad[ch - '0'];

        ArrayList<String> recAns = GetKPC(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            for (String s : recAns)
                myAns.add(code.charAt(i) + s);
        }

        return myAns;
    }

    // without substring function
    public static ArrayList<String> getKPC(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int n = (str.charAt(idx) - '0');
        String code = nokiakeyPad[n];

        ArrayList<String> recAns = getKPC(str, idx + 1);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < code.length(); i++) {
            for (String s : recAns)
                ans.add(code.charAt(i) + s);
        }

        return ans;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        ArrayList<String> ans = GetKPC(str);
        System.out.println(ans);
    }
}
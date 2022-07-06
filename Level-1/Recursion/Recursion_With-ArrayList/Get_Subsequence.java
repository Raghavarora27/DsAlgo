import java.util.*;

public class Get_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> ans = GetSubsequence(str);

        System.out.println(ans);
        sc.close();
    }

    public static ArrayList<String> GetSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = GetSubsequence(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>(recAns);
        for (String s : recAns)
            myAns.add(ch + s);

        return myAns;

    }

    // without substring function
    public static ArrayList<String> GetSubsequence2(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = GetSubsequence2(str, idx + 1);
        ArrayList<String> ans = new ArrayList<>(recAns);
        for (String s : recAns)
            ans.add(str.charAt(idx) + s);

        return ans;
    }
}
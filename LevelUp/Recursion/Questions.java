import java.util.HashSet;

public class Questions {

    public static int c = 0;

    public static void friendsPair(int count, int n, boolean[] used, String asf) {
        if (count == n) {
            System.out.println(c++ + "." + asf);
            return;
        }

        int fup = 1; // first un-used person
        while (fup <= n && used[fup])
            fup++;

        used[fup] = true;
        friendsPair(count + 1, n, used, asf + "(" + fup + ") ");

        for (int pp = fup + 1; pp <= n; pp++) {
            if (!used[pp]) {
                used[pp] = true;
                friendsPair(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }

        used[fup] = false;
    }

    // hum maximum letter ki length nikal ke ,ei wala loop utna chala sakte h ,isse thoda optimise ho jayega
	public static int wordBreak(String str, String ans, HashSet<String> dict){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int ei = 0;ei < str.length();ei++){
            String pWord = str.substring(0, ei + 1);
            if(dict.contains(pWord)){
                count += wordBreak(str.substring(ei + 1), ans + pWord + " ", dict);
            }
        }

        return count;
	}


    public static String max = "";

    public static void findMaximum(String str, int k, int ii) {
        if (k == 0)
            return;

        for (int i = ii; i < str.length(); i++) {
            int idx = -1;
            char maxCh = '0';
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j) && maxCh < str.charAt(j)) {
                    idx = j;
                    maxCh = str.charAt(j);
                }
            }

            if (idx != -1) {
                for (int j = idx; j < str.length(); j++) {
                    if (str.charAt(j) == maxCh) {
                        String temp = swap(str, i, j);
                        if (isGreater(temp, max))
                            max = temp;
                        findMaximum(temp, k - 1, i + 1);
                    }
                }
            }
        }
    }

    public static boolean isGreater(String temp, String str) {
        if (temp.length() > str.length())
            return true;
        else if (temp.length() < str.length())
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (temp.charAt(i) > str.charAt(i))
                return true;
            else if (temp.charAt(i) < str.charAt(i))
                return false;
        }

        return true;
    }

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char c1 = str.charAt(i);
        char c2 = str.charAt(j);

        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);

        return sb.toString();
    }
}
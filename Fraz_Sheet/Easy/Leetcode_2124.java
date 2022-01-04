package Easy;

public class Leetcode_2124 {
    public String SortString(String s) {
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    public boolean checkString(String s) {
        String Sort_String = SortString(s);
        return s.equals(Sort_String);
    }
}

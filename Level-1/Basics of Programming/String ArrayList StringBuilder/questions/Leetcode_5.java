public class Leetcode_5 {
    class Solution {
        // O(n^3) ---- TLE
        public String longestPalindrome(String str) {
            int maxLen = 0;
            String ans = "";
            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    if (Ispalindrome(str, i, j)) {
                        int len = j - i + 1;
                        if (len > maxLen) {
                            ans = str.substring(i, j + 1);
                            maxLen = len;
                        }
                    }
                }
            }
            return ans;
        }

        public boolean Ispalindrome(String str, int si, int ei) {
            while (si <= ei) {
                if (str.charAt(si++) != str.charAt(ei--))
                    return false;
            }
            return true;
        }
    }
}
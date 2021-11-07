public class Leetcode_151 {
    class Solution {
        public String reverseWords(String str) {
            StringBuilder sb = new StringBuilder();
            String[] arr = str.trim().split("\\s+");

            sb.append(arr[arr.length - 1]);

            for (int i = arr.length - 2; i >= 0; i--) {
                sb.append(" " + arr[i]);
            }
            return sb.toString();
        }
    }

    class Solution2 {
        public String reverseWords(String s) {
            s = s.trim() + " ";
            String ans = "", word = "";
            int fg = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    fg = 0;
                    word += s.charAt(i);
                } else if (fg == 0) {
                    fg = 1;
                    ans = word + " " + ans;
                    word = "";
                }
            }
            return ans.trim();
        }
    }
}

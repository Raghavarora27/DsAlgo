public class Leetcode_125 {
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch))
                    ch = Character.toLowerCase(ch);

                if (Character.isLetterOrDigit(ch))
                    sb.append(ch);
            }

            return IsPalindrome(sb.toString());
        }

        public boolean IsPalindrome(String s) {
            if (s.length() == 0 || s.length() == 1)
                return true;

            int i = 0;
            int j = s.length() - 1;

            while (i < j) {
                if (s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}

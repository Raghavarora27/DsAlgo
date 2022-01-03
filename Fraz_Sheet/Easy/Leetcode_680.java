package Easy;
public class Leetcode_680 {
    class Solution {
        public boolean validPalindrome(String s) {
            if (s.length() == 1)
                return true;
            boolean deleted = false;
            int Left = 0, Right = s.length() - 1;
            return IsPalindrome(s, deleted, Left, Right);
        }

        public boolean IsPalindrome(String str, boolean deleted, int Left, int Right) {

            while (Left < Right) {
                if (str.charAt(Left) != str.charAt(Right)) {
                    if (deleted)
                        return false;

                    return IsPalindrome(str, true, Left + 1, Right) || IsPalindrome(str, true, Left, Right - 1);
                }
                Left++;
                Right--;
            }
            return true;
        }
    }
}
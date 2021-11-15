public class Leetcode_58 {
    class Solution {
        public int lengthOfLastWord(String str) {
            int n = str.length() - 1;

            while (str.charAt(n) == ' ') {
                n--;
            }

            int count = 0;
            while (str.charAt(n) != ' ') {
                count++;

                if (n - 1 < 0)
                    break;

                n--;
            }

            return count;
        }
    }
}

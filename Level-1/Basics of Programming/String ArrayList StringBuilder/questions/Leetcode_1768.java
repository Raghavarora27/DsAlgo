package questions;

public class Leetcode_1768 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (n > 0 && m > 0) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));

                i++;
                n--;
                m--;
            }

            while (n-- > 0) {
                sb.append(word1.charAt(i++));
            }

            while (m-- > 0) {
                sb.append(word2.charAt(i++));
            }

            return sb.toString();
        }
    }
}

package questiions;

import java.util.Arrays;

public class Leetcode_72 {
    class Solution {
        public int minDistance(String word1, String word2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0)
                return dp[n][m] = (n == 0) ? m : n;

            if (dp[n][m] != -1)
                return dp[n][m];

            int Insert = minDistance(word1, word2, n, m - 1, dp) + 4;
            int Delete = minDistance(word1, word2, n - 1, m, dp) + 5;
            int Replace = minDistance(word1, word2, n - 1, m - 1, dp) + 7;

            if (word1.charAt(n - 1) == word2.charAt(m - 1))
                return dp[n][m] = Replace;
            else
                return dp[n][m] = Math.min(Math.min(Insert, Delete), Replace) + 1;
        }

        public int minDistance(String word1, String word2) {
            int n = word1.length(), m = word2.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int[] d : dp)
                Arrays.fill(d, -1);

            return minDistance(word1, word2, n, m, dp);
        }
    }
}

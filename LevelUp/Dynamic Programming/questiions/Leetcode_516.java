package questiions;

public class Leetcode_516 {
    class Solution {
        public int longestPalindromeSubseq(String str) {
            int n = str.length();
            int[][] dp = new int[n][n];
            int ans = lpss(str, 0, n - 1, dp);
            return ans;
        }

        public static int lpss(String str, int i, int j, int[][] dp) {
            if (i >= j)
                return dp[i][j] = (i == j) ? 1 : 0;

            if (dp[i][j] != 0)
                return dp[i][j];

            if (str.charAt(i) == str.charAt(j))
                return dp[i][j] = lpss(str, i + 1, j - 1, dp) + 2;
            else
                return dp[i][j] = Math.max(lpss(str, i + 1, j, dp), lpss(str, i, j - 1, dp));
        }

    }
}

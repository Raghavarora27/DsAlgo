import java.util.Arrays;

public class StringSet {

    // 516 Longest Palindromic Substring
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

    public static int lpss_Tabu(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2; // lpss(str, i + 1, j - 1, dp) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[I][J];
    }

    public static int longestPalindromicSubseq(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        int ans = lpss(str, 0, n - 1, dp);
        return ans;
    }

    // 1143 Longest Common Subsequence
    public static int lcss(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            dp[n][m] = lcss(str1, str2, n - 1, m - 1, dp) + 1;
        else
            dp[n][m] = Math.max(lcss(str1, str2, n - 1, m, dp), lcss(str1, str2, n, m - 1, dp));

        return dp[n][m];
    }

    public static int lcss_tabu(String str1, String str2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m] + 1; // lcss(str1, str2, n - 1, m - 1, dp) + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];
    }

    public static int longestCommonSubseq(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int ans = lcss(str1, str2, n, m, dp);
        return ans;
    }
}
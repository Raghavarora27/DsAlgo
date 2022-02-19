import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
                    dp[n][m] = dp[n - 1][m - 1] + 1; // lcss(str1, str2, n - 1, m - 1, dp) + 1;
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

    /// 115
    public static int numDistinct(String s, String t, int n, int m, int[][] dp) {
        if (m == 0)
            return dp[n][m] = 1;

        if (n < m)
            return dp[n][m] = 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        int a = numDistinct(s, t, n - 1, m - 1, dp);
        int b = numDistinct(s, t, n - 1, m, dp);

        if (s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = a + b;
        else
            return dp[n][m] = b;
    }

    public static int numDistinct_DP(String s, String t, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (m == 0) {
                    dp[n][m] = 1;
                    continue;
                }

                if (n < m) {
                    dp[n][m] = 0;
                    continue;
                }

                int a = dp[n - 1][m - 1]; // numDistinct(s, t, n - 1, m - 1, dp);
                int b = dp[n - 1][m]; // numDistinct(s, t, n - 1, m, dp);

                if (s.charAt(n - 1) == t.charAt(m - 1))
                    dp[n][m] = a + b;
                else
                    dp[n][m] = b;
            }
        }
        return dp[N][M];
    }

    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)
            Arrays.fill(d, -1);

        return numDistinct(s, t, n, m, dp);
    }

    // 72
    public int minDistance(String word1, String word2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return dp[n][m] = (n == 0) ? m : n;

        if (dp[n][m] != -1)
            return dp[n][m];

        int Insert = minDistance(word1, word2, n, m - 1, dp);
        int Delete = minDistance(word1, word2, n - 1, m, dp);
        int Replace = minDistance(word1, word2, n - 1, m - 1, dp);

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

    /// Follow Up-1 --> Cost of Insert Operation = a, Cost of replace Operation = b,
    /// Cost of Delete Operation = c
    /// Find the minimum cost to convert str1 to str2
    /// cost : {insert = a, replace = b, delete = c}
    public int minDistance_02(String word1, String word2, int n, int m, int[] cost, int[][] dp) {
        if (n == 0 || m == 0)
            return dp[n][m] = (n == 0) ? m * cost[0] : n * cost[2];

        if (dp[n][m] != -1)
            return dp[n][m];

        int Insert = minDistance_02(word1, word2, n, m - 1, cost, dp);
        int Delete = minDistance_02(word1, word2, n - 1, m, cost, dp);
        int Replace = minDistance_02(word1, word2, n - 1, m - 1, cost, dp);

        if (word1.charAt(n - 1) == word2.charAt(m - 1))
            return dp[n][m] = Replace;
        else
            return dp[n][m] = Math.min(Math.min(Insert + cost[0], Delete + cost[2]), Replace + cost[1]);
    }

    // 44
    public String removeStars(String str) {
        if (str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        int i = 1;
        while (i < str.length()) {
            while (i < str.length() && sb.charAt(sb.length() - 1) == '*' && str.charAt(i) == '*')
                i++;

            if (i < str.length())
                sb.append(str.charAt(i));
            i++;
        }

        return sb.toString();
    }

    public int isMatch(String s, String p, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            if (n == 0 && m == 0)
                return dp[n][m] = 1; // true
            else if (m == 1 && p.charAt(m - 1) == '*')
                return dp[n][m] = 1;
            else
                return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);

        if (ch1 == ch2 || ch2 == '?') {
            return dp[n][m] = isMatch(s, p, n - 1, m - 1, dp);
        } else if (ch2 == '*') {
            boolean res = false;
            res = res || isMatch(s, p, n - 1, m, dp) == 1; // sequence of characters
            res = res || isMatch(s, p, n, m - 1, dp) == 1; // Empty string

            return dp[n][m] = res ? 1 : 0;
        } else {
            return dp[n][m] = 0;
        }
    }

    public boolean isMatch(String s, String p) {
        p = removeStars(p);
        int n = s.length(), m = p.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)
            Arrays.fill(d, -1);

        return isMatch(s, p, n, m, dp) == 1;
    }

    // 1035
    public int maxUncrossedLines_memo(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (nums1[n - 1] == nums2[m - 1])
            return dp[n][m] = maxUncrossedLines_memo(nums1, nums2, n - 1, m - 1, dp) + 1;
        else
            return dp[n][m] = Math.max(maxUncrossedLines_memo(nums1, nums2, n, m - 1, dp),
                    maxUncrossedLines_memo(nums1, nums2, n - 1, m, dp));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (nums1[n - 1] == nums2[m - 1])
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = maxUncrossedLines(nums1, nums2, n, m, dp);
        return ans;
    }

    // 1458
    public int maximum(int... arr) { // jo bhi isme pass kia hoga vo array ki form me aayega
        int max = arr[0];
        for (int ele : arr)
            max = Math.max(max, ele);

        return max;
    }

    public int maxDotProduct(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = -(int) 1e8;
        }

        if (dp[n][m] != -(int) 1e9)
            return dp[n][m];

        int val = nums1[n - 1] * nums2[m - 1];
        int acceptTwoNumbers = maxDotProduct(nums1, nums2, n - 1, m - 1, dp) + val;
        int a = maxDotProduct(nums1, nums2, n, m - 1, dp);
        int b = maxDotProduct(nums1, nums2, n - 1, m, dp);

        return dp[n][m] = maximum(acceptTwoNumbers, val, a, b);

    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -(int) 1e9);

        return maxDotProduct(nums1, nums2, n, m, dp);
    }

    // O(n^2)
    // 5
    public String longestPalindromicSubstring(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0, maxLen = 0, si = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap == 1 && s.charAt(i) == s.charAt(j)) // agar 2 length ki string ho
                    dp[i][j] = true;
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

                if (dp[i][j]) {
                    count++;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        si = i;
                    }
                }
            }
        }

        return s.substring(si, si + maxLen);
    }

    // longest common substring
    public static int lcsubstring_tabu(String str1, String str2, int N, int M, int[][] dp) {
        int maxLen = 0, ei = 0;
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                    if (dp[n][m] > maxLen) {
                        maxLen = dp[n][m];
                        ei = n - 1;
                    }
                }
            }
        }

        return maxLen;
    }

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = lcsubstring_tabu(str1, str2, n, m, dp);
        return ans;
    }

    // 583
    // Delete Operation for Two Strings
    public int DeleteOperation(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubseq(word1, word2);
    }

    // 132
    public int minCut_memo(String s, int si, boolean[][] isPlaindromeDp, int[] dp) {
        if (isPlaindromeDp[si][s.length() - 1])
            return dp[si] = 0;

        if (dp[si] != -1)
            return dp[si];

        int minAns = (int) 1e8;
        for (int cut = si; cut < s.length(); cut++) {
            if (isPlaindromeDp[si][cut])
                minAns = Math.min(minAns, minCut_memo(s, cut + 1, isPlaindromeDp, dp) + 1);
        }

        return dp[si] = minAns;

    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPlaindromeDp = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    isPlaindromeDp[i][j] = true;
                else if (gap == 1 && s.charAt(i) == s.charAt(j))
                    isPlaindromeDp[i][j] = true;
                else
                    isPlaindromeDp[i][j] = s.charAt(i) == s.charAt(j) && isPlaindromeDp[i + 1][j - 1];
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCut_memo(s, 0, isPlaindromeDp, dp);
    }

    // https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
    public int fun(String s) {
        int emptyCount = 1;
        long aCount = 0, bCount = 0, cCount = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a')
                aCount = aCount + (aCount + emptyCount) % mod;
            else if (ch == 'b')
                bCount = bCount + (bCount + aCount) % mod;
            else if (ch == 'c')
                cCount = cCount + (cCount + bCount) % mod;
        }

        return (int) (cCount % mod);
    }

    // 136
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss);
            len = Math.max(len, ss.length());
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) {
                String substr = s.substring(i, i + l);
                if (set.contains(substr)) {
                    dp[i + l] = true;
                }
            }
        }

        return dp[n];
    }

    public static String lpss_backEngg(String str, int si, int ei, int[][] dp) {
        if (si >= ei)
            return si == ei ? str.charAt(si) + "" : "";

        if (str.charAt(si) == str.charAt(ei))
            return str.charAt(si) + lpss_backEngg(str, si + 1, ei - 1, dp) + str.charAt(ei);
        else if (dp[si + 1][ei] > dp[si][ei - 1])
            return lpss_backEngg(str, si + 1, ei, dp);
        else
            return lpss_backEngg(str, si, ei - 1, dp);
    }

    // 140 -- word break 2
    public void wordbreak_backEngg(String s, int idx, boolean[] dp, List<String> ans, int maxlen, List<String> wordDict,
            HashSet<String> set, String asf) {
        if (idx >= s.length()) {
            ans.add(asf.substring(0, asf.length() - 1));
            return;
        }

        for (int l = 1; l <= maxlen && idx + l <= s.length(); l++) {
            if (dp[idx + l]) {
                String substr = s.substring(idx, idx + l);
                if (set.contains(substr))
                    wordbreak_backEngg(s, idx + l, dp, ans, maxlen, wordDict, set, asf + substr + " ");
            }
        }
    }

    public List<String> wordBreakk(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss);
            len = Math.max(len, ss.length());
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) {
                String substr = s.substring(i, i + l);
                if (set.contains(substr)) {
                    dp[i + l] = true;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        if (dp[n])
            wordbreak_backEngg(s, 0, dp, ans, len, wordDict, set, "");
        return ans;
    }
}
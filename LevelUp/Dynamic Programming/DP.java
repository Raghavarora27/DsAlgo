public class DP {
    // subarray -- continous hote hai lekin subset nhi hote

    // 64
    public static int minCostMazePath(int[][] arr, int[][] dp) {

        // there can be 4 cases --
        // 1. i == dp.length -1 && j == dp[0].length - 1 that means no path horizontally
        // and vertically
        // 2. last row me ho that means no vertically path
        // 3. last column me ho that means no horizontal path
        // 4. this case is for the remaining blocks that means both horizontal and
        // vertical path exists
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
                }
            }
        }

        return dp[0][0];
    }

    public static int goldmine(int n, int m, int[][] arr) {
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int[][] dp = new int[n][m];

        int maxGold = 0;
        for (int[] d : dp)
            Arrays.fill(d, -1);

        for (int r = 0; r < n; r++) {
            maxGold = Math.max(maxGold, goldMine(arr, r, 0, dir, dp));
        }

        return maxGold;
    }

    public static int goldMine(int[][] arr, int sr, int sc, int[][] dir, int[][] dp) {
        int n = arr.length, m = arr[0].length;
        if (sc == m)
            return dp[sr][sc] = arr[sr][sc];

        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        int maxGold = 0;
        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < n && c < m) {
                maxGold = Math.max(maxGold, goldMine(arr, r, c, dir, dp) + arr[sr][sc]);
            }
        }

        return dp[sr][sc] = maxGold;
    }

    // 1219
    public static int goldmine(int[][] arr, int[][] dp) {
        for (int j = dp[0].length - 1; j >= 0; j--) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (j == dp[0].length - 1) {
                    // last column
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    // first row
                    // if there is only one row // then we cannot take the diagonal call
                    if (i + 1 < dp.length)
                        dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                    else
                        dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (i == dp.length - 1) {
                    // last row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    // remaining blocks
                    dp[i][j] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j + 1]), dp[i - 1][j + 1]) + arr[i][j];
                }
            }
        }
        // finding the maximum in the first column
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}

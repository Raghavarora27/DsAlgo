import java.util.Arrays;

public class TwoPointerSet {
    // 1_Faith
    // 2_RecursiveTree
    // 3_RecursiveCode->Memoization // Memoization - recursively data ko store
    // karwate hue solve karna
    // 4_Observation
    // 5_Tabulation // Iterative code me convert karna -- pattern observe karke --
    // base recursion hi hota h
    // 6_Optimization // memo ka code dekhke pattern ko observe karte hue iterative
    // me convert karne ko tabulation khete h
    // From memo to tabu -- just observe and find the direction

    // DP real life example
    // maine 1st time koi new cheez seekhi toh mujhe jada time laga
    // lekin next time uspe maine dobara kaam kiya toh mujhe time nhi laga

    // /// // Important -- find the real life example of all the ds
    // Top to down means recursion se karna 
    // Bottom to top means tabulation

    public static void display(int[] dp) {
        for (int ele : dp)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] d : dp)
            display(d);
        System.out.println();
    }

    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1)
            return dp[n] = n;

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);

        return dp[n] = ans;
    }

    // TC : O(n), SC : O(n)
    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
        return dp[N];
    }

    // TC : O(n), SC : O(1)
    public static int fibo_opti(int N) {
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void fibo() {
        int n = 5;
        int[] dp = new int[n + 1];
        System.out.println(fibo_opti(n));
        display(dp);
    }

    public static int mazePath_memo(int er, int ec, int[][] dp, int[][] dir) {
        if (er == 0 && ec == 0)
            return dp[er][ec] = 1;

        if (dp[er][ec] != 0)
            return dp[er][ec];

        int count = 0;
        for (int[] d : dir) {
            int r = er + d[0];
            int c = ec + d[1];

            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length)
                count += mazePath_memo(r, c, dp, dir);
        }

        return dp[er][ec] = count;
    }

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir) {
        if (sr == er && sc == ec)
            return dp[sr][sc] = 1; // ek rasta mil gya

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length)
                count += mazePath_memo(r, c, er, ec, dp, dir);
        }

        return dp[sr][sc] = count;
    }

    // O(4n^2)
    public static int mazePath_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (ER == sr && EC == sc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int[] d : dir) {
                    int r = sr + d[0];
                    int c = sc + d[1];

                    if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length)
                        count += dp[r][c];
                }
                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    // O(4n^3)
    public static int mazePathJump_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (ER == sr && EC == sc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int[] d : dir) {
                    int r = sr + d[0];
                    int c = sc + d[1];

                    while (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        count += dp[r][c];
                        r += d[0];
                        c += d[1];
                    }
                }
                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath() {
        int sr = 0, sc = 0, er = 2, ec = 2;
        int[][] dp = new int[er + 1][ec + 1];
        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
        mazePathJump_tabu(sr, sc, er, ec, dp, dir);
        display2D(dp);
    }

    // 70
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

    // Board Path
    public static int BoardPath_memo(int sp, int ep, int[] dp) {
        if (sp == ep)
            return dp[sp] = 1;

        if (dp[sp] != 0)
            return dp[sp];

        int count = 0;
        for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
            count += BoardPath_memo(sp + dice, ep, dp);
        }

        return dp[sp] = count;
    }

    // TC : O(6n) SC : O(n)
    public static int BoardPath_tabu(int SP, int ep, int[] dp) { // right to left dependency
        for (int sp = ep; sp >= 0; sp--) {
            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                count += dp[sp + dice]; // BoardPath_memo(sp + dice, ep, dp);
            }

            dp[sp] = count;
        }

        return dp[SP]; // answer Starting point pe milega
    }

    // 91
    public static int numDecodings(String s, int idx, int[] dp) {
        if (idx == s.length())
            return dp[idx] = 1;

        if (dp[idx] != -1)
            return dp[idx];

        char ch = s.charAt(idx);
        if (ch == '0')
            return dp[idx] = 0;

        int count = 0;
        count += numDecodings(s, idx + 1, dp);

        if (idx < s.length() - 1) {
            char ch1 = s.charAt(idx + 1);
            int num = (ch - '0') * 10 + (ch1 - '0');
            if (num <= 26)
                count += numDecodings(s, idx + 2, dp);
        }

        return dp[idx] = count;
    }

    public static int numDecodings_tabu(String s, int IDX, int[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            char ch = s.charAt(idx);
            if (ch == '0') {
                dp[idx] = 0;
                continue;
            }

            int count = dp[idx + 1]; // numDecodings_tabu(s, idx + 1, dp);

            if (idx < s.length() - 1) {
                char ch1 = s.charAt(idx + 1);
                int num = (ch - '0') * 10 + (ch1 - '0');
                if (num <= 26)
                    count += dp[idx + 2]; // numDecodings_tabu(s, idx + 2, dp);
            }

            dp[idx] = count;
        }
        return dp[IDX];
    }

    public static int numDecodings_opti(String s) {
        int a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            char ch = s.charAt(idx);
            int sum = 0;
            if (ch != '0') {

                sum += a;

                if (idx < s.length() - 1) {
                    char ch1 = s.charAt(idx + 1);
                    int num = (ch - '0') * 10 + (ch1 - '0');
                    if (num <= 26)
                        sum += b;
                }

            }

            b = a;
            a = sum;
        }
        return a;
    }

    public static int mod = (int) 1e9 + 7;

    public long numDecodingsStar(String s, int idx, long[] dp) {
        int n = s.length();
        if (idx == n) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        char ch = s.charAt(idx);
        if (ch == '0')
            return dp[idx] = 0;

        long count = 0;
        if (ch == '*') {
            count = (count + 9 * numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < n - 1) {
                char ch1 = s.charAt(idx + 1);
                if (ch1 >= '0' && ch1 <= '6')
                    count = (count + 2 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else if (ch1 >= '7' && ch1 <= '9')
                    count = (count + 1 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else
                    count = (count + 15 * numDecodingsStar(s, idx + 2, dp)) % mod;
            }
        } else {
            count = (count + 1 * numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < n - 1) {
                char ch1 = s.charAt(idx + 1);
                if (ch1 == '*' && ch == '1') {
                    count = (count + 9 * numDecodingsStar(s, idx + 2, dp)) % mod;
                } else if (ch1 == '*' && ch == '2') {
                    count = (count + 6 * numDecodingsStar(s, idx + 2, dp)) % mod;
                } else if (ch1 != '*') {
                    int num = (ch - '0') * 10 + (ch1 - '0');
                    if (num <= 26)
                        count = (count + 1 * numDecodingsStar(s, idx + 2, dp)) % mod;
                }
            }
        }

        return dp[idx] = count;
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

    public static void goldmine() {
        int[][] arr = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int[][] dp = new int[arr.length][arr[0].length];

        int maxGold = 0;
        for (int[] d : dp)
            Arrays.fill(d, -1);

        for (int r = 0; r < arr.length; r++) {
            maxGold = Math.max(maxGold, goldMine(arr, r, 0, dir, dp));
        }
    }

    public static long countFriendsPairing(int n, long[] dp) {
        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != -1)
            return dp[n];

        long single = countFriendsPairing(n - 1, dp);
        long pairUp = (n - 2) >= 0 ? countFriendsPairing(n - 2, dp) * (n - 1) : 0;

        return dp[n] = (single + pairUp % mod) % mod;
    }

    public static long countFriendsPairing(int n) {
        if(n == 0)
            return 0;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairing(n, dp);
    }

    public static long countFriendsPairing_opti(int n) {
        long a = 1, b = 1;
        for(int i = 2; i <= n; i++){
            long sum = b + (a * (i - 1))  % mod;
            a = b;
            b = sum % mod;
        }
        return b;
    }

    // O(n*k)
    public static int divideInKGroup(int n,int k,int [][] dp){
        if( n == k || k == 1 )
            return dp[n][k] = 1;
        
        if(dp[n][k] != 0)
            return dp[n][k];
        
        int selfGroup = divideInKGroup(n - 1, k - 1, dp);
        int partOfGroup = divideInKGroup(n - 1, k, dp) * k;

        return dp[n][k] = selfGroup + partOfGroup;
    }
    
    // left to right and top to bottom
    public static int divideInKGroup_tabu(int N,int K,int [][] dp){
        
        for(int n = 1;n <= N;n++){
            for(int k = 1;k <= K; k++){
                if( n == k || k == 1 ){
                    dp[n][k] = 1;
                    continue;
                }

                int selfGroup = dp[n - 1][k - 1];  //divideInKGroup(n - 1, k - 1, dp);
                int partOfGroup = dp[n - 1][k] * k; //divideInKGroup(n - 1, k, dp) * k;
        
                dp[n][k] = selfGroup + partOfGroup;
            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
        // fibo();
        mazePath();
    }
}
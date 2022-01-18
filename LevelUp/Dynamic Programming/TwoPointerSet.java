public class TwoPointerSet {
    // 1_Faith
    // 2_RecursiveTree
    // 3_RecursiveCode->Memoization             // Memoization - recursively data ko store karwate hue solve karna
    // 4_Observation
    // 5_Tabulation                             // Iterative code me convert karna -- pattern observe karke -- base recursion hi hota h 
    // 6_Optimization                           // memo ka code dekhke pattern ko observe karte hue iterative me convert karne ko tabulation khete h
                                                // From memo to tabu -- just observe and find the direction 

    // DP real life example 
    // maine 1st time koi new cheez seekhi toh mujhe jada time laga 
    // lekin next time uspe maine dobara kaam kiya toh mujhe time nhi laga

    // /// // Important -- find the real life example of all the ds

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

    public static int mazePath_memo(int er,int ec,int [][] dp,int [][] dir){
        if(er == 0 && ec == 0)
            return dp[er][ec] = 1;

        if(dp[er][ec] != 0)
            return dp[er][ec];
        
        int count = 0;
        for(int [] d : dir){
            int r = er + d[0];
            int c = ec + d[1];

            if(r >= 0 && c >= 0  && r < dp.length && c < dp[0].length)
                count += mazePath_memo(r, c, dp, dir);
        }

        return dp[er][ec] = count;
    }
    public static int mazePath_memo(int sr,int sc,int er,int ec,int [][] dp,int [][] dir){
        if(sr == er && sc == ec)
            return dp[sr][sc] = 1;  // ek rasta mil gya

        if(dp[sr][sc] != 0)
            return dp[sr][sc];
        
        int count = 0;
        for(int [] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];

            if(r >= 0 && c >= 0  && r < dp.length && c < dp[0].length)
                count += mazePath_memo(r, c,er,ec, dp, dir);
        }

        return dp[sr][sc] = count;
    }

    // O(4n^2)
    public static int mazePath_tabu(int SR,int SC,int ER,int EC,int [][] dp,int [][] dir){
        for(int sr = ER;sr >= SR;sr--){
            for(int sc = EC;sc >= SC;sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for(int [] d : dir){
                    int r = sr + d[0];
                    int c = sc + d[1];
        
                    if(r >= 0 && c >= 0  && r < dp.length && c < dp[0].length)
                        count += dp[r][c];
                }
                dp[sr][sc] = count;
            }
        }
        
        return dp[SR][SC];
    }
    
    // O(4n^3)
    public static int mazePathJump_tabu(int SR,int SC,int ER,int EC,int [][] dp,int [][] dir){
        for(int sr = ER;sr >= SR;sr--){
            for(int sc = EC;sc >= SC;sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for(int [] d : dir){
                    int r = sr + d[0];
                    int c = sc + d[1];
        
                    while(r >= 0 && c >= 0  && r < dp.length && c < dp[0].length){
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

    public static void mazePath(){
        int sr = 0,sc = 0, er = 2,ec = 2;
        int [][] dp = new int[er + 1][ec + 1];
        int [][] dir = {{1,0},{0,1},{1,1}};
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
    public static int BoardPath_memo(int sp,int ep,int [] dp){
        if(sp == ep)
            return dp[sp] = 1;
        
        if(dp[sp] != 0)
            return dp[sp];

        int count = 0;
        for(int dice = 1;dice <= 6 && sp + dice <= ep;dice++){
            count += BoardPath_memo(sp + dice, ep, dp);
        }

        return dp[sp] = count;
    }
    
    // TC : O(6n) SC : O(n)
    public static int BoardPath_tabu(int SP,int ep,int [] dp){ // right to left dependency
        for(int sp = ep;sp >= 0;sp--){
            if(sp == ep){
                dp[sp] = 1;
                continue;
            }
    
            int count = 0;
            for(int dice = 1;dice <= 6 && sp + dice <= ep;dice++){
                count += dp[sp + dice]; // BoardPath_memo(sp + dice, ep, dp);
            }
    
            dp[sp] = count;
        }

        return dp[SP]; // answer Starting point pe milega
    }

    public static void main(String[] args) {
        // fibo();
        mazePath();
    }
}
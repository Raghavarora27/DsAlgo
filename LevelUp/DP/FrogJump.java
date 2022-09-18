import java.util.*;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return jump_memo(heights,n - 1,dp);
    }

    // Greedy Approach will not work

    // Recursion 
    // TC : O(2 ^ N) SC : O(N) {Recursive stack space}
    public static int jump_rec(int [] arr,int idx){
        if(idx == 0)
            return 0;
        
        int left = jump_rec(arr,idx - 1) + Math.abs(arr[idx] - arr[idx - 1]);
        int right = (int)1e9;
        if(idx > 1)
            right = jump_rec(arr,idx - 2) + Math.abs(arr[idx] - arr[idx - 2]);
        
        return Math.min(right,left);
    }

    // Memoization 
    // TC : O(N) SC : O(N) {Recursive stack space} + O(N) {dp space}
    public static int jump_memo(int [] arr,int idx,int [] dp){
        if(idx == 0)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int left = jump_memo(arr,idx - 1,dp) + Math.abs(arr[idx] - arr[idx - 1]);
        int right = (int)1e9;
        if(idx > 1)
            right = jump_memo(arr,idx - 2,dp) + Math.abs(arr[idx] - arr[idx - 2]);
        
        return dp[idx] = Math.min(right,left);
    }

    // Tabulation
    // TC : O(N) SC : O(N) {dp space}
    public static int jump_Tabulation(int n, int heights[]) {    
        int [] dp = new int[n];
        for(int i = 1;i < n;i++){
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = (int)1e9;
            if(i > 1)               
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            
            dp[i] = Math.min(fs,ss);
        }
        
        return dp[n - 1];
    }
    
    // Space Optimised
    // TC : O(N) SC : O(1)
    public static int jump_opti(int n, int heights[]) {    
        int prev = 0,prev2 = 0;
        for(int i = 1;i < n;i++){
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = (int)1e9;
            if(i > 1)               
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            
            prev2 = prev;
            prev = Math.min(fs,ss);
        }
        
        return prev;
    }

    // Recursion 
    // TC : O(N * K) SC : O(N) {Recursive stack space}
    public static int jumpK_rec(int [] arr,int idx,int k){
        if(idx == 0)
            return 0;
            
        int ans = (int)1e9;
        for(int j = 1;j <= k;j++){
            if(idx - j >= 0){
                int rec = jumpK_rec(arr,idx - j,k) + Math.abs(arr[idx] - arr[idx - j]);
                ans = Math.min(ans,rec);
            }
        }
        
        return ans;
    }
    

    // Memoization 
    // TC : O(N * K) SC : O(N) {Recursive stack space} + O(N) {dp space}
    public static int jumpK_memo(int [] arr,int idx,int k,int [] dp){
        if(idx == 0)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];
            
        int ans = (int)1e9;
        for(int j = 1;j <= k;j++){
            if(idx - j >= 0){
                int rec = jumpK_rec(arr,idx - j,k) + Math.abs(arr[idx] - arr[idx - j]);
                ans = Math.min(ans,rec);
            }
        }

        return dp[idx] = ans;
    }
    
    // Tabulation
    // TC : O(N) SC : O(N) {dp space}
    public static int jumpK_Tabulation(int n, int heights[],int k) {    
        int [] dp = new int[n];
        for(int i = 1;i < heights.length;i++){       
            int ans = (int)1e9;
            for(int j = 1;j <= k;j++){
                if(i - j >= 0){
                    int res = dp[i - j] + Math.abs(dp[i] - dp[i - j]);
                    ans = Math.min(ans,res);
                }
            }
            dp[i] = ans;
        }
        
        return dp[n - 1];
    }
}
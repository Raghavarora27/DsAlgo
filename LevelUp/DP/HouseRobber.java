public class HouseRobber {

    // Recusion
    // TC : O(2 ^ N) SC : O(N) {Recursive space}
    public static int robber_rec(int [] arr,int idx){
        if(idx == 0)    // not picked the 1 index so pick 0 index
        return arr[idx];
        
        if(idx < 0)    
        return 0;

        // pick
        int pick = arr[idx] + robber_rec(arr,idx - 2);
        
        // not pick
        int Notpick = robber_rec(arr,idx - 1);
        
        return Math.max(pick, Notpick);
    }
    
    // memoization
    // TC : O(N) SC : O(N) {Recursive space} + O(N) {DP space}
    public static int robber_memo(int [] arr,int idx,int [] dp){
        if(idx == 0)    // not picked the 1 index so pick 0 index
            return arr[idx];

        if(idx < 0)    
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        // pick
        int pick = arr[idx] + robber_memo(arr,idx - 2,dp);
        
        // not pick
        int Notpick = robber_memo(arr,idx - 1,dp);

        return dp[idx] = Math.max(pick, Notpick);
    }

    // Tabulation
    // TC : O(N) SC : O(N)
    public int robber_tabu(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            
            int pick = nums[i];
            if(i > 1)
                pick +=  dp[i - 2];

            int Notpick = 0 + dp[i - 1];
            
            dp[i] = Math.max(pick, Notpick);
        }
        
        return dp[nums.length - 1];
    }
    
    // Space Optimised
    // TC : O(N) SC : O(1)
    public int robber_Opti(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 1;i < nums.length;i++){
            
            int pick = nums[i];
            if(i > 1)
                pick +=  prev2;

            int Notpick = 0 + prev;
            
            prev2 = prev;
            prev = Math.max(pick, Notpick);
        }
        
        return prev;
    }
    
    // House Robber 2
    // In this, First and last element are adjacent to each other 
    // Space Optimised
    // TC : O(N) SC : O(1)
    public int robber(int [] nums){
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int [] first = new int[n - 1];
        int [] second = new int[n - 1];
        int fi = 0,si = 0;
        for(int i = 0;i < n;i++){
            if(i != 0)
                first[fi++] = nums[i];
            if(i != n - 1)
                second[si++] = nums[i];
        }
        return Math.max(robber2_Opti(first), robber2_Opti(second));
    } 
    public int robber2_Opti(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 1;i < nums.length;i++){
            
            int pick = nums[i];
            if(i > 1)
                pick +=  prev2;

            int Notpick = 0 + prev;
            
            prev2 = prev;
            prev = Math.max(pick, Notpick);
        }
        
        return prev;
    }
}

public class TrappingRainWater{
    // Approach - 1
    // Brute Force
    // TC : O(N^2) SC : O(1)
    public static void trapping_1(int[] arr){
        int [] ans = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            int leftmax = Max_1(arr,i,true);
            int rightmax = Max_1(arr,i,false);
            ans[i] = Math.min(leftmax, rightmax) - arr[i];
        }
    }

    public static int Max_1(int[] arr,int idx,boolean leftmax){
        int maxEle = -1;
        if(leftmax){
            for(int i = 0;i <= idx;i++){
                maxEle = Math.max(maxEle,arr[i]);
            }
        }
        else{
            for(int i = idx;i < arr.length;i++){
                maxEle = Math.max(maxEle,arr[i]);
            }
        }
        return maxEle;
    }

    // Approach - 2
    // TC : O(N) SC : O(2N)
    public static void trapping_2(int[] arr){
        int [] ans = new int[arr.length];
        int [] prefixMax = new int[arr.length];
        int [] suffixMax = new int[arr.length];
        Max_2(arr, prefixMax, suffixMax);
        for(int i = 0;i < arr.length;i++){
            ans[i] = Math.min(prefixMax[i], suffixMax[i]) - arr[i];
        }
    }

    public static void Max_2(int[] arr,int[] prefixMax,int[] suffixMax){
        int prefix = 0;
        for(int i = 0;i < arr.length;i++){
            prefix = Math.max(arr[i],prefix);
            prefixMax[i] = prefix;
        }

        int suffix = 0;
        for(int i = arr.length - 1;i >= 0;i--){
            suffix = Math.max(arr[i],suffix);
            suffixMax[i] = suffix;
        }
    }

    // Optimised
    // TC : O(N) SC : O(1)
    public static void trapping_3(int[] arr){
        int ans = 0,leftMax = 0,rightMax = 0;
        int left = 0,right = arr.length - 1;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    ans += leftMax - arr[left];
                left++;
            }
            else{
                if(arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    ans += rightMax - arr[right];
                right--;
            }
        }
        System.out.println(ans);
    }   

}
package Bits;

public class bits {

    // 0 -> 1, 1 -> 1 / false -> true, true -> true // -> arr[idx] = true;
    public static void offToOn(int n, int k) {
        int mask = (1 << k);
        n |= mask;
        System.out.println(n);
    }

    // 1 -> 0, 0 -> 0 / true -> false, false -> false // -> arr[idx] = false;
    public static void onToOff(int n, int k) {
        int mask = (1 << k);
        n &= (~mask);

        System.out.println(n);
    }

    // O(n)
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = (1 << i);
            if ((n & mask) != 0)
                count++;
        }
        return count;
    }

    // log(n)
    public static int countSetBits_02(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                count++;
            n >>>= 1;
        }
        return count;
    }

    // jitne set bit hai utne steps lagenge
    public static int countSetBits_03(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1); // it will remove the last set bit
        }
        return count;
    }

    // 231
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 342
    public boolean isPowerOfFour(int n) {
        if (n <= 0 || (n & (n - 1)) != 0)
            return false; // means power of two nhi h ,toh power of four bhi nhi hoga

        int count = 0;
        while (n != 1) {
            count++;
            n >>>= 1;
        }

        return (count & 1) == 0;
    }

    // 136
    public int singleNumber(int[] nums) {
        int ans = 0;
        // XOR -- same element gives 0
        for (int ele : nums)
            ans ^= ele;

        return ans;
    }

    // 338
    public int[] countBits(int n) {
        int [] ans = new int[n + 1];
        for(int i = 0;i <= n ;i++){
            int count = 0;
            int num = i;
            while(num != 0){
                count++;
                num = num & (num - 1);
            }
            ans[i] = count;
        }
        
        return ans;
    }

    public int[] countBits_02(int n) {
        int [] ans = new int[n + 1];
        for(int i = 1;i <= n ;i++){
            ans[i] = ans[ i & (i - 1)] + 1;
        }
        
        return ans;
    }

    // 268
    public int missingNumber(int[] nums) {
        int ans = 0;
        int i = 0;
        for(int ele : nums){
            ans ^= ele;
            ans ^= i;
            i++;
        }
        
        return ans ^ i;
    }

    public int missingNumber_02(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int ele : nums){
            ans += ele;
        }
        
        return ((n * (n + 1)) / 2) - ans;
    }
}

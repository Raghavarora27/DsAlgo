public class Leetcode_238 {
    // O(n)
    class Solution {
        public int[] productExceptSelf(int[] arr) {
            int[] ans = new int[arr.length];
            int left = 1, right = 1;

            for (int i = 0; i < ans.length; i++) {
                ans[i] = 1;
            }

            for (int i = 0, j = arr.length - 1; i < arr.length - 1; i++, j--) {
                left *= arr[i];
                right *= arr[j];
                ans[i + 1] *= left;
                ans[j - 1] *= right;
            }
            return ans;
        }
    }
}
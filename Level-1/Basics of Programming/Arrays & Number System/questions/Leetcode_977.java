public class Leetcode_977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] arr = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    arr[i] = (-1 * (nums[i])) * (-1 * (nums[i]));
                } else
                    arr[i] = nums[i] * nums[i];
            }

            Arrays.sort(arr);
            return arr;
        }
    }
}

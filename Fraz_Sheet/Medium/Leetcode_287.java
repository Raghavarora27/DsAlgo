public class Leetcode_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int ans = -1;
            for (int i = 0; i < nums.length; i++) {
                int idx = Math.abs(nums[i]) - 1;

                if (nums[idx] < 0) {
                    ans = Math.abs(nums[i]);
                    break;
                }

                nums[idx] = -nums[idx];
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }

            return ans;
        }
    }
}
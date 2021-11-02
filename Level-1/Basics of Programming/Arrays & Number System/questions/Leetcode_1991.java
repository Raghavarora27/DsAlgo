public class Leetcode_1991 {
    class Solution {
        public int findMiddleIndex(int[] nums) {
            int LeftSum = 0;
            int RightSum = 0;

            for (int i = 0; i < nums.length; i++) {
                RightSum += nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                RightSum -= nums[i];

                if (LeftSum == RightSum)
                    return i;

                LeftSum += nums[i];
            }
            return -1;
        }
    }
}

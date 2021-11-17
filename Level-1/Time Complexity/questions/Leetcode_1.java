import java.util.*;

public class Leetcode_1 {
    /// TC : O(n) SC : O(n)
    class Solution {
        public int[] twoSum(int[] arr, int target) {
            int[] ans = new int[2];

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(target - arr[i])) {
                    ans[0] = i;
                    ans[1] = map.get(target - arr[i]);
                    break;
                } else {
                    map.put(arr[i], i);
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[i] + nums[j]) == target) {
                        ans[0] = i;
                        ans[1] = j;
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
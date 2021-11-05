import java.util.*;

class Solution {

    public void permute(int[] nums, List<List<Integer>> res, List<Integer> ans, int count) {
        if (count == nums.length) {
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= -10 && nums[i] <= 10) {
                int val = nums[i];
                nums[i] = -100;
                ans.add(val);

                // recursive call
                permute(nums, res, ans, count + 1);

                ans.remove(ans.size() - 1);
                nums[i] = val;
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        permute(nums, res, ans, 0);
        return res;
    }
}
package questions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            combinationSum(n, 1, ans, comb, k);
            return ans;
        }

        public void combinationSum(int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns, int k) {
            if (tar == 0 && smallAns.size() == k) {
                List<Integer> base = new ArrayList<>(smallAns); // deep copy
                ans.add(base); // shallow copy
                return;
            }

            for (int i = idx; i <= 9; i++) {
                if (tar - i >= 0) {
                    smallAns.add(i);
                    combinationSum(tar - i, i + 1, ans, smallAns, k);
                    smallAns.remove(smallAns.size() - 1);
                }
            }

        }
    }
}

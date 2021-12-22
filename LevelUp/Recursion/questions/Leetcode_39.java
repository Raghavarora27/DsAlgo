package questions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            combination(candidates, target, res, ans, 0);
            return res;
        }

        public int combination(int[] coins, int tar, List<List<Integer>> res, List<Integer> ans, int idx) {
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(ans); /// deep copy   
                res.add(base);  // shallow copy -- means apne uska address copy karlia
                return 1;
            }

            int count = 0;
            for (int i = idx; i < coins.length; i++) {
                if (tar - coins[i] >= 0) {
                    ans.add(coins[i]);
                    count += combination(coins, tar - coins[i], res, ans, i);
                    ans.remove(ans.size() - 1);
                }
            }

            return count;
        }
    }
}

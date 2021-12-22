package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// single supply combination - check prev character after doing sorting
public class Leetcode_40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] coins, int tar) {
            Arrays.sort(coins);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            combinations(coins, tar, res, ans, 0);
            return res;
        }

        public int combinations(int[] coins, int tar, List<List<Integer>> res, List<Integer> ans, int idx) {
            if (tar == 0) {
                ArrayList<Integer> base = new ArrayList<>(ans);
                res.add(base);
                return 1;
            }

            int count = 0;
            int prev = -1;
            for (int i = idx; i < coins.length; i++) {
                if (prev != coins[i] && tar - coins[i] >= 0) {
                    ans.add(coins[i]);
                    count += combinations(coins, tar - coins[i], res, ans, i + 1);
                    ans.remove(ans.size() - 1);
                    prev = coins[i];
                }
            }

            return count;
        }
    }
}
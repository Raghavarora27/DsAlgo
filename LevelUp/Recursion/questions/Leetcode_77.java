package questions;

import java.util.*;

public class Leetcode_77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            combinationSum(n, 1, ans, comb, k);
            return ans;
        }

        public void combinationSum(int n, int idx, List<List<Integer>> ans, List<Integer> smallAns, int k) {
            if (smallAns.size() == k) {
                List<Integer> base = new ArrayList<>(smallAns); // deep copy
                ans.add(base); // shallow copy
                return;
            }

            for (int i = idx; i <= n; i++) {
                smallAns.add(i);
                combinationSum(n, i + 1, ans, smallAns, k);
                smallAns.remove(smallAns.size() - 1);
            }

        }
    }
}

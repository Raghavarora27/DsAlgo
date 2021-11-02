import java.util.*;

public class Leetcode_229 {
    class Solution {
        // O(n)
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
            List<Integer> ans = new ArrayList<>();

            for (int num : nums) {
                if (!myMap.containsKey(num))
                    myMap.put(num, 1);
                else
                    myMap.put(num, myMap.get(num) + 1);
            }

            for (int a : myMap.keySet()) {
                if (myMap.get(a) > Math.floor(nums.length / 3)) {
                    ans.add(a);
                }
            }
            return ans;
        }
    }
}

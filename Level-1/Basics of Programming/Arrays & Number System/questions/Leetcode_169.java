import java.util.*;

public class Leetcode_169 {
    
    // O(nlogn)
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    // TC : O(n) , SC : O(n)
    class Solution2 {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
            int ans = 0;

            for (int num : nums) {
                if (!myMap.containsKey(num))
                    myMap.put(num, 1);
                else
                    myMap.put(num, myMap.get(num) + 1);
                if (myMap.get(num) > nums.length / 2) {
                    ans = num;
                    break;
                }
            }
            return ans;
        }
    }
}
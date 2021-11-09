import java.util.ArrayList;

public class Leetcode_4 {
    class Solution {
        // O(n+m)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0, j = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] > nums2[j])
                    ans.add(nums2[j++]);
                else
                    ans.add(nums1[i++]);
            }

            while (i < nums1.length)
                ans.add(nums1[i++]);

            while (j < nums2.length)
                ans.add(nums2[j++]);

            System.out.println(ans);

            double median;

            if (ans.size() % 2 == 0) {
                median = (double) (ans.get(ans.size() / 2) + ans.get(ans.size() / 2 - 1)) / 2;
            } else {
                median = ans.get(ans.size() / 2);
            }

            return median;
        }
    }
}
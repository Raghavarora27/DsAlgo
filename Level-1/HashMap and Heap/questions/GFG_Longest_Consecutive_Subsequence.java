package questions;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#

public class GFG_Longest_Consecutive_Subsequence {

    class Solution {
        public int findLongestConseqSubseq(int arr[], int N) {
            HashSet<Integer> set = new HashSet<>();

            for (int ele : arr) {
                set.add(ele);
            }

            int len = 0;
            for (int ele : arr) {
                if (!set.contains(ele))
                    continue;

                int left = ele - 1, right = ele + 1;
                set.remove(ele);

                while (set.contains(left))
                    set.remove(left--);

                while (set.contains(right))
                    set.remove(right++);

                if (right - left - 1 > len) {
                    len = right - left - 1;
                }
            }
            return len;
        }
    }
}

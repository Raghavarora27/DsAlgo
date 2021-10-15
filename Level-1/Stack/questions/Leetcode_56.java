package questions;

import java.util.*;

public class Leetcode_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0)
                return intervals;

            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });

            LinkedList<int[]> st = new LinkedList<>(); // Stack of Arrays

            for (int[] a : intervals) {
                int minStartTime = a[0];
                int maxEndTime = a[1];

                while (st.size() != 0 && a[0] <= st.getFirst()[1]) {
                    minStartTime = st.getFirst()[0];
                    maxEndTime = Math.max(maxEndTime, st.getFirst()[1]);
                    st.removeFirst();
                }

                st.addFirst(new int[] { minStartTime, maxEndTime });
            }

            int[][] ans = new int[st.size()][2];
            int len = ans.length - 1;
            while (st.size() != 0) {
                ans[len--] = st.removeFirst();
            }
            return ans;
        }
    }
}

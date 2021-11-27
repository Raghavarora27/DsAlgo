package questions;

import java.util.*;

public class Leetcode_503 {
    class Solution {
        public int[] nextGreaterElements(int[] arr) {
            LinkedList<Integer> st = new LinkedList<>();
            int[] ans = new int[arr.length];
            Arrays.fill(ans, -1);

            for (int i = 0; i < arr.length * 2; i++) {
                int num = arr[i % arr.length];
                while (st.size() != 0 && arr[st.getFirst()] < num)
                    ans[st.removeFirst()] = num;

                if (i < arr.length)
                    st.addFirst(i);
            }
            return ans;
        }
    }
}

package questions;

import java.util.HashMap;

public class Leetcode_1528 {
    class Solution {
        // TC : O(n^2) SC : O(1)
        public String restoreString(String s, int[] indices) {
            StringBuilder sb = new StringBuilder();

            int idx = 0;
            while (idx < s.length()) {
                for (int i = 0; i < indices.length; i++) {
                    if (indices[i] == idx) {
                        sb.append(s.charAt(i));
                        break;
                    }
                }
                idx++;
            }
            return sb.toString();
        }
    }

    class Solution2 {
        // TC : O(n) SC : O(n)
        public String restoreString(String s, int[] indices) {
            HashMap<Integer, Character> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < indices.length; i++) {
                map.put(indices[i], s.charAt(i));
            }

            // 4 : c
            // 5 : o
            // 6 : d
            // 7 : e
            // 0 : l
            // 2 : e
            // 1 : e
            // 3 : t

            for (int i = 0; i < s.length(); i++) {
                sb.append(map.get(i));
            }
            return sb.toString();
        }
    }
}

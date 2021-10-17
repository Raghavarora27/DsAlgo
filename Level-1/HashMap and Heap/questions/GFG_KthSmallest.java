package questions;

import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class GFG_KthSmallest {

    class Solution {
        public int kthSmallest(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            for (int ele : arr) {
                pq.add(ele);
                if (pq.size() > k)
                    pq.remove();
            }
            return pq.peek();
        }
    }

}

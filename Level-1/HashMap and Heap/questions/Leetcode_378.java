package questions;

import java.util.PriorityQueue;

public class Leetcode_378 {
    class Solution {
        // nlog(k) -- n = total number of elements in 2d array 
        public int kthSmallest(int[][] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    pq.add(arr[i][j]);
                    if (pq.size() > k)
                        pq.remove();
                }
            }

            return pq.peek();
        }
    }
}

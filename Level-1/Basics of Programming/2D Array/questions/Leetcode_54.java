package questions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();

            int n = matrix.length, m = matrix[0].length;
            int TotalCount = n * m;
            int rmin = 0, rmax = n - 1, cmin = 0, cmax = m - 1;

            while (TotalCount != 0) {

                for (int j = cmin; j <= cmax && TotalCount > 0; j++) {
                    ans.add(matrix[rmin][j]);
                    TotalCount--;
                }
                rmin++;

                for (int i = rmin; i <= rmax && TotalCount > 0; i++) {
                    ans.add(matrix[i][cmax]);
                    TotalCount--;
                }
                cmax--;

                for (int j = cmax; j >= cmin && TotalCount > 0; j--) {
                    ans.add(matrix[rmax][j]);
                    TotalCount--;
                }
                rmax--;

                for (int i = rmax; i >= rmin && TotalCount > 0; i--) {
                    ans.add(matrix[i][cmin]);
                    TotalCount--;
                }
                cmin++;
            }
            return ans;
        }
    }
}
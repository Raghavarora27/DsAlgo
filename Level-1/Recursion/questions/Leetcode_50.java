public class Leetcode_50 {
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0)
                return 1;

            if (x == 0 || x == 1 || n == 1)
                return x;

            double ans = myPow(x, n / 2);

            if (n % 2 == 0) {
                return ans * ans;
            } else {
                if (n < 0) {
                    return ans * ans / x;
                } else {
                    return ans * ans * x;
                }
            }
        }
    }
}
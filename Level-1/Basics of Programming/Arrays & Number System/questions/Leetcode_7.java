public class Leetcode_7 {
    class Solution {
        public int reverse(int x) {
            long ans = 0;
            long pow = 10;

            while (x != 0) {
                ans = (ans * pow) + (x % 10);
                x /= 10;
            }
            return (ans >= Math.pow(-2, 31) && ans <= Math.pow(2, 31) - 1) ? (int) ans : 0;
        }
    }
}
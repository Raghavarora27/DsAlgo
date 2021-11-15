public class Leetcode_69 {
    class Solution {
        public int mySqrt(int x) {
            int si = 1;
            int ei = x;

            while (si <= ei) {
                long mid = si + (ei - si) / 2;

                if (mid * mid == x)
                    return (int) mid;
                else if (mid * mid > x)
                    ei = (int) mid - 1;
                else
                    si = (int) mid + 1;
            }
            return ei;
        }
    }
}

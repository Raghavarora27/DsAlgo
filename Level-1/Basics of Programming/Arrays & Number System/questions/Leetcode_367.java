public class Leetcode_367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1)
                return true;
            long si = 2;
            long ei = num / 2;

            while (si <= ei) {
                long mid = si + (ei - si) / 2;

                if (mid * mid == num)
                    return true;
                else if (mid * mid > num)
                    ei = mid - 1;
                else
                    si = mid + 1;
            }
            return false;
        }
    }
}

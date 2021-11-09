public class Leetcode_744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int si = 0;
            int ei = letters.length - 1;

            while (si <= ei) {
                int mid = (si + (ei - si) / 2);

                if (letters[mid] > target)
                    ei = mid - 1;
                else
                    si = mid + 1;
            }
            return letters[si % letters.length];
        }
    }
}

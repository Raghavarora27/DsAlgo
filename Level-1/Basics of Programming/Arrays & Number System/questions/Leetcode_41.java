public class Leetcode_41 {
    class Solution {
        // nlogn
        public int firstMissingPositive(int[] arr) {
            Arrays.sort(arr);

            int PI = 1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < PI)
                    continue;
                else if (arr[i] == PI) {
                    PI++;
                } else {
                    return PI;
                }
            }
            return PI;
        }
    }
}

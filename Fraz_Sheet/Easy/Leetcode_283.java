package Easy;
public class Leetcode_283 {
    // TC : O(n) SC : O(1)
    class Solution {
        public void moveZeroes(int[] arr) {
            int readIndex = 0;
            int writeIndex = 0;

            while (readIndex < arr.length) {
                if (arr[readIndex] == 0) {
                    readIndex++;
                    continue;
                }

                if (readIndex != writeIndex) {
                    arr[writeIndex] = arr[readIndex];
                    arr[readIndex] = 0;
                }

                readIndex++;
                writeIndex++;
            }
        }
    }

}

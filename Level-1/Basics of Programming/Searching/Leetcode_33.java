public class Leetcode_33 {
    class Solution {
        // O(logn)
        public int search(int[] arr, int target) {
            int si = 0;
            int ei = arr.length - 1;

            while (si <= ei) {
                int mid = (si + ei) / 2;

                if (arr[mid] == target)
                    return mid;

                if (arr[si] <= arr[mid]) {
                    if (target >= arr[si] && target < arr[mid])
                        ei = mid - 1;
                    else
                        si = mid + 1;
                } else {
                    if (target <= arr[ei] && target > arr[mid])
                        si = mid + 1;
                    else
                        ei = mid - 1;
                }
            }
            return -1;
        }
    }
}

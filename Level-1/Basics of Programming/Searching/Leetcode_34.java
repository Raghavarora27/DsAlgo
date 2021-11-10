public class Leetcode_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = { -1, -1 };
            ans[0] = search(nums, target, true);
            ans[1] = search(nums, target, false);

            return ans;
        }

        public int search(int[] arr, int target, boolean IsStartIndex) {
            int si = 0;
            int ei = arr.length - 1;
            int ans = -1;

            while (si <= ei) {
                int mid = si + (ei - si) / 2;

                if (arr[mid] > target) {
                    ei = mid - 1;
                } else if (arr[mid] < target) {
                    si = mid + 1;
                } else {
                    ans = mid;
                    if (IsStartIndex)
                        ei = mid - 1;
                    else
                        si = mid + 1;
                }
            }
            return ans;
        }
    }

    class Solution2 {

        public static int FirstIndex(int[] arr, int data) {

            int si = 0;
            int ei = arr.length - 1;

            while (si <= ei) {

                int mid = (si + ei) / 2;

                if (arr[mid] == data) {
                    if (mid - 1 >= 0 && arr[mid - 1] == data) {
                        ei = mid - 1;
                    } else {
                        return mid;
                    }
                } else if (arr[mid] > data) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            return -1;
        }

        public static int LastIndex(int[] arr, int data) {

            int si = 0;
            int ei = arr.length - 1;

            while (si <= ei) {

                int mid = (si + ei) / 2;

                if (arr[mid] == data) {
                    if (mid + 1 < arr.length && arr[mid + 1] == data) {
                        si = mid + 1;
                    } else {
                        return mid;
                    }
                } else if (arr[mid] > data) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] arr, int data) {
            int[] ans = { FirstIndex(arr, data), LastIndex(arr, data) };
            return ans;
        }
    }
}

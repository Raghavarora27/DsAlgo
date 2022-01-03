package Easy;
import java.util.*;

public class Leetcode_448 {

    // TC : O(n) SC : O(1)
    class Solution1 {
        public List<Integer> findDisappearedNumbers(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            for (int ele : arr) {
                int idx = Math.abs(ele) - 1;

                if (arr[idx] > 0)
                    arr[idx] = -arr[idx];
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0)
                    ans.add(i + 1);

            }
            return ans;
        }
    }

    // TC : O(n) SC : O(n)
    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] arr) {
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < arr.length; i++) {
                if (!set.contains(arr[i]))
                    set.add(arr[i]);
            }

            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= arr.length; i++) {
                if (!set.contains(i))
                    ans.add(i);
            }

            return ans;
        }
    }
}

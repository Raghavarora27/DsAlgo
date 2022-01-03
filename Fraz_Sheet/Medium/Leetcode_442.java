package Medium;
import java.util.*;

public class Leetcode_442 {

    // TC : O(n) SC : O(1)
    class Solution1 {
        public static List<Integer> findDuplicates(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int idx = Math.abs(arr[i]) - 1;

                if (arr[idx] < 0)
                    ans.add(Math.abs(arr[i]));

                arr[idx] = -arr[idx];
            }
            return ans; 
        }
    }

    // TC : O(n) SC : O(n)
    class Solution2 {
        public List<Integer> findDuplicates(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    ans.add(arr[i]);
                } else {
                    map.put(arr[i], 1);
                }
            }
            return ans;
        }
    }

    // TC : O(nlogn) SC : O(1)
    class Solution3 {
        public List<Integer> findDuplicates(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            if (arr.length <= 1)
                return ans;
            Arrays.sort(arr);
            int lastEle = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    if (lastEle == -1) {
                        lastEle = arr[i];
                        ans.add(arr[i]);
                    } else {
                        if (lastEle != arr[i])
                            ans.add(arr[i]);
                    }
                }
            }

            return ans;
        }
    }
}

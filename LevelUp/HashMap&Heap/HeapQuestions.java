import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapQuestions {

    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1/#
    // nlogk
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // max Heap
            return b - a;
        });

        while (l <= r) {
            pq.add(arr[l]);
            if (pq.size() > k)
                pq.remove();
            l++;
        }

        return pq.peek();
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static boolean compareTo(int[] arr, int x, int y, boolean Isincreasing) {
        return Isincreasing ? arr[x] > arr[y] : arr[y] > arr[x];
    }

    public static void downheapify(int[] arr, int pi, int li, boolean Isincreasing) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int maxIdx = pi;

        if (lci <= li && compareTo(arr, lci, maxIdx, Isincreasing)) {
            maxIdx = lci;
        }

        if (rci <= li && compareTo(arr, rci, maxIdx, Isincreasing)) {
            maxIdx = rci;
        }

        if (maxIdx != pi) {
            swap(arr, maxIdx, pi);
            downheapify(arr, maxIdx, li, Isincreasing);
        }
    }

    // n + klogn
    public static int kthSmallest_2(int[] arr, int l, int r, int k) {
        // min heap
        boolean Isincreasing = false;
        int li = r, n = arr.length;

        // we will create a maxHeap
        for (int i = li; i >= 0; i--) {
            downheapify(arr, i, li, Isincreasing);
        }

        // sort array
        int K = k;
        while (li > 0 && K-- > 0) {
            swap(arr, 0, li--);
            downheapify(arr, 0, li, Isincreasing);
        }

        return (arr[n - k]);
    }

    // 703
    class KthLargest {
        // min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int K;

        public KthLargest(int k, int[] nums) {
            K = k;
            for (int ele : nums) {
                pq.add(ele);
                if (pq.size() > k)
                    pq.remove();
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > K)
                pq.remove();

            return pq.peek();
        }
    }

    // https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1/
    // public static int kthSmallest(int[][] mat, int n, int k) {
    // // code here.
    // }

    // 378 Kth Smallest Element in a Sorted Matrix
    // nlog(k)
    public static int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                pq.add(arr[i][j]);
                if (pq.size() > k)
                    pq.remove();
            }
        }

        return pq.peek();
    }

    // klog(n)
    public int kthSmallest_2(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;

            return arr[i1][j1] - arr[i2][j2];
        });

        // priorityQueue me 1D index daal diya hai
        for (int i = 0; i < n; i++)
            pq.add(i * m + 0);

        int r = 0, c = 0;
        while (k-- > 0) {
            int idx = pq.remove();
            r = idx / m;
            c = idx % m;

            if (c + 1 < m)
                pq.add(r * m + c + 1);
        }

        return arr[r][c];
    }

    // 347
    // nlogk
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        // {ele,freq}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        for (int ele : map.keySet()) {
            pq.add(ele);
            if (pq.size() > k)
                pq.poll(); // poll is like remove but poll doesnot give exception if queue is empty
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        while (pq.size() != 0) {
            ans[i++] = pq.poll();

        }

        return ans;
    }

    // 451

    // 973 K Closest Points to Origin
    // nlogk
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int d1 = points[a][0] * points[a][0] + points[a][1] * points[a][1];
            int d2 = points[b][0] * points[b][0] + points[b][1] * points[b][1];

            return d2 - d1;
        });

        for (int i = 0; i < points.length; i++) {
            pq.add(i);
            if (pq.size() > k)
                pq.remove();
        }

        int[][] ans = new int[k][];
        int i = 0;
        while (pq.size() != 0) {
            int idx = pq.remove();
            ans[i++] = points[idx];
        }

        return ans;
    }

    // 692. Top K Frequent Words
    // nlogk
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words)
            map.put(str, map.getOrDefault(str, 0) + 1);

        // min heap
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b))
                return b.compareTo(a);
            // jo lexographically bada hai usse nikal denge // b chota hai a se ya nhi
            // b ke baare me baat kar rha
            return map.get(a) - map.get(b);
        });

        for (String ele : map.keySet()) {
            pq.add(ele);
            if (pq.size() > k)
                pq.poll(); // poll is like remove but poll doesnot give exception if queue is empty
        }

        List<String> ans = new LinkedList<>();
        while (pq.size() != 0) {
            ans.add(0, pq.remove());
        }
        return ans;
    }

    // 778. Swim in Rising Water
    public int swimInWater(int[][] grid) {
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int n = grid.length, m = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;

            return grid[i1][j1] - grid[i2][j2];
        });

        boolean[][] vis = new boolean[n][m];
        pq.add(0);
        vis[0][0] = true;

        int minHeight = 0;
        while (pq.size() != 0) {
            int idx = pq.remove();
            int i = idx / m, j = idx % m;
            int height = grid[i][j];

            minHeight = Math.max(minHeight, height);

            if (i == n - 1 && j == m - 1)
                break;

            for (int[] d : dir) {
                int r = i + d[0];
                int c = j + d[1];

                if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                    vis[r][c] = true;
                    pq.add(r * m + c);
                }
            }
        }

        return minHeight;
    }

    // 1642. Furthest Building You Can Reach
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            int currDiff = heights[i] - heights[i - 1];
            if (currDiff > 0) {
                pq.add(currDiff);
                if (pq.size() > ladders)
                    bricks -= pq.remove();
                if (bricks < 0)
                    return i - 1;
            }
        }

        return n - 1;
    }

    // 632. Smallest Range Covering Elements from K Lists
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        // {r,c}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a[0], c1 = a[1];
            int r2 = b[0], c2 = b[1];

            return nums.get(r1).get(c1) - nums.get(r2).get(c2);
        });

        int maxvalue = -(int) 1e9;
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { i, 0 });
            maxvalue = Math.max(maxvalue, nums.get(i).get(0));
        }

        int range = (int) 1e9, sp = -1, ep = -1;
        while (pq.size() == n) {
            int[] re = pq.remove();
            int r = re[0], c = re[1], val = nums.get(r).get(c);
            if (maxvalue - val < range) {
                range = maxvalue - val;
                sp = val;
                ep = maxvalue;
            }

            c++;
            if (c < nums.get(r).size()) {
                pq.add(new int[] { r, c });
                maxvalue = Math.max(maxvalue, nums.get(r).get(c));
            }
        }

        return new int[] { sp, ep };
    }

    // 128. Longest Consecutive Sequence
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int e : arr)
            set.add(e);

        int len = 0;
        for (int i = 0; i < arr.length; i++) {

            if (!set.contains(arr[i]))
                continue;

            int left = arr[i] - 1, right = arr[i] + 1;
            set.remove(arr[i]);
            while (set.contains(left))
                set.remove(left--);
            while (set.contains(right))
                set.remove(right++);

            if (right - left - 1 > len)
                len = right - left - 1;
        }
        return len;
    }

    /// 781. Rabbits in Forest
    // TC: O(n) SC: O(n)
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int ele : answers) {
            if (!map.containsKey(ele)) {
                ans += 1 + ele;
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
            if (map.get(ele) == ele + 1)
                map.remove(ele);
        }
        return ans;
    }

    // 1218. Longest Arithmetic Subsequence of Given Difference
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele - difference, 0) + 1);
            maxLen = Math.max(maxLen, map.get(ele));
        }

        return maxLen;
    }

    // 1424. Diagonal Traverse II
    // TC: O(N * M) SC: O(N)
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        int maxDiag = 0, len = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int idx = i + j;
                map.putIfAbsent(idx, new LinkedList<>());
                map.get(idx).addFirst(nums.get(i).get(j));
                len++;
                maxDiag = Math.max(maxDiag, idx);
            }
        }

        int[] ans = new int[len];
        int idx = 0;
        for (int i = 0; i <= maxDiag; i++) {
            LinkedList<Integer> list = map.get(i);
            while (list.size() != 0)
                ans[idx++] = list.removeFirst();
        }

        return ans;
    }

    // 1027
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = A[i] - A[j];
                int currLen = dp[i].getOrDefault(diff, 0);
                int newLen = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, Math.max(currLen, newLen));
                len = Math.max(len, dp[i].get(diff));
            }
        }

        return len;
    }

}
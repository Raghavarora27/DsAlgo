import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HeapQuestions {

    // nlogk
    public static int kthLargest(int[] arr, int l, int r, int k) {
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

    // 378
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
}
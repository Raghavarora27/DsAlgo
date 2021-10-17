import java.util.*;

public class questions {

    // Brute Force
    // SC :- O(n) TC :- nlog(n) + klog(k)
    public static void KthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int ele : arr)
            pq.add(ele);

        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove());
        }
    }

    // optimised
    // nlog(k)
    public static void KthLargest1(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k)
                pq.remove();
        }

        System.out.println(pq.peek());
    }

    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k)
                pq.remove();
        }
        return pq.peek();
    }

    // Sort matrix on the basis on 1 index of 1d array
    public static void sortKsortedArray(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a / m, c1 = a % m, r2 = b / m, c2 = b % m;
            return arr[r1][c1] - arr[r2][c2];
        });

        for (int i = 0; i < n; i++) {
            pq.add(i * m + 0);
        }

        int[] ans = new int[n * m];
        int idx = 0;
        while (pq.size() != 0) {
            Integer eidx = pq.remove(); // encoded index
            int r = eidx / m, c = eidx % m;
            ans[idx++] = arr[r][c];

            c++;
            if (c < m)
                pq.add(r * m + c);
        }

        for (int ele : ans)
            System.out.print(ele + " ");
    }

    // O(nlogn)
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ArrayList<Integer> a : lists)
            for (int ele : a)
                pq.add(ele);

        while (pq.size() != 0)
            rv.add(pq.remove());

        return rv;
    }

    // O(nlogk)
    public static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int data;

        Pair(int li, int di, int data) {
            this.li = li;
            this.di = di;
            this.data = data;
        }

        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }

    public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.data);
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.data = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return rv;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 5, 3, 1, 0, 3, 2 };
        // KthLargest(arr, 1);
    }
}

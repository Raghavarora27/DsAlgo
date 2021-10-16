import java.util.PriorityQueue;

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

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 1, 0, 3, 2 };
        // KthLargest(arr, 1);
    }
}

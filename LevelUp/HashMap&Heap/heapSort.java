public class heapSort {

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
            swap(arr, maxIdx ,pi);
            downheapify(arr, maxIdx, li, Isincreasing);

        }
    }

    // N + NlogN
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13, 14 };
        boolean Isincreasing = true;
        int li = arr.length - 1;

        // we will create a maxHeap
        for (int i = li; i >= 0; i--) {
            downheapify(arr, i, li, Isincreasing);
        }

        // sort array
        while (li > 0) {
            swap(arr, 0, li--);
            downheapify(arr, 0, li, Isincreasing);
        }

        for (int ele : arr)
            System.out.println(ele);
    }
}

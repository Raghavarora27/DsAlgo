import java.util.*;

public class Merge_Overlapping_Intervals {
    public static void mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0]; // this - other gives default behaviour // a[0] ke basis pe sort hoga
            // return b[0] - a[0] // other - this gives reverse of default behaviour
        });

        LinkedList<int[]> st = new LinkedList<>();
        for (int[] a : arr) {
            int minStartTime = a[0];
            int maxEndingTime = a[1];
            while (st.size() != 0 && a[0] <= st.getFirst()[1]) {
                minStartTime = st.getFirst()[0];
                maxEndingTime = Math.max(maxEndingTime, st.getFirst()[1]);
                st.removeFirst();
            }

            st.addFirst(new int[] { minStartTime, maxEndingTime });
        }

        while (st.size() != 0) {
            int[] a = st.removeLast();
            System.out.println(a[0] + " " + a[1]);
        }
    }
}

import java.io.*;
import java.util.LinkedList;

public class Celebrity_Problem {
    // Leetcode 277
    public static int findCelebrity(int[][] arr) {

        int celebrity = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (celebrity != i && arr[celebrity][i] == 1)
                celebrity = i;
        }

        for (int i = 0; i < n; i++) {
            if (celebrity == i)
                continue;
            if ((arr[celebrity][i] == 1) || (arr[i][celebrity] == 0))
                return -1;
        }

        return celebrity;
    }

    public static int find(int [][] arr){
        int cel = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            if(cel != i && arr[cel][i] == 1)
                cel = i;
        }

        for(int i = 0;i < arr.length; i++){
            if(cel != i && arr[cel][i] == 1 && arr[i][cel] == 0)
                return -1;
        }

        return cel;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        int ans = findCelebrity(arr);
        System.out.println(ans == -1 ? "none" : ans);

    }

    // portal Celebrity
    public static void findcelebrity(int[][] arr) {
        LinkedList<Integer> st = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            st.addFirst(i);
        }
        while (st.size() >= 2) {
            int i = st.removeFirst();
            int j = st.removeFirst();

            if (arr[i][j] == 1) {
                // i knows j -> i is not the celebrity
                st.addFirst(j);
            } else {
                // i doesnot knows j -> i is the celebrity
                st.addFirst(i);
            }
        }

        int potential = st.removeFirst();
        for (int i = 0; i < arr.length; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);
    }
}
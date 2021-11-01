import java.util.*;

public class SpiralDisplay {

    public static void spiral(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int rmin = 0;
        int rmax = n - 1;
        int cmin = 0;
        int cmax = m - 1;
        int Totalcount = n * m;

        while (Totalcount > 0) {

            for (int r = rmin; r <= rmax && Totalcount > 0; r++) {
                System.out.print(arr[r][cmin] + "    ");
                Totalcount--;
            }
            cmin++;

            for (int c = cmin; c <= cmax && Totalcount > 0; c++) {
                System.out.print(arr[rmax][c] + "    ");
                Totalcount--;
            }
            rmax--;

            for (int r = rmax; r >= rmin && Totalcount > 0; r--) {
                System.out.print(arr[r][cmax] + "    ");
                Totalcount--;
            }
            cmax--;

            for (int c = cmax; c >= cmin && Totalcount > 0; c--) {
                System.out.print(arr[rmin][c] + "    ");
                Totalcount--;
            }
            rmin++;
        }
    }

    public static void Input(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        Input(arr);
        spiral(arr);
    }
}

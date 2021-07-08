import java.util.*;

public class Rotate {

    public static int length(int n) {
        int nod = 0;
        while (n != 0) {
            n = n / 10;
            nod++;
        }
        return nod;
    }

    public static int rotateNumber(int n, int k) {
        int divisor = 1;
        int multiplier = 1;

        for (int i = 1; i <= length(n); i++) {

            if (i <= k) {
                divisor *= 10;
            } else {
                multiplier *= 10;
            }
        }

        int part_1 = n / divisor;
        int rem = n % divisor;
        int ans = rem * multiplier + part_1;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int len = length(n);
        k = k % len;
        if (k < 0) {
            k = k + len;
        }
        System.out.println(rotateNumber(n, k));
    }
}
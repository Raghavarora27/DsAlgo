import java.util.*;

public class printIncreasingDecreasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printincreasingdecreasing(n);
        sc.close();
    }

    public static void printincreasingdecreasing(int n) {
        if (n < 1)
            return;

        System.out.println(n);
        printincreasingdecreasing(n - 1);
        System.out.println(n);
    }

}
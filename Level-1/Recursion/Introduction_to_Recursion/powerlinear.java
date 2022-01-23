import java.util.*;

public class powerlinear {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(power(x, n));
        sc.close();
    }

    public static int power(int x, int n) {
        if (n < 1)
            return 1;
        return x * power(x, n - 1);
    }

}
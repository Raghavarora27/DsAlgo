import java.util.*;

public class factorial {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Factorial(n));
        sc.close();
    }

    public static int Factorial(int n) {
        if (n <= 1)
            return 1;
        return n * Factorial(n - 1);
    }

}
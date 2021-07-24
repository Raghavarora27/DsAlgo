import java.util.*;

public class Pythagoras_Trip {

    public static void checkTriplet(int a, int b, int c) {
        if (a > b && a > c) {
            if (b * b + c * c == a * a) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } else if (b > a && b > c) {
            if (a * a + c * c == b * b) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } else if (c > b && c > a) {
            if (a * a + b * b == c * c) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        checkTriplet(a, b, c);
    }

}
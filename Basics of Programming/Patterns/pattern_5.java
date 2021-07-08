import java.util.*;

public class pattern_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int star = 1;
        int space = n / 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }
            System.out.println();

            if (i <= n / 2) {
                star = star + 2;
                space--;
            } else {
                star = star - 2;
                space++;
            }

        }

    }
}
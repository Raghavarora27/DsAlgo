import java.util.*;

public class DTB {

    public static void decimalToBinary(int n){
        int pow = 1;
        int ans = 0;
        while(n != 0){
            ans = ans + (n % 2) * pow;
            pow *= 10;
            n = n / 2;
        }

        System.out.println(ans);
    }


    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int n = sc.nextInt();
        decimalToBinary(n);
    }    
}

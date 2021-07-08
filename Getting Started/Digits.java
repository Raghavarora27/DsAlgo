import java.util.*;

public class Digits {
    
    public static int power(int n){
        int pow = 1;
        n = n / 10;
        while(n != 0){
            n = n / 10;
            pow = pow * 10;
        }
        return pow;
    }


    public static void digits_of_number(int n){
        int pow = power(n);
        while(pow != 0){
            System.out.println(n / pow);
            n = n % pow;
            pow = pow / 10;
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        digits_of_number(n);
    }
}

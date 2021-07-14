import java.util.*;

public class DTAB {

    public static void decimalToAnyBase(int n,int b){
        int pow = 1;
        int ans = 0;
        while(n != 0){
            ans = ans + (n % b) * pow;
            pow *= 10;
            n = n / b;
        }

        System.out.println(ans);
    }


    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int n = sc.nextInt();
        int b = sc.nextInt();
        decimalToAnyBase(n,b);
    }    
}

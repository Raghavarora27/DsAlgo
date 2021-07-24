import java.util.*;

public class ABTAB {
    
    public static Scanner sc = new Scanner(System.in);

    public static int anyBasetoDecimal(int n,int b){
        int pow = 1;
        int ans = 0;

        while(n != 0){
            
            ans = ans + (n % 10)*pow;
            
            pow *= b;
            n /= 10;
        }
        return ans;
    }

    public static int decimalToAnyBase(int n,int b){
        int pow = 1;
        int ans = 0;
        while(n != 0){
            ans = ans + (n % b) * pow;
            pow *= 10;
            n = n / b;
        }

        return ans;
    }

    public static void main(String [] args){
        int n = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int decimalNumber = anyBasetoDecimal(n, b1);
        System.out.println(decimalToAnyBase(decimalNumber, b2));
    }

}

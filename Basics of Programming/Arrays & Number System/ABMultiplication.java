import java.util.*;

public class ABMultiplication {

    public static int anyBaseMultiplication(int n1,int n2,int b){
        int carry = 0;
        int pow = 1;
        int ans = 0;

        while(n1 != 0 || carry != 0){
            int res = ((n1 % 10) * n2) + carry;

            carry = res / b;
            res = res % b;

            ans = ans + res * pow;


            n1 /= 10;
            pow *= 10;

        }

        return ans;
    }

    public static int anyBaseAddition(int n1,int n2,int b){
        int carry = 0;
        int ans = 0;
        int pow = 1;
        
        while(n1 != 0 || n2 != 0 || carry != 0){

            int res = (n1 % 10) + (n2 % 10) + carry;
            
            carry = res / b;
            res = res % b;
            ans = ans + res*pow;

            n1 /= 10;
            n2 /= 10;
            pow *= 10;

        }
        return ans;
    }

    public static int result(int n1,int n2,int b){
        int ans = 0;
        int pow = 1;
        while(n2 != 0){
            int res = anyBaseMultiplication(n1, n2%10, b)*pow;
            ans = anyBaseAddition(ans, res, b);
            pow *= 10;
            n2 /= 10;
        }

        return ans;
    }


    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.print(result(n1,n2,b));
    }
}

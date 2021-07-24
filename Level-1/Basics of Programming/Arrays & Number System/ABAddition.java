import java.util.*;

public class ABAddition {
    
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

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.print(anyBaseAddition(n1,n2, b));
    }
}

import java.util.*;

public class ABSubtraction {
    
    public static int anyBaseSubtraction(int n1,int n2,int b){
        int borrow = 0;
        int ans = 0;
        int pow = 1;
        
        while(n1 != 0 || n2 != 0 || borrow != 0){

            int res = -(n1 % 10) + (n2 % 10) + borrow;
            
            if(res < 0){
                res += b;
                borrow = -1;
            }
            else{
                borrow = 0;
            }

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
        System.out.print(anyBaseSubtraction(n1,n2,b));
    }
}

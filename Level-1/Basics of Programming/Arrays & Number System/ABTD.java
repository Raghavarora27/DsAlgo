import java.util.*;
public class ABTD {
    
    public static void anyBasetoDecimal(int n,int b){
        int pow = 1;
        int ans = 0;

        while(n != 0){
            
            ans = ans + (n % 10)*pow;
            
            pow *= b;
            n /= 10;
        }
        System.out.println(ans);
    } 

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int n = sc.nextInt();
        int b = sc.nextInt();
        anyBasetoDecimal(n,b);
    }
}

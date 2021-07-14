import java.util.*;
public class BTD {
    
    public static void binarytoDecimal(int n){
        int pow = 1;
        int ans = 0;

        while(n != 0){
            
            ans = ans + (n % 10)*pow;
            
            pow *= 2;
            n /= 10;
        }
        System.out.println(ans);
    } 

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int n = sc.nextInt();
        binarytoDecimal(n);
    }
}

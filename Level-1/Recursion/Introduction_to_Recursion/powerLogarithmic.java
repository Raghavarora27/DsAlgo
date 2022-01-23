import java.util.*;

public class powerLogarithmic {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(power(a,b));
        sc.close();
    }

    public static int power(int x, int n){
        if(n==0)
        return 1;
        
        int ans = power(x,n/2);
        ans *= ans;
        return n % 2 == 0 ? ans : ans*x;
    }

}
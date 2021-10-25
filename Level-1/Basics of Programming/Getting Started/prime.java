import java.util.*;

public class prime {
    
    public static void prime_no(int n){
        boolean flag = true;
        for(int i=2;i*i<=n;i++){
            if(n % i == 0)
                flag = false;
        }
        if(!flag)
            System.out.println("not prime");
        else 
            System.out.println("prime");
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            prime_no(n);
        }
        sc.close();
    }     
}

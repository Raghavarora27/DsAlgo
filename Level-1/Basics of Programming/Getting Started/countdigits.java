import java.util.*;

public class countdigits {
    
    public static void count(int n){
        int c = 0;
        while(n != 0){
            c++;
            n = n / 10;
        }
        System.out.println(c);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(n);
    }
}

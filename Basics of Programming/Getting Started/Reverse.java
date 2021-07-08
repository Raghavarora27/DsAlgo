import java.util.*;

public class Reverse {
    
    public static void reverse_no(int n){
        while(n != 0){
            System.out.println(n % 10);
            n = n / 10;
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reverse_no(n);
    }
}

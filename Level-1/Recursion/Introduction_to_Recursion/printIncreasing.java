import java.util.*;

public class printIncreasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printincreasing(n);
    }

    public static void printincreasing(int n){
        if(n < 1)
            return;
        
        printincreasing(n-1);
        System.out.println(n);
    }

}
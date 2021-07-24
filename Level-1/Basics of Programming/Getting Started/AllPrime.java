import java.util.*;

public class AllPrime {
    
    public static void prime(int low , int high){
        for(int i=low;i<=high;i++){
            boolean flag = true;
            for(int j=2;j*j<=i;j++){
                if(i % j == 0)
                    flag = false;
            }
            if(flag)
                System.out.println(i);
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        prime(low, high);
    }
}

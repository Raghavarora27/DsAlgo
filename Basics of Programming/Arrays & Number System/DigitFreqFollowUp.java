import java.util.*;

public class DigitFreqFollowUp {
    
    public static void digit(long n,int [] query){
        int [] arr = new int[10];

        while(n != 0){
            long no = n % 10;
            arr[(int)no]++;
            n = n / 10;
        }
        for(int ele : query)
            System.out.println(arr[ele]);
    }


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int [] query = new int[sc.nextInt()];

        for(int i=0;i<query.length;i++){
            query[i] = sc.nextInt();
        }
        digit(n, query);

    }
}

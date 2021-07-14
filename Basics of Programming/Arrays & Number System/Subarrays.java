import java.util.*;

public class Subarrays{

    public static void print_range(int [] arr,int si,int ei){
        while(si <= ei){
            System.out.print(arr[si] + "    ");
            si++;
        }
        System.out.println();
    }

    public static void subarray(int [] arr){
        
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                print_range(arr, i, j);
            }
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        subarray(arr);
    }
}
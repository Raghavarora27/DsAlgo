import java.util.*;

public class Arrays{

    public static int maximum(int [] arr){
        int max = (int)-1e9;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    
    public static int minimum(int [] arr){
        int min = (int)1e9;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int find(int [] arr , int n){
        int idx = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == n)
                return i;
        }
        return idx;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = {1,2,3,4,5,78,6,54,3};
        System.out.println(maximum(arr));
        System.out.println(minimum(arr));
        System.out.println(find(arr, 54));
        sc.close();
    }
}
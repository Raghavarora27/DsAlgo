import java.util.*;

public class PatitionOverPivot {
    
    public static void partition(int [] arr,int pivotIdx){
        int n = arr.length;
        swap(arr,pivotIdx,n-1);

        int p = -1, itr = 0,li = n-1;
        while(itr < n){
            if(arr[itr] < arr[li])
                swap(arr,++p,itr);
            itr++;
        }
        swap(arr,++p,li);
    }

    public static void print(int [] arr){
        for(Integer i : arr)
            System.out.println(i);
    }

    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = {4,3,2,10,12,1,5,6};
        int pivotIdx = sc.nextInt(); 
        partition(arr, pivotIdx);
        print(arr);
        sc.close();
    }
}
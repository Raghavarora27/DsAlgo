public class Rotate {

    // Brute Force -  O(n*n)
    public static void rotate(int [] arr,int k){
        k = k % arr.length;
        if(k < 0)
            k += arr.length;

        for(int i=0;i<k;i++){
            int temp = arr[arr.length-1];
            for(int j=arr.length-1;j>=1;j--){
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "   ");
        }
    }

    // Optimised - O(n)
    
    public static void reverse(int [] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotate2(int [] arr,int k){
        if(arr.length == 1) return;

        k = k % arr.length;
        if(k < 0)
            k += arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "   ");
        }
    }
   public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8};
        rotate2(arr,3);
   } 
}

import java.util.*;

public class TwoDArray{

    public static int maximum(int [][] arr){
        int max = -(int)1e9;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        return max;
    }
    
    public static int minimum(int [][] arr){
        int min = (int)1e9;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] < min)
                    min = arr[i][j];
            }
        }
        return min;
    }
    
    public static void Display(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    
    public static boolean find(int [][] arr,int data){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == data)
                    return true;
            }
        }
        return false;
    }

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args){
        int [][] arr = new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int data = sc.nextInt();
        System.out.println(maximum(arr));
        System.out.println(minimum(arr));
        System.out.println(find(arr, data));

    }
}
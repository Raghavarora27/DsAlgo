import java.util.*;

public class ForwardBackward {
    
    public static void FB(int [][] arr){
        for(int i=0;i<arr.length;i++){
            if(i % 2 == 0){
                for(int j=0;j<arr[0].length;j++){
                    System.out.print(arr[i][j] + "  ");
                }
            }
            else{
                for(int j=arr[0].length-1;j>=0;j--){
                    System.out.print(arr[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void Input(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int [][] arr = new int[sc.nextInt()][sc.nextInt()];
        Input(arr);
        FB(arr);
    }
}

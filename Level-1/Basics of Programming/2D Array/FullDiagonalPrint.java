import java.util.*;

// State of Wakanda 2 or Diagonal Print
public class FullDiagonalPrint {
    
    public static void diagonalprint(int [][] arr){
        for(int gap=arr.length-1;gap>=1;gap--){
            for(int i=gap,j=0;i<arr.length && j<arr[0].length;i++,j++){
                System.out.println(arr[i][j]);
            }
        }
        
        for(int gap=0;gap<arr[0].length;gap++){
            for(int i=0,j=gap;i<arr.length && j<arr[0].length;i++,j++){
                System.out.println(arr[i][j]);
            }
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
        diagonalprint(arr);
    }
}

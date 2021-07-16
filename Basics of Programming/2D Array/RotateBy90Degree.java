import java.io.*;
import java.util.*;

public class RotateBy90Degree {

    public static void rotate(int [][] arr){
        Transpose(arr);
        int n = arr.length;
        int si = 0,ei = n-1;
        while(si < ei){
            for(int i=0;i<n;i++){
                int temp = arr[i][si];
                arr[i][si] = arr[i][ei];
                arr[i][ei] = temp;
            }
            si++;
            ei--;
        }    
    }
    
    public static void Transpose(int [][] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    } 

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        rotate(arr);
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
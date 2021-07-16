import java.io.*;
import java.util.*;

public class SaddlePrice {
    public static int col_max(int [][] arr,int idx_column){
        int n = arr.length;
        int max = -(int)1e9;
        int idx = -1;
        
        for(int j=0;j<n;j++){
            if(arr[j][idx_column] > max){
                max = arr[j][idx_column];
                idx = j;
            }
        }
        return idx;
    }
    public static void saddleprice(int [][] arr){
        int n = arr.length;
        boolean flag = false;
        
        for(int i=0;i<n;i++){
            int idx_column = -1;
            int min = (int)1e9;
            for(int j=0;j<n;j++){
                if(arr[i][j] < min){
                    min = arr[i][j];
                    idx_column = j;
                }
            }
            int idx = col_max(arr,idx_column);
            
            if(idx == i){
                System.out.println(arr[idx][idx_column]);
                flag = true;
            }
        }
        if(!flag)
            System.out.println("Invalid input");
    } 
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        saddleprice(arr);
    }

}
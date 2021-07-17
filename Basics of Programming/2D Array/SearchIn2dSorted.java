import java.util.*;

public class SearchIn2dSorted{

    public static boolean searchMatrix(int[][] arr, int data) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == data){
                    return true;
                }
                
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] arr, int data) {
        int n = arr.length;
        int i = 0,j=arr[0].length-1;
        
        while(i < n && j >= 0){
            if(arr[i][j] == data){
                return true;
            }
            else if(arr[i][j] < data){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int [][] arr = new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int data = sc.nextInt();
        searchMatrix(arr,data);

    }
}

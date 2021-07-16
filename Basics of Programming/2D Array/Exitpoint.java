import java.io.*;
import java.util.*;

public class Exitpoint {
    public static void exitPoint(int [][] arr){
        int n = arr.length,m =arr[0].length;
        int dir = 0;
        int i = 0,j = 0;
        while(true){
            dir = (dir + arr[i][j]) % 4;
            
            if(dir == 0){
                j++;
                if(j == m){ // north
                    System.out.println(i);
                    System.out.println(j-1);
                    break;
                }
            }
            else if(dir == 1){
                i++;
                if(i == n){ // east
                    System.out.println(i - 1);
                    System.out.println(j);
                    break;
                }
            }
            else if(dir == 2){
                j--;
                if(j == -1){ // south
                    System.out.println(i);
                    System.out.println(j+1);
                    break;
                }
            }
            else{
                i--;
                if(i == -1){ // west
                    System.out.println(i + 1);
                    System.out.println(j);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        exitPoint(arr);
    }

}
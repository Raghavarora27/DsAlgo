import java.io.*;
import java.util.*;

public class SumOfTwoArray{
    
    
    public static void SumOfTwoArray(int [] arr1,int [] arr2){
        int [] ans = new int[Math.max(arr1.length,arr2.length) + 1];
        
        int i = arr1.length-1;
        int j = arr2.length-1;
        int k = ans.length-1;
        
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0){
            int sum = (i < 0 ? 0 : arr1[i]) + (j < 0 ? 0 : arr2[j] ) + carry;
            carry = sum / 10;
            sum %= 10;
            
            ans[k] = sum;
            
            i--;
            j--;
            k--;
        }
        
        for(int z=0;z<ans.length;z++){
            if(z==0 && ans[z]==0){
                continue;
            }
            System.out.println(ans[z]);
        }
    }

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] arr1 = new int[n1];
        
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        
        
        int n2 = sc.nextInt();
        int [] arr2 = new int[n2];
        
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        
        SumOfTwoArray(arr1,arr2);
     }

}
import java.util.*;

public class DiffOfTwoArray{

    public static void SubtractOfTwoArray(int [] arr1,int [] arr2){
        int [] ans = new int[arr2.length];
        
        int i = arr1.length-1;
        int j = arr2.length-1;
        int k = ans.length-1;
        
        int borrow = 0;
        
        while(i >= 0 || j >= 0 || borrow != 0 ){
            int diff = (j < 0 ? 0 : arr2[j]) - (i < 0 ? 0 : arr1[i]) + borrow;
            
            if(diff < 0){
                borrow = -1;
                diff += 10;
            }
            else{
                borrow = 0;
            }
            
            ans[k] = diff;
            
            i--;
            j--;
            k--;
        }
        
        for(int  z=0;z<ans.length;z++){
            if(z==0 && ans[z] == 0)
                continue;
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
        SubtractOfTwoArray(arr1,arr2);
        
     }

}
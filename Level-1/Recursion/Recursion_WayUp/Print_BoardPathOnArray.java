import java.util.*;

public class Print_BoardPathOnArray{

    public static int BoardPathOnArrays(int [] arr,int n,String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int jump : arr){
            if(n - jump >= 0)
                count += BoardPathOnArrays(arr,n - jump,ans + jump);
        }
        
        return count;
    }

    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int [] arr = {2,1,3,6};
        int n = sc.nextInt();
        
        System.out.println(BoardPathOnArrays(arr,n,""));
    }
}
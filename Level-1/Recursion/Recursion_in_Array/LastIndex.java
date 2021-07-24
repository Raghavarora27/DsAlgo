import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(Lastindex(arr,0,x));
    }

    public static int Lastindex(int[] arr, int idx, int x){
        if(idx == arr.length)
            return -1;
        
        int ans = Lastindex(arr,idx+1,x);
        
        if(ans != -1){
            return ans;
        }
        return arr[idx]==x ? idx : -1;
    }

}
import java.util.*;

public class BrokenEconomy{
    
public static void CeilFloor(int [] arr,int data){
    int ceil = 0;
    int floor = 0;
    int si = 0;
    int ei = arr.length-1;
    
    while(si <= ei){
        int mid =  (si + ei) / 2;
        
        if(arr[mid] == data){
            System.out.println(arr[mid]);
        }
        else if(arr[mid] < data){
            si = mid + 1;
            floor = arr[mid];
        }
        else{
            ei = mid - 1;
            ceil = arr[mid];
        }
    }
    System.out.println(ceil);
    System.out.println(floor);
}

public static Scanner sc = new Scanner(System.in); 
public static void main(String[] args) throws Exception {
    int n = sc.nextInt();
    int [] arr = new int[n];
    
    for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    int data = sc.nextInt();
    CeilFloor(arr,data);
 }

}
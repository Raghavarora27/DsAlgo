import java.util.*;

public class RemoveData{

    public static void swap(ArrayList<Integer> arr,int i,int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }
    //O(n)
    public static void removedata(ArrayList<Integer> arr,int data){
        int i = 0;
        int j = arr.size()-1;
        while(i <= j){
            if(arr.get(i) == data){
                swap(arr, i, j);
                arr.remove(j);
                j--;
            }
            else{
                i++;
            }
        }
        System.out.print(arr);
    }
    

    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<15;i++){
            int a = sc.nextInt();
            arr.add(a);    
        }
        int data = sc.nextInt();
        removedata(arr,data);
    }
}
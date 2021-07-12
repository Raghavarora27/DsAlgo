public class Reverse {

    public static int [] reverse(int [] arr){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    } 

    public static void main(String [] args){
        int [] arr = {2,34,33,56,4,23,1};
        int [] arr2 = reverse(arr);
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] + "    ");
        }
    }
}

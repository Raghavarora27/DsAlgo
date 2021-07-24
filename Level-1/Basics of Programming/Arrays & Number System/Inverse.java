public class Inverse {

    public static int [] inv_array(int [] arr){
        int [] arr2 = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int idx = arr[i];
            int val = i;
            arr2[idx] = val; 
        }

        return arr2;
    }


    public static void main(String [] args){
        int [] arr = {2,3,4,0,1};
        int [] ans = inv_array(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + "    ");
        }
    }
}

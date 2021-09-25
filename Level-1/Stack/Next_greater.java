import java.util.*;

public class Next_greater{

    public static void nextGreater(int [] arr){
        int n = arr.length;
        int [] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            while(st.size() != 0 && arr[st.getFirst()] < arr[i])
                ans[st.removeFirst()] = arr[i];
            
            st.addFirst(i);
        }

        for(int ele : ans)
            System.out.println(ele);
    }

    public static void main(String [] args){
        
    }
}
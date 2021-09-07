import java.util.*;

// Leetcode 215
public class QuickSelect{
    
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int partition(int [] arr,int si,int ei,int Pidx){
        swap(arr,Pidx,ei);
        int p = si - 1,itr = si;
        while(itr <= ei){
            if(arr[itr] <= arr[ei])
                swap(arr,++p,itr);
            itr++;
        }
        return p;
    }
    
    public static void quickselect(int [] arr,int si,int ei,int idx){
        if(si > ei)
            return;
            
        int Pivot = ei;
        int pidx = partition(arr,si,ei,Pivot);
        
        if(pidx == idx)
            return;
        else if(idx > pidx)
            quickselect(arr,pidx+1,ei,idx);
        else
            quickselect(arr,si,pidx-1,idx);
    }
    
    public static int quickselect(int [] arr,int k){
        int n = arr.length,idx = n-k;
        quickselect(arr,0,n-1,idx);
        return arr[idx];
    }
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int [] arr = {48,26,-50,-2,0,18,10};
        int k = 3;
        System.out.println(quickselect(arr,k));
    }
}
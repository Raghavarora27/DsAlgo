import java.util.*;

public class TargetSum {
    // Merge Sort
    public static int [] MergeTwoSortedArray(int [] A,int [] B){
        if(A.length == 0 || B.length == 0)
            return A.length == 0 ? B : A;
        
        int n = A.length,m = B.length,len = n + m;
        int i = 0,j = 0,k = 0;
        int [] arr = new int[len];
        
        while(i < n && j < m){
            if(A[i] < B[j])
                arr[k++] = A[i++];
            else
                arr[k++] = B[j++];
        }
        while(i < n){
            arr[k++] = A[i++];
        }
        while(j < m){
            arr[k++] = B[j++];
        }
        return arr;
    }
    
    public static int []  mergesort(int [] arr,int si,int ei){
        if(si == ei)
            return new int[] {arr[si]};
        
        int mid = (si + ei)/2;
        int [] left = mergesort(arr,si,mid);
        int [] right = mergesort(arr,mid+1,ei);
        
        return MergeTwoSortedArray(left,right);
    }

    // QuickSort
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    public static int partition(int [] arr,int si,int ei,int Pidx){
        int p = si-1,itr = si;
        swap(arr,Pidx,ei);
        while(itr <= ei){
            if(arr[itr] <= arr[ei])
                swap(arr,++p,itr);
            itr++;
        }
        return p;
    }
    
    public static void quicksort(int [] arr,int si,int ei){
        if(si > ei)
            return;
        
        int p = partition(arr,si,ei,ei);
        
        quicksort(arr,si,p-1);
        quicksort(arr,p+1,ei);
    }
    
    // NlogN
    public static void targetSumPair(int[] arr, int target){
        arr = mergesort(arr,0,arr.length-1); // NlogN 
        int i = 0,j = arr.length-1;
        while(i < j){ // O(N)
            if(arr[i]+arr[j] == target){
                System.out.println(arr[i]+", "+arr[j]);
                i++;
                j--;
            }
            else if(arr[i]+arr[j] < target){
                i++;
            }
            else{
                j--;
            }
        }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
    
    scn.close();
  }

}
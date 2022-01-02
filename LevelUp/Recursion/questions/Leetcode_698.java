package questions;

import java.util.ArrayList;

public class Leetcode_698 {
    class Solution {
        public boolean canPartitionKSubsets(int[] arr, int k) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < k; i++)
                ans.add(new ArrayList<>());

            int sum = 0;
            for (int ele : arr)
                sum += ele;

            int[] subsetSum = new int[k];
            return kSubsets(arr, 0, subsetSum, ans);
        }

        public boolean kSubsets(int[] arr, int idx, int[] subsetSum, ArrayList<ArrayList<Integer>> ans) {
            if (idx == arr.length) {
                int s = subsetSum[0];
                for (int ele : subsetSum)
                    if (ele != s)
                        return false;

                return true;
            }

            boolean res = false;

            for (int k = 0; k < subsetSum.length; k++) {
                ArrayList<Integer> set = ans.get(k);
                set.add(arr[idx]);
                subsetSum[k] += arr[idx];

                res = res || kSubsets(arr, idx + 1, subsetSum, ans);
                if (res)
                    return res;
                subsetSum[k] -= arr[idx];
                set.remove(set.size() - 1);
                if (set.size() == 0)
                    break;
            }
            return res;
        }
    }

    class Solution2 {
        public boolean canPartitionKSubsets(int[] arr, int k) {
            int n = arr.length;
            int sum = 0;
            int maxEle = 0;
            for(int ele : arr){
                sum += ele;
                maxEle = Math.max(maxEle,ele);
            }
            
            if(sum % k != 0 || maxEle > sum / k)    return false;
            boolean [] vis = new boolean[n];
            return canPartitionKSubsets(arr,k,0,0,sum / k,vis);
        }
        
        public boolean canPartitionKSubsets(int [] arr,int k,int idx,int sumSF,int tar,boolean [] vis){
            if(k == 0)  return true;
            if(sumSF > tar) return false;
            if(sumSF == tar){
                return canPartitionKSubsets(arr,k - 1,0,0,tar,vis);
            }
            
            boolean res = false;
            for(int i = idx;i < arr.length;i++){
                if(vis[i])  continue;
                vis[i] = true;
                res = res || canPartitionKSubsets(arr,k,i + 1,sumSF + arr[i],tar,vis);
                vis[i] = false;
            }
            
            return res;
        }
    }
}
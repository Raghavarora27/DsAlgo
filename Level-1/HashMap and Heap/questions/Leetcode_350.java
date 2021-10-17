package questions;

import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode_350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> res = new ArrayList<>();
            
            for(int ele : nums1)
                map.put(ele,map.getOrDefault(ele,0) + 1);
            
            for(int ele : nums2){
                if(map.containsKey(ele)){
                    res.add(ele);
                    map.put(ele,map.get(ele) - 1);
                    if(map.get(ele) == 0)   map.remove(ele);
                }
            }
            
            int [] ans = new int[res.size()];
            for(int i = 0; i < res.size(); i++)
                ans[i] = res.get(i);
            return ans;
        }
    }
}

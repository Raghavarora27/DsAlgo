import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class slidingWindow{
    // Maximum Sum Subarray of size K
    // O(n)
    public static int max_sum(int k, int [] arr){
        int sum = 0;
        // finding the sum of first K size window 
        for(int i = 0;i < k;i++){
            sum += arr[i];
        }

        int ans = sum;
        for(int i = k;i < arr.length;i++){
            sum += arr[i] - arr[i - k];
            ans = Math.max(sum,ans);
        }

        return ans;
    }

    // First negative integer in every window of size k
    public static int [] FirstNegativeWindow(int k,int [] arr){
        int [] ans = new int[arr.length - k + 1];
        int idx = 0,i = 0,j = 0,n = arr.length;
        
        LinkedList<Integer> que = new LinkedList<>();
        while(j < n){
            if(arr[j] < 0)
                que.addLast(arr[j]);
                
            if(j - i + 1 == k){
                // window
                if(que.size() == 0){
                    ans[idx++] = 0;
                }
                else{
                    ans[idx++] = que.getFirst();
                    if(arr[i] == que.getFirst()){
                        que.removeFirst();
                    }
                }
                i++;
            }
            j++;
        }

        return ans;
    }

    // Count Occurences of Anagrams
    public static int CountAnagrams(String str,String res){
        int[] strList = new int[26];
        int[] resList = new int[26];

        int n = str.length(),k = res.length();
        for(int i = 0;i < k;i++){
            strList[str.charAt(i) - 'a']++;
            resList[res.charAt(i) - 'a']++;
        }

        int count = 0;
        if(Arrays.equals(resList,strList)){
            count++;
        }
    
        for(int i = k;i < n;i++){
            strList[str.charAt(i) - 'a']++;
            strList[str.charAt(i - k) - 'a']--;

            if(Arrays.equals(resList,strList)){
                count++;
            }
        }

        return count;
    }

    // 239. Sliding Window Maximum
    // O(n * k)
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int [] ans = new int[nums.length - k + 1];
        
        int idx = 0;
        for(int i = 0;i < nums.length - k + 1;i++){
            int max = -(int)1e9;
            for(int j = i;j < i + k;j++){
                max = Math.max(max,nums[j]);
            }
            ans[idx++] = max;
        }
        
        return ans;
    }

    // O(n)
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n - k + 1];
        int idx = 0;

        LinkedList<Integer> Deque = new LinkedList<>(); // store index

        for(int i = 0;i < n;i++){
            // remove numbers out of range K
            if(Deque.size() != 0 && Deque.getFirst() == i - k)
                Deque.removeFirst();
            
            // remove smaller numbers in k range as they are useless
            while(Deque.size() != 0 && nums[Deque.getLast()] <= nums[i])
                Deque.removeLast();

            Deque.addLast(i);

            // start setting answer array after passing the first window of size K
            if(i >= k - 1){
                ans[idx++] = nums[Deque.getFirst()];
            }
        }

        return ans;
    }   

    // 560. Subarray Sum Equals K
    // TC : O(n) SC : O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        int sum = 0,count = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        
        return count;
    }

    // 76. Minimum Window Substring
    // TC : O(n) SC : O(n) where n = s.length()
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        
        // Storing character with its frequency
        HashMap<Character,Integer> map1 = new HashMap<>(); // for s string
        HashMap<Character,Integer> map2 = new HashMap<>(); // for t string
        
        // filling map2
        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0) + 1);
        }
        
        int mcnt = 0, dmcnt = t.length(); // match count and desired match count
        int i = -1, j = -1;
        String ans = "";
        while(true){
            
            // for exit
            boolean flag1 = false;
            boolean flag2 = false;
                      
            // acquire till mcnt < mdcnt
            while(i < s.length() - 1 && mcnt < dmcnt){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0) + 1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0))
                    mcnt++;
                flag1 = true;
                
            }
            
            // collect answer and release
            // now we have answer but we will make our answer better by releasing characters
            while(j < i && mcnt == dmcnt){
                // Collecting answer
                String pAns = s.substring(j + 1,i + 1); // potential Answer
                if(ans.length() == 0 || pAns.length() < ans.length())
                    ans = pAns;
                
                // now releasing
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1)
                    map1.remove(ch);
                else
                    map1.put(ch,map1.get(ch) - 1);
                
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0))
                   mcnt--;
                   
                flag2 = true;
            }
            
            if(flag1 == false && flag2 == false)
                break;
        }
 
        return ans;
    }

    // 1052. Grumpy Bookstore Owner
    // O(n * minutes) where n = customers.length
    public int maxSatisfied_1(int[] customers, int[] grumpy, int minutes) {
        int totalZeroSum = 0;
        for(int i = 0;i < customers.length;i++){
            if(grumpy[i] == 0)
                totalZeroSum += customers[i];
        }
        
        int total = 0;
        for(int i = 0;i < customers.length - minutes + 1;i++){
            int max = 0;
            for(int j = i;j < i + minutes;j++){
                if(grumpy[j] == 1)
                    max += customers[j];
            }
            total = Math.max(max,total);
        }

        return totalZeroSum + total;
    }

    // O(n)
    public int maxSatisfied_2(int[] customers, int[] grumpy, int minutes) {
        int Satisfied = 0;
        for(int i = 0;i < customers.length;i++){
            if(grumpy[i] == 0)
                Satisfied += customers[i];
        }
        
        int unsatisfied = 0;
        // first window
        for(int i = 0;i < minutes;i++){
            if(grumpy[i] == 1)
                unsatisfied += customers[i];
        }
        
        int max = unsatisfied;
        for(int i = minutes;i < customers.length;i++){
            if(grumpy[i] == 1)
                max += customers[i];
            
            if(grumpy[i - minutes] == 1)
                max -= customers[i - minutes];
            
            unsatisfied = Math.max(max,unsatisfied);
        }

        return Satisfied + unsatisfied;
    }

    // 480. Sliding Window Median
    class Solution {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        
        public double[] medianSlidingWindow(int[] nums, int k) {
            double [] ans =  new double[nums.length - k + 1];
            int idx = 0;
            
            for(int i = 0;i < k;i++){
                addNum(nums[i]);
            }
            
            ans[0] = findMedian();
            
            for(int i = k;i < nums.length;i++){
                deleteNum(nums[idx++]);
                addNum(nums[i]);
                ans[idx] = findMedian();
            }
            
            return ans;
        }
        
        public void addNum(int num){
            if(pqMax.size() == 0 || pqMax.peek() > num)
                pqMax.add(num);
            else
                pqMin.add(num);
    
            if(pqMax.size() > pqMin.size() + 1)
                pqMin.add(pqMax.remove());
            else if(pqMin.size() > pqMax.size() + 1)
                pqMax.add(pqMin.remove());
        }
        
        public double findMedian() {
            if(pqMax.size() == pqMin.size()){
                return ((double)(pqMax.peek())) / 2.0 + ((double)(pqMin.peek())) / 2.0;
            }   
            return pqMax.size() > pqMin.size() ? pqMax.peek() : pqMin.peek();
        }
        
        public void deleteNum(int num){
            boolean isDelete = pqMax.remove(num);
            if(!isDelete)
                pqMin.remove(num);
            
            if(pqMax.size() > pqMin.size() + 1)
                pqMin.add(pqMax.remove());
            else if(pqMin.size() > pqMax.size() + 1)
                pqMax.add(pqMin.remove());
        }
    }

    public static void main(String [] args){
        // int [] arr = {-8,2,3,-6,10};
        // int [] ans = FirstNegativeWindow(2, arr);

        // for(int ele : ans)
        //     System.out.print(ele + " ");

        // CountAnagrams("raghav", "res");
    }
}
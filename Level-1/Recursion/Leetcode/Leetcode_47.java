class Solution {
    public void permuteUnique(int [] arr,int count,List<Integer> ans,List<List<Integer>> res) {
        if(count == arr.length){
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return;
        }
        
        int prev = -100;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > -10 && arr[i] < 10 && arr[i] != prev){
                int val = arr[i];
                arr[i] = -100;
                ans.add(val);
                
                permuteUnique(arr,count+1,ans,res);
                
                ans.remove(ans.size()-1);
                arr[i] = val;
            }
            prev = arr[i];
            
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        int [] a = new int[26];
        for(int i=0;i<arr.length;i++){
            a[arr[i]+11]++;
        }
        
        int k=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<a[i];j++){
                arr[k++] = i-11; 
            }
        }
        permuteUnique(arr,0,ans,res);
        return res;
    }
}
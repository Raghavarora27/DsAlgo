import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Questions {

    public static int c = 0;

    public static void friendsPair(int count, int n, boolean[] used, String asf) {
        if (count == n) {
            System.out.println(c++ + "." + asf);
            return;
        }

        int fup = 1; // first un-used person
        while (fup <= n && used[fup])
            fup++;

        used[fup] = true;
        friendsPair(count + 1, n, used, asf + "(" + fup + ") ");

        for (int pp = fup + 1; pp <= n; pp++) {
            if (!used[pp]) {
                used[pp] = true;
                friendsPair(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }

        used[fup] = false;
    }

    // hum maximum letter ki length nikal ke ,ei wala loop utna chala sakte h ,isse
    // thoda optimise ho jayega
    public static int wordBreak(String str, String ans, HashSet<String> dict) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int ei = 0; ei < str.length(); ei++) {
            String pWord = str.substring(0, ei + 1);
            if (dict.contains(pWord)) {
                count += wordBreak(str.substring(ei + 1), ans + pWord + " ", dict);
            }
        }

        return count;
    }

    public static String max = "";

    public static void findMaximum(String str, int k, int ii) {
        if (k == 0)
            return;

        for (int i = ii; i < str.length(); i++) {
            int idx = -1;
            char maxCh = '0';
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j) && maxCh < str.charAt(j)) {
                    idx = j;
                    maxCh = str.charAt(j);
                }
            }

            if (idx != -1) {
                for (int j = idx; j < str.length(); j++) {
                    if (str.charAt(j) == maxCh) {
                        String temp = swap(str, i, j);
                        if (isGreater(temp, max))
                            max = temp;
                        findMaximum(temp, k - 1, i + 1);
                    }
                }
            }
        }
    }

    public static boolean isGreater(String temp, String str) {
        if (temp.length() > str.length())
            return true;
        else if (temp.length() < str.length())
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (temp.charAt(i) > str.charAt(i))
                return true;
            else if (temp.charAt(i) < str.charAt(i))
                return false;
        }

        return true;
    }

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char c1 = str.charAt(i);
        char c2 = str.charAt(j);

        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);

        return sb.toString();
    }

    // crypto

    public static int stringToInt(String str, HashMap<Character, Integer> CharIntMap) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + CharIntMap.get(str.charAt(i));
        }
        return res;
    }

    public static void crypto(String unique, int idx, HashMap<Character, Integer> CharIntMap, boolean[] usedNumber,
            String s1, String s2, String s3) {
        if (idx == unique.length()) {
            int x = stringToInt(s1, CharIntMap);
            int y = stringToInt(s2, CharIntMap);
            int z = stringToInt(s3, CharIntMap);

            if (x + y == z) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) (i + 'a');
                    if (CharIntMap.containsKey(ch))
                        System.out.print(ch + "-" + CharIntMap.get(ch) + " ");
                }
                System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);
        for (int num = 0; num < 10; num++) {
            if (!usedNumber[num]) {
                usedNumber[num] = true;
                CharIntMap.put(ch, num);

                crypto(unique, idx + 1, CharIntMap, usedNumber, s1, s2, s3);

                CharIntMap.remove(ch, num);
                usedNumber[num] = false;
            }
        }
    }

    public static int equalSet(int[] arr, int idx, String set1, int sum1, String set2, int sum2) {
        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println(set1 + " = " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += equalSet(arr, idx + 1, set1 + arr[idx] + " ", sum1 + arr[idx], set2, sum2);
        count += equalSet(arr, idx + 1, set1, sum1, set2 + arr[idx] + " ", sum2 + arr[idx]);

        return count;
    }

    public static void kSubsets(int [] arr,int idx,int [] subsetSum,ArrayList<ArrayList<Integer>> ans){
        if(idx == arr.length){
            int s = subsetSum[0];
            for(int ele : subsetSum)
                if(ele != s)
                    return;
            
            for(ArrayList<Integer> a : ans)
                System.out.println(a + " ");
            
            return;
        }

        for(int k = 0;k < subsetSum.length;k++){
            ArrayList<Integer> set = ans.get(k);
            set.add(arr[idx]);
            subsetSum[k] += arr[idx];
            
            kSubsets(arr, idx + 1, subsetSum, ans);
            
            subsetSum[k] -= arr[idx];
            set.remove(set.size() - 1);
            if(set.size() == 0)
                break;
        }
    }

    public static void equalSet(int [] arr,int k){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < k;i++)
            ans.add(new ArrayList<>());
        
        int sum = 0;
        for(int ele : arr)
            sum += ele;
        
        if(sum % k != 0)
            return;
        
        int [] subsetSum = new int[k];
        kSubsets(arr, 0, subsetSum, ans);
        System.out.println(ans);
    }

    public static int count = 1;
    public static void kPartition(int num,int TotalNum,ArrayList<ArrayList<Integer>> ans){
        if(num > TotalNum){
            if(ans.get(ans.size() - 1).size() == 0)
                return;
            
            System.out.print(count++ + ". ");
            for(ArrayList<Integer> a : ans)
                System.out.print(a + " ");
            System.out.println();

            return;
        }

        for(ArrayList<Integer> a : ans){
            a.add(num);

            kPartition(num + 1, TotalNum, ans);

            a.remove(a.size() - 1);
            if(a.size() == 0)
                break;
        }
    }

    public static void main(String [] args){
        int [] arr = {10,20,30,40,50,60,70,80};
        // equalSet(arr, 0, " ", 0, "", 0);
        equalSet(arr, 1, "10 ", 10, "", 0); // to remove mirror sets // 10 ko 2nd set me jane se rok liya
    }
}
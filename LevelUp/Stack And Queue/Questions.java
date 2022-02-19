import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Questions {
    // O(3n)
    public static int[] NGOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n); // n
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < n; i++) { // 2n -- har element pe 2 baar visit kar rhe h
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    public static int[] NSOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    public static int[] NGOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    public static int[] NSOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // 503
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < 2 * n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i % n])
                ans[st.removeFirst()] = i % n;

            if (i < n)
                st.addFirst(i);
        }

        return ans;
    }

    // 438
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = p.charAt(i);
            arr1[ch1 - 'a']++;
            arr2[ch2 - 'a']++;
        }

        int start = 0;
        int end = p.length();

        if (Arrays.equals(arr1, arr2))
            ans.add(start);

        while (end < s.length()) {
            arr1[s.charAt(start) - 'a']--;
            arr1[s.charAt(end) - 'a']++;

            if (Arrays.equals(arr1, arr2))
                ans.add(start + 1);

            start++;
            end++;
        }

        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1/
    public static int[] StockSpan(int[] price) {
        int[] ans = new int[price.length];
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < price.length; i++) {
            int count = 1;
            for (int j = i; j >= 0; j--) {
                while (st.getFirst() != -1 && price[st.getFirst()] < price[i]) {
                    ans[st.removeFirst()] = i;
                }
                st.addFirst(i);
            }
            ans[i] = count;
        }

        return ans;
    }

    // 901
    class StockSpanner {
        int day = 0;
        LinkedList<int[]> st = new LinkedList<>();

        public StockSpanner() {
            // {idx,val}
            st.addFirst(new int[] { -1, -1 });
        }

        public int next(int price) {
            while (st.getFirst()[0] != -1 && st.getFirst()[1] <= price)
                st.removeFirst();

            int span = day - st.getFirst()[0];
            st.addFirst(new int[] { day++, price });
            return span;
        }
    }

    // 20
    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        LinkedList<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.addFirst(ch);
            } else {
                if (st.size() == 0)
                    return false;
                else if (st.getFirst() == '(' && ch != ')')
                    return false;
                else if (st.getFirst() == '{' && ch != '}')
                    return false;
                else if (st.getFirst() == '[' && ch != ']')
                    return false;
                else
                    st.removeFirst();
            }
        }

        return st.size() == 0;
    }

    // 739
    public int[] dailyTemperatures(int[] arr) {
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[arr.length];

        st.addFirst(-1);
        for (int i = 0; i < arr.length; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                int rn = st.removeFirst();
                ans[rn] = i - rn;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // 735
    //// Possible Cases ////
    // + + --> No collision
    // + - --> collision Possible
    // - + --> No collision
    // - - --> No collision
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> st = new LinkedList<>();
        // ArrayDeque<Integer> st = new ArrayDeque<>();
        // read about this
        // yeh LL or stack dono se faster hai
        // linkedlist jaisa feature hai lekin bana array pe hai
        // java me stack LL pe bana hai
        st.addFirst(-1001);

        for (int ele : asteroids) {
            // when element is +ve, no collision
            if (ele > 0) {
                st.addFirst(ele);
                continue;
            }

            while (st.size() != 0 && st.getFirst() > 0 && st.getFirst() < -ele)
                st.removeFirst();

            if (st.size() != 0 && st.getFirst() == -ele)
                st.removeFirst();
            else if (st.size() == 0 || st.getFirst() < 0)
                st.addFirst(ele);
            else {
                // nothing to do
                // stack ke top pe greater element hai aur aur jo aaya h small h
            }
        }

        int[] ans = new int[st.size() - 1];
        int i = ans.length - 1;
        while (st.getFirst() != -1001) {
            ans[i--] = st.removeFirst();
        }

        return ans;
    }

    // 946
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int popped_idx = 0;
        for (int ele : pushed) {
            st.addFirst(ele);
            while (st.size() != 0 && st.getFirst() == popped[popped_idx]) {
                popped_idx++;
                st.removeFirst();
            }
        }

        return st.size() == 0;
    }

    // 856
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.addFirst(0);
            else {
                int a = st.removeFirst();
                int b = st.removeFirst();

                int val = b + Math.max(2 * a, 1);
                st.addFirst(val);
            }
        }

        return st.removeFirst();
    }

    // 84. Largest Rectangle in Histogram
    // TC : O(7n) SC : O(n)
    public int largestRectangleArea_01(int[] heights) {
        int[] nsol = NSOL(heights); // O(3n)
        int[] nsor = NSOR(heights); // O(3n)

        int MaxArea = 0;
        for (int i = 0; i < heights.length; i++) { // O(n)
            MaxArea = Math.max(MaxArea, heights[i] * (nsor[i] - nsol[i] - 1));
        }

        return MaxArea;
    }

    public int largestRectangleArea_02(int[] heights) {
        int n = heights.length;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        int MaxArea = 0;
        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && heights[st.getFirst()] >= heights[i]) {
                int h = heights[st.removeFirst()];
                int w = i - st.getFirst() - 1;
                MaxArea = Math.max(MaxArea, h * w);
            }
            st.addFirst(i);
        }

        while (st.getFirst() != -1) {
            int h = heights[st.removeFirst()];
            int w = n - st.getFirst() - 1;
            MaxArea = Math.max(MaxArea, h * w);
        }

        return MaxArea;
    }

    // 85
    // O(3nm)
    // har ek row ko base banake largest area nikali h
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if (n == 0 || m == 0)
            return 0;

        int[] height = new int[m];
        int MaxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }

            MaxArea = Math.max(MaxArea, largestRectangleArea_02(height));
        }

        return MaxArea;
    }

    // 32
    public int longestValidParentheses(String s) {
        int n = s.length(), maxLen = 0;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')' && st.getFirst() != -1 && s.charAt(st.getFirst()) == '(') {
                st.removeFirst();
                maxLen = Math.max(maxLen, i - st.getFirst());
            } else
                st.addFirst(i);
        }

        return maxLen;
    }

    // 402
    // return the smallest possible integer after removing k digits from num
    /// Approach -- stack se element remove kardenge jab
    // stack ka top element bada hoga incoming element se
    // if k > 0 rha gya to end ke k element remove kardenge
    // ArrayList islie use kari h kyoki starting se iterate karna h stack ko
    public String removeKdigits(String str, int k) {
        ArrayList<Character> st = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            while (st.size() != 0 && k > 0 && ch < st.get(st.size() - 1)) {
                k--;
                st.remove(st.size() - 1);
            }
            st.add(ch);

        }

        while (k-- > 0) {
            st.remove(st.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        boolean nonZeroValue = false;
        for (Character ch : st) {
            if (ch == '0' && !nonZeroValue)
                continue;

            nonZeroValue = true;
            sb.append(ch);
        }

        return sb.length() != 0 ? sb.toString() : "0";
    }

    // 316 // 1081
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder();
        boolean[] vis = new boolean[26];
        int[] freq = new int[26];

        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (vis[ch - 'a'])
                continue;

            while (st.length() != 0 && st.charAt(st.length() - 1) > ch && freq[st.charAt(st.length() - 1) - 'a'] > 0) {
                vis[st.charAt(st.length() - 1) - 'a'] = false;
                st.deleteCharAt(st.length() - 1);
            }
            vis[ch - 'a'] = true;
            st.append(ch);
        }

        return st.toString();
    }

    // 1249
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        char[] chArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (st.size() != 0)
                    st.removeFirst();
                else
                    chArr[i] = '#';
            } else if (ch == '(')
                st.addFirst(i);
        }

        while (st.size() != 0)
            chArr[st.removeFirst()] = '#';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] != '#')
                sb.append(chArr[i]);
        }

        return sb.toString();
    }

    // 921
    public int minAddToMakeValid(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        char[] chArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (st.size() != 0)
                    st.removeFirst();
                else
                    chArr[i] = '#';
            } else if (ch == '(')
                st.addFirst(i);
        }

        while (st.size() != 0)
            chArr[st.removeFirst()] = '#';

        int count = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '#')
                count++;
        }

        return count;
    }

    // 895
    // Maximum Frequency Stack
    class FreqStack {
        private class pair implements Comparable<pair> {
            int val = 0;
            int idx = 0;
            int freq = 0;

            pair(int val, int idx, int freq) {
                this.val = val;
                this.idx = idx;
                this.freq = freq;
            }

            public int compareTo(pair o) {
                if (this.freq == o.freq)
                    return o.idx - this.idx;
                else
                    return o.freq - this.freq;
            }
        }

        private PriorityQueue<pair> pq;
        private HashMap<Integer, Integer> freq;
        private int idx;

        public FreqStack() {
            pq = new PriorityQueue<>();
            freq = new HashMap<>();
        }

        // logn
        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            pq.add(new pair(val, idx++, freq.get(val)));
        }

        // logn
        public int pop() {
            pair rp = pq.remove();
            freq.put(rp.val, rp.freq - 1);
            if (freq.get(rp.val) == 0)
                freq.remove(rp.val);
            return rp.val;
        }

        public int top() {
            pair rp = pq.peek();
            return rp.val;
        }
    }

    class FreqStack_ {

        private ArrayList<LinkedList<Integer>> freqMap;
        private HashMap<Integer, Integer> map;
        private int maxFreq = 0;

        public FreqStack_() {
            freqMap = new ArrayList<>();
            map = new HashMap<>();

            freqMap.add(new LinkedList<>());
        }

        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(val));

            if (maxFreq == freqMap.size())
                freqMap.add(new LinkedList<>());

            freqMap.get(map.get(val)).addFirst(val);
        }

        public int pop() {
            int rv = freqMap.get(maxFreq).removeFirst();
            if (freqMap.get(maxFreq).size() == 0) {
                freqMap.remove(maxFreq--);
            }

            map.put(rv, map.get(rv) - 1);
            if (map.get(rv) == 0)
                map.remove(rv);

            return rv;
        }
    }

    // 155. Min Stack
    class MinStack {

        LinkedList<Long> st = new LinkedList<>();
        long minsf = 0;

        public MinStack() {

        }

        public void push(int val) {
            long x = val;
            if (st.size() == 0) {
                st.addFirst(x);
                minsf = x;
                return;
            }

            if (x < minsf) {
                // encode
                st.addFirst(2 * x - minsf);
                minsf = x;
            } else {
                st.addFirst(x);
            }
        }

        public void pop() {
            if (st.getFirst() < minsf) {
                // decode
                minsf = 2 * minsf - st.getFirst();
            }

            st.removeFirst();
        }

        public int top() {
            if (st.getFirst() < minsf) {
                return (int) minsf;
            }

            return (int) (long) st.getFirst();
            // yaha pe aassa islie kiye kyoki Long ke object hai yeh phele apne primitive me
            // convert hoga ,i.e , long and then we can convert it to int
            // (Long) -> (long) -> (int)
            // directly capital Long se int me convert nhi kar sakte
            // stack Long ka islie bana h kyoki stack object ke bante hai
            // eg. stack<Integer> st , stack<Long> st etc
        }

        public int getMin() {
            return (int) minsf;
        }
    }

}
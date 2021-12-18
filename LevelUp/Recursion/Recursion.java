import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class Recursion {

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void printIncreasing(int a, int b) {
        if (a > b)
            return;
        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if (a > b) {
            return;
        }
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if (a > b) {
            return;
        }
        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void oddEven(int a, int b) {
        if (a > b)
            return;

        if (a % 2 == 0)
            System.out.println(a + " is Even");

        oddEven(a + 1, b);

        if (a % 2 != 0)
            System.out.println(a + " is Odd");
    }

    public static int power(int a, int b) {
        if(b == 0)
            return 1;
        
        return a * power(a, b - 1);
    }

    // // O(logn)
    public static int powerBtr(int a, int b) {
        if(b == 0)
            return 1;

        int smallAns = powerBtr(a, b / 2);
        smallAns *= smallAns;

        return b % 2 == 0 ? smallAns : smallAns * a;
    }

    public static void printArray(int[] arr, int idx) {
        if (idx >= arr.length)
            return;

        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    public static void printArrayReverse(int[] arr, int idx) {
        if (idx >= arr.length)
            return;

        printArrayReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static int maximum(int[] arr, int idx) {
        if(idx >= arr.length)
            return -(int)1e9;
        
        return Math.max(arr[idx],maximum(arr, idx + 1));
    }

    public static int minimum(int[] arr, int idx) {
        if(idx >= arr.length)
            return (int)1e9;
        
        return Math.min(arr[idx],minimum(arr, idx + 1));
    }

    public static boolean find(int[] arr, int data, int idx) {
        if (idx >= arr.length)
            return false;

        return arr[idx] == data || find(arr, data, idx + 1);
    }

    public static int firstIndex(int[] arr, int data, int idx) {
        if (idx >= arr.length)
            return -1;

        return arr[idx] == data ? idx : firstIndex(arr, data, idx + 1);
    }

    public static int lastIndex(int[] arr, int data, int idx) {
        if (idx >= arr.length)
            return -1;

        int ans = lastIndex(arr, data, idx + 1);
        if (ans != -1)
            return ans;

        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndex(int[] arr, int data, int idx, int count) {
        if(idx >= arr.length)
            return new int[count];
        
        if(data == arr[idx])
            count++;
        int [] ans = allIndex(arr, data, idx + 1, count);
        if(data == arr[idx])
            ans[count - 1] = arr[idx];
        
        return ans;
    }

    public static ArrayList<String> subsequence(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> recAns = subsequence(ros);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        for(String s : recAns)
            myAns.add(ch + s);
        return myAns;
    }
    
    public static ArrayList<String> subsequence(String str, int idx) {
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = subsequence(str, idx+1);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        for(String s : recAns)
            myAns.add(str.charAt(idx) + s);
        return myAns;
    }

    public static int subsequence(String str, int idx, String asf, ArrayList<String> ans) {
        if (idx == str.length()) {
            ans.add(asf);
            return 1;
        }
        int count = 0;
        count += subsequence(str, idx + 1, asf, ans);
        count += subsequence(str, idx + 1, asf + str.charAt(idx), ans);

        return count;
    }

    public static String[] nokiaKeys = { ".;", "abc", "def", "ghi", "jkl", "mno",
    "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> nokiaKeyPad(String str) {
        if(str.length() == 0){
            ArrayList<String>  base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String code = nokiaKeys[ch - '0'];

        ArrayList<String> recAns = nokiaKeyPad(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();
        for(int i = 0;i < code.length(); i++){
            for(String s : recAns)
                myAns.add(code.charAt(i) + s);
        }
        return myAns;
    }

    // public static ArrayList<String> stairPath(int n) {
    // }

    // public static int stairPath(int n, String psf, ArrayList<String> ans) {
    // }

    // public static int boardPath(int n, String psf, ArrayList<String> ans) {
    // }

    // public static int boardPath(int[] arr, int n, String psf, ArrayList<String>
    // ans) {
    // }

    // public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf,
    // ArrayList<String> ans, int[][] dir,
    // }

    // public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String
    // psf, ArrayList<String> ans, int[][] dir,
    // }

    // public static void mazePath() {
    // int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
    // String[] dirS = { "H", "V", "D" };

    // ArrayList<String> ans = new ArrayList<>();
    // System.out.println(mazePath_HVD_multi(0, 0, 2, 2, "", ans, dir, dirS));

    // System.out.println(ans);
    // }

    // // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

    // public static int ratInMaze(int sr, int sc, int[][] mat, String psf,
    // ArrayList<String> ans, int[][] dir,
    // String[] dirS) {
    // }

    // public static void ratInMaze(int[][] mat) {

    // }

    // public static int specialMatrix(int sr, int sc, boolean[][] mat, int[][] dir)
    // {
    // }

    // public static void specialMatrix(int n, int m, int[][] blockedCells) {
    // }

    public static void main(String[] args) {
        // int n = factorial(5);
        // System.out.println(n);
        // printIncreasing(1, 6);
        // System.out.println(power(12, 5));
        ArrayList<String> ans = nokiaKeyPad("78");
        System.out.println(ans);
    }
}
import java.util.*;

public class Get_StairPath {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n <= 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 3 && (n - i) >= 0; i++) {
            ArrayList<String> myrec = getStairPaths(n - i);

            for (String s : myrec)
                ans.add(i + s);
        }

        return ans;
    }

}
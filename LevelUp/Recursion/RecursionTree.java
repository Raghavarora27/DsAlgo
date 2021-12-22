public class RecursionTree {

    public static int infiPermutations(int[] coins, int tar, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += infiPermutations(coins, tar - coins[i], asf + coins[i]);
        }

        return count;
    }

    public static int infiCombinations(int[] coins, int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += infiCombinations(coins, tar - coins[i], asf + coins[i], i);
        }

        return count;
    }

    public static int SingleCombinations(int[] coins, int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += SingleCombinations(coins, tar - coins[i], asf + coins[i], i + 1);
        }

        return count;
    }

    public static int SinglePermutations(int[] coins, int tar, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > 0 && tar - coins[i] >= 0) {
                int val = coins[i];
                coins[i] = -coins[i];
                count += SinglePermutations(coins, tar - val, asf + val);
                coins[i] = -coins[i];
            }
        }

        return count;
    }

    // subsequence method
    public static int singleCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += singleCombination_subseq(coins, tar - coins[idx], idx + 1, asf + coins[idx]);
        count += singleCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiCombination_subseq(coins, tar - coins[idx], idx, asf + coins[idx]);
        count += infiCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiPermutation_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiPermutation_subseq(coins, tar - coins[idx], 0, asf + coins[idx] + " ");
        count += infiPermutation_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int singlePermutation_subseq(int[] coins, int tar, boolean[] vis, String asf, int idx) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (!vis[idx] && tar - coins[idx] >= 0) {
            vis[idx] = true;
            count += singlePermutation_subseq(coins, tar - coins[idx], vis, asf + coins[idx], 0);
            vis[idx] = false;
        }
        count += singlePermutation_subseq(coins, tar, vis, asf, idx + 1);

        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        String asf = "";
        int tar = 10;
        boolean[] vis = new boolean[coins.length];
        // System.out.println(SingleCombinations(coins, tar, asf, 0));
        // System.out.println(singleCombination_subseq(coins, tar, 0,asf));
        // System.out.println(infiCombination_subseq(coins, tar, 0,asf));
        // System.out.println(infiCombinations(coins, tar,asf,0));
        System.out.println(singlePermutation_subseq(coins, tar, vis, asf, 0));
        System.out.println(SinglePermutations(coins, tar, asf));
    }
}

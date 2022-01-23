public class DisplayArrayInReverse {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        displayArrInRev(arr, 0);
        sc.close();
    }

    public static void displayArrInRev(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        displayArrInRev(arr, idx + 1);
        System.out.println(arr[idx]);
    }

}
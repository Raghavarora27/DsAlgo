import java.util.*;

public class FLIndex {

    public static int FirstIndex(int[] arr, int data) {

        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == data) {
                if (mid - 1 > 0 && arr[mid - 1] == data) {
                    ei = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }

    public static int LastIndex(int[] arr, int data) {

        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == data) {
                if (mid + 1 <= arr.length - 1 && arr[mid + 1] == data) {
                    si = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int data = sc.nextInt();

        System.out.println(FirstIndex(arr, data));
        System.out.println(LastIndex(arr, data));

        sc.close();
    }

}
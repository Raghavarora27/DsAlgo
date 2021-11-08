public class CeilAndFloor {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 8, 12, 14, 16, 19 };
        System.out.println(Ceil(arr, 10));
        System.out.println(Floor(arr, 10));
    }

    public static int Ceil(int[] arr, int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si; // ei target si
    }

    public static int Floor(int[] arr, int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return ei; // target ei si
    }
}
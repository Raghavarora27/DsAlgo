import java.util.*;

public class RemovePrimes {

	public static boolean isprime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void removeprime(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<>();

		for (Integer ele : arr) {
			if (!isprime(ele))
				ans.add(ele);
		}

		arr.clear();

		for (Integer ele : ans)
			arr.add(ele);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(scn.nextInt());
		}
		removeprime(al);
		System.out.println(al);
		scn.close();
	}

}
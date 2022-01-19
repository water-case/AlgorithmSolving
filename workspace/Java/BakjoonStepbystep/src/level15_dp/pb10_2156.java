package level15_dp;

import java.util.Scanner;

public class pb10_2156 {

	static int arr[];
	static Integer ans[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		arr = new int[n + 1];
		ans = new Integer[n + 1];

		for (int i = 1; i < n+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		ans[0] = 0;
		ans[1] = arr[1];
		
		if(n>1) {
			ans[2] = arr[1]+arr[2];
		}

		System.out.println(cf(n));

	}

	static int cf(int n) {
		if (ans[n] == null) {
			ans[n] = Math.max(Math.max(cf(n - 2), cf(n - 3) + arr[n - 1]) + arr[n], cf(n-1));
		}

		return ans[n];
	}

}

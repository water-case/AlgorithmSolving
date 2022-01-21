package level17_numAndCombi;

import java.util.Scanner;

public class pb02_1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		if (N == 1) {
			ans = arr[0] * arr[0];
		} else {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if(arr[i] > max) max = arr[i];
				if(arr[i] < min) min = arr[i];
			}
			ans = max*min;
		}
		
		System.out.println(ans);

	}

}

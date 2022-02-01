package level26_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb02_2470 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(token.nextToken());

		Arrays.sort(arr);

		int p1 = 0;
		int p2 = N - 1;
		int min = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0;

		while (p1 < p2) {
			int sum = arr[p1] + arr[p2];
			int asum = Math.abs(sum);
			if (asum == 0) {
				System.out.println(arr[p1] + " " + arr[p2]);
				return;
			} else if (asum < min) {
				min = asum;
				ans1 = p1;
				ans2 = p2;
				if (sum > 0) {
					p2--;
				} else {
					p1++;
				}
			} else {
				if (sum > 0) {
					p2--;
				} else {
					p1++;
				}
			}
		}
		System.out.println(arr[ans1] + " " + arr[ans2]);
	}

}

package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb5_2110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int max = arr[N - 1] - arr[0] + 1;
		int min = 1;
		while (min < max) {
			int ans = 1;
			int mid = (max + min) / 2;
			
			int tmp = arr[0];
			for (int i = 1; i < N; i++) {
				if (arr[i] - tmp >= mid) {
					ans++;
					tmp = arr[i];
				}
			}
			
			
			if (ans < C) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}

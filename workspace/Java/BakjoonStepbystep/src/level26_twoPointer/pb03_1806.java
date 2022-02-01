package level26_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb03_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int S = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}

		int p1 = 0;
		int p2 = 0;
		int ans = N+1;
		int sum = 0;

		while (true) {
			if (sum >= S) {
				sum -= arr[p1++];
				ans = Math.min(ans, p2 - p1 + 1);
			} else if(p2 == N) break;
			else sum+= arr[p2++];
		}

		if(ans == N+1) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
//		while (p1 < p2) {
//			int psum2 = psum1 + arr[p1] + arr[p2];
////			System.out.println(p1 + " " + p2);
//			if (tsum - psum2 >= S) {
//				ans = ans - 2;
//				p1++;
//				p2--;
//				psum1 = psum2;
//			} else {
//				psum2 = psum1 + (arr[p1] < arr[p2] ? arr[p1] : arr[p2]);
//				if (tsum - psum2 >= S) {
//					ans--;
//					psum1 = psum2;
//					if(arr[p1] < arr[p2]) p1++;
//					else p2--;
//				} else {
//					break;
//				}
//			}
//		}
	}

}

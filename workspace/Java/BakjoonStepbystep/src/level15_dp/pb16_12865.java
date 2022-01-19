package level15_dp;

import java.util.Arrays;
import java.util.Scanner;

public class pb16_12865 {

	static Integer[][] ans;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 버틸 수 있는 무게

		ans = new Integer[N][K+1];
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // 무게
			arr[i][1] = sc.nextInt(); // 가치
		}
		
		System.out.println(cf(N-1, K));

		sc.close();
	}
	
	static int cf(int i, int K) {
		if(i<0) return 0;
		
		if(ans[i][K] == null) {
			if(arr[i][0] > K) {
				ans[i][K] = cf(i-1, K);
			} else {
				ans[i][K] = Math.max(cf(i-1, K), cf(i-1,K-arr[i][0]) + arr[i][1]);
			}
		}
		
		return ans[i][K];
	}

}

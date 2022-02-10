package level33_dp3;

import java.io.*;
import java.util.*;

public class pb02_1311 {

	static int N;
	static int[][] in, dp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 사람과 일의 수
		in = new int[N][N]; // i번 사람이 j번 일을 할 때 필요한 비용 배열
		dp = new int[N][1 << N]; // 사람 배열속에 일의 수 비트배열을 만든다

		StringTokenizer token;
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				in[i][j] = Integer.parseInt(token.nextToken());
		} // 입력받은것을 비용 배열에 파싱하여 넣는다

		System.out.println(cf(0, 0)); // 재귀와 메모이제이션을 이용하여 최소값을 구한다
		br.close();
	}

	static int cf(int n, int bit) {
		if (n == N) // 조건에서 벗어난 파라미터가 오면 영향없도록 처리
			return 0;
		if (dp[n][bit] != 0) // 이미 구한값이라면 바로 리턴
			return dp[n][bit];

		int r = 1000001;
		for (int i = 0; i < N; i++) {
			if ((bit & (1 << i)) == 0) { // 플래그를 이용해 사람에 일이 배정되었는지를 확인
				r = Math.min(r, in[n][i] + cf(n + 1, bit | (1 << i))); // 이전까지 구해진값과 비교하여 작은값 저장
			}
		}
		dp[n][bit] = r;
		return dp[n][bit];
	}

}

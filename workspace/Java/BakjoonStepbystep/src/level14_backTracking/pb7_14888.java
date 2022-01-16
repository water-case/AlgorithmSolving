package level14_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb7_14888 {

	static int[] nums;
	static int[] cal = new int[4];
	static int amax = Integer.MIN_VALUE;
	static int amin = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer token = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(token.nextToken());
		}

		cf(1, nums[0]);

		System.out.println(amax);
		System.out.println(amin);

	}

	public static void cf(int depth, int value) {
		if (depth == N) {
			amax = Math.max(amax, value);
			amin = Math.min(amin, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				cal[i]--;

				switch (i) {
				case 0:
					cf(depth + 1, value + nums[depth]);
					break;
				case 1:
					cf(depth + 1, value - nums[depth]);
					break;
				case 2:
					cf(depth + 1, value * nums[depth]);
					break;
				case 3:
					cf(depth + 1, value / nums[depth]);
					break;
				}

				cal[i]++;
			}
		}

	}

}

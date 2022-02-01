package level26_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pb05_1450 {

	static int N, C;
	static int[] arr;

	static void dfs(int now, int end, int sum, ArrayList<Integer> list) {
		if (sum > C)
			return;
		if (now > end) {
			list.add(sum);
			return;
		}
		dfs(now + 1, end, sum, list);
		dfs(now + 1, end, sum + arr[now], list);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new int[N];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(token.nextToken());

		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		dfs(0, N / 2, 0, left);
		dfs(N / 2 + 1, N - 1, 0, right);
//		System.out.println(left.size());
//		System.out.println(right.size());

		Collections.sort(left);
		Collections.sort(right);
		int ans = 0;
		int a = right.size() - 1;
		for (int i = 0; i < left.size(); i++) {
			while(a >= 0 && left.get(i)+right.get(a) > C) {
				a--;
			}
			ans += a+1;
		}
		System.out.println(ans);

//		int p1 = 0;
//		int p2 = 0;
//		int sum = 0;
//		int count = 0;
//		while(true) {
//			if(sum > C) {
//				sum -= arr[p1++];
//				count++;
//			}
//			if(sum <= C) {
//				if(p2 == N) {
//					count += Math.pow(2, p2-p1);
//					break;
//				}
//				sum += arr[p2++];
//			}
//		}
//		System.out.println(count);

//		System.out.println((int)Math.pow(2, 30));
	}

}

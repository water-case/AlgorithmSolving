package level27_dpAndTraceback;

import java.util.*;
import java.io.*;

public class pb07_9019 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			String[] route = new String[10000];
			boolean[] visit = new boolean[10000];
			Queue<Integer> q = new LinkedList<>();

			visit[A] = true;
			q.add(A);
			Arrays.fill(route, "");

			while (!q.isEmpty() && !visit[B]) {
				int now = q.poll();
				int D = now * 2 % 10000;
				int S = now == 0 ? 9999 : now - 1;
				int L = now % 1000 * 10 + now / 1000;
				int R = now % 10 * 1000 + now / 10;
				
				if(!visit[D]) {
					q.add(D);
					visit[D] = true;
					route[D] = route[now] + "D";
				}
				if(!visit[S]) {
					q.add(S);
					visit[S] = true;
					route[S] = route[now] + "S";
				}
				if(!visit[L]) {
					q.add(L);
					visit[L] = true;
					route[L] = route[now] + "L";
				}
				if(!visit[R]) {
					q.add(R);
					visit[R] = true;
					route[R] = route[now] + "R";
				}
			}
			System.out.println(route[B]);
		}
	}

}

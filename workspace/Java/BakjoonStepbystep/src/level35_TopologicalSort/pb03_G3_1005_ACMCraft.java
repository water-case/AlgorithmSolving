package level35_TopologicalSort;

import java.io.*;
import java.util.*;

public class pb03_G3_1005_ACMCraft {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			token = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(token.nextToken()); // 건물의 개수
			int K = Integer.parseInt(token.nextToken()); // 건설 규칙개수
			int[] times = new int[N + 1]; // 건물 건설에 걸리는 시간
			int[] indegree = new int[N + 1];
			ArrayList<ArrayList<Integer>> elist = new ArrayList<>();
			
			for(int i=0; i<=N; i++) elist.add(new ArrayList<>());
			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) times[i] = Integer.parseInt(token.nextToken());

			for (int i = 0; i < K; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				elist.get(a).add(b);
				indegree[b]++;
			}
			
			int target = Integer.parseInt(br.readLine());
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			int[] complete = new int[N+1]; // 각 건물의 완료시간 저장배열

			for (int i = 1; i <= N; i++) {
				complete[i] = times[i];
				if(indegree[i] == 0)
					q.add(i);
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int i : elist.get(now)) {
					complete[i] = Math.max(complete[i], complete[now] + times[i]);
					indegree[i]--;
					if(indegree[i] == 0)
						q.add(i);
				}
			}
			System.out.println(complete[target]);
		}
	}
}

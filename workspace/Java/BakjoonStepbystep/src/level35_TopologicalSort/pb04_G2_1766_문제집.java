package level35_TopologicalSort;

import java.io.*;
import java.util.*;

public class pb04_G2_1766_문제집 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문제의 수
		int M = Integer.parseInt(st.nextToken()); // 먼저 푸는 정보의 개수
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());
		int[] indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			indegree[b]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++)
			if(indegree[i] == 0)
				pq.offer(i);
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			
			for(int i : list.get(now)) {
				indegree[i]--;
				if(indegree[i] == 0)
					pq.offer(i);
			}
		}
		
		System.out.println(sb.toString());
	}
}

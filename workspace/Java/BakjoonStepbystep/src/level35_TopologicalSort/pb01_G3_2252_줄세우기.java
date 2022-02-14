package level35_TopologicalSort;

import java.io.*;
import java.util.*;

public class pb01_G3_2252_줄세우기 {

	static int[] in_degree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		in_degree = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<=N; i++) list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			in_degree[b]++;
			list.get(a).add(b);
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++)
			if(in_degree[i] == 0)
				q.offerLast(i);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");

			for(int num : list.get(now)) {
				in_degree[num]--;
				if(in_degree[num] == 0)
					q.offerLast(num);
			}
		}
	}
}

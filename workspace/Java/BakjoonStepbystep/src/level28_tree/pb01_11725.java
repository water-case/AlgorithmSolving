package level28_tree;

import java.util.*;
import java.io.*;

public class pb01_11725 {

	static class Node {
		int num;
		ArrayList<Integer> children;

		public Node(int n) {
			num = n;
			children = new ArrayList<>();
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N + 1];
		Node[] Tree = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			Tree[i] = new Node(i);

		for (int i = 1; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			Tree[a].children.add(b);
			Tree[b].children.add(a);
		}

		StringBuilder sb = new StringBuilder();

		boolean[] visit = new boolean[N + 1];
		Queue<Node> q = new LinkedList<>();
		q.add(Tree[1]);
		visit[1] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			ArrayList<Integer> list = now.children;

			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				if(visit[num]) continue;
				visit[num] = true;
				ans[num] = now.num;
				q.add(Tree[num]);
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

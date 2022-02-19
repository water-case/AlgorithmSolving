package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class pb02_P4_4196_도미노 {

	static ArrayList<ArrayList<Integer>> domino;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] visit;
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 도미노의 개수
			int M = Integer.parseInt(st.nextToken()); // 관계의 개수
			domino = new ArrayList<>(); // 테스트케이스마다 새로운 리스트 생성
			for (int i = 0; i <= N; i++)
				domino.add(new ArrayList<>()); // 도미노 리스트 생성

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				domino.get(a).add(b); // 도미노 연결
			}
			
			count = 0; // 각 테스트케이스마다 세야하므로 0으로 초기화
			
			visit = new boolean[N + 1];
			for(int i=1; i<=N; i++) {
				if(!visit[i])
					dfsFirst(i);
			}
//			System.out.println(stack);
			
			Arrays.fill(visit, false);
			while(!stack.isEmpty()) {
				int now = stack.pop();
//				System.out.println(now + " " + count + " " + Arrays.toString(visit));
				
				if(!visit[now]) {
					dfsSecond(now);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
	static void dfsSecond(int n) {
		visit[n] = true;
		for(int next : domino.get(n)) {
			if(!visit[next])
				dfsSecond(next);
		}
	}
	
	static void dfsFirst(int n) {
		visit[n] = true;
		for(int next : domino.get(n)) {
			if(!visit[next])
				dfsFirst(next);
		}
		stack.push(n);
	}

}

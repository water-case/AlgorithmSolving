package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

/*
 * 입력데이터 : 변수의개수 10_000개, clause의 개수 100_000개
 * 
 * 하나의 절이 true이려면 A U B 의 절에서 A가 true이거나 B가 true여야한다
 * !A -> B 와 !B -> A 두개의 간선을 만들고 정방향 역방향 그래프를 생성하여 scc를 구한다
 * 하나의 변수가 A이거나 !A인 상태를 동시에 이룰 수 없으므로
 * 그 두개가 하나의 scc에 속하면 안된다
 * 문제에서 정점이 음수로도 주어지므로, 모든 정점에 N만큼 더해서 양수로만 동작하도록 하였다 
 * 
 */

public class pb05_P4_11280_2_SAT_3 {

	static ArrayList<ArrayList<Integer>> list1 = new ArrayList<>(), 
										 list2 = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>();
	static int N, M, sccCount;
	static boolean[] visit;
	static int[] sccNum;
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 변수의 개수
		M = Integer.parseInt(st.nextToken()); // 절의 개수
		
		for (int i = 0; i <= (2 * N) + 1; i++) { // 변수의 값으로 가능한 만큼 리스트 생성
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a < 0) a = -a + N;
			if(b < 0) b = -b + N;
			list1.get(change(a)).add(b);
			list2.get(b).add(change(a));
			list1.get(change(b)).add(a);
			list2.get(a).add(change(b));
		}
		
		visit = new boolean[(2 * N) + 1];
		for (int i = 1; i < (2 * N) + 1; i++)
			if(!visit[i]) dfsFirst(i);

		visit = new boolean[(2 * N) + 1];
		sccNum = new int[(2 * N) + 1];
		sccCount = 0;
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(!visit[now]) {
				dfsSecond(now);
				sccCount++;
			}
		}

		for (int i = 1; i <= N; i++) {
			if(sccNum[i] == sccNum[i+N]) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
		
	}
	
	static void dfsSecond(int n) {
		visit[n] = true;
		sccNum[n] = sccCount;
		for(int next : list2.get(n))
			if(!visit[next]) dfsSecond(next);
	}
	
	static void dfsFirst(int n) {
		visit[n] = true;
		for(int next : list1.get(n))
			if(!visit[next]) dfsFirst(next);
		stack.push(n);
	}
	
	static int change(int n) {
		return n > N ? n - N : n + N;
	}
}

package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

/*
 * 이전문제와 유사하나 식의 해까지 출력해야한다
 * 코사라주 알고리즘에선 scc를 만들때 처음 양수부터 음수까지의 순서로 정방향 그래프를 돌면서 스택에 쌓는다
 * 그래서 최종 스택의 맨 위에는 진출차수가 없는 음수인 정점이 오게된다
 * scc의 맨 첫번째는 진출차수가 없는 음수의 정점과 사이클을 이루는 것들이 묶인다
 * scc의 첫번째부터 해를 정한다, 뒤부터 해도 상관없다.
 * 식의 해는 여러가지가 있을 수 있기때문이다
 * 음수의 정점은 true의 정점으로 변경하여 result배열에 해당 인덱스에는 0을 넣고
 * 양수의 정점인덱스는 result배열에 1로 넣는다
 * 이후 1번부터 순차적으로 출력하면 된다
 * 
 * ** 문제에서 기초적으로 주어지는 예제의 출력과 해당 코드의 결과는 다르게 도출되어 혼란이 올 수 있는데
 *    식의 정답은 여러개일 수 있다는 점을 생각하자
 *    
 * 
 */

public class pb06_P3_11281_2_SAT_4 {

	static ArrayList<ArrayList<Integer>> list1 = new ArrayList<>(), 
										 list2 = new ArrayList<>(),
										 sccList = new ArrayList<>();
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
				sccList.add(new ArrayList<>());
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
		// 해를 얻어내고 출력한다
		int[] result = new int[N + 1];
		for(int i = 0; i< sccCount; i++) {
			for(int j : sccList.get(i)) {
				if(j > N) {
					result[j-N] = 0;
				} else 
					result[j] = 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			sb.append(result[i]).append(" ");
		System.out.println(sb.toString());
	}
	
	static void dfsSecond(int n) {
		visit[n] = true;
		sccList.get(sccCount).add(n);
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

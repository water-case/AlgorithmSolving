package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class pb01_P5_2150_StronglyConnectedComponent {

	static ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>();
	static int sccCount = 0;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= V; i++) {
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());
			sccList.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list1.get(a).add(b); // SCC를 위해 정방향과 역방향 그래프 두개를만듬
			list2.get(b).add(a);
		}

		// SCC의 첫번째 단계 : 특정노드에서 dfs를 돌며 스택에 넣는다, 낮은번호부터
		visit = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			if(!visit[i])
				dfsFirst(i);
		}
		// SCC의 두번쨰 단계 : 스택에서 하나씩 빼면서 dfs를 돌면서 방문되는건 해당 scc리스트에 넣는다
//		System.out.println(stack);
		Arrays.fill(visit, false);
		while (!stack.isEmpty()) {
			int now = stack.pop();
			if (!visit[now]) {
				dfsSecond(now);
				sccCount++;
			}
		}
		sb.append(sccCount).append("\n");
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < sccCount; i++) {
			Collections.sort(sccList.get(i));
			map.put(sccList.get(i).get(0), i);
		}
			
//			Collections.sort(sccList.get(i));
//		Collections.sort(sccList, (o1, o2) ->{ return o1.get(0) - o2.get(0); });
//		for (int i = 0; i < sccCount; i++) {
//			for(int j=0; j<sccList.get(i).size(); j++) {
//				sb.append(sccList.get(i).get(j)).append(" ");
//			}
//			sb.append(-1).append("\n");
//		}
		
		map.keySet().forEach(key -> {
			int value = map.get(key);
			
			for(int now : sccList.get(value))
				sb.append(now + " ");
			sb.append(-1).append("\n");
		});
		
		// 도출된 결과를 포맷에 맞게 변경하여 출력
		System.out.println(sb.toString());
		br.close();
	}

	static void dfsSecond(int n) {
		visit[n] = true;
		sccList.get(sccCount).add(n);
		for (int next : list2.get(n)) {
			if (!visit[next]) {
				dfsSecond(next);
			}
		}
	}

	static void dfsFirst(int n) {
		visit[n] = true;
		for (int next : list1.get(n)) {
			if (!visit[next])
				dfsFirst(next);
		}
		stack.push(n);
	}

}

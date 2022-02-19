package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

/*
 * 1. scc로 사이클찾아서 출력하니 출력초과뜸
 * 2. 구한 scc들을 각각 하나의 노드로 생각하고 진입점이 하나인가 아닌가를 먼저 찾아야함
 *    위상정렬 + SCC 문제이다
 *    위상정렬은 진입점이 하나이다
 *    진입차수가 2개이상이면 Confused 출력
 *    
 *    1개 일때만 scc 구성요소들 오름차순으로 출력
 *    사이클이 이루어진 scc는 하나의 노드로 생각한다
 *    scc개수만큼 indegree배열크기를 만들고 scc간 진입차수를 구하고 진입차수가 0인것이 2개 이상이면 confused 
 *    
 */

public class pb03_P4_3977_축구전술 {

	static Stack<Integer> stack = new Stack<>();
	static ArrayList<ArrayList<Integer>> list1, list2, sccList;
	static int sccCount;
	static int[] sccNum;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 구역의 수
			int M = Integer.parseInt(st.nextToken()); // 지시한 움직임의 수
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
//			sccList = new ArrayList<>();
			for (int i = 0; i < N; i++) { // 리스트 생성
				list1.add(new ArrayList<>());
				list2.add(new ArrayList<>());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list1.get(a).add(b); // scc 작업을 위한 정배열, 역배열 생성
				list2.get(b).add(a);
			}

			// 1. dfs돌며 방문의 역순으로 스택에 push
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (!visit[i])
					dfsFirst(i);
			}

			// 2. 스택에서 빼서 반대로 돌면서 scc생성
			Arrays.fill(visit, false);
			sccCount = 0;
			sccNum = new int[N + 1];
			while (!stack.isEmpty()) {
				int now = stack.pop();

				if (!visit[now]) {
//					sccList.add(new ArrayList<>());
					dfsSecond(now);
//					if(sccList.get(sccCount).size() <= 1)
//						sccList.remove(sccCount);
					sccCount++;
				}
			}

			// 진입차수 정보 얻기
			int[] indegree = new int[sccCount];
//			System.out.println("! : " + sccCount);
			for (int i = 0; i < N; i++) {
				int s = list1.get(i).size();
				for (int j = 0; j < s; j++) {
					int end = list1.get(i).get(j);
					if(sccNum[end] != sccNum[i])
						indegree[sccNum[end]]++;
				}
			}

			// 진입차수가 0인게 몇개인지 알아내기
			int cnt = 0;
			int tag = 0;
			for (int i = 0; i < sccCount; i++) {
				if(indegree[i] == 0) {
					tag = i; // 진입차수가 0인곳을 저장해놓는다
					cnt++; // 진입차수가 0인곳이 몇개인지?
				}
			}

			// 출력
			if (cnt > 1) { // 진입차수가 2개이상이면 유일한 시작구역찾기 불가능
				bw.write("Confused\n");
			} else {
//				Collections.sort(sccList.get(0));
				for (int i = 0; i < N; i++)
					if(sccNum[i] == tag) // 저장해놓은 진입차수 장소와 일치하면 출력한다
						bw.write(i + "\n"); // 사이클이 없을경우 1개만출력, 사이클있으면 사이클 모두출력
			}

			bw.write("\n");
			String s = br.readLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfsSecond(int n) {
		visit[n] = true;
		sccNum[n] = sccCount;
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

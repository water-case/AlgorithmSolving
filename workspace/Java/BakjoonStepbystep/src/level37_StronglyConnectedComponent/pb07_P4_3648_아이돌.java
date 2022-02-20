package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

/*
 * 심사위원이 자신의 표 두개중 하나는 영향을 미쳐야 한다는 조건을 통해
 * 2-SAT 문제임을 생각할 수 있다
 * 사이클이 없으면 1번도 포함하는 해는 당연히 만들 수 있다
 * 1번이 true인지 아닌지를 확인하는것은 위상정렬개념을 사용하는데
 * 참 -> 거짓의 이동경로가 발생하면 안된다
 * 때문에 먼저 방문하는 정점을 false로 놓는것을 이용하여 -1번 정점 방문 이후에 1번정점을 방문하는 경우가
 * 1번이 항상 true인 경우이다
 * 
 */

public class pb07_P4_3648_아이돌 {

	static ArrayList<ArrayList<Integer>> list1, list2;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] visit;
	static int[] sccNum;
	static int N, M, sccCount;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			String s = br.readLine();
			if(s == null || s.equals("") || s.equals(" ")) break;
			
			st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken()); // 참가자의 수
			M = Integer.parseInt(st.nextToken()); // 심사위원의 수

			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			for (int i = 0; i <= (2 * N) + 1; i++) {
				list1.add(new ArrayList<>());
				list2.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list1.get(change(-a)).add(change(b));
				list1.get(change(-b)).add(change(a));
				list2.get(change(b)).add(change(-a));
				list2.get(change(a)).add(change(-b));
			}
			
//			for(ArrayList<Integer> a : list2)
//				System.out.println(a.toString());
			
			visit = new boolean[(2 * N) + 1];
			for (int i = 1; i < (2 * N) + 1; i++)
				if(!visit[i])
					dfsFirst(i);
			
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
//			System.out.println("sccCount : " + sccCount);
			
			boolean check = true;
			for (int i = 1; i <= N; i++) {
				if(sccNum[i] == sccNum[i+N]) {
					check = false;
					break;
				}
			}
			if (check && sccNum[1] > sccNum[1 + N]) // 위상정렬에서 먼저만나는정점을 false로 설정하므로 1+N번 정점을 먼저만나야한다
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
//			System.out.println(Arrays.toString(sccNum));
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void dfsSecond(int n) {
		visit[n] = true;
		sccNum[n] = sccCount;
		for(int next : list2.get(n)) {
			if(!visit[next]) dfsSecond(next);
		}
	}
	
	static void dfsFirst(int n) {
		visit[n] = true;
		for(int next : list1.get(n))
			if(!visit[next]) dfsFirst(next);
		stack.push(n);
	}

	static int change(int n) {
		return (0 < n && n < N + 1) ? n : -n + N;
	}

}

package level37_StronglyConnectedComponent;

import java.io.*;
import java.util.*;

/*
 *  입력데이터 : 500_000 개이하의 노드와 간선
 *  			 노드당 4000원이하, 계산결과 최대 20억이하이므로 int 자료형사용
 *  1. scc를 구하고 각 scc당 인출 현금 액수를 구해놓음
 *  2. 도출된 scc정보와 기존 방향그래프를 탐색하면서 DP를 통해 최대액수를 구하자
 *  
 *  
 *  1차 답안제출 : 메모리초과 (5%) 
 *  	최초 설계에서 dp를 노드간 노드로 만들었다가 css대 css로 변경 시 dp 크기를 수정을 안해주어서 생긴 이슈같음
 *  2차 답안제출 : 시간초과 (5%)
 *  	dp크기를 수정해주니 메모리초과는 해결됨
 *  
 *  수정안 : 재귀식으로 구하지않고 큐를 통해 dp를 다 계산한후에 출력했다
 *  3차 답안제출 : 틀렸습니다 (94%)
 *  	0원일떄도있어서 dp에서 비교할때 작거나 같다로 해봣는데 시간초과
 *  4차 답안제출 : 시간초과 (5%)
 *  	첫 사이클이 0일 경우가 문제인거같다, 다음진행이 안됨
 *  5차 답안제출 : 틀렸습니다 (5%)
 *  	첫사이클이 0인경우 문제가 되어 첫사이클에 1을더해줫다가 출력때 1을빼줘서 시도해봤으나 틀림 다른 방법을 생각해보자
 *  6차 답안제출 : 틀렸습니다 (94%)
 *  	첫사이클이 0인경우 통과하기위해 0인경우는 다음걸로 그냥 통과하게 했으나 틀림
 *  7차 답안제출 : 맞았습니다 (100%)
 *  	dp의 모든 곳에 각 사이클의 합계를 넣어놓고 시작했다. 너무나도 바보같은 실수
 */

public class pb04_P2_4013_ATM {

	static ArrayList<ArrayList<Integer>> list1 = new ArrayList<>(), 	// 입력으로 주어지는 정방향 방향그래프
										 list2 = new ArrayList<>(), 	// scc도출을 위한 역방향 방향그래프
										 sccList = new ArrayList<>();	// 각 scc의 구성요소 저장 배열
	static ArrayList<Integer> sccMoney = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>(); // scc도출에 사용되는 스택
	static boolean[] visit;
	static int[] dp; // 앞의숫자 : 출발지, 뒤의숫자 : 도착지, 저장정보 : 최대 인출액
	static int[] cash, rest, sccNum;
	static int sccCount, ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 교차로의 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 수
		
		for (int i = 0; i <= N; i++) {
			list1.add(new ArrayList<>()); // 정방향 그래프 생성
			list2.add(new ArrayList<>()); // 역방향 그래프 생성
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list1.get(a).add(b); // 정방향 노드 삽입
			list2.get(b).add(a); // 역방향 노드 삽입
		}
		
		cash = new int[N + 1]; // 각 노드의 현금 보유액저장 배열
		for (int i = 1; i <= N; i++) cash[i] = Integer.parseInt(br.readLine()); // 각 노드의 현금 보유액 입력받음
		
		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken()); // 출발 장소
		int P = Integer.parseInt(st.nextToken()); // 레스토랑의 개수
		
		rest = new int[P]; // 레스토랑 위치 저장배열
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < P; i++) rest[i] = Integer.parseInt(st.nextToken()); // 레스토랑 위치 입력받음
		
		// 1. scc를 구하고 각 scc의 최대 인출액수를 구한다 (코사라주 알고리즘)
		// 1-1. 정방향 돌면서 스택넣기
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			if(!visit[i]) dfsFirst(i);
		
		// 1-2. 스택에서 빼서 역방향 돌면서 scc구성하면서 사이클당 인출액 합계구하기
		visit = new boolean[N + 1];
		sccCount = 0;
		sccNum = new int[N + 1]; // 각 노드의 scc번호 저장
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(!visit[now]) {
				sccList.add(new ArrayList<>());
				int money = dfsSecond(now);
				sccMoney.add(money);
				sccCount++;
			}
		}
//		System.out.println(sccMoney); // 인출액 합계가 정상적으로 구해졌는지 확인
//		System.out.println(Arrays.toString(sccNum)); // scc 번호가 정상적으로 저장되었는지 확인
		
		// 2. 구해진 결과물들로 dp 돌면서 각 레스토랑까지의 최대액수를 구하고 그 중 최대값 출력
		dp = new int[sccCount];
		dp[sccNum[S]] = sccMoney.get(sccNum[S]);
		
//		dp[0]++;
//		System.out.println(Arrays.toString(dp));
		ArrayDeque<Integer> q = new ArrayDeque<Integer>(); // 시작하는 scc번호부터 진출하면서 각 scc로의 최대값 구함
		q.add(sccNum[S]);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int mem : sccList.get(now)) {
				for(int next : list1.get(mem)) {
					if (now != sccNum[next] && dp[sccNum[next]] < dp[now] + sccMoney.get(sccNum[next])) {
						dp[sccNum[next]] = dp[now] + sccMoney.get(sccNum[next]);
						q.add(sccNum[next]);
					} else if (now != sccNum[next] && dp[now] == 0) {
						q.add(sccNum[next]);
					}
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		
		for(int i=0; i<P ;i++)
			ans = Math.max(ans, dp[sccNum[rest[i]]]);
		System.out.println(ans);
		
	}
	
	static int dfsSecond(int n) {
		visit[n] = true;
		sccNum[n] = sccCount;
		sccList.get(sccCount).add(n);
		int money = cash[n];
		for (int next : list2.get(n))
			if (!visit[next])
				money += dfsSecond(next);
		return money;
	}

	static void dfsFirst(int n) {
		visit[n] = true;
		for (int next : list1.get(n)) {
			if(!visit[next]) dfsFirst(next);
		}
		stack.push(n);
	}

}

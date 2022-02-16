package level35_TopologicalSort;

import java.io.*;
import java.util.*;

public class pb02_G1_3665_최종순위 {

	static int[] indegree;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 숫자

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 팀의 수
			indegree = new int[n + 1];
			map = new boolean[n + 1][n + 1];

			StringTokenizer token = new StringTokenizer(br.readLine()); // 작년순위
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(token.nextToken());
				indegree[num] = i;
				for (int j = 1; j <= n; j++) {
					if(j!=num && !map[j][num]) map[num][j] = true;
				}
			}

			int m = Integer.parseInt(br.readLine()); // 등수가 바뀐 쌍의 수
			for (int i = 0; i < m; i++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				
				if(map[a][b]) {
					map[a][b] = false;
					map[b][a] = true;
					indegree[a]++;
					indegree[b]--;
				} else {
					map[a][b] = true;
					map[b][a] = false;
					indegree[a]--;
					indegree[b]++;
				}
			}

			ArrayDeque<Integer> q = new ArrayDeque<Integer>(); // 시작점 삽입
			for (int i = 1; i <= n; i++)
				if (indegree[i] == 0)
					q.addLast(i);

			StringBuilder sb = new StringBuilder(); // 모아서 출력
			for (int i = 0; i < n; i++) { // 큐는 n의 개수만큼 돌아야 한다
				if (q.size() > 1) {
					sb = new StringBuilder().append("?");
					break;
				}
				if (q.isEmpty()) {
					sb = new StringBuilder().append("IMPOSSIBLE");
					break;
				}
				int now = q.poll();
				sb.append(now).append(" ");
//				System.out.println(now);

				for (int j = 1; j <= n; j++) // 모든 indegree를 1씩 감해준다
					if(map[now][j]) {
						map[now][j] = false;
						if (--indegree[j] == 0) q.addLast(j);
					}
			}

			System.out.println(sb);

		}
	}

}

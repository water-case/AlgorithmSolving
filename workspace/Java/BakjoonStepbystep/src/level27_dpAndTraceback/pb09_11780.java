package level27_dpAndTraceback;

import java.io.*;
import java.util.*;

public class pb09_11780 {

	static int MAX = 1_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;

		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		int[][] map = new int[n + 1][n + 1];
		int[][] route = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				route[i][j] = -1;
				if (i == j)
					continue;
				map[i][j] = MAX;
			}
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());

			if (map[a1][a2] > a3) {
				map[a1][a2] = a3;
			}
			route[a1][a2] = a1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > (map[i][k] + map[k][j])) {
						map[i][j] = map[i][k] + map[k][j];
						route[i][j] = route[k][j];
					}
				}
			}
		}

		// 출력부
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == MAX)
					sb.append(0).append(" ");
				else
					sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(route[i][j] == -1)
					sb.append(0).append("\n");
				else {
					Stack<Integer> stack = new Stack<>();
					stack.push(j);
					int idx = j;
					
					while(i != route[i][idx]) {
						idx = route[i][idx];
						stack.push(idx);
					}
					
					sb.append(stack.size()+1).append(" ")
					  .append(i).append(" ");
					
					while(!stack.isEmpty())
						sb.append(stack.pop()).append(" ");
					
					sb.append("\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

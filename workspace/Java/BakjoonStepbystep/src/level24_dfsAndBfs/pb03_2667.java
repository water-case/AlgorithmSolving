package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class pb03_2667 {

	static int[][] deltas = new int[][] {
		{-1, 0}, // 상
		{ 0, 1}, // 우
		{ 1, 0}, // 하
		{ 0,-1}, // 좌
	};
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int count;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				arr[i][j] = tmp[j] - 48;
		}
//		for(boolean[] b : visit) System.out.println(Arrays.toString(b));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visit[i][j] == false) {
//					for(boolean[] b : visit) System.out.println(Arrays.toString(b));
					dfs(i, j);
//					System.out.println(i + " " + j + " " + count);
					if(count != 0) {
						ans.add(count);
						count = 0;
					}
				}
			}
		}
		ans.sort((o1, o2)->{ return o1-o2; });
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++)
			System.out.println(ans.get(i));
	}
	
	static void dfs(int x, int y) {
//		if(x < 0 || x > N-1 || y < 0 || y > N-1) return;
		if(visit[x][y] == true) return;
		visit[x][y] = true;
		count++;
		for(int i=0; i<4; i++) {
			int dx = x+deltas[i][0];
			int dy = y+deltas[i][1];
			if(dx < 0 || dx > N-1 || dy < 0 || dy > N-1) continue;
			if(arr[dx][dy] == 1 && visit[dx][dy] == false) {
				dfs(dx, dy);
			}
		}
	}
}

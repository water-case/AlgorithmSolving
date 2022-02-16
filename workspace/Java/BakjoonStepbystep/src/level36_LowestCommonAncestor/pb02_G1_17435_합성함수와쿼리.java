package level36_LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class pb02_G1_17435_합성함수와쿼리 {

	static int log = 19;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());
		int[][] f = new int[log + 1][m + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++)
			f[0][i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < log + 1; i++)
			for (int j = 1; j < m + 1; j++)
				f[i][j] = f[i - 1][f[i - 1][j]];
//		for(int[] ia : f)
//			System.out.println(Arrays.toString(ia));

		int Q = Integer.parseInt(br.readLine());
		int[][] Qs = new int[Q][2];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			Qs[i][0] = Integer.parseInt(st.nextToken());
			Qs[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; i++) {
			int q = Qs[i][0];
			int x = Qs[i][1];
			for (int j = 0; j < log; j++) {
				if ((q & (1 << j)) > 0) {
					x = f[j][x];
				}
			}
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}

}

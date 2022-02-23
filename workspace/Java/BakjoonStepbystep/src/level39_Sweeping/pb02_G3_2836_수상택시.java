package level39_Sweeping;

import java.io.*;
import java.util.*;

public class pb02_G3_2836_수상택시 {

	static class Line implements Comparable<Line> {
		int x, y;

		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line o) {
			return x - o.x;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수상 택시를 타려고 하는 사람 수
		int M = Integer.parseInt(st.nextToken()); // 상근이가 가려고 하는 집

		Line[] line = new Line[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i] = new Line(a, b);
		}
		Arrays.sort(line);
		int ans = line[0].x;
		int left = line[0].x;
		int right = line[0].y;
		for (int i = 1; i < N; i++) {
			Line now = line[i];
			if (now.x > right) { // 이어지지 않은경우
				ans += (right - left) * 2 + (now.x - left);
				left = now.x;
				right = now.y;
			} else if (now.x < left && now.y > right) // 이어진경우
				right = now.y;
		}
		ans += (right - left) * 2 + (M - right);
		System.out.println(ans);
	}

}

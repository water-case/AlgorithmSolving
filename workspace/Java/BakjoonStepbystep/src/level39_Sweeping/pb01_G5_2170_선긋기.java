package level39_Sweeping;

import java.io.*;
import java.util.*;

public class pb01_G5_2170_선긋기 {

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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 선을 그은 횟수

		Line[] line = new Line[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i] = new Line(a, b);
		}
		Arrays.sort(line); // x순서대로 정렬

		int ans = 0;
		int left = line[0].x;
		int right = line[0].y;
		for (int i = 1; i < N; i++) { // 순서대로 빼면서 기록
			if(line[i].x > right) { // 줄이 끊어진경우 갱신
				ans += right - left;
				left = line[i].x;
				right = line[i].y;
			} else if(line[i].y > right) // 줄이이어진경우
				right = line[i].y;
//			System.out.println(left + " " + right);
		}
		ans += right - left;
		System.out.println(ans);
	}

}

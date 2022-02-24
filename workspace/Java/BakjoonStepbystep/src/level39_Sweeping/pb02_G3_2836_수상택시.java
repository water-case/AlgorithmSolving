package level39_Sweeping;

import java.io.*;
import java.util.*;

/*
 * 주어지는 쿼리수인 N이 300_000개이고
 * M은 10억이다
 * 결과를 저장하는 변수를 long으로 두지않으면 터짐
 */

public class pb02_G3_2836_수상택시 {

	static class Line implements Comparable<Line> {
		int end, start;

		public Line(int end, int start) {
			this.end = end;
			this.start = start;
		}

		@Override
		public int compareTo(Line o) {
			if(end != o.end) return end - o.end;
			return start - o.start;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수상 택시를 타려고 하는 사람 수
		int M = Integer.parseInt(st.nextToken()); // 상근이가 가려고 하는 집

		ArrayList<Line> line = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b)
				line.add(new Line(b, a));
//			else
//				line[i] = new Line(a, b);
		}
		if(line.size() == 0) {
			System.out.println(M);
			System.exit(0);
		}
		Collections.sort(line);
//		for(Line l : line) System.out.println(l.start + " " + l.end);
		long ans = M;
		int start = line.get(0).start;
		int end = line.get(0).end;
		for (int i = 1; i < line.size(); i++) {
			Line now = line.get(i);
			if (now.end > start) { // 이어지지 않은경우
				ans += (start - end) * 2;
				start = now.start;
				end = now.end;
			} else if (now.start > start && now.end <= start) {// 이어진경우
				start = now.start;
			}
		}
		ans += (start - end) * 2;
		System.out.println(ans);
	}

}

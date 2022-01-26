package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class pb10_2261 {
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Point[] pa;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pa = new Point[N];
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			pa[i] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())) ;
		}
		Arrays.sort(pa, (o1, o2)->Integer.compare(o1.x, o2.x) );
		System.out.println(cf(0, N-1));
	}
	// 두 점 사이의 거리 구하는 메서드
	static int dif(Point a, Point b) {
		int x = a.x-b.x, y = a.y-b.y;
		return x*x + y*y;
	}
	// 완전탐색
	static int alls(int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			Point x = pa[i];
			for (int j = i + 1; j <= end; j++)
				min = Math.min(min, dif(x,pa[j]));
		}
		return min;
	}
	
	static int cf(int start, int end) {
		if(end - start + 1 < 4) return alls(start, end);
		int mid = (start + end) / 2;
		int l = cf(start, mid);
		int r = cf(mid + 1, end);
		int min = Math.min(l, r);
		int middle = middleDif(start, mid, end, min);
		return Math.min(min, middle);
	}
	
	static int middleDif(int start, int mid, int end, int min) {
		int xdif;
		
		List<Point> list = new ArrayList<>();
		int midx = pa[mid].x;
		for(int i=start; i<=end; i++) {
			xdif = pa[i].x - midx;
			if(xdif * xdif < min) {
				list.add(pa[i]);
			}
		}
		
		Collections.sort(list, (o1, o2)->Integer.compare(o1.y, o2.y));
		int ydif;
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				ydif = list.get(i).y - list.get(j).y;
				if(ydif * ydif < min) {
					min = Math.min(dif(list.get(i), list.get(j)), min);
				} else {
					break;
				}
			}
		}
		return min;
	}
}

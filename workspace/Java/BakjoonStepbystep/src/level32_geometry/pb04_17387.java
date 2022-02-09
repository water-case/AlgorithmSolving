package level32_geometry;

import java.io.*;
import java.util.*;

public class pb04_17387 {

	static class Point {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Point[] p = new Point[4];
		for (int i = 0; i < 2; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			p[i*2] = new Point(x, y);
			x = Integer.parseInt(token.nextToken());
			y = Integer.parseInt(token.nextToken());
			p[i*2+1] = new Point(x, y);
		}

		// abc*abd 와 bca*bcd ccw를 구하고, 둘다 0이면 네점이 한직선상에 있는 평행인데, 서로 포함하느냐 포함하지 않느냐를 검사해야한다
		// 문제에서는 포함하면 교차로 본다
		// 각 선분과 상대 선분 한점을 기점으로해서 x, y값으로 포함하는지 아닌지를 비교함
		// 이미 ccw로 평행한 상태인걸 확인했기때문에 충분히 구할 수 있음
		// 포함시 1출력, 포함안하면 0출력
		// 그리고 세 점이 한 직선상에 있는 경우 선분간 관계
		// 1. 한 점이 다른 선분에 포함된 경우 
		// CCW(A, B, C) * CCW(A, B, D) < 0   &&   CCW(C, D, A) * CCW(C, D, B) == 0
		// 2. 한 점이 다른 선분의 끝점에 포함된 경우
		// CCW(A, B, C) * CCW(A, B, D) == 0   &&   CCW(C, D, A) * CCW(C, D, B) == 0
		// 3. 한 점이 다른 선분에 포함되지 않는 경우
		// CCW(A, B, C) * CCW(A, B, D) > 0   &&   CCW(C, D, A) * CCW(C, D, B) == 0
		// 를 정리하면 두 선분의 내부끼리만 교차 + 세 점이 한 직선상에 있는 경우를 합쳐 
		// d1<=0 && d2<=0 식을 도출 할 수 있음
		int d1 = ccw(p[0],p[1],p[2]) * ccw(p[0],p[1],p[3]);
		int d2 = ccw(p[2],p[3],p[0]) * ccw(p[2],p[3],p[1]);
		if (d1 == 0 && d2 == 0) {
			if(isLine(p[0],p[1],p[2]) && isLine(p[0],p[1],p[3]) || (isLine(p[1],p[0],p[2]) && isLine(p[1],p[0],p[3]))) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		} else {
			if(d1 <= 0 && d2 <= 0) {
				System.out.println(1);
			}else 
				System.out.println(0);
		}
	}
	
	static boolean isLine(Point p1, Point p2, Point p3) {
		if(p1.x < p2.x) {
			return p2.x < p3.x;
		} else if(p2.x < p1.x) {
			return p3.x < p2.x;
		} else {
			if(p1.y < p2.y) {
				return p2.y < p3.y;
			} else if(p2.y < p1.y) {
				return p3.y < p2.y;
			}
		}
		return false;
	}

	static int ccw(Point p1, Point p2, Point p3) {
		long tmp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
		if (tmp == 0) {
			return 0;
		} else if (tmp > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}

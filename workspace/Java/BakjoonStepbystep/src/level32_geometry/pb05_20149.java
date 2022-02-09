package level32_geometry;

import java.io.*;
import java.util.*;

import level32_geometry.pb04_17387.Point;

public class pb05_20149 {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		Point[] point = new Point[4];
		token = new StringTokenizer(br.readLine());
		point[0] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		point[1] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		token = new StringTokenizer(br.readLine());
		point[2] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		point[3] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));

		solve(point);
	}

	static void solve(Point[] p) {
		int p123 = ccw(p[0], p[1], p[2]);
		int p124 = ccw(p[0], p[1], p[3]);
		int p341 = ccw(p[2], p[3], p[0]);
		int p342 = ccw(p[2], p[3], p[1]);
		int d12 = p123 * p124;
		int d34 = p341 * p342;

		if (d12 <= 0 && d34 < 0 || d12 < 0 && d34 <= 0) {
			System.out.println(1);
			String s1 = getSlope(p[0], p[1]);
			String s2 = getSlope(p[2], p[3]);
			double x, y;
			
			if(s1.equals("INF")) {
				x = p[0].x;
				double sl2 = Double.parseDouble(s2);
				y = sl2 * (x - p[2].x) + p[2].y;
			} else if (s2.equals("INF")) {
				x = p[2].x;
				double sl1 = Double.parseDouble(s1);
				y = sl1 * (x - p[0].x) + p[0].y;
			} else {
				double sl1 = Double.parseDouble(s1), sl2 = Double.parseDouble(s2);
				x = (sl1 * p[0].x - sl2 * p[2].x + p[2].y - p[0].y) / (sl1 - sl2);
				y = sl1 * (x - p[0].x) + p[0].y;
			}
			System.out.println(x + " " + y);
		} else if (d12 == 0 && d34 == 0) {
			if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
				int n = isCrossed(p);
				if (n > 0)
					System.out.println(1);
				else
					System.out.println(0);

				if (n == 2) {
					if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
						System.out.println(p[0].x + " " + p[0].y);
					else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
						System.out.println(p[1].x + " " + p[1].y);
				}
			} else {
				System.out.println(1);
				if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
					System.out.println(p[0].x + " " + p[0].y);
				else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
					System.out.println(p[1].x + " " + p[1].y);
			}
		} else
			System.out.println(0);

	}

	static int isCrossed(Point[] p) {
		int A, B, C, D;
		if (p[0].x == p[1].x) {
			A = Math.min(p[0].y, p[1].y);
			B = Math.max(p[0].y, p[1].y);
			C = Math.min(p[2].y, p[3].y);
			D = Math.max(p[2].y, p[3].y);
		} else {
			A = Math.min(p[0].x, p[1].x);
			B = Math.max(p[0].x, p[1].x);
			C = Math.min(p[2].x, p[3].x);
			D = Math.max(p[2].x, p[3].x);
		}

		if (A == D || B == C)
			return 2;
		else if (A < D && C < B)
			return 1;
		else
			return 0;
	}

	static String getSlope(Point p1, Point p2) {
		if (p1.x == p2.x)
			return "INF";
		double s = ((double) p2.y - p1.y) / (p2.x - p1.x);
		return String.valueOf(s);
	}

	static int ccw(Point p1, Point p2, Point p3) {
		long tmp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
		if (tmp == 0) { // 일직선
			return 0;
		} else if (tmp > 0) {
			return 1;
		} else {
			return -1;
		}
	}
// 		계속해서 히든케이스가 안풀려 풀이를 사용함
//		이후 이 문제 포함 이후 기하문제들은 난이도가 너무높아 Pass 함

}
// 		기본적인 케이스들은 풀리나 히든케이스들은 안풀려서 기존 풀이들을 참고함
//		Point[] p = new Point[4];
//		for (int i = 0; i < 2; i++) {
//			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
//			int x = Integer.parseInt(token.nextToken());
//			int y = Integer.parseInt(token.nextToken());
//			p[i * 2] = new Point(x, y);
//			x = Integer.parseInt(token.nextToken());
//			y = Integer.parseInt(token.nextToken());
//			p[i * 2 + 1] = new Point(x, y);
//		}
//
//		// abc*abd 와 bca*bcd ccw를 구하고, 둘다 0이면 네점이 한직선상에 있는 평행인데, 서로 포함하느냐 포함하지 않느냐를
//		// 검사해야한다
//		// 문제에서는 포함하면 교차로 본다
//		// 각 선분과 상대 선분 한점을 기점으로해서 x, y값으로 포함하는지 아닌지를 비교함
//		// 이미 ccw로 평행한 상태인걸 확인했기때문에 충분히 구할 수 있음
//		// 포함시 1출력, 포함안하면 0출력
//		// 그리고 세 점이 한 직선상에 있는 경우 선분간 관계
//		// 1. 한 점이 다른 선분에 포함된 경우
//		// CCW(A, B, C) * CCW(A, B, D) < 0 && CCW(C, D, A) * CCW(C, D, B) == 0
//		// 2. 한 점이 다른 선분의 끝점에 포함된 경우
//		// CCW(A, B, C) * CCW(A, B, D) == 0 && CCW(C, D, A) * CCW(C, D, B) == 0
//		// 3. 한 점이 다른 선분에 포함되지 않는 경우
//		// CCW(A, B, C) * CCW(A, B, D) > 0 && CCW(C, D, A) * CCW(C, D, B) == 0
//		// 를 정리하면 두 선분의 내부끼리만 교차 + 세 점이 한 직선상에 있는 경우를 합쳐
//		// d1<=0 && d2<=0 식을 도출 할 수 있음
//		int d1 = ccw(p[0], p[1], p[2]) * ccw(p[0], p[1], p[3]);
//		int d2 = ccw(p[2], p[3], p[0]) * ccw(p[2], p[3], p[1]);
//		if (d1 == 0 && d2 == 0) {
//			if (isLine(p[0], p[1], p[2]) && isLine(p[0], p[1], p[3])
//					|| (isLine(p[1], p[0], p[2]) && isLine(p[1], p[0], p[3]))) {
//				System.out.println(0);
//			} else {
//				System.out.println(1);
//				spot(p[0], p[1], p[2], p[3]);
//			}
//		} else {
//			if (d1 <= 0 && d2 <= 0) {
//				System.out.println(1);
//				spot(p[0], p[1], p[2], p[3]);
//			} else
//				System.out.println(0);
//		}
//	}
//
//	// 두 직선의 교점구하는 방정식
//	static void spot(Point p1, Point p2, Point p3, Point p4) {
//		long px = (p1.x*p2.y - p1.y*p2.x)*(p3.x-p4.x) - (p1.x-p2.x)*(p3.x*p4.y-p3.y*p4.x);
//		long py = (p1.x*p2.y - p1.y*p2.x)*(p3.y-p4.y) - (p1.y-p2.y)*(p3.x*p4.y-p3.y*p4.x);
//		long p = (p1.x-p2.x)*(p3.y-p4.y) - (p1.y-p2.y)*(p3.x-p4.x);
//		
//		if(p==0) {
//			System.exit(0);
//		} else {
//			System.out.println((double)px/p + " " + (double)py/p);
//		}
//	}
//
//	static boolean isLine(Point p1, Point p2, Point p3) {
//		if (p1.x < p2.x) {
//			return p2.x < p3.x;
//		} else if (p2.x < p1.x) {
//			return p3.x < p2.x;
//		} else {
//			if (p1.y < p2.y) {
//				return p2.y < p3.y;
//			} else if (p2.y < p1.y) {
//				return p3.y < p2.y;
//			}
//		}
//		return false;
//	}
//
//	static int ccw(Point p1, Point p2, Point p3) {
//		long tmp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
//		if (tmp == 0) {
//			return 0;
//		} else if (tmp > 0) {
//			return 1;
//		} else {
//			return -1;
//		}
//	}
//
//}
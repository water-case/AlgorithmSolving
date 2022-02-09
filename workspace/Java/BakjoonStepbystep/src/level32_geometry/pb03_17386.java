package level32_geometry;

import java.io.*;
import java.util.*;

public class pb03_17386 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(token.nextToken());
		int y1 = Integer.parseInt(token.nextToken());
		int x2 = Integer.parseInt(token.nextToken());
		int y2 = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(token.nextToken());
		int y3 = Integer.parseInt(token.nextToken());
		int x4 = Integer.parseInt(token.nextToken());
		int y4 = Integer.parseInt(token.nextToken());

		int d1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
		int d2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
		if (d1 < 0 && d2 < 0)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		return x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0 ? 1 : -1;
	}

	// 수학적인 풀이방법에는 실패, 신발끈풀이(ccw)를 이용한 풀이로 대체
//		int[][] ps = new int[4][2];
//		int[][][] line = new int[4][2][2];
//
//		for (int i = 0; i < 2; i++) {
//			StringTokenizer token = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 2; j++) {
//				for (int k = 0; k < 2; k++) {
//					ps[i * 2 + j][k] = Integer.parseInt(token.nextToken());
//				}
//			}
//		}
//
//		for (int i = 0; i < 4; i++) {
//			if (i == 0 || i == 1) {
//				line[i][0] = getLine(ps[i], ps[2]);
//				line[i][1] = getLine(ps[i], ps[3]);
//			} else {
//				line[i][0] = getLine(ps[i], ps[0]);
//				line[i][1] = getLine(ps[i], ps[1]);
//			}
//		}
//
//		int v1 = vecter(line[0][0], line[0][1]);
//		int v2 = vecter(line[1][0], line[1][1]);
//		int d1 = v1 * v2;
//		int v3 = vecter(line[2][0], line[2][1]);
//		int v4 = vecter(line[3][0], line[3][1]);
//		int d2 = v3 * v4;
//		
//		System.out.println(d1 + " " + d2);
//
//		if (d1 < 0 && d2 < 0)
//			System.out.println(1);
//		else
//			System.out.println(0);
//
//	}

//	static int vecter(int[] l1, int[] l2) {
//		return l1[0] * l2[1] - l1[1] * l2[0];
//	}
//
//	static int[] getLine(int[] p1, int[] p2) {
//		return new int[] { p2[0] - p1[0], p2[1] - p1[1] };
//	}

}

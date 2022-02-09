package level32_geometry;

import java.io.*;
import java.util.*;

public class pb02_11758 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] p = new int[3][2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(token.nextToken());
			p[i][1] = Integer.parseInt(token.nextToken());
		}
		
		int[] vecter1 = getVecter(p[0],p[1]);
		int[] vecter2 = getVecter(p[0],p[2]);
		
		int result = ccw(vecter1, vecter2);
		
		if(result > 0) {
			System.out.println(1);
		}else if(result < 0) {
			System.out.println(-1);
		}else {
			System.out.println(0);
		}
	}
	
	static int ccw(int[] v1, int[] v2) {
		return v1[0]*v2[1] - v1[1]*v2[0];
	}
	
	static int[] getVecter(int[] p1, int[] p2) {
		int[] result = new int[2];
		result[0] = p2[0]-p1[0];
		result[1] = p2[1]-p1[1];
		return result;
	}

}

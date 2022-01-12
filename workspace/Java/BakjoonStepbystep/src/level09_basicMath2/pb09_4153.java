package level09_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb09_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] tc = new int[100][3];
		int i = 0;
		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());

			if(a > b) {
				if(a > c) {
					tc[i][0] = b;
					tc[i][1] = c;
					tc[i][2] = a;
				} else {
					tc[i][0] = b;
					tc[i][1] = a;
					tc[i][2] = c;
				}
			} else {
				if(b > c) {
					tc[i][0] = a;
					tc[i][1] = c;
					tc[i][2] = b;
				} else {
					tc[i][0] = b;
					tc[i][1] = a;
					tc[i][2] = c;
				}
			}

			if (tc[i][0] == 0 && tc[i][1] == 0 && tc[i][1] == 0)
				break;

			i++;
		}

		for (int j = 0; j < i; j++) {
			int a = (int) Math.pow(tc[j][0], 2);
			int b = (int) Math.pow(tc[j][1], 2);
			int c = (int) Math.pow(tc[j][2], 2);
			
			if (c == a + b)
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}

}

package level09_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb08_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] x = new int[3];
		int[] y = new int[3];

		for (int i = 0; i < 3; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			x[i] = Integer.parseInt(token.nextToken());
			y[i] = Integer.parseInt(token.nextToken());
		}

		boolean bx = false;
		boolean by = false;

		for (int i = 1; i <= 2; i++) {
			int x1 = x[0];
			int y1 = y[0];
			
			if(x1 == x[i]) {
				x[0] = -1;
				x[i] = -1;
				bx = true;
			}
			if(y1 == y[i]) {
				y[0] = -1;
				y[i] = -1;
				by = true;
			}
		}
		
		if(bx) {
			// -1아닌것 찾기
			System.out.print(x[1] == -1 ? x[2] + " " : x[1] + " ");
		} else
			System.out.print(x[0] + " ");
		
		if(by) {
			// -1아닌것 찾기
			System.out.print(y[1] == -1 ? y[2] : y[1]);
		} else
			System.out.print(y[0]);
		
	}

}

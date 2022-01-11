package level8_basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb6_2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[] input = new int[t * 2];
		for (int i = 0; i < t * 2; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int[][] apart = new int[15][14];
		// 고정층 입력
		for (int i = 0; i < 14; i++) {
			apart[0][i] = i + 1;
		}

		// 재귀적 값계산
		for (int i = 1; i < 15; i++) {
			for (int j = 0; j < 14; j++) {
				for (int k = 0; k <= j; k++) {
					apart[i][j] += apart[i - 1][k];
				}
			}
		}

//		for (int i = 13; i >= 0; i--) {
//			for (int j = 0; j < 14; j++) {
//				System.out.print(apart[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < t*2; i+=2) {
			System.out.println(apart[input[i]][input[i+1]-1]);
		}

	}

}

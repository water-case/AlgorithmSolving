package level14_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb6_2580 {

	public static int[][] arr = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		cf(0, 0);
	}

	public static void cf(int row, int col) {
		if (col == 9) {
			cf(row + 1, 0);
			return;
		}

		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
 
			System.exit(0);
		}

		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (poss(row, col, i)) {
					arr[row][col] = i;
					cf(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}

		cf(row, col + 1);
	}

	private static boolean poss(int row, int col, int v) {

		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == v) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == v) {
				return false;
			}
		}

		int tmpr = (row / 3) * 3;
		int tmpc = (col / 3) * 3;
		for (int i = tmpr; i < tmpr + 3; i++) {
			for (int j = tmpc; j < tmpc + 3; j++) {
				if(arr[i][j] == v) {
					return false;
				}
			}
		}

		return true;

	}

}

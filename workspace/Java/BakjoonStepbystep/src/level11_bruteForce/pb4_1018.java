package level11_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb4_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		// 너무 어렵게 접근한거같은데?
		int ans = 64;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				boolean check = false;
				char wb = 'W';
				int ans1 = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if(board[k][l] != wb) {
							ans1++;
						}
						if(ans1 > ans) {
							check = true;
							break;
						}
						if(wb == 'W') wb = 'B';
						else wb= 'W';
					}
					if(wb == 'W') wb = 'B';
					else wb= 'W';
					if(check) {
						check = false;
						break;
					}
				}
				wb = 'B';
				int ans2 = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if(board[k][l] != wb) {
							ans2++;
						}
						if(ans2 > ans) {
							check = true;
							break;
						}
						if(wb == 'W') wb = 'B';
						else wb= 'W';
					}
					if(wb == 'W') wb = 'B';
					else wb= 'W';
					if(check) {
						check = false;
						break;
					}
				}
				if (ans1 >= ans2) {
					if (ans > ans2) {
						ans = ans2;
					}
				} else {
					if (ans > ans1) {
						ans = ans1;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}

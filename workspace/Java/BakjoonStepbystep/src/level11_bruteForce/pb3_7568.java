package level11_bruteForce;

import java.util.Scanner;

public class pb3_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] ps = new int[N][3];

		for (int i = 0; i < N; i++) {
			ps[i][0] = sc.nextInt();
			ps[i][1] = sc.nextInt();
			ps[i][2] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1+i; j < N; j++) {
				if (ps[i][0] < ps[j][0] && ps[i][1] < ps[j][1]) {
					ps[i][2]++;
				} else if (ps[i][0] > ps[j][0] && ps[i][1] > ps[j][1]) {
					ps[j][2]++;
				}
				
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(ps[i][2] + " ");
		}

	}

}

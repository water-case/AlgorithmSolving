package level17_numAndCombi;

import java.util.Scanner;

public class pb09_1010 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			int[][] farr = new int[N+1][N+1];
			
			for(int i=0; i<N+1; i++) {
				for(int j=0; j<=i; j++) {
					if(i==j || j == 0) {
						farr[i][j] = 1;
					} else {
						farr[i][j] = (farr[i-1][j-1] + farr[i-1][j]);
					}
				}
			}
			sb.append(farr[N][K] + "\n");
		}
		System.out.println(sb);
	}

}

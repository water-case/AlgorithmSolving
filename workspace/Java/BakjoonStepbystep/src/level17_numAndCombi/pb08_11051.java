package level17_numAndCombi;

import java.util.Scanner;

public class pb08_11051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] farr = new int[N+1][N+1];
		
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<=i; j++) {
				if(i==j || j == 0) {
					farr[i][j] = 1;
				} else {
					farr[i][j] = (farr[i-1][j-1] + farr[i-1][j])%10007;
				}
			}
		}
		System.out.println(farr[N][K]);
	}

}

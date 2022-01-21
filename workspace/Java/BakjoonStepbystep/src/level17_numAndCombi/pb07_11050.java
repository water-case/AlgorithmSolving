package level17_numAndCombi;

import java.util.Scanner;

public class pb07_11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(factorial(N) / (factorial(K) * factorial(N-K)));
		
	}
	
	static int factorial(int n) {
		int a = 1;
		for(int i=2; i<=n; i++) {
			a *= i;
		}
		return a;
	}

}

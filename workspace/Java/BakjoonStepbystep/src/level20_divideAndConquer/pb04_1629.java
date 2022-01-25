package level20_divideAndConquer;

import java.util.Scanner;

public class pb04_1629 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		System.out.println(cf(A, B, C));
		sc.close();
	}

	static long cf(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}
		
		long tmp = cf(a, b / 2, c);
		
		if (b % 2 == 0) {
			return tmp * tmp % c;
		} else {
			return (tmp * tmp % c) * a % c;
		}

	}
}

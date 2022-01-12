package level9_basicMath2;

import java.util.Scanner;

public class pb03_11653 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		if (a == 1)
			return;
		if (prime(a))
			System.out.println(a);
		else {
			// 소인수분해함
			while (true) {
				// 더 이상 나눌 수 없으면
				if (prime(a)) {
					System.out.println(a);
					break;
				}
				for (int i = 2; i < a; i++) {
					if (a % i == 0) {
						a /= i;
						System.out.println(i);
						break;
					}
				}

			}
		}

	}

	public static boolean prime(int x) {
		if (x == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

}

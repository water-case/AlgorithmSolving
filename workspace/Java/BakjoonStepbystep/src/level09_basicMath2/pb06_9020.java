package level09_basicMath2;

import java.util.Scanner;

public class pb06_9020 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] test = new int[n];

		for (int i = 0; i < n; i++)
			test[i] = scan.nextInt();

		int[] gold = new int[n];

		for (int i = 0; i < n; i++) {
			int num = test[i];
			for (int j = 2; j <= num / 2; j++) {
				if (prime(j)) {
					if(prime(num-j))
						gold[i] = j;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(gold[i] + " " + (test[i]-gold[i]));
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

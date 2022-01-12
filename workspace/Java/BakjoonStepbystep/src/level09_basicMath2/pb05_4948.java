package level09_basicMath2;

import java.util.Scanner;

public class pb05_4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10000];

		int c = 0;
		while (true) {
			a[c] = sc.nextInt();
			if (a[c] == 0)
				break;
			c++;
		}

		int[] ans = new int[c];
		for (int i = 0; i < c; i++) {
			for (int j = a[i]+1; j <= 2*a[i]; j++) {
				if(prime(j)) {
					ans[i]++;
				}
			}
		}
		
		for (int i = 0; i < c; i++) {
			System.out.println(ans[i]);
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

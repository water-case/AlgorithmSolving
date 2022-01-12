package level10_recursion;

import java.util.Scanner;

public class pb2_10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a1 = 0;
		int a2 = 1;
		int a3 = 1;
		int an = 0;

		if (n == 0)
			System.out.println(0);
		else if (n == 1)
			System.out.println(1);
		else if (n == 2)
			System.out.println(1);
		else {
			for (int i = 3; i <= n; i++) {
				an = a2+a3;
				a2 = a3;
				a3 = an;
			}
			System.out.println(an);
		}

		sc.close();
	}

}

package level11_bruteForce;

import java.util.Scanner;

public class pb5_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int i = 666;
		int ans = 0;
		int count = 0;
		while (true) {
			int tmp = i;
			count = 0;
			while(tmp>1) {
				int a = tmp % 10;
				tmp /= 10;
				
				if (a == 6)
					count++;
				else {
					count = 0;
				}
				
				if (count == 3) {
					ans++;
					break;
				}
				
			}
			
			if (ans == n) {
				System.out.println(i);
				break;
			}
			i++;


		}

	}

}

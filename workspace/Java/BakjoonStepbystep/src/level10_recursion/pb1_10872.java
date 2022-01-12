package level10_recursion;

import java.util.Scanner;

public class pb1_10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int pac = 1;
		for(int i=1; i<=n; i++) {
			pac *= i;
		}
		
		System.out.println(pac);
	}

}

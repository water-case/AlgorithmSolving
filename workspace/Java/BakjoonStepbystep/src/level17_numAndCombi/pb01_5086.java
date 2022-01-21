package level17_numAndCombi;

import java.util.Scanner;

public class pb01_5086 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			if(n1 == 0 && n2 == 0) break;
			
			// 첫 번째 숫자가 두 번째 숫자의 약수 8 16
			if(n2%n1 == 0 && n1<n2) {
				sb.append("factor\n");
			} else if(n1%n2 == 0 && n2<n1) {
				// 첫 번째 숫자가 두 번째 숫자의 배수 32 4
				sb.append("multiple\n");
			} else {
				// 첫 번째 숫자가 두 번째 숫자의 약수와 배수 둘다 아니다
				sb.append("neither\n");
			}
		}
		
		System.out.println(sb);
		
	}

}

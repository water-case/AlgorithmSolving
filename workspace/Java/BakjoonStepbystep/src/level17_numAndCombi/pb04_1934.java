package level17_numAndCombi;

import java.util.Scanner;

public class pb04_1934 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int g = gcdf(a,b);
			sb.append(a*b/g + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int gcdf(int a, int b) {
		int tmp = a%b;
		if(tmp == 0) {
			return b;
		}else {
			return gcdf(b, tmp);
		}
	}

}

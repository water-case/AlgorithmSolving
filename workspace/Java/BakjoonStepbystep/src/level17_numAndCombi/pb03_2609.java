package level17_numAndCombi;

import java.util.Scanner;

public class pb03_2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int g = gcdf(a,b);
		int l = a*b/g;
		
		System.out.println(g);
		System.out.println(l);
		sc.close();
	}
	
	static int gcdf(int a, int b) {
		int tmp = a%b;
		if(tmp == 0) {
			return b;
		} else {
			return gcdf(b, tmp);
		}
	}

}

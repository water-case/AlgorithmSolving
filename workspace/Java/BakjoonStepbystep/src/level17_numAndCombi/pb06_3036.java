package level17_numAndCombi;

import java.util.Scanner;

public class pb06_3036 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
//		System.out.println(gcd(12,8));
		
		for(int i=1; i<N; i++) {
			int a = arr[0]*arr[i]/gcd(arr[0], arr[i]);
			sb.append(a/arr[i] + "/" + a/arr[0] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int gcd(int a, int b) {
		while(b!= 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}

}

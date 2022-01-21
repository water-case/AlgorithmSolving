package level17_numAndCombi;

import java.util.Arrays;
import java.util.Scanner;

public class pb05_2981 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int tmp = arr[1] - arr[0];
		for(int i=2; i<T; i++) {
			tmp = gcdf(tmp, arr[i]-arr[i-1]);
		}
		
		for(int i=2; i<=tmp; i++) {
			if(tmp%i == 0) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
		sc.close();
	}
	
	static int gcdf(int a, int b) {
		while( b!= 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

}

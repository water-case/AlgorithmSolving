package level16_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class pb3_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int sum = 0;
		int ans = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i];
			ans += sum;
		}
		
		System.out.println(ans);
		
	}

}

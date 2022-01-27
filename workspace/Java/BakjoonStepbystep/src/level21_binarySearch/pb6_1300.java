package level21_binarySearch;

import java.util.Scanner;

public class pb6_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		long start = 1;
		long end = k;
		
		while(start < end) {
			long mid = (start+end) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++)
				count += Math.min(mid / i, N);
			
			if(k <= count) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}

}

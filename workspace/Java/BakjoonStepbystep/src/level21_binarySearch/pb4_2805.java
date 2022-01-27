package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb4_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		long max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
			max = Math.max(max, arr[i]);
		}
		max++;
		
		long min = 0;
		long mid = 0;
		while(min < max) {
			long ans = 0;
			mid = (max+min) / 2;
			for(int i=0; i<N; i++) {
				if(arr[i] > mid)
					ans += arr[i] - mid;
			}
			
			if(ans < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min-1);
		
	}

}

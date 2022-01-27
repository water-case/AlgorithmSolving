package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb3_1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(token.nextToken());
		int N = Integer.parseInt(token.nextToken());
		long[] arr = new long[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		max++;

		long min = 0;
		long mid = 0;
		while(min < max) {
			int count = 0;
			mid = (max+min) / 2;
			
			for(int i=0; i<K; i++) {
				count += arr[i]/mid;
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min-1);
	}

}
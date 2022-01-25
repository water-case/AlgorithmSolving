package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb09_6549 {

	static long max;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			if(N == 0) break;
			
			max = N;
			arr = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = Integer.parseInt(token.nextToken());
			cf(0, 1);
			System.out.println(max);
		}
	}
	
	static void cf(int idx, int count) {
		if(arr[idx+count] == 1) {
			max = Math.max(max, arr[idx]*count);
			cf(idx+2, 1);
		}
		
	}

}

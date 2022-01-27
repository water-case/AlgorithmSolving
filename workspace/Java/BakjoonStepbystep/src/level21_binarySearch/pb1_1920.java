package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb1_1920 {
	
	static int[] ar1;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ar1 = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			ar1[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(ar1);
		
		int M = Integer.parseInt(br.readLine());
		int[] ar2 = new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++)
			ar2[i] = Integer.parseInt(token.nextToken());
		
		for(int i=0; i<M; i++) {
			sb.append(cf2(ar2[i]) - cf1(ar2[i]) + " ");
		}
		System.out.println(sb);
	}
	
	static int cf1(int n) {
		int start = 0;
		int end = ar1.length;
		
		while(start < end) {
			int mid = (start+end) / 2;
			
			if(n <= ar1[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
	static int cf2(int n) {
		int start = 0;
		int end = ar1.length;
		
		while(start < end) {
			int mid = (start+end) / 2;
			
			if(n < ar1[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

}

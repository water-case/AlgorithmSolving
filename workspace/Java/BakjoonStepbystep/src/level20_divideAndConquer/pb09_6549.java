package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb09_6549 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			if(N == 0) break;
			
			arr = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = Integer.parseInt(token.nextToken());
			sb.append(cf(0, N-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	static long cf(int left, int right) {
		if(left==right) return arr[left];
		
		int middle = (left + right) / 2;
		
		long lSize = cf(left, middle);
		long rSize = cf(middle + 1, right);
		
		long max = Math.max(lSize, rSize);
		max = Math.max(max, getMSize(left, right, middle));
		
		return max;
	}
	
	static long getMSize(int left, int right, int middle) {
		int l = middle;
		int r = middle;
		long h = arr[middle];
		long max = h;
		
		while(left < l && r < right) {
			if(arr[l - 1] < arr[r + 1]) {
				r++;
				h = Math.min(h, arr[r]);
			} else {
				l--;
				h = Math.min(h, arr[l]);
			}
			
			max = Math.max(max, h * (r - l + 1));
		}
		
		while(r < right) {
			r++;
			h = Math.min(h, arr[r]);
			max = Math.max(max, h*(r - l + 1));
		}
		while(l > left) {
			l--;
			h = Math.min(h, arr[l]);
			max = Math.max(max, h*(r - l + 1));
		}
		return max;
	}

}

package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb2_10816 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			sb.append(cf(0, N-1, Integer.parseInt(token.nextToken())) + " ");
		System.out.println(sb);
	}

	static int cf(int start, int end, int n) {
		if(start==end) {
			if(arr[start] == n) {
				return 1;
			}
			return 0;
		}
		
		int ans = -1;
		int mid = (start + end) / 2;

		if (arr[mid] > n) {
			ans = cf(start, mid, n);
		} else if (arr[mid] == n) {
			ans = 1;
			for(int i=mid-1; i>=start; i--) {
				if(arr[i]==n) {
					ans++;
				} else {
					break;
				}
			}
			for(int i=mid+1; i<=end; i++) {
				if(arr[i]==n) {
					ans++;
				} else {
					break;
				}
			}
		} else {
			ans = cf(mid + 1, end, n);
		}

		return ans;
	}

}

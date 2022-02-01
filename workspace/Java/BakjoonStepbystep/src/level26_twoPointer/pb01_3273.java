package level26_twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb01_3273 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(token.nextToken());
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int p1 = 0;
		int p2 = n-1;
		int count = 0;
		while(p1 < p2) {
			int sum = arr[p1] + arr[p2]; 
			if(sum == x) {
				count++;
				p1++;
				p2--;
			} else if(sum > x) {
				p2--;
			} else {
				p1++;
			}
		}
		System.out.println(count);
	}

}

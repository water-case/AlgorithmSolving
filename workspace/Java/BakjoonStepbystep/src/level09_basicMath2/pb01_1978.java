package level09_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb01_1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(token.nextToken());

		boolean check = true;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < 2) continue;
			if (a[i] == 2) {
				ans++;
				continue;
			}
			for (int j = 2; j < a[i]; j++) {
				if (a[i] % j == 0) {
					check = false;
					break;
				}
			}
			if(check)
				ans++;
			check = true;
		}
		System.out.println(ans);

	}

}

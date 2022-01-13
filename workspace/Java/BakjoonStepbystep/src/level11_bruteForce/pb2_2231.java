package level11_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb2_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		int n = Integer.parseInt(N);
		int ans = 0;
		int sum = 0;
		for (int i = n - N.length() * 9; i < n; i++) {
			if(i<1)
				i=1;
			String x = String.valueOf(i);
			for (int j = 0; j < x.length(); j++) {
					sum += Integer.parseInt(x.substring(j, j+1));
			}
			if(n == i + sum) {
				ans = i;
				break;
			}
			sum = 0;
		}

		System.out.println(ans);
	}

}

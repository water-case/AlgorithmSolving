package level11_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb1_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[] cards = new int[N];

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(token.nextToken());
		}
		
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += cards[i];
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				sum += cards[j];
				for (int k = 0; k < N; k++) {
					if (k == i || k == j)
						continue;
					sum += cards[k];
					
					if(sum > ans && sum <= M)
						ans = sum;
					sum -= cards[k];
				}
				sum -= cards[j];
			}
			sum -= cards[i];
		}
		
		System.out.println(ans);

	}

}

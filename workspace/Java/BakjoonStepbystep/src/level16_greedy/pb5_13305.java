package level16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb5_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] road = new long[N];
		long[] price = new long[N];
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(token.nextToken());
		}
		
		// price 첫 주유소 제외한 이전주유소 중 최소값으로 수정 5241 -> 5221
		long min = price[0];
		for(int i=1; i<N; i++) {
			if(price[i] < min) {
				min = price[i];
			} else {
				price[i] = min;
			}
		}
		
		long ans = 0;
		for(int i=0; i<N; i++) {
			ans+=road[i]*price[i];
		}
		System.out.println(ans);
//		System.out.println(Arrays.toString(road));
//		System.out.println(Arrays.toString(price));
		
		
	}

}

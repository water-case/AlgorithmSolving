package level08_basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb9_1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 갯수 입력
		int t = Integer.parseInt(br.readLine());

		int[] diff = new int[t];
		int[] ans = new int[t];

		// 각각의 테스트 케이스 입력
		for (int i = 0; i < t; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			diff[i] = b-a;
		}

		// k광년을 이동하였을때는 k-1, k, k+1 광년만을 다시 이동할 수 있다
		// 처음 작동시 1 이동
		// x지점에서 y지점까지 최소한의 작동횟수로 이동하려함
		// 안전성을 위해 y지점에 도착하기 바로 직전의 이동거리는 반드시 1광년
		// 장치 작동 횟수의 최소값을 구하는 프로그램 작성하기

		for (int i = 0; i < t; i++) {
			int d = diff[i]; // 이동할 거리
			int speed = 1; // 속도
			
			if(d == 1) {
				ans[i] = 1;
				continue;
			}
			
			while(d >= speed*2) {
				d -= speed*2;
				ans[i]++;
				speed++;
			}
			ans[i] *= 2;
			
			if(d > speed) {
				ans[i]++;
			}
			
			// 거리가 speed보다 적게 남았다면 장치 작동횟수 1증가
			if(d != 0) {
				ans[i]++;
			}
		}
		
		for (int i = 0; i < t; i++)
			System.out.println(ans[i]);

	}

}

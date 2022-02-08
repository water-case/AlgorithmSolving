package level32_geometry;

import java.io.*;
import java.util.*;

public class pb01_2166 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N + 1][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Long.parseLong(token.nextToken());
			arr[i][1] = Long.parseLong(token.nextToken());
		}
		arr[N] = arr[0];
		// 신발끈공식을 이용하여 풀이함
		// 벡터의 외적을 이용하여 도출한 공식
		long sum1 = 0;
		long sum2 = 0;

		for (int i = 0; i < N; i++) {
			sum1 += arr[i][0] * arr[i+1][1];
			sum2 += arr[i][1] * arr[i+1][0];
		}
		
		System.out.println(String.format("%.1f", Math.abs((sum1 - sum2) / 2.0)));

		// 세부결과값 떄문이 아니라, 문제에서 주어지는 다각형이 삐뚤빼뚤한 다각형이 주어지면 틀림
//		 ** 세부결과값이 달라서인지 틀렸습니다 출력됨
//		// 다각형을 0번점을 기준으로 N-1개의 삼각형으로 나누고
//		// 헤론의 공식을 이용하여 각각의 넓이를 구해 다각형의 넓이를 구함
//		// 다각형을 이루는 순서대로 좌표가 주어짐
//		// 0,1,2 삼각형 / 0,2,3 삼각형 / 0,3,4 삼각형 / 순서대로 구한다
//		double sum = 0;
//		for (int i = 1; i < N - 1; i++) {
//			// 헤론의 공식을 위해서 삼각형 세변의 길이가 필요함
//			double a = getLength(arr[0], arr[i]);
//			double b = getLength(arr[0], arr[i+1]);
//			double c = getLength(arr[i], arr[i+1]);
//			double S = (a + b + c) / 2; // 세변의 둘레
//			sum += Heron(S, a, b, c);
////			System.out.println(a + " " + b + " " + c + " " + S + " " + sum);
//		}
//		System.out.println(String.format("%.2f", sum));

	}

//	static double Heron(double S, double a, double b, double c) {
//		return Math.sqrt(S * (S - a) * (S - b) * (S - c));
//	}
//
//	static double getLength(double[] a, double[] b) {
//		return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
//	}

}

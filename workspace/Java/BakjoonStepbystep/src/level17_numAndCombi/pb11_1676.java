package level17_numAndCombi;

import java.util.Scanner;

public class pb11_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 5! 5x4x3x2x1 = 120
		// 뒤에서부터 처음 0이 아닌 숫자가 나올때 0의 개수 = 1
		// 10! 10x9x8x7x6x5x4x3x2x1 = 3628800
		// 뒤에서부터 처음 0이 아닌 숫자가 나올때 0의 개수 = 2
		// 10이 나오려면 2x5일때만 가능
		// 5, 10, 15, 20 5의배수때만 5의 개수 증가
		// N을 5로 나누고 몫 누적합, 몫이 5보다 크면 계속 진행
		// N이 30인경우 5로나누면 몫은 6, 한번더진행해서 1 누적합 그리고 종료

		int count = 0;
		while (N >= 5) {
			count += N/5;
			N /= 5;
		}
		
		System.out.println(count);

	}

}

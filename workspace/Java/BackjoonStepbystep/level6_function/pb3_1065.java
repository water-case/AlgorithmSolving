package level6_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb3_1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 : 첫째 줄에 1000보다 작거나 같은 자연수 N이 주어진다
		int n = Integer.parseInt(br.readLine());

		// 한수 : 어떤 양의 정수 X의 각 자리가 등차수열을 이루는 수
		int hanSu = 0;
		for (int i = 1; i <= n; i++) {
			if (Hansu(i) == true)
				hanSu++;
		}

		// 출력 : 1보다 크거나 같고, N보다 작거나 같은 '한수'의 개수를 출력한다
		System.out.println(hanSu);
	}

	public static boolean Hansu(int num) {
		// 100미만은 모두 한수
		if (num < 100)
			return true;
		
		int value = num;
		String digit = Integer.toString(num);
		int[] digits = new int[digit.length()];
		int[] diff = new int[digit.length()-1];


		// 일의 자리수를 구하고, 숫자의 자리수를 한칸 내린다
		for (int i = 0; i < digit.length(); i++) {
			digits[i] = value % 10;
			value /= 10;
		}
		
		// 자리수들의 차를 구한다
		for (int i = 0; i < diff.length; i++) {
			diff[i] = digits[i] - digits[i+1];
		}
		
		// 차들이 다르면 false 끝까지 같으면 true
		for (int i = 0; i < diff.length-1; i++) {
			if(diff[i] != diff[i+1])
				return false;
		}
		return true;

	}

}

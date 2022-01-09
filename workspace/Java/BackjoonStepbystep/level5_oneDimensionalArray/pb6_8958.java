package level5_oneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb6_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력받기 위한 버퍼리더 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 갯수를 입력받는다
		int num = Integer.parseInt(br.readLine());

		// 테스트 케이스의 갯수만큼 점수를 계산한다
		int cont = 1; // O의 점수
		int sum = 0; // 총점
		for (int i = 0; i < num; i++) {
			// 버퍼리더로 문자열 테스트 케이스를 입력받는다
			String tcase = br.readLine();
			
			// O의 연속성에 따라 점수를 계산한다
			for(int j=0;j<tcase.length();j++) {
				if(tcase.charAt(j) == 'O') {
					sum += cont;
					cont++;
				}else {
					cont = 1;
				}
			}
			// 점수를 출력한다
			System.out.println(sum);
			sum = 0;
			cont = 1;	
		}
	}
}

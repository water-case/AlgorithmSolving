package level5_oneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb7_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 개수를 입력받는다
		int tcasenum = Integer.parseInt(br.readLine());

		StringTokenizer token;
		for (int i = 0; i < tcasenum; i++) {
			// 첫수로 학생의숫자, 이어서 학생들의 점수를 입력받는다
			String tcase = br.readLine();
			token = new StringTokenizer(tcase, " ");
			
			int stdnum = Integer.parseInt(token.nextToken());
			int sum = 0;
			while(token.hasMoreTokens()) {
				sum += Integer.parseInt(token.nextToken());
			}
			double avg = sum/(double)stdnum;
			// 각 케이스마다 평균을 넘는 학생들의 비율을 출력
			token = new StringTokenizer(tcase, " ");
			token.nextToken(); // 첫수 날리기
			double per;
			int goodstd = 0;
			while(token.hasMoreTokens()) {
				if(avg < Double.parseDouble(token.nextToken())) {
					goodstd++;
				}
			}
			per = goodstd/(double)stdnum;
			System.out.printf("%.3f%%\n", per*100);
		}

	}

}

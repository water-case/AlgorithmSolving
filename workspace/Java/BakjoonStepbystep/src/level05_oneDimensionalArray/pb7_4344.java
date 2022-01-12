package level05_oneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb7_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �׽�Ʈ ���̽��� ������ �Է¹޴´�
		int tcasenum = Integer.parseInt(br.readLine());

		StringTokenizer token;
		for (int i = 0; i < tcasenum; i++) {
			// ù���� �л��Ǽ���, �̾ �л����� ������ �Է¹޴´�
			String tcase = br.readLine();
			token = new StringTokenizer(tcase, " ");
			
			int stdnum = Integer.parseInt(token.nextToken());
			int sum = 0;
			while(token.hasMoreTokens()) {
				sum += Integer.parseInt(token.nextToken());
			}
			double avg = sum/(double)stdnum;
			// �� ���̽����� ����� �Ѵ� �л����� ������ ���
			token = new StringTokenizer(tcase, " ");
			token.nextToken(); // ù�� ������
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

package level05_oneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb6_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// �Է¹ޱ� ���� ���۸��� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �׽�Ʈ ���̽��� ������ �Է¹޴´�
		int num = Integer.parseInt(br.readLine());

		// �׽�Ʈ ���̽��� ������ŭ ������ ����Ѵ�
		int cont = 1; // O�� ����
		int sum = 0; // ����
		for (int i = 0; i < num; i++) {
			// ���۸����� ���ڿ� �׽�Ʈ ���̽��� �Է¹޴´�
			String tcase = br.readLine();
			
			// O�� ���Ӽ��� ���� ������ ����Ѵ�
			for(int j=0;j<tcase.length();j++) {
				if(tcase.charAt(j) == 'O') {
					sum += cont;
					cont++;
				}else {
					cont = 1;
				}
			}
			// ������ ����Ѵ�
			System.out.println(sum);
			sum = 0;
			cont = 1;	
		}
	}
}

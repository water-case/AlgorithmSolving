package level06_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb3_1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �Է� : ù° �ٿ� 1000���� �۰ų� ���� �ڿ��� N�� �־�����
		int n = Integer.parseInt(br.readLine());

		// �Ѽ� : � ���� ���� X�� �� �ڸ��� ���������� �̷�� ��
		int hanSu = 0;
		for (int i = 1; i <= n; i++) {
			if (Hansu(i) == true)
				hanSu++;
		}

		// ��� : 1���� ũ�ų� ����, N���� �۰ų� ���� '�Ѽ�'�� ������ ����Ѵ�
		System.out.println(hanSu);
	}

	public static boolean Hansu(int num) {
		// 100�̸��� ��� �Ѽ�
		if (num < 100)
			return true;
		
		int value = num;
		String digit = Integer.toString(num);
		int[] digits = new int[digit.length()];
		int[] diff = new int[digit.length()-1];


		// ���� �ڸ����� ���ϰ�, ������ �ڸ����� ��ĭ ������
		for (int i = 0; i < digit.length(); i++) {
			digits[i] = value % 10;
			value /= 10;
		}
		
		// �ڸ������� ���� ���Ѵ�
		for (int i = 0; i < diff.length; i++) {
			diff[i] = digits[i] - digits[i+1];
		}
		
		// ������ �ٸ��� false ������ ������ true
		for (int i = 0; i < diff.length-1; i++) {
			if(diff[i] != diff[i+1])
				return false;
		}
		return true;

	}

}

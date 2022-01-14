package level12_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb01_2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s[i] > s[j]) {
					int tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}

	}

}

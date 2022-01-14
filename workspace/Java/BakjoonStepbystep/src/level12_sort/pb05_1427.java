package level12_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pb05_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int[] a = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			a[i] = Integer.parseInt(input.substring(i, i + 1));
		}

		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (a[j] < a[i]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}

		for (int i = 0; i < input.length(); i++) {
			System.out.print(a[i]);
		}
	}

}

package level5_oneDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb5_1546 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int num = Integer.parseInt(n);

		int[] score = new int[num];
		String scores = br.readLine();

		StringTokenizer st = new StringTokenizer(scores);
		int biggest = 0;
		if (st.countTokens() == num) {
			for (int i = 0; i < num; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				if (score[i] > biggest)
					biggest = score[i];
			}
		}

		double sum = 0;
		for (int i = 0; i < num; i++) {
			sum += score[i] / (double)biggest * 100;
		}

		double avg = sum / (double) num;
		System.out.println(avg);
	}
}
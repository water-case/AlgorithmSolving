package level12_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pb03_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[10001];

		for (int i = 0; i < N; i++) {
			num[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i < 10001; i++) {
			int a = num[i];
			while (a > 0) {
				bw.write(String.valueOf(i));
				bw.newLine();
				a--;
			}
		}

		bw.flush();
		bw.close();
	}
}

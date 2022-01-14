package level12_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class pb09_10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[][] s = new String[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s[i][0] = st.nextToken(); 
			s[i][1] = st.nextToken();
		}

		Arrays.sort(s, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}

		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(s[i][0]).append(' ').append(s[i][1]).append('\n');
		}

		System.out.println(sb);

	}

}

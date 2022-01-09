package level7_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb4_2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());

		for (int k = 0; k < a; k++) {
			String n = br.readLine();

			if (n == null) {
				break;
			}

			// 공백으로 문자열 토큰화
			StringTokenizer token = new StringTokenizer(n, " ");
			int r = 0;
			String s = "";
			String p = "";
			if (token.countTokens() == 2) {
				r = Integer.parseInt(token.nextToken());
				if (token.hasMoreTokens()) {
					s = token.nextToken();
				} else {
					continue;
				}
			}

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < r; j++) {
					p = p.concat(Character.toString(s.charAt(i)));
				}
			}
			System.out.println(p);
		}

	}

}
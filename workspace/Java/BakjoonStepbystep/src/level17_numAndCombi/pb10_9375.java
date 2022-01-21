package level17_numAndCombi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb10_9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			// 의상들 입력받으면서 기존과 비교
			// 각 줄마다 의상의 이름, 의상의 종류가 주어지는데
			// 의상의 종류만 사용하고 종류가 같으면 그 인덱스의 값을 1증가 시킴
			// N크기의 String, int 타입의 1차원배열 두개를만들고 String값이 같으면 int 배열 인덱스의 값 1증가
			String[] sa = new String[N];
			int[] ia = new int[N];
			int count = 0;
			label: for (int j = 0; j < N; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine(), " ");
				token.nextToken(); // 의상이름은 필요없다
				if (count == 0) {
					sa[0] = token.nextToken();
					ia[0]++;
					count++;
					continue label;
				}
				String tmp = token.nextToken();
				for (int k = 0; k < count; k++) {
					if (sa[k].equals(tmp)) {
						ia[k]++;
						continue label;
					}
				}
				sa[count] = tmp;
				ia[count]++;
				count++;

			}
			int ans = 1;
			for (int j = 0; j < count; j++) {
				ans*=(ia[j]+1);
			}
			sb.append(ans-1 + "\n");
		}
		System.out.println(sb);
	}

}

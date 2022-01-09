package level7_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1316번 그룹 단어 체커
 * 
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
 * kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 단어의 개수 N이 들어온다. 
 * N은 100보다 작거나 같은 자연수이다. 
 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 
 * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 * 
 * 출력
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 * 
 * 예제 입력 1 : 	3
				happy
				new
				year
 * 예제 출력 1 : 3
 * 
 * 예제 입력 2 : 	4
				aba
				abab
				abcabc
				a
 * 예제 출력 2 : 1
 * 
 * 예제 입력 3 : 	5
				ab
				aa
				aca
				ba
				bb
 * 예제 출력 3 : 4
 * 
 * 예제 입력 4 : 	2
				yzyzy
				zyzyz
 * 예제 출력 4 : 0
 * 
 * 예제 입력 5 : 	1
				z
 * 예제 출력 5 : 1
 * 
 */

public class pb10_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n > 100)
			return;

		int groupNum = 0;
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			String remove = "";
			remove += word.charAt(0);

			for (int j = 1; j < word.length(); j++) {
				// 단어의 연속된 알파벳의 중복을 제거한다
				if (remove.charAt(remove.length() - 1) != word.charAt(j)) {
					remove += word.charAt(j);
				}
			}
			// 중복된 알파벳이 있는지 확인하고 없으면 그룹단어 1증가
			boolean dupl = false;
			for (int j = 0; j < remove.length(); j++) {
				char alpha1 = remove.charAt(j);
				for (int k = j + 2; k < remove.length(); k++) {
					if(alpha1 == remove.charAt(k)) {
						dupl = true;
						break;
					}
				}
				if(dupl) break;
			}
			if(!dupl) groupNum++;
		}
		System.out.println(groupNum);
	}

}

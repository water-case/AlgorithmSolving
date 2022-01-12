package level07_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2941번 크로아티아 알파벳
 * 
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
 * 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 * č	c=
 * ć	c-
 * dž	dz=
 * đ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
 * lj와 nj도 마찬가지이다.
 * 위 목록에 없는 알파벳은 한 글자씩 센다.
 * 
 * 입력
 * 첫째 줄에 최대 100글자의 단어가 주어진다.
 * 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 단어는 크로아티아 알파벳으로 이루어져 있다.
 * 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 * 
 * 출력
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 
 * 예제 입력 1 : ljes=njak
 * 예제 출력 1 : 6
 * 
 * 예제 입력 2 : ddz=z=
 * 예제 출력 2 : 3
 * 
 * 예제 입력 3 : nljj
 * 예제 출력 3 : 3
 * 
 * 예제 입력 4 : c=c=
 * 예제 출력 4 : 2
 * 
 * 예제 입력 5 : dz=ak
 * 예제 출력 5 : 3
 * 
 */

public class pb9_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int tSize = input.length();
		int output = 0;
		char text =' ', text2=' ', text3=' ';

		if (tSize <= 100) {
			for (int i = 0; i < tSize; i++) {
				text = input.charAt(i);
				if (i + 1 < tSize)
					text2 = input.charAt(i + 1);
				if (i + 2 < tSize)
					text3 = input.charAt(i + 2);
				
				if (text == 'c') {
					if (text2 == '=' || text2 == '-') {
						i++;
					}
				} else if (text == 'd') {
					if (text2 == 'z') {
						i++;
						if (text3 == '=') {
							i++;
						} else {
							i--;
						}
					} else if (text2 == '-') {
						i++;
					}
				} else if (text == 'l' && text2 == 'j') {
					i++;
				} else if (text == 'n' && text2 == 'j') {
					i++;
				} else if (text == 's' && text2 == '=') {
					i++;
				} else if (text == 'z' && text2 == '=') {
					i++;
				}

				if((int)text >= 97 && (int)text <=122) {
					output++;
				}
				text2 = ' ';
				text3 = ' ';
			}
		}
		System.out.println(output);
	}

}

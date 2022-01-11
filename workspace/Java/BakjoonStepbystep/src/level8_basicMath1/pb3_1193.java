package level8_basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1193번 분수찾기
 * 
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * 
 * 출력
 * 첫째 줄에 분수를 출력한다.
 * 
 * 예제1 in : 1 , out : 1/1
 * 예제2 in : 2 , out : 1/2
 * 예제3 in : 3 , out : 2/1
 * 예제4 in : 4 , out : 3/1
 * 예제5 in : 5 , out : 2/2
 * 예제6 in : 6 , out : 1/3
 * 예제7 in : 7 , out : 1/4
 * 예제8 in : 8 , out : 2/3
 * 예제9 in : 9 , out : 3/2
 * 예제10 in : 14 , out : 2/4
 * 
 */

public class pb3_1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		// a/b
		int top = 1; // 분자
		int bot = 1; // 분모

		// 분자,분모 더하고 빼는것을 결정하는 방향변수
		// true이면 분자증가, false이면 분모증가
		boolean direct = true;
		
		while(input > 0) {
			// input이 1이면 break
			if(input == 1) break;
			// topbot 모두 1이면 bot증가
			if(top == 1 && bot == 1) {
				bot++;
				input--;
				continue;
			}
			
			if(top == 1 && bot == 2) {
				top++;
				bot--;
				input--;
				direct = true;
				continue;
			}
			
			// 분자 1이고 방향false이면 bot증가시키고 방향전환
			if(top == 1 && direct == false) {
				bot++;
				direct = true;
				input--;
				continue;
			}
			// 분모 1이고 방향true이면 top증가시키고 방향전환
			if(bot == 1 && direct == true) {
				top++;
				direct = false;
				input--;
				continue;
			}
			
			if(direct) {
				top++;
				bot--;
			} else {
				top--;
				bot++;
			}
			
			input--;
		}
		
		System.out.println(top+"/"+bot);

	}

}

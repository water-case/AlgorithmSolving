package level8_basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2869번 달팽이는 올라가고 싶다
 * 
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 
 * 또, 정상에 올라간 후에는 미끄러지지 않는다. 
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * 
 * 입력 : 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 * 
 * 출력 : 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 * 
 * 예제1 in : 2 1 5 , out : 4
 * 예제2 in : 5 1 6 , out : 2
 * 예제3 in : 100 99 1000000000 , out : 999999901
 * 
 */

public class pb4_2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer token = new StringTokenizer(input, " ");
		
		int move = Integer.parseInt(token.nextToken()); // 하루 이동량
		int drop = Integer.parseInt(token.nextToken()); // 하루 감소량
		int end = Integer.parseInt(token.nextToken()); // 목표 이동량
		int day = 0; // 일자
		int moving = 0; // 움직인 거리
		
		// 목적거리에서 하루 이동량 뺘고 하루지나기
		end -= move;
		day++;
		
		// 하루증가량
		int diff = move - drop;
		
		day += Math.ceil((double)end/diff);
			
		System.out.println(day);
		
	}

}

package level26_twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class pb04_1644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>(); 

		// N 까지의 소수구하기
		boolean[] bar = new boolean[N + 1];
		bar[0] = true;
		bar[1] = true;
		
		for(int i=2; i<=N; i++) {
			if(bar[i] == false) {
				int tmp = 2;
				while (i * tmp <= N) {
					bar[i*tmp] = true;
					tmp+=1;
				}
			}
		}
		for(int i=2; i<=N; i++) {
			if(bar[i] == false) {
				list.add(i);
			}
		}
		
//		System.out.println(list.toString());
		// 구해진 소수로 투포인터 돌기
		int count = 0;
		int p1 = 0;
		int p2 = 0;
		int sum = 0;
		while(true) {
			if(sum >= N) {
				if(sum == N) count++;
				sum -= list.get(p1++);
				if(p1 == list.size()) {
					break;
				}
			}
			if(sum < N) {
				if(p2 == list.size()) {
					break;
				}
				sum += list.get(p2++);
			}
		}
		System.out.println(count);
	}

}

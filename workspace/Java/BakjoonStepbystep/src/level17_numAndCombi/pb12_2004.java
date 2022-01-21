package level17_numAndCombi;

import java.util.Scanner;

public class pb12_2004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 아이디어 소인수에 5의 개수만큼 뒷자리에 0이 있을 수 있음
		// 그리고 팩토리얼에선 2의 숫자는 항상 5보다 많음
		// 그러므로 5의개수가 바로 뒷자리 0의개수임
		// 근데 이항계수에가면 나머지가 있음
		// 다른 숫자는 생각하지 않고 5의 개수만 생각함
		// 나눗셈을 해도 5끼리만 계산됨 소수이기 때문
		// N의 5의개수 - (M의 5의개수 N-M의 5의개수) 각각 구해서 계산하면됨
		// 나누는게 들어가므로 소인수에 2가 없을수도있어서 ,, 2의개수또한 생각해줘야한다 안해줘서 1회틀림
		// CaseFuntion 함수만들어서 루프돌림
		// 2와 5의 개수들을 각각계산하고 2와 5의 개수중 작은것이 0의개수
		
		int O = N-M;
		int a = cf(N, 2) - (cf(M, 2) + cf(N-M, 2));
		int b = cf(N, 5) - (cf(M, 5) + cf(N-M, 5));
		
		System.out.println(Math.min(a, b));
	}
	
	static int cf(int n, int m) {
		int count = 0;
		while(n>=m) {
			count += n/m;
			n /= m;
		}
		return count;
	}

}

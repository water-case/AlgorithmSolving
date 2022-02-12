package level33_dp3;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class pb04_1086_backup {
	
	static int N, K, lengthSum;
	static long count, totalCount=1;
	static BigInteger[] nums;
	static int[] larr;
	static int[][] mnums;
	static Long[][] dp;

	public static void main(String[] args) throws Exception {
//		long start = System.nanoTime();
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new BigInteger[N];
		larr = new int[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			nums[i] = new BigInteger(s);
			larr[i] = s.length();
			lengthSum += s.length(); // 전체 길이구한다
		}
		K = Integer.parseInt(br.readLine());
//		long start2 = System.nanoTime();
//		System.out.println((start2 - start) / 1000000000 + " 초걸림");
		
		mnums = new int[N][lengthSum]; //모듈러연산을 각 자리일때 dp에 미리 다해놓는다 
		BigInteger ten = new BigInteger(String.valueOf(10)); // 10곱하기
		BigInteger mode = new BigInteger(String.valueOf(K)); // 모듈러할값
		for (int i = 0; i < N; i++) {
			BigInteger tmpn = new BigInteger("1");
			for (int j = 0; j < lengthSum; j++) {
				BigInteger result = (nums[i].multiply(tmpn)).mod(mode);
				mnums[i][j] = Integer.parseInt(result.toString());
				tmpn = tmpn.multiply(ten);
			}
		}
		for(int[] ia : mnums)
			System.out.println(Arrays.toString(ia));
//		long start3 = System.nanoTime();
//		System.out.println((start3 - start2) / 1000000000 + " 초걸림");
		
		dp = new Long[1<<N][K];
		count = cf(0, 0, 0, 0);
//		long start4 = System.nanoTime();
//		System.out.println((start4 - start3) / 1000000000 + " 초걸림");
		
//		for(int[] ia : dp)
//			System.out.println(Arrays.toString(ia));
		
		// 출력부 계산
		for (int i = 2; i <= N; i++) totalCount *= i; // nPn
//		System.out.println(count + " " + totalCount);
		long gcd = GCD(totalCount, count);
		if(gcd != 0) {
			count /= gcd;
			totalCount /= gcd;
		}		
		if(count == 0)
			System.out.println(count + "/" + 1);
		else
			System.out.println(count + "/" + totalCount);
	}
	
	static long cf(int n, int bit, int val, int length) {
//		if(n == N) { // 모두 선택되었을때 기저부분
//			// 문자열이 엄청 길어지면 int와 long으로 처리할 수 없어 BigInteger사용해야함
//			// dp에 미리 계산해놓은 모듈러로 연산
//			int nowl = 0;
//			int num = 0;
//			for(int i=0; i<N; i++) { // 전부 나눠지면 totalCount++
//				num += mnums[sarr[i]][nowl];
//				nowl += larr[sarr[i]]; // 누적길이
//			}
//			if(num % K == 0) count++;
//			
//			return;
//		}
		if(n == N && val == 0) return 1;
		
		if(dp[bit][val]!=null) return dp[bit][val];
		dp[bit][val] = 0l;
		for(int i=0; i<N; i++) { // 한개씩 선택하는 유도부분
			if( (bit & (1<<i)) == 0) { // 선택되지 않았을때
				dp[bit][val] += cf(n+1, bit | (1<<i), (val + mnums[i][length]) % K, length+larr[i]); // 비트변수에 i번째 비트를 1로 만들고 재귀호출
			}
		}
		return dp[bit][val];
	}
	
	static long GCD(long a, long b) { // 기약분수로 만들기 위해 최대공약수 구하기
		while(b != 0) {
			long tmp = b;
			b = a % b;
			a = tmp;
		}
		if(b==0) return a;
		return b;
	}

}


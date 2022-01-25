package level20_divideAndConquer;

import java.util.Scanner;

public class pb05_11401 {

	static long P = 1_000_000_007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
		
		long num = fac(N);
		
		long num2 = fac(K) * fac(N-K) % P;
		
		System.out.println(num*cf(num2, P-2) % P);
		
		sc.close();
	}
	
	static long fac(long n) {
		long fac = 1L;
		while(n>1) {
			fac = (fac * n) % P;
			n--;
		}
		return fac;
	}
	
	static long cf(long n, long k) {
		if(k==1) return n % P;
		long tmp = cf(n, k/2);
		if(k % 2 == 0) return tmp * tmp % P;
		return (tmp * tmp % P) * n % P;
	}

}

package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb04_P5_10266 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 바늘의 수
		int[] ar1 = new int[720_000]; // 두개를 이어붙여서 탐색할 문자열처럼 생각해야한다
		int[] ar2 = new int[360_000]; // 탐색문자열로 생각하고 pi구한다
		StringTokenizer token1 = new StringTokenizer(br.readLine());
		StringTokenizer token2 = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(token1.nextToken()); 
			ar1[tmp] = 1;
			ar1[tmp + 360_000] = 1;
			ar2[Integer.parseInt(token2.nextToken())] = 1;
		}
		
		int[] pi = new int[360_000];
		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			while (ar2[i] != ar2[j] && j > 0)
				j = pi[j - 1];
			if (ar2[i] == ar2[j])
				pi[i] = ++j;
		}
		
		j = 0;
		label:for (int i = 0; i < ar1.length; i++) {
			while(ar1[i] != ar2[j] && j > 0)
				j = pi[j-1];
			if(ar1[i] == ar2[j]) {
				j++;
				if(j == 360_000) {
					break label;
				}
			}
		}
		if(j == 360_000)
			System.out.println("possible");
		else
			System.out.println("impossible");
		
//		System.out.println(Arrays.toString(ar1));
//		System.out.println(Arrays.toString(ar2));
		
	}

}

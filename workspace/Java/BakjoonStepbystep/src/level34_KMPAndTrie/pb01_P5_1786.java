package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb01_P5_1786 {

	static ArrayList<Integer> idxs = new ArrayList<>();
	static int[] pi;
	static char[] T, P;
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();

		/*
		 * 찾을 문자열 배열 미리 계산
		 * 방법 : 문자열 길이만큼 돌면서 일치하면 j++, 일치하지않으면 j를 j-1일때 계산한 위치로 변경
		 * 예시)
		 * ABCABC
		 * 000123
		 */
		pi = new int[P.length];
		int j = 0;
		for (int i = 1; i < P.length; i++) {
			while(j > 0 && P[i] != P[j])
				j = pi[j-1];
			if(P[i] == P[j])
				pi[i] = ++j;
		}
//		System.out.println(Arrays.toString(pi));
		
		/*
		 * 위치 찾을 문자열 배열 계산
		 */
		j = 0;
		for (int i = 0; i < T.length; i++) {
			while(j > 0 && T[i] != P[j]) {
//				System.out.println(j);
				j = pi[j-1];
			}
			if(T[i] == P[j]) {
				if(j == P.length - 1) {
					count++;
					idxs.add(i + 1 - P.length + 1);
//					System.out.println(i + " " + j);
					j = pi[j];
				} else j++;
			}
		}
		System.out.println(count);
		for(int a : idxs)
			System.out.print(a + " ");
		
	}

}

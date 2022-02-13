package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb02_P5_4354 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			
			char[] T = s.toCharArray();
			
			/*
			 * 접두사 접미사가 같은 최대 길이를 구한다 (자주 사용하므로 암기하자)
			 */
			int[] pi = new int[T.length];
			int j = 0;
			for (int i = 1; i < T.length; i++) {
				while(j > 0 && T[i] != T[j])
					j = pi[j-1];
				if(T[i] == T[j])
					pi[i] = ++j;
			}
			
			/*
			 * ababab의 경우 001234가 나온다
			 * 전체 길이 - 마지막인덱스값 = 가장 짧은 반복길이가 나온다
			 * 전체길이 / 가장짧은 반복길이 = 가장큰 제곱수
			 * 반복길이가 홀수이거나 전체길이로 나눴을때 나머지가 남으면 제곱수가 될 수없음
			 */
			int max = T.length % (T.length - pi[T.length-1]) == 0 ? T.length / (T.length - pi[T.length-1]) : 1;  
			System.out.println(max);
			
			System.out.println(Arrays.toString(pi));
		}
		System.out.println(sb);
	}
}

package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb03_P4_1305 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 광고판의 길이
		char[] str = br.readLine().toCharArray(); // 광고판의 문자열
		
		/*
		 *  문자열의 접두접미 최대길이 구하기
		 *  자주쓰이므로 암기필요하다
		 */
		int[] pi = new int[str.length];
		int j = 0;
		for(int i=1; i<pi.length; i++) {
			while(str[i] != str[j] && j > 0)
				j = pi[j-1];
			if(str[i] == str[j])
				pi[i] = ++j;
		}
		
//		System.out.println(Arrays.toString(pi));
		// 전체길이 - 마지막인덱스값 = 제일 짧은 길이
		System.out.println(str.length - pi[str.length-1]);
		
	}

}

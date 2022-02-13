package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb06_S3_14425 {

	/*
	 * 일반적으로 풀면 널널하게 풀 수 있지만 트라이로 풀게되면 간발의차로 시간초과가 된다
	 * LinkedList나 HashMap을 이용해서 구현해봤지만 시간초과가 되어
	 * 트리맵을 통해 빠르게 동작하는 코드를 참고하였다
	 */
	
	static class Trie {
		TreeMap<Character, Trie> child = new TreeMap<>();
		boolean end;
		
		public Trie() { }
		
		public void add(String s) {
			Trie now = this;
			for(int i=0; i<s.length(); i++) {
				now = now.child.computeIfAbsent(s.charAt(i), key -> new Trie());
			}
			now.end = true;
		}
		public boolean search(String s) {
			Trie now = this;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(now.child.get(c) == null) return false;
				now = now.child.get(c);
			}
			return now.end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		Trie trie = new Trie();
		for(int i=0; i<N; i++)
			trie.add(br.readLine());
		int count = 0;
		for(int i=0; i<M; i++)
			if(trie.search(br.readLine()))
				count++;
		
		System.out.println(count);
	}

}

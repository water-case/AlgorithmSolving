package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb07_P4_5670 {
	
	static class Trie {
		TreeMap<Character, Trie> child = new TreeMap<>();
		boolean end;
		
		public void add(String s) {
			Trie now = this;
			for(int i=0; i<s.length(); i++)
				now = now.child.computeIfAbsent(s.charAt(i), key -> new Trie());
			now.end = true;
		}
		
		public int search(String s) {
			int count = 1;
			Trie now = this;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				now = now.child.get(c);
				// 단어가 안끝난상태에서, 다른 단어의 끝이거나 선택지가 2개이상이면 횟수증가 
				if(i < s.length() -1 && (now.end || now.child.size() > 1 )) count++;
//				int size = now.child.size();
//				if((size != 1 && i != 0) || (i!= 0 && size == 1 && i < s.length()-1 && (now.end || now.child.get(c).end))) {
////					System.out.print(c);
//					count++;
//				}
//				now = now.child.get(c);
			}
			return count;
		}
		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s;
		while ((s = br.readLine()) != null) {
			int N = Integer.parseInt(s);
			String[] sar = new String[N];
			Trie trie = new Trie();
			for (int i = 0; i < N; i++) {
				sar[i] = br.readLine();
				trie.add(sar[i]);
			}
			
			int sum = 0;
			for(int i=0; i<N; i++)
				sum += trie.search(sar[i]);
			
			sb.append(String.format("%.2f", 1.0 * sum / N)).append("\n");
		}
		
		System.out.println(sb);
	}
}

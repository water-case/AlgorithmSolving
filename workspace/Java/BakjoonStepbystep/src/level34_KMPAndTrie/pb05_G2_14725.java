package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb05_G2_14725 {

	/*
	 * 문자열의 효율적 검색을 위한 트라이 자료구조
	 * 추가할 문자열의 개수가 n이고 길이가 최대 m일때
	 * 생성시 시간복잡도 O(n*m)
	 * 삽입시 시간복잡도 O(m)
	 * 탐색시 시간복잡도 O(m)
	 * 최초생성은 오래걸리지만 삽입과 탐색이 매우빨라 검색어 자동완성과 같은 곳에 사용된다
	 */
	static class Trie implements Comparable<Trie>{
		String s;
		LinkedList<Trie> list = new LinkedList<>();
		
		public Trie() { }
		public Trie(String s) {
			this.s = s;
		}

		void add(String[] s, int idx, int size, boolean r) {
			if(idx == size) return;
			
			for(Trie t : list) {
				if(s[idx].equals(t.s)) {
					t.add(s, idx+1, size, r);
					return;
				}
			}
			list.addFirst(new Trie(s[idx]));
			list.get(0).add(s, idx + 1, size, r);
		}
		
		void search(int level) {
			if(level > 0) {
				for(int i=1 ;i<level; i++)
					System.out.print("--");
				System.out.println(s);
			}
			/*
			 * 사전순으로 출력해야하므로 정렬을하는데 사용자 정의 클래스이기때문에
			 * comparable 인터페이스를 상속하고 compareTo를 구현하여 문자열을 기준으로 정렬함
			 */
			Collections.sort(list);
			for(Trie t : list) {
				t.search(level+1);
			}
		}
		
		@Override
		public int compareTo(Trie o) {
			return s.compareTo(o.s);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 먹이 정보의 개수
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			trie.add(s, 1, s.length, true);
		}
		
		trie.search(0);
	}

}

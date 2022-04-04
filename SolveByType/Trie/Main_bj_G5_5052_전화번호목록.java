import java.io.*;
import java.util.*;

public class Main_bj_G5_5052_전화번호목록 {

	static class TrieNode {
		private Map<Character, TrieNode> child=new HashMap<>();
		private boolean last;
		
		Map<Character, TrieNode> getchild() {
			return this.child;
		}
		boolean isLast() {
			return this.last;
		}
		void setIsLast(boolean isLast) {
			this.last=isLast;
		}
	}
	static class Trie {
		private TrieNode root;
		
		Trie() {
			root=new TrieNode();
		}
		void insert(char[] word) {
			TrieNode Node=this.root;
			for(int i=0; i<word.length; i++)
				Node=Node.getchild().computeIfAbsent(word[i], c->new TrieNode());
			Node.setIsLast(true);
		}
		boolean contain(char[] word) {
			TrieNode Node=this.root;
			for(int i=0; i<word.length; i++) {
				TrieNode next=Node.getchild().get(word[i]);
				if(next==null) return false;
				if(next.isLast()) return true;
				Node=next;
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5052"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			boolean check=false;
			int N=Integer.parseInt(br.readLine());
			Trie trie=new Trie();
			for(int i=0; i<N; i++) {
				if(check) {
					br.readLine();
					continue;
				}
				char[] tele=br.readLine().toCharArray();
				
				if(!trie.contain(tele)) trie.insert(tele);
				else check=true;
			}
			if(check) System.out.println("NO");
			else System.out.println("YES");
		}
		br.close();
	}
	
}

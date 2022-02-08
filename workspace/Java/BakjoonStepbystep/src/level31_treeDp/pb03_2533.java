package level31_treeDp;

import java.io.*;
import java.util.*;

public class pb03_2533 {

	static int N, ans;
	static ArrayList<ArrayList<Integer>> elist = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 트리 정점 수
		for (int i = 0; i <= N; i++) {
			elist.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) { // 트리 간선 입력
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			elist.get(a).add(b);
			elist.get(b).add(a);
		}
		
		treeBuilder(1, -1);
		
		cf(1);
		
		System.out.println(ans);
		
//		for(ArrayList<Integer> a : tree)
//			System.out.println(a);

	}
	
	static boolean cf(int node) {
		if(tree.get(node).size() == 0) {
			return true;
		}
		
		int count = 0;
		for(int son : tree.get(node)) {
			if(cf(son)) {
//				System.out.println(node + " " + son);
				count++;
			}
		}
		
		if(count != 0) {
			ans++;
			return false;
		} else {
			return true;
		}
		
	}
	
	static void treeBuilder(int now, int parent) {
		for(int son : elist.get(now)) {
			if(son != parent) {
				tree.get(now).add(son);
				treeBuilder(son, now);
			}
		}
	}

}

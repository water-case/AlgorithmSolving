package level28_tree;

import java.io.*;
import java.util.*;

public class pb06_5639 {

	static class Tree {
		int num;
		Tree left, right;

		public Tree(int num) {
			this.num = num;
		}

		void insert(int n) {
			if (n < num) {
				if (left == null)
					left = new Tree(n);
				else
					left.insert(n);
			} else {
				if (right == null)
					right = new Tree(n);
				else
					right.insert(n);
			}
		}

	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Tree tree = new Tree(Integer.parseInt(br.readLine()));
		String input;
		while (true) { // 이진트리 삽입
			input = br.readLine();
			if(input == null || input.equals("")) break;
			tree.insert(Integer.parseInt(input));
		}
		cf(tree);
		br.close();
	}

	static void cf(Tree tree) {
		if (tree.left != null)
			cf(tree.left);
		if (tree.right != null)
			cf(tree.right);
		System.out.println(tree.num);
	}

}

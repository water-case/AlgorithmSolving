package level28_tree;

import java.io.*;
import java.util.*;

public class pb05_2263 {

	static int n, preidx;
	static int[] inOrder, preOrder, postOrder;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;

		n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		preOrder = new int[n];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			inOrder[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			postOrder[i] = Integer.parseInt(token.nextToken());

		cf(0, n - 1, 0, n - 1);

		for (int n : preOrder)
			sb.append(n + " ");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void cf(int ins, int ine, int posts, int poste) {
		if (ins <= ine && posts <= poste) {
			preOrder[preidx++] = postOrder[poste];
			int pos = ins;
			for (int i = ins; i <= ine; i++) {
				if (inOrder[i] == postOrder[poste]) {
					pos = i;
					break;
				}
			}
			cf(ins, pos - 1, posts, posts + pos - ins - 1);
			cf(pos + 1, ine, posts + pos - ins, poste - 1);
		}
	}

}

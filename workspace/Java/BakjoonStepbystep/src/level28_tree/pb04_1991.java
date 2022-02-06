package level28_tree;

import java.io.*;
import java.util.*;

public class pb04_1991 {

	static String[] arr;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		N = Integer.parseInt(br.readLine());
		arr = new String[(int) Math.pow(2, N)];
		arr[1] = "A";
		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			String a1 = token.nextToken();
			String a2 = token.nextToken();
			String a3 = token.nextToken();
			
			if(a2.equals(".") && a3.equals(".")) continue;
			
			int idx = 0;
			for(int j=1; j<arr.length; j++) {
				if(a1.equals(arr[j])) {
					idx = j;
					break;
				}
			}
			
			arr[2 * idx] = a2;
			arr[2 * idx + 1] = a3;
		}
		preOrder(1,2,3);
		System.out.println();
		inOrder(1,2,3);
		System.out.println();
		postOrder(1,2,3);
//		System.out.println(Arrays.toString(arr));
	}
	// 전위순회 preOrder 파라미터로 인덱스번호
	static void preOrder(int a, int b, int c) {
		if(a < arr.length && arr[a] != null && !arr[a].equals(".")) System.out.print(arr[a]);
		if(b < arr.length) preOrder(b, 2 * b, 2 * b + 1);
		if(c < arr.length) preOrder(c, 2 * c, 2 * c + 1);
	}
	// 중위순회 inOrder
	static void inOrder(int a, int b, int c) {
		if(b < arr.length) inOrder(b, 2 * b, 2 * b + 1);
		if(a < arr.length && arr[a] != null && !arr[a].equals(".")) System.out.print(arr[a]);
		if(c < arr.length) inOrder(c, 2 * c, 2 * c + 1);
//		if(a < arr.length) preOrder(a, 2 * a, 2 * a + 1);
//		if(b < arr.length && arr[b] != null && !arr[b].equals(".")) System.out.print(arr[b]);
//		if(c < arr.length) preOrder(c, 2 * c, 2 * c + 1);
	}
	// 후위순회 postOrder
	static void postOrder(int a, int b, int c) {
		if(b < arr.length) postOrder(b, 2 * b, 2 * b + 1);
		if(c < arr.length) postOrder(c, 2 * c, 2 * c + 1);
		if(a < arr.length && arr[a] != null && !arr[a].equals(".")) System.out.print(arr[a]);
//		if(a < arr.length) preOrder(a, 2 * a, 2 * a + 1);
//		if(b < arr.length) preOrder(b, 2 * b, 2 * b + 1);
//		if(c < arr.length && arr[c] != null && !arr[c].equals(".")) System.out.print(arr[c]);
	}
}

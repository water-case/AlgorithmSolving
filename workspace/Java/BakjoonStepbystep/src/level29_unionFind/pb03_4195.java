package level29_unionFind;

import java.io.*;
import java.util.*;

public class pb03_4195 {

	static int[] parent;
	static int[] value;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[2 * F]; // 유니온배열
			value = new int[2 * F]; // 네트워크 수치배열
			for (int i = 0; i < 2 * F; i++) {
				parent[i] = i;
				value[i] = 1;
			}

			int idx = 0;
			Map<String, Integer> map = new HashMap<>();

			for (int f = 0; f < F; f++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				String s1 = token.nextToken();
				String s2 = token.nextToken();
				
				if(!map.containsKey(s1))
					map.put(s1, idx++);
				if(!map.containsKey(s2))
					map.put(s2, idx++);
				
				sb.append(union(map.get(s1), map.get(s2)) + "\n");
			}
//			System.out.println(Arrays.toString(value));
//
//			System.out.println();
//			System.out.println(names.toString());
		}
		System.out.println(sb);
		br.close();
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
			value[a] += value[b];
			value[b] = 1;
		}

		return value[a];
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

}

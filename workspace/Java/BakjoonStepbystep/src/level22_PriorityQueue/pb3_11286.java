package level22_PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class pb3_11286 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>((o1, o2)->{
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if (a == b)
					return o1 > o2 ? 1 : -1;
				return a - b;
		});
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.add(a);
			}
		}
		System.out.println(sb);
	}

}

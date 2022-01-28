package level22_PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class pb1_11279 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine()); 
			if(a == 0) {
				if(pq.size() == 0) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll()+"\n");
				}
			} else {
				pq.add(a);
			}
		}
		System.out.println(sb);
	}

}

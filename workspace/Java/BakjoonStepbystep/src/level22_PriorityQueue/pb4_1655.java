package level22_PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class pb4_1655 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> maxQ = new PriorityQueue<Integer>((o1, o2)->{return o2 - o1;});
		Queue<Integer> minQ = new PriorityQueue<Integer>((o1, o2)->{return o1 - o2;});
		
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(maxQ.size() == minQ.size()) {
				maxQ.add(a);
			} else {
				minQ.add(a);
			}
			
			if(!maxQ.isEmpty() && !minQ.isEmpty()) {
				if(minQ.peek() < maxQ.peek()) {
					int tmp = minQ.poll();
					minQ.add(maxQ.poll());
					maxQ.add(tmp);
				}
			}
			
			sb.append(maxQ.peek()+"\n");
		}
		System.out.println(sb);
	}

}

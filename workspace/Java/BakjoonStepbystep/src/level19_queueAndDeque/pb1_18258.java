package level19_queueAndDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pb1_18258 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue2 q = new Queue2();
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String s = token.nextToken();
				 if(s.equals("push"))	q.push(Integer.parseInt(token.nextToken()));
			else if(s.equals("pop"))	sb.append(q.pop() + "\n");
			else if(s.equals("size"))	sb.append(q.size() + "\n");
			else if(s.equals("empty"))	sb.append(q.empty() + "\n");
			else if(s.equals("front"))	sb.append(q.front() + "\n");
			else if(s.equals("back"))	sb.append(q.back() + "\n");
		}
		
		System.out.println(sb);

	}

}

class Queue2 {
	int size = 0;
	int front = 0;
	int[] arr = new int[2_000_000];

	public void push(int n) {
		arr[size++] = n;
	}

	public int pop() {
		if (size-front > 0) {
			return arr[front++];
		} else {
			return -1;
		}
	}

	public int size() {
		return size-front;
	}

	public int empty() {
		if (size == front) {
			return 1;
		} else {
			return 0;
		}
	}

	public int front() {
		if (size-front > 0) {
			return arr[front];
		} else {
			return -1;
		}
	}

	public int back() {
		if (size-front > 0) {
			return arr[size-1];
		} else {
			return -1;
		}
	}

}
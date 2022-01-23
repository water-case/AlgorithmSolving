package level19_queueAndDeque;

import java.util.Scanner;

public class pb3_11866 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("<");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue4 q = new Queue4(N);
		for(int i=0; i<N; i++) {
			for(int j=1; j<K; j++) {
				q.push(q.pop());
			}
			sb.append(q.pop());
			if(i != N-1) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}

class Queue4 {
	int front = 0;
	int tail = 0;
	int arr[];

	public Queue4(int n) {
		arr = new int[n * n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		tail = n;
	}
	public void push(int n) {
		if(tail < arr.length) arr[tail++] = n;
	}
	public int pop() {
		if(front < tail) return arr[front++];
		else return -1;
	}
}
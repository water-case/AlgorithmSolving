package level19_queueAndDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb5_10866 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque2 dq = new Deque2(N);
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String a = token.nextToken();
			
				 if(a.equals("push_front"))	dq.push_front(Integer.parseInt(token.nextToken()));
			else if(a.equals("push_back"))	dq.push_back(Integer.parseInt(token.nextToken()));
			else if(a.equals("pop_front"))	sb.append(dq.pop_front() + "\n");
			else if(a.equals("pop_back"))	sb.append(dq.pop_back()+ "\n");
			else if(a.equals("size"))		sb.append(dq.size()+"\n");
			else if(a.equals("empty"))		sb.append(dq.empty() + "\n");
			else if(a.equals("front"))		sb.append(dq.front() + "\n");
			else if(a.equals("back"))		sb.append(dq.back() + "\n");
		}
		System.out.println(sb);
	}
}

class Deque2 {
	int front = 0;
	int tail = 0;
	int[] arr;

	public Deque2(int n) {
		arr = new int[n * 2 + 1];
		front = n;
		tail = n + 1;
	}

	public void push_front(int n) {
		arr[front--] = n;
	}
	public void push_back(int n) {
		arr[tail++] = n;
	}
	public int pop_front() {
		if (front == tail-1) return -1;
		else return arr[++front];
	}
	public int pop_back() {
		if (front == tail-1) return -1;
		else return arr[--tail];
	}
	public int size() {
		return tail - front - 1;
	}
	public int empty() {
		if(front == tail-1) return 1;
		else return 0;
	}
	public int front() {
		if(front == tail-1) return -1;
		else return arr[front+1];
	}
	public int back() {
		if(front == tail-1) return -1;
		else return arr[tail-1];
	}

}
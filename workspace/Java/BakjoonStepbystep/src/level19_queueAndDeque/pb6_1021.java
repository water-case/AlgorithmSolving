package level19_queueAndDeque;

import java.util.Scanner;

public class pb6_1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑아내려고 하는 수의 개수
		Deque3 dq = new Deque3(N);
		int[] arr = new int[M];
		int ans = 0;
		
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int idx = dq.position(arr[i]);
			int l = idx - dq.front;
			int r = dq.tail - idx;
//			System.out.println(dq.front + " " + idx + " " + dq.tail);
			if(dq.front() == arr[i]) {
				int c = dq.pop_front();
				continue;
			}
//			System.out.println(l + " " + r);
			if (l < r) {
				for (int j = 0; j < l; j++) {
					dq.push_back(dq.pop_front());
					ans++;
				}
				dq.pop_front();
			} else {
				for (int j = 1; j < r; j++) {
					dq.push_front(dq.pop_back());
					ans++;
				}
				dq.pop_back();
				ans++;
			}
		}
//		System.out.println();
//		System.out.println(Arrays.toString(dq.arr));
		System.out.println(ans);
		sc.close();
	}

}

class Deque3 {
	int front, tail;
	int[] arr;

	public Deque3(int n) {
		arr = new int[n * n];
		for (int i = n * n / 2; i < n * n / 2 + n; i++)
			arr[i] = i + 1 - n*n/2;
		front = n * n / 2;
		tail = n * n / 2 + n;
	}

	public void push_front(int n) {
		arr[--front] = n;
	}
	public void push_back(int n) {
		arr[tail++] = n;
	}
	public int pop_front() {
		if (front == tail - 1) return -1;
		return arr[front++];
	}
	public int pop_back() {
		if (front == tail - 1) return -1;
		return arr[--tail];
	}
	public int size() {
		return tail - front - 1;
	}
	public int empty() {
		if (front == tail - 1) return 1;
		else return 0;
	}
	public int front() {
		if (front == tail - 1) return -1;
		else return arr[front];
	}
	public int back() {
		if (front == tail - 1) return -1;
		else return arr[tail - 1];
	}
	public int position(int n) {
		for (int i = front; i < tail; i++) {
			if (n == arr[i])
				return i;
		}
		return -1;
	}

}
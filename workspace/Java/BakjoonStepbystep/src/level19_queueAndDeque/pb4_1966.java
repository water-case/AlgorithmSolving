package level19_queueAndDeque;

import java.util.Scanner;

public class pb4_1966 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 문서 번호 0 번부터
			int[] arr = new int[N];
			for (int j = 0; j < N; j++)
				arr[j] = sc.nextInt();
			Queue5 q = new Queue5(N, arr);
			int count = 0;
			for (int j = 0; j < N; j++) {
				count++;
				if (q.pop() == M) {
					sb.append(count + "\n");
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
}

class Queue5 {
	int front = 0;
	int tail = 0;
	int count = 0;
	int[][] arr;

	public Queue5(int n, int[] parr) {
		arr = new int[n * n + 1][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = i;
			arr[i][1] = parr[i];
		}
		tail = n;
	}

	public void push(int n, int v) {
		arr[tail][0] = n;
		arr[tail][1] = v;
		tail++;
	}

	public int pop() { // 중요도 가장 높은 문서 빼기
		int max = front;
		for (int i = front + 1; i < tail; i++)
			if (arr[i][1] > arr[max][1])
				max = i;
		for (int i = front; i < max; i++) {
			push(arr[i][0], arr[i][1]);
		}
		front = max + 1;
		return arr[max][0];
	}
}
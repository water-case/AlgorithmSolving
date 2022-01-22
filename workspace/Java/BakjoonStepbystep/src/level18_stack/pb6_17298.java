package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb6_17298 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}

		MyStack2 a = new MyStack2(N);

		for (int i = 0; i < N; i++) {
			while(!a.empty() && arr[a.pick()] < arr[i]) {
				arr[a.pop()] = arr[i];
			}
			
			a.push(i);
		}
		while(!a.empty()) {
			arr[a.pop()] = -1;
		}
		for(int i=0; i<N; i++) {
			sb.append(arr[i] + " ");
		}

		System.out.println(sb);
	}

}

class MyStack2 {
	int top = -1;
	int[] arr;

	public MyStack2(int n) {
		arr = new int[n];
	}

	public void push(int n) {
		arr[top + 1] = n;
		top++;
	}

	public int pop() {
		if (top > -1)
			return arr[top--];
		else
			return -1;
	}
	
	public boolean empty() {
		if(top == -1) return true;
		else return false;
	}

	public int pick() {
		return arr[top];
	}

}
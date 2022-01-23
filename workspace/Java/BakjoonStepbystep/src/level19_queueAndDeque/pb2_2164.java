package level19_queueAndDeque;

import java.util.Arrays;
import java.util.Scanner;

public class pb2_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue3 q = new Queue3(N);
//		q.print();
		while(q.tail() != -1) {
			q.pop();
			q.push(q.pop());
		}
		System.out.println(q.end());
//		q.print();

	}

}

class Queue3 {
	int front = 0;
	int tail = 0;
	int[] arr;

	public Queue3(int n) {
		arr = new int[2 * n+1];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		tail = n;
	}
	
	public void push(int n) {
		if(tail == arr.length) {
			tail = 0;
			arr[tail] = n;
		} else {
			arr[tail++] = n;
			if(tail >= arr.length) tail = 0;
		}
	}
	public int pop() {
		if(front != tail) {
			int a = arr[front++];
			if(front >= arr.length) front = 0;
			return a;
		} else if(front == arr.length){
			front = 0;
			return arr[front];
		} else {
			return -1;
		}
	}
	public int tail() {
		return arr[front];
	}
	public int end() {
		return arr[front-1];
	}
	public void print() {
		System.out.println(Arrays.toString(arr));
	}

}
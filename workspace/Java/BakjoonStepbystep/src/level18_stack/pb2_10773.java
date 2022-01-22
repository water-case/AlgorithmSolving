package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pb2_10773 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack.arr = new int[N];
		
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				Stack.pop();
			} else {
				Stack.push(a);
			}
		}
		System.out.println(Stack.sum());
	}

	static class Stack {
		private static int top = -1;
		private static int size = 0;
		public static int[] arr;
		
		public static void push(int n) {
			top++;
			arr[size++] = n;
		}
		public static void pop() {
			if(top>-1) {
				top--;
				size--;
			}
		}
		public static int sum() {
			int sum = 0;
			for(int i=0; i<size; i++) {
				sum+=arr[i];
			}
			return sum;
		}
	
	}

}

package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb1_10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine()," " );
			String s = token.nextToken();
			if(s.equals("push")) {
				int n = Integer.parseInt(token.nextToken());
				stack.push(n);
			} else if(s.equals("top")){
				System.out.println(stack.top());
			} else if(s.equals("size")){
				System.out.println(stack.size());
			} else if(s.equals("empty")){
				System.out.println(stack.empty());
			} else if(s.equals("pop")){
				System.out.println(stack.pop());
			}
		}

	}

	public static class stack {
		private static int top = -1;
		private static int size = 0;
		private static int[] arr = new int[10000];

		public static void push(int n) {
			top++;
			arr[size++] = n;
		}
		public static int top() {
			if(top == -1) return -1;
			return arr[top];
		}
		public static int size() {
			return size;
		}
		public static int empty() {
			return size == 0 ? 1 : 0;
		}
		public static int pop() {
			if(size > 0) {
				size--;
				return arr[top--];
			} else {
				return -1;
			}
		}
	}

}

package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pb3_9012 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			boolean check = false;
			for (int j = 0; j < s.length(); j++) {
				if (s.substring(j, j + 1).equals("(")) {
					Stack.push();
				} else {
					check = Stack.pop();
				}
				if(check) {
					break;
				}
			}
			if(check) {
				sb.append("NO\n");
				Stack.reset();
				continue;
			}
			if (Stack.result()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			Stack.reset();
		}
		System.out.println(sb);

	}

	public static class Stack {
		private static int top = -1;

		private static void push() {
			top++;
		}

		private static boolean pop() {
			if(top==-1) {
				return true;
			} else {
				top--;
				return false;
			}
		}

		private static boolean result() {
			if (top == -1)
				return true;
			else
				return false;
		}

		private static void reset() {
			top = -1;
		}

	}

}

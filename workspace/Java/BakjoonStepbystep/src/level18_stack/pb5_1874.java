package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pb5_1874 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		MyStack stack = new MyStack(n);
		
		int lnum = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(lnum == 0) { // 처음 숫자만큼 push
				for(int j=1;j<=num;j++) {
					stack.push(j);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
				lnum = num;
				continue;
			}
			
			// num이 lnum보다 작으면 pop한수랑 비교하고 다르면 실패이므로 NO출력;
			if(num <= lnum) {
				int p = stack.pop();
				if(num != p) {
					sb = new StringBuilder("NO");
					break;
				} else {
					sb.append("-\n");
					continue;
				}
			} else if(num > lnum) { // num이 lnum보다 크면 차이만큼 증가
				for(int j=lnum+1 ; j<=num; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
				lnum = num;
				continue;
			}
			
		}
		System.out.println(sb);
	}

}

class MyStack {
	public int top = -1;
	public int[] arr;
	
	public MyStack(int n) {
		arr = new int[n];
	}
	
	public void push(int n) {
		arr[top+1] = n;
		top++;
	}
	public int pop() {
		if(top > -1) {
			return arr[top--];
		}
		return -1;
	}
}
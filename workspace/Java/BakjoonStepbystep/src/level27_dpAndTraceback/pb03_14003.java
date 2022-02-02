package level27_dpAndTraceback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class pb03_14003 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int[] iarr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(token.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.MIN_VALUE);

		for (int i = 1; i <= N; i++) {
			int num = arr[i];
			int left = 1;
			int right = list.size() - 1;

			if (num > list.get(list.size() - 1)) {
				list.add(num);
				iarr[i] = list.size() - 1;
			} else {
				while (left < right) {
					int mid = (left + right) >> 1;
					if (list.get(mid) >= num)
						right = mid;
					else
						left = mid + 1;
				}
				list.set(right, num);
				iarr[i] = right;
			}
		}

		sb.append(list.size() - 1 + "\n");

		Stack<Integer> stack = new Stack<>();
		int idx = list.size() - 1;
		for (int i = N; i > 0; i--) {
			if(iarr[i] == idx) {
				idx--;
				stack.push(arr[i]);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);
	}

}

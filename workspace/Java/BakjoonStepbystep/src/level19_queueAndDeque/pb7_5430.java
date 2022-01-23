package level19_queueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb7_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
		label: for(int tc=0; tc<T; tc++) {
			String s = br.readLine();					// 함수 문자열
			char[] p = s.toCharArray();					// 함수를 문자배열로 변경
			int n = Integer.parseInt(br.readLine());	// 배열에 들어있는 수
			int[] arr = new int[n];						// 수를 넣을 배열
			s = br.readLine();
			StringTokenizer token = new StringTokenizer(s.substring(1, s.length()-1), ",");
			int c = 0;
			while(token.hasMoreTokens())
				arr[c++] = Integer.parseInt(token.nextToken());
			
			Deque4 dq = new Deque4(arr);
			boolean direct = true;
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 'R') {
					direct = !direct;
				} else if (p[i] == 'D') {
					if (dq.empty() || n == 0) {
						sb.append("error\n");
						continue label;
					}
					if (direct)
						dq.pop_front();
					else
						dq.pop_back();
				}
			}
			sb.append("[");
			if(direct) {
				for (int i = dq.front; i < dq.tail; i++) {
					sb.append(dq.pop_front());
					if(i+1 != dq.tail) sb.append(","); 
				}
			} else {
//				System.out.println(dq.tail + " " + dq.front);
				for (int i = dq.tail; i > dq.front; i--) {
					sb.append(dq.pop_back());
					if(i != dq.front+1) sb.append(",");
				}
			}
			sb.append("]\n");
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(arr));
		}
		System.out.println(sb);
	}
}

class Deque4 {
	int front, tail;
	int[] arr;

	public Deque4(int[] a) {
		arr = a;
		front = 0;
		tail = arr.length;
	}

	public int pop_front() {
		if (front == tail) return -1;
		return arr[front++];
	}
	public int pop_back() {
		if (front == tail) return -1;
		return arr[--tail];
	}
	public int size() {
		return tail - front;
	}
	public boolean empty() {
		if (front == tail) return true;
		else return false;
	}

}
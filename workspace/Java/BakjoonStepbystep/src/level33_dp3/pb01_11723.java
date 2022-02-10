package level33_dp3;

import java.io.*;
import java.util.*;

public class pb01_11723 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int bit = 0;

		for (int tc = 0; tc < N; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String command = token.nextToken();
			if (command.equals("all")) {
				bit |= (~0);
				continue;
			} else if (command.equals("empty")) {
				bit &= 0;
				continue;
			}
			int num = Integer.parseInt(token.nextToken());

			if (command.equals("add")) {
				bit |= (1 << (num - 1));
			} else if (command.equals("remove")) {
				bit &= ~(1 << (num - 1));
			} else if (command.equals("check")) {
				sb.append((bit & (1 << (num - 1))) != 0 ? "1" : "0").append("\n");
			} else if (command.equals("toggle")) {
				bit ^= (1 << (num-1));
			}
		}
		System.out.println(sb);
	}

}

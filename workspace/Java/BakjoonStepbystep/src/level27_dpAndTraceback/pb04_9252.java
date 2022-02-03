package level27_dpAndTraceback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class pb04_9252 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char[] c1 = new char[s1.length() + 1];
		char[] c2 = new char[s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			c1[i] = s1.charAt(i - 1);
		}
		for (int i = 1; i <= s2.length(); i++) {
			c2[i] = s2.charAt(i - 1);
		}

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (c1[i] == c2[j])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

//		for (int[] a : dp)
//			System.out.println(Arrays.toString(a));
		System.out.println(dp[s1.length()][s2.length()]);
		Stack<Character> stack = new Stack<>();
		int i = s1.length(), j = s2.length();
		while (i > 0 || j > 0) {
			if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else {
				stack.push(c1[i]);
				i--;
				j--;
			}
			if(dp[i][j] == 0) break;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}

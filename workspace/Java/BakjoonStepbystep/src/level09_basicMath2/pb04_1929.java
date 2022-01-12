package level09_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb04_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		
		for (int i = a; i <= b; i++) {
			if(prime(i))
				System.out.println(i);
		}

	}

	public static boolean prime(int x) {
		if (x == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}

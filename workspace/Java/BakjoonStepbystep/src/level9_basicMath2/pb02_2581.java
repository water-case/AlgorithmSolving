package level9_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb02_2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int sum = 0;
		int mini = 0;
		boolean check = true;
		for (int i = a; i <= b; i++) {
			if(i<2)
				continue;
			
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				//System.out.println(i);
				sum += i;
				if (mini == 0) {
					mini = i;
				}
			}
			check = true;
		}
		//System.out.println();
		if (mini == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(mini);
		}
	}

}

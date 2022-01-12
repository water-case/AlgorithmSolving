package level08_basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb7_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		int output = 0;

		if (input % 5 == 0) {
			output = input / 5;
			input = 0;
		} else {
			while (input >= 3) {
				input -= 3;
				output++;
				if (input % 5 == 0) {
					output += input / 5;
					input = 0;
				}
			}
		}
		
		if(input != 0) {
			System.out.println(-1);
		} else {
			System.out.println(output);
		}
	}

}

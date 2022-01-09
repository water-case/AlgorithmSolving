package level7_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb5_1157 {

	public static void main(String[] args) throws IOException {
		String[] alpha = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		int[] search = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();

		for (int i = 0; i < a.length(); i++) {
			int c = (int)a.charAt(i);
			if(c > 90) {
				c-=32;
			}
			search[c-65]++;
		}
		
		int index = 0;
		int val = 0;
		boolean two = false;
		for (int i = 0; i < search.length; i++) {
			if(search[i] > val) {
				index = i;
				val = search[i];
				two = false;
			} else if(search[i] == val) {
				two = true;
			}
		}
		
		if(two) {
			System.out.println("?");
		} else {
			System.out.println(alpha[index]);
		}

	}

}
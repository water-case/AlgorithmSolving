package level7_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb3_10809 {

	public static void main(String[] args) throws IOException {

		char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] search = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		for(int i=0; i<n.length(); i++) {
			char c = n.charAt(i);
			for(int j=0; j<alpha.length; j++) {
				if(c == alpha[j]) {
					if(search[j] == -1) {
						search[j] = i;
					}
				}
			}
		}
		for(int i=0; i<alpha.length; i++) {
			System.out.print(search[i] + " ");
		}
	}

}
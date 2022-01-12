package level10_recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class pb4_11729 {

	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		bw.write((int) (Math.pow(2, N) - 1) + "\n");
		hanoi(N, 1, 2, 3);
		
		bw.flush();
		bw.close();
		sc.close();
	}
	
	static void hanoi(int N, int start, int mid, int to) throws IOException {
		if(N==1) {
			bw.write(start + " " + to + "\n");
			return;
		}
		
		hanoi(N-1, start, to , mid);
		
		bw.write(start + " " + to + "\n");

		hanoi(N-1, mid, start , to);
		
	}
	
}

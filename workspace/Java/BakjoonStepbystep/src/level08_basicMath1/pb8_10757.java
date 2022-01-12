package level08_basicMath1;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class pb8_10757 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		
		
// 내가 만들어본건데 틀렷다고 나옴
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
//
//		StringTokenizer token = new StringTokenizer(input, " ");
//		
//		StringBuffer sb;
//		sb = new StringBuffer(token.nextToken());
//		String a = sb.reverse().toString();
//		sb = new StringBuffer(token.nextToken());
//		String b = sb.reverse().toString();
//		
//		String sum = "";
//		boolean carry = false;
//
//		if (b.length() > a.length()) {
//			String temp = a;
//			a = b;
//			b = temp;
//		}
//		
//		int cal = 0;
//		for (int i = 0; i < b.length(); i++) {
//			cal = a.charAt(i) + b.charAt(i) - 96;
//			if(carry) {
//				carry = false;
//				cal += 1;
//			}
//			
//			if (cal >= 10) {
//				carry = true;
//				cal -= 10;
//			}
//			
//			sum += cal;
//		}
//		
//		if(carry) {
//			if(a.length() == b.length())
//				sum += 1;
//			else {
//				// 남은 번호가 9인데 캐리가 남았으면 지속적인 캐리 발생 처리를 해야함
//				for (int i = 0; i < a.length() - b.length(); i++) {
//					if(carry) {
//						cal = a.charAt(b.length()+i) - 48 + 1;
//						
//						if(cal == 10) {
//							sum += cal - 10;
//							if(i == a.length() - b.length() -1) {
//								sum += 1;
//							}
//						} else {
//							sum += cal;
//							carry = false;
//						}
//					}
//				}
//			}
//		} else {
//			if(a.length() != b.length()) {
//				sum += a.substring(b.length(), a.length());
//			}
//		}
//		
//		sb = new StringBuffer(sum);
//		sum = sb.reverse().toString();
//		System.out.println(sum);
	}
		
}

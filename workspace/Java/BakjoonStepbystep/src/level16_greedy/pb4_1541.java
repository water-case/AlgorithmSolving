package level16_greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pb4_1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringTokenizer token1 = new StringTokenizer(s, "+-");
		StringTokenizer token2 = new StringTokenizer(s, "0123456789");
		
		int[] nums = new int[50];
		String[] cals = new String[50];
		int idx = 0;
		while(token2.hasMoreTokens()) {
			cals[idx++] = token2.nextToken();
		}
		
		idx = 0;
		int c = 0;
		int sum = 0;
		while(token1.hasMoreTokens()) {
			if(cals[c] == null) {
				sum += Integer.parseInt(token1.nextToken());
				nums[idx++] = sum;
				sum = 0;
				break;
			}
			if(cals[c].equals("-")) {
				sum += Integer.parseInt(token1.nextToken());
				nums[idx++] = sum;
				sum = 0;
				c++;
			} else {
				sum += Integer.parseInt(token1.nextToken());
				c++;
			}
		}
		nums[idx] = sum;
		
		System.out.println(Arrays.toString(cals));
		System.out.println(Arrays.toString(nums));
		
		int ans = nums[0];
		for(int i=1; i<50; i++) {
			if(nums[i] != 0) {
				ans -= nums[i];
			}
		}
		
		System.out.println(ans);
		
		
	}

}

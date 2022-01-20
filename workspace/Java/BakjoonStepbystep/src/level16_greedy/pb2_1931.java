package level16_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pb2_1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt(); // 회의시작시간
			arr[i][1] = sc.nextInt(); // 회의끝나는시간
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int end = 0;
		
		for(int i=0; i<N; i++) {
			if(end <=arr[i][0]) {
				end = arr[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}

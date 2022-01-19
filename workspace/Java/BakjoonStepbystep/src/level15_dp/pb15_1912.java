package level15_dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb15_1912 {

	static int[] arr;
	static Integer[] ans;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		ans = new Integer[N];
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		ans[0] = arr[0];
		max = arr[0];
		
		cf(N-1);
		
		System.out.println(max);
		
		// 돌면서 배열압축
//		int[] tmp = new int[N]; // 줄인배열 저장
//		int sum = 0;
//		int count = 0;
//		for (int i = 0; i < N; i++) {
//			int num = Integer.parseInt(token.nextToken());
//			if(num < 0) {
//				if(sum > 0) {
//					tmp[count++] = sum;
//					sum = 0;
//				}
//				tmp[count++] = num;
//			} else {
//				sum += num;
//			}
//		}
//		
//		int max = Integer.MIN_VALUE;
//		// 양수일때 더해가면서 최대값 저장, 음수일땐 continue
//		sum = 0;
//		for (int i = 0; i < count; i++) {
//			if (tmp[i] > max)
//				max = tmp[i];
//			if (tmp[i] > 0) {
//				sum += tmp[i];
//				for (int j = i + 1; j < count; j++) {
//					sum += tmp[j];
//					if (sum > max) {
//						max = sum;
//					}
//				}
//				sum = 0;
//			}
//		}
//		
//		System.out.println(max);
		
//		System.out.println(Arrays.toString(ans));
//		for(int[] i:arr) System.out.println(Arrays.toString(i));
		
		// 압축된 배열끼리 계산
//		for(int i=1; i<count; i++) {
//			for(int j=0; j<count-i; j++) {
//				arr[j] = arr[j] + tmp[j+i];
//				if(arr[j] > max) max = arr[j];
//			}
//		}
		// 기본 수에서 최대값이 있는지 검사
//		for (int i = 0; i < count; i++) {
//			if (tmp[i] > max)
//				max = tmp[i];
//		}
		
	}
	
	static int cf(int N) {
		
		if(ans[N] == null) {
			ans[N] = Math.max(cf(N-1)+arr[N], arr[N]);
			
			max = Math.max(ans[N], max);
		}
		
		return ans[N];
	}

}

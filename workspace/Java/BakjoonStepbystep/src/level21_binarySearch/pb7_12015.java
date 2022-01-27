package level21_binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class pb7_12015 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(0);
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(token.nextToken());
			if (list.get(list.size() - 1) < a) {
				list.add(a);
			} else {
				int max = 0;
				int min = list.size() - 1;

				while (max < min) {
					int mid = (max + min) / 2;
					if(list.get(mid) >= a) {
						min = mid;
					} else {
						max = mid + 1;
					}
				}
				list.set(min, a);
			}
		}
		System.out.println(list.size() - 1);
	}

}

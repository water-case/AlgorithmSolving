package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb03_1780 {
	static int N;
	static int[][] arr;
	static int[] ans = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(token.nextToken());
		}

		cf(N, 0, 0);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}

	static void cf(int size, int x, int y) {
		if(size == 1) {
			ans[arr[x][y]+1]++;
			return;
		}
		
label:	for (int i = x; i < size + x; i++) {
			for (int j = y; j < size + y; j++) {
				if(arr[x][y] != arr[i][j]) {
					int resize = size/3;
					cf(resize, x, y);
					cf(resize, x+resize , y);
					cf(resize, x+resize*2 , y);
					cf(resize, x, y+resize);
					cf(resize, x+resize, y+resize);
					cf(resize, x+resize*2, y+resize);
					cf(resize, x, y+resize*2);
					cf(resize, x+resize, y+resize*2);
					cf(resize, x+resize*2, y+resize*2);
					break label;
				}
			}
			if(i == size+x-1)
				ans[arr[x][y]+1]++;
		}
	}

}

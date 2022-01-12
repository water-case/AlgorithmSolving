package level9_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb11_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		String[] tc = new String[t];
		for (int i = 0; i < t; i++) {
			tc[i] = br.readLine();
		}

		for (int i = 0; i < t; i++) {
			StringTokenizer token = new StringTokenizer(tc[i], " ");
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int r1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			int r2 = Integer.parseInt(token.nextToken());
			
			int dispow = (int) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

			// 서로 같은 원일 경우
			if(x1 == x2 && y1 == y2 && r1 == r2)
				System.out.println(-1);
			
			// 포함하지만 접점이 없는 경우
			else if(dispow < Math.pow(r2-r1, 2)) {
				System.out.println(0);
			}
			
			// 포함하면서 접점이 있는 경우
			else if(dispow == Math.pow(r2-r1, 2)) {
				System.out.println(1);
			}
			
			// 서로 다른원이면서 두점에서 만나는 경우
			else if(dispow < Math.pow(r2+r1, 2)) {
				System.out.println(2);
			}
			
			// 서로 다른원이면서 외접
			else if(dispow == Math.pow(r2+r1, 2)) {
				System.out.println(1);
			}
			
			// 서로 다른 원이면서 안만나는 경우
			else if(dispow > Math.pow(r2+r1, 2)) {
				System.out.println(0);
			}

		}

	}

}

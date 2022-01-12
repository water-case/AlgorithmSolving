package level9_basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb07_1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int w = Integer.parseInt(token.nextToken());
		int h = Integer.parseInt(token.nextToken());
		
		// wh와의거리
		int ax = w-x;
		int ay = h-y;
		
		// 비교
		int ansX = ax > x ? x : ax;
		int ansY = ay > y ? y : ay;
		
		// 비교한것중에 또비교
		System.out.println(ansX > ansY ? ansY : ansX);
		
	}

}

package level41_ConvexHull;

import java.io.*;
import java.util.*;

/*
 * 풀이순서
 * 1. y축값이 가장작은걸 기준으로 ccw를 돌려서 시계 반대방향순서대로정렬
 * 2. 그라함스캔이라는 알고리즘을 이용한다
 * - 최초 두점을 스택에 넣고, ccw로 좌회전인지 우회전인지 확인한다
 * - ccw의 결과값이 0보다 크면 좌회전, 작으면 우회전임
 * - 정렬순서대로 stack에 넣고 현재인덱스의 점과 스택의 맨윗점과 그아랫점으로 ccw검사
 * - 우회전일경우 넣었던 점을 스택에서 빼고 다시검사한다
 * - 모든 점에 대해 검사가 끝나면 블록껍질이 완성된다
 * - 이후 스택에 들어가있는 점의 개수가 블록껍질을 이루는 점들의 개수이다
 * 
 * 기본 예제는 잘 도출되나 런타임 에러 (IllegalArgument) 발생으로 틀림
 * 자료형으로 인한 이슈로, 클래스내 변수 및 정렬비교를 long타입으로 변경하여 해결하였음
 */

public class pb01_P5_1708_블록껍질 {

	static class Point {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

	}

	static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N=Integer.parseInt(br.readLine()); // 점의 개수
		ArrayList<Point> pa=new ArrayList<>(); // 점들을 저장할 배열

		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			pa.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		
		Collections.sort(pa, (o1,o2)->{
				if(o1.y!=o2.y) return Long.compare(o1.y, o2.y);
				else return Long.compare(o1.x, o2.x);
		});
		
		root=pa.get(0); // y값이 제일작고, x값이 제일작은점을 기준으로한다
		
		Collections.sort(pa, (o1,o2)->{ // 반시계방향으로 정렬한다
				int rccw=ccw(root,o1,o2);
				if(rccw>0) return -1; // 좌회전
				else if(rccw<0) return 1; // 우회전
				else {
					long d1=dist(root,o1);
					long d2=dist(root,o2);
					if(d1>d2) return 1; // 거리순정렬
				}
				return -1;
		});
		
		Stack<Point> stack=new Stack<>();
		stack.add(root);
		for(int i=1; i<N; i++) {
			while(stack.size()>1 && ccw(stack.get(stack.size()-2), stack.get(stack.size()-1), pa.get(i))<=0) {
				stack.pop();
			}
			stack.add(pa.get(i));
		}
		System.out.println(stack.size());
		
	}
	
	static int ccw(Point p1, Point p2, Point p3) {
		long rccw =  (p1.x*p2.y+p2.x*p3.y+p3.x*p1.y)-(p2.x*p1.y+p3.x*p2.y+p1.x*p3.y); // 신발끈 공식
		if(rccw>0) return 1;
		else if(rccw<0) return -1;
		else return 0;
	}
	
	static long dist(Point p1, Point p2) {
		return (p2.x-p1.x) * (p2.x-p1.x) + (p2.y-p1.y) * (p2.y-p1.y); 
	}

}

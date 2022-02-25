package level39_Sweeping;

import java.io.*;
import java.util.*;

/*
 * 별의 개수 200_000개, 좌표범위 -200_000 ~ 200_000
 * x좌표로 오름차순후 좌표압축 후
 * y좌표로 내림차순, 같으면 x좌표 오름차순으로 세그먼트트리에 넣으면서
 * 큰값, 작은값 알아내서 곱해준값을 누적합한다
 * y좌표가 같으면 별자리가 이루어진게 아니므로 제외하기위해
 * 업데이트는 y좌표값이 변할때 한번에 업데이트한다
 * 
 * 5만개까지는 쉽게 구해지나, 그 이상부터 시간이 기하급수적으로 늘어난다
 * 다른 방법으로도 해봤으나 시간초과
 * 방법이 잘못되었나 의문이들어 c++로 돌려보니 아주잘구해진다. 
 * 자바언어의 경우 시간을 더줘야하는데 안줘서 그런것 같은줄 알았으나
 * 정답자들의 코드를 보니까 다른 방법이 있음
 */

public class pb04_P4_17131_여우가정보섬에올라온이유 {

	static class Star {
		int x, y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int mod=1_000_000_007;
	static int size = 200_000;
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		tree=new int[size*8];
		LinkedList<Star> sL = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			sL.add(new Star(Integer.parseInt(st.nextToken())+size, Integer.parseInt(st.nextToken())+size));
		}
		
		Collections.sort(sL, (a,b)->{
			if(b.y!=a.y) return b.y-a.y;
			else return a.x-b.x;
		}); // y좌표로 내림차순
		long ans=0;
		int savey=sL.get(0).y, scnt=0;
		for(int i=0; i<N; i++) {
			Star now=sL.get(i);
			if(now.y==savey) scnt++;
			else { // 업데이트는 y좌표가 바뀌면 몰아서 업데이트함
				for(int j=i-scnt; j<i; j++)
					update(1,size*2,1,sL.get(j).x);
				scnt=0; savey=now.y;
			}
			ans=(ans+query(1,size*2,1,1,now.x-1)*(query(1,size*2,1,now.x+1,size*2)))%mod;
		}
		System.out.println(ans);
	}
	
	static int query(int start, int end, int node, int left, int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&right>=end) return tree[node];
		int mid=(start+end)/2;
		return query(start, mid, node*2, left, right)+query(mid+1, end, node*2+1, left, right);
	}
	
	static void update(int start, int end, int node, int idx) {
		if(idx>end||idx<start) return;
		tree[node]++;
		if(start==end) return;
		int mid=(start+end)/2;
		update(start, mid, node*2, idx);
		update(mid+1, end, node*2+1, idx);
	}

}

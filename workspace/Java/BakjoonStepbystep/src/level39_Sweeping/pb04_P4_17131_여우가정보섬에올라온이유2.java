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
 */

public class pb04_P4_17131_여우가정보섬에올라온이유2 {

	static class Star {
		int x, y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int mod=1_000_000_007;
	static int addCor=200_001;
	static int corMax=200_000+addCor;
	static int[] tree=new int[500_000];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		LinkedList<Star> sL = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			sL.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			update(sL.get(i).x+addCor, 1);
		}
		
		Collections.sort(sL, (a,b)->{
			if(b.y==a.y) return a.x-b.x;
			else return a.y-b.y;
		});
		
		int num = mod;
		long ans = 0;
		for(int i=0; i<N; i++) {
			if(num!=sL.get(i).y) {
				num=sL.get(i).y;
				for(int j=i; sL.get(j).y==num; j++) {
					update(sL.get(j).x+addCor,-1);
				}
			}
			int x=sL.get(i).x+addCor;
			int left=query(x-1)%mod;
			int right=(query(corMax)-query(x))%mod;
			ans += (left * right)%mod;
			ans %= mod;
		}
		System.out.println(ans);
		
	}
	
	static int query(int i) {
		int val=0;
		while(i>0) {
			val+=tree[i];
			i-=(i&-i);
		}
		return val;
	}
	
	static void update(int i, int dif) {
		while(i<=corMax) {
			tree[i]+=dif;
			i+=(i&-i);
		}
	}

}

package level39_Sweeping;

import java.io.*;
import java.util.*;

/*
 * 수의범위는 -10억 ~ 10억이고 수의 개수는 75000이므로 좌표압축이 필수
 * 좌표압축에 대해서 애매모호하게 생각하고 있었는데 제대로 알게됨
 * 큰수부터 세그먼트트리에 넣으면서 숫자를 셀것이므로 압축전 y값 내림차순으로 정렬한다
 * y축을 기준으로 좌표압축을 한다, y값이 같으면 같은 값이 들어갈것이다
 * 이후 x좌표로는 오름차순을 해준다
 * 세그먼트 트리에 넣는 우선순위를 정리하자면 x값이 작은것먼저, x값이 같으면 y값이 큰거부터
 * 트리에 넣는 기준값은 압축한 y값으로 넣는다
 * 그렇게하면 넣는 y값보다 작은 트리의 갯수는 안세고, y값보다 크면서 x값이 작은것들을 세게 되는데 문제의 목적과 정확히 부합한다 
 */

public class pb03_P4_5419_북서풍 {
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n=Integer.parseInt(br.readLine());
			ArrayList<Pos> pl = new ArrayList<>();
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine(), " ");
				pl.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			Collections.sort(pl, (a,b)->b.y-a.y); // 좌표 압축전 정렬 
			
			int[] zip=new int[n]; // 좌표압축 시작
			int cnt=1;
			for(int i=0; i<n; i++) {
				if(i>0 && pl.get(i).y!=pl.get(i-1).y) cnt++;
				zip[i]=cnt;
			}
			for(int i=0; i<n; i++) pl.get(i).y=zip[i]; // 좌표압축완료
			
			Collections.sort(pl, (a,b)->{
				if(a.x!=b.x) return a.x-b.x;
				else		 return a.y-b.y;
			});
			
			tree=new int[n*4];
			long ans = 0;
			for(int i=0; i<n; i++) {
				ans+=query(1,n,1,1,pl.get(i).y);
				update(1,n,1,pl.get(i).y);
			}
			System.out.println(ans);
		}
		br.close();
	}
	
	static void update(int start, int end, int node, int idx) {
		if(idx<start || end<idx) return;
		tree[node]++;
		if(start==end) return;
		int mid=(start+end)/2;
		update(start,mid,node*2,idx);
		update(mid+1,end,node*2+1,idx);
	}
	
	static int query(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return 0;
		if(left<=start && right>=end) return tree[node];
		int mid=(start+end)/2;
		return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
		
	}

}

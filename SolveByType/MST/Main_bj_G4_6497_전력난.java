import java.io.*;
import java.util.*;

public class Main_bj_G4_6497_전력난 {
	
	static class Edge implements Comparable<Edge> {
		int start, end, price;

		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
		
		@Override
		public int compareTo(Edge o) {
			return price-o.price;
		}
		
	}
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_6497"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			int m=Integer.parseInt(st.nextToken()); // 집의 수
			int n=Integer.parseInt(st.nextToken()); // 길의 수
			if(m==0 && n==0) break;

			parent=new int[m];
			for(int i=0; i<m; i++)
				parent[i]=i;
			
			PriorityQueue<Edge> pq=new PriorityQueue<>();
			
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int z=Integer.parseInt(st.nextToken());
				pq.add(new Edge(x, y, z));
			}
			
			int ans=0;
			while(!pq.isEmpty()) {
				Edge now=pq.poll();
				if(!isUnion(now.start,now.end))
					Union(now.start,now.end);
				else
					ans+=now.price;
			}
			
			System.out.println(ans);
		}
		br.close();
	}
	
	static void Union(int a, int b) {
		a=find(a);
		b=find(b);
		if(parent[a]==parent[b]) return;
		parent[b]=a;
	}
	
	static boolean isUnion(int a, int b) {
		a=find(a);
		b=find(b);
		if(parent[a]==parent[b]) return true;
		return false;
	}

	static int find(int a) {
		a=parent[a];
		if(a==parent[a]) return a;
		return parent[a]=find(parent[a]);
	}
	
}

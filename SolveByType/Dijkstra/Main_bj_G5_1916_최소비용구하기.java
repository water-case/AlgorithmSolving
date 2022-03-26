import java.io.*;
import java.util.*;

public class Main_bj_G5_1916_최소비용구하기 {

	static class Node implements Comparable<Node> {
		int end;
		long price;
		
		public Node(int end, long price) {
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(price, o.price);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1916"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine()); // 도시 수
		int M=Integer.parseInt(br.readLine()); // 버스 수
		
		long[] dist=new long[N+1];
		for(int i=1; i<=N; i++) dist[i]=Long.MAX_VALUE;
		boolean[] v=new boolean[N+1];
		ArrayList<Node>[] g=new ArrayList[N+1];
		for(int i=1;i<=N;i++) g[i]=new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			g[a].add(new Node(b, c));
		}
		
		st=new StringTokenizer(br.readLine()," ");
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq=new PriorityQueue<>();
		dist[start]=0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
			
			if(v[now.end])continue;
			v[now.end]=true;
			
			for(Node next:g[now.end]) {
				if(!v[next.end] && dist[next.end]>dist[now.end]+next.price) {
					dist[next.end]=dist[now.end]+next.price;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
	}

}

import java.io.*;
import java.util.*;

public class Main_bj_G3_1238_파티 {

	static class Node implements Comparable<Node> {
		int end, price;

		public Node(int end, int price) {
			this.end = end;
			this.price = price;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(price, o.price);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1238"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int N=Integer.parseInt(st.nextToken()); // 학생 수
		int M=Integer.parseInt(st.nextToken()); // 도로 수
		int X=Integer.parseInt(st.nextToken()); // 모이는 마을
		
		ArrayList<Node>[] g1=new ArrayList[N+1];
		ArrayList<Node>[] g2=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g1[i]=new ArrayList<>();
			g2[i]=new ArrayList<>();
		}
		int[] dist1=new int[N+1];
		int[] dist2=new int[N+1];
		for(int i=1; i<=N; i++) {
			dist1[i]=Integer.MAX_VALUE;
			dist2[i]=Integer.MAX_VALUE;
		}
		boolean[] v1=new boolean[N+1];
		boolean[] v2=new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			g1[a].add(new Node(b, c));
			g2[b].add(new Node(a, c));
		}
		
		PriorityQueue<Node> pq1=new PriorityQueue<>();
		PriorityQueue<Node> pq2=new PriorityQueue<>();
		dist1[X]=0;
		dist2[X]=0;
		pq1.add(new Node(X, 0));
		pq2.add(new Node(X, 0));
		
		while(!pq1.isEmpty()) {
			Node now=pq1.poll();
			
			if(v1[now.end]) continue;
			v1[now.end]=true;
			
			for(Node next:g1[now.end]) {
				if(!v1[next.end] && dist1[next.end]>dist1[now.end]+next.price) {
					dist1[next.end]=dist1[now.end]+next.price;
					pq1.add(new Node(next.end, dist1[next.end]));
				}
			}
		}
		while(!pq2.isEmpty()) {
			Node now=pq2.poll();
			
			if(v2[now.end]) continue;
			v2[now.end]=true;
			
			for(Node next:g2[now.end]) {
				if(!v2[next.end] && dist2[next.end]>dist2[now.end]+next.price) {
					dist2[next.end]=dist2[now.end]+next.price;
					pq2.add(new Node(next.end, dist2[next.end]));
				}
			}
		}
		
		int[] sumdist=new int[N+1];
		for(int i=1; i<=N; i++)
			sumdist[i]=dist1[i]+dist2[i];
		
		int ans=0;
		for(int i=1; i<=N; i++)
			ans=Math.max(ans, sumdist[i]);
		System.out.println(ans);
		
	}

}

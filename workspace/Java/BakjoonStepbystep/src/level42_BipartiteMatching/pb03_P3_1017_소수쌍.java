package level42_BipartiteMatching;

import java.io.*;
import java.util.*;

/*
 * 주어지는 자연수의 크기가 정해져 있으므로 에라스토테네스의 체를 이용하여 소수판별배열을 만들고
 * 이를 기반으로 두 수의 합이 소수가 되는경우 간선으로 생각하고 문제를 풀이한다
 * 
 * 이후 첫째값과 소수를 이루는 수를 고정시키고 돌려야하는데
 * 이를 이분매칭에 적용한 구현에 어려움을 겪어 방법을 변경
 * 짝수 + 홀수의 경우에만 소수가 가능함을 이용하여 분류
 * 
 * 하나의 배열로 구현해보려다가 꽤 많은 시간을 낭비했다
 * 홀수와 짝수로 나누고 두개의 배열을통해서 짝을 맞추는방식으로 구현해야 한다
 */

public class pb03_P3_1017_소수쌍 {

	static boolean[] prime=new boolean[2000], v;
	static int[] apair, bpair;
	static ArrayList<Integer> a,b;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine()); // 리스트의 크기
		makePrime(); // 소수배열생성
		
		a=new ArrayList<>(); b=new ArrayList<>();
		st=new StringTokenizer(br.readLine()," ");
		a.add(Integer.parseInt(st.nextToken()));
		
		for(int i=1; i<N; i++) {
			int num=Integer.parseInt(st.nextToken());
			if((a.get(0)+num)%2==0) a.add(num); // 홀수 짝수 구분하여 따로 배열에 저장
			else b.add(num);
		}
		if(a.size()!=b.size()) { // 홀수 짝수의 짝이 맞지않으면 완전매칭이 불가능함
			System.out.println(-1);
			return;
		}
		
		graph=new ArrayList[a.size()];
		for(int i=0; i<a.size(); i++) {
			graph[i]=new ArrayList<>();
			for(int j=0; j<b.size(); j++)
				if(prime[a.get(i)+b.get(j)]) // 소수일경우 간선연결
					graph[i].add(j);
		}

		ArrayList<Integer> ans=new ArrayList<>();
		apair=new int[a.size()];
		bpair=new int[b.size()];
		for(int i=0; i<graph[0].size(); i++) { // 1이랑 소수되는경우 매칭해놓고 이분매칭
			Arrays.fill(apair, -1);
			Arrays.fill(bpair, -1);
			apair[0]=graph[0].get(i);
			bpair[graph[0].get(i)]=0;
			
			int cnt=1;
			for(int j=0; j<a.size(); j++) {
				v=new boolean[a.size()];
				if(dfs(j)) cnt++;
			}
			if(cnt==b.size()) ans.add(b.get(apair[0]));
		}
		Collections.sort(ans);
		if(ans.size()==0) System.out.println(-1);
		else {
			for(int res:ans)
				System.out.print(res+" ");
		}
	}
	
	static boolean dfs(int x) {
		for(int next:graph[x]) {
			if(x==0 || v[next]) continue;
			v[next]=true;
			if(bpair[next]==-1 || dfs(bpair[next])) {
				apair[x]=next;
				bpair[next]=x;
				return true;
			}
		}
		return false;
	}
	
	static void makePrime() {
		Arrays.fill(prime, true);
		prime[0]=false; prime[1]=false;
		for(int i=2; i<2000; i++) {
			if(!prime[i]) continue;
			int num=i+i;
			while(num<2000) {
				prime[num]=false;
				num+=i;
			}
		}
	}

}

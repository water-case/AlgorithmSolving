import java.io.*;
import java.util.*;

public class Main_bj_G4_2458_키순서 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2458"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] g=new int[N+1][N+1];
		for(int i=1; i<=N; i++)
			Arrays.fill(g[i], 999_999);
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			g[a][b]=1;
		}
		
		for(int k=1; k<=N; k++)
			for(int i=1; i<=N; i++) {
				if(k==i) continue;
				for(int j=1; j<=N; j++) {
					if(i==j || j==k) continue;
					if(g[i][k]!=999_999 && g[k][j]!=999_999)
						g[i][j]=1;
				}
			}
		
		int ans=0;
		for(int i=1; i<=N; i++) {
			int cnt=0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(g[i][j]!=999_999 || g[j][i]!=999_999) cnt++;
			}
			if(cnt==N-1) ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
}

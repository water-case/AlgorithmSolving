import java.io.*;
import java.util.*;
public class Main_bj_G5_2225_합분해 {

	static int N,K,MOD=1_000_000_000;
	static Integer[][] dp; // 더한횟수, 결과값
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2225"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dp=new Integer[K+1][N+1];
		
		System.out.println(dp(K, N));
		br.close();
	}
	
	static int dp(int k, int n) {
		if(k==1 || n==0) return 1;

		if(dp[k][n]==null) {
			dp[k][n]=0;
			dp[k][n]=((dp(k,n-1)%MOD)+(dp(k-1,n)%MOD))%MOD;
		}
		
		return dp[k][n];
	}

}

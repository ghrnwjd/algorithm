import java.util.*;
import java.io.*;

public class b9251 {
	static int N, M;
	static char cs1[], cs2[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		cs1 = s1.toCharArray();
		cs2 = s2.toCharArray();
		
		N = s1.length();
		M = s2.length();
		
		int dp [][] = new int [N][M];
		
		initialize(dp);
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				
				if(cs1[i] == cs2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	
		
		System.out.println(dp[N-1][M-1]);
		
	}
	
	public static void initialize(int dp[][]) {
		boolean tf = false;
		for(int i = 0; i < M; i++) {
			if(cs2[i] == cs1[0]) {
				tf = true;
			}
			if(tf) {
				dp[0][i] = 1;
			}
		}
		
		tf = false;
		for(int i = 0; i < N; i++) {
			if(cs1[i] == cs2[0]) tf = true;
			if(tf) dp[i][0] = 1;
		}
	}
}

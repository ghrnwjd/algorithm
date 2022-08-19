import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int dp [] = new int [k+1];
		int coin [] = new int [n];
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) { // O(nk)			
			for(int j = 1; j <= k; j++) {
				if(j - coin[i] >=0 ) {
					dp[j] += dp[j - coin[i]];
				}
			}
		}
		
		System.out.println(dp[k]);
	}
}

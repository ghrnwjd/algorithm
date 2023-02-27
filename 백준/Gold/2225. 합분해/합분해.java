import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static final int maxSize = 201;
	static final int mod = 1000000000;
	static int board [][] = new int [maxSize][maxSize];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Arrays.fill(board[1], 1);
		for(int i = 1; i < maxSize; i++) {
			board[i][1] = i;
		}
		/** 
		 * 0 0 0 0 0 0 0
		 * 0 1 1 1 1 1 1
		 * 0 2 
		 * 0 3
		 * 0 4
		 * 0 5		
		 */
		
		
		for(int i = 2; i < maxSize; i++) {
			for(int j = 2; j < maxSize; j++) {
				board[i][j] = (board[i-1][j] + board[i][j-1]) % mod;
			}
		}			
		
		System.out.println(board[k][n]);
		
		
		
	}
}

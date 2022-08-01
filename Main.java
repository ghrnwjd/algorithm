import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int board [][] = new int[N][M];
		int ans_board [][] = new int [N][M];
		
		for(int i = 0; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - 0;
			}
		}
		
		for(int i = 0; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				ans_board[i][j] = s.charAt(j) - 0;
			}
		}
		
		
		if(N < 3 || M < 3) System.out.println("-1");
		else {
			for(int i = 0; i < N - 2; i++) { // ������
				for (int j = 0; j < M - 2; j++) { // ������
					if(board[i][j] != ans_board[i][j]) {
						for(int row = i; row < i + 3; row++) {
							for(int col = j; col < j + 3; col++) {
								if(board[i][j] == 1) board[row][col] = 0;
								else board[row][col] = 1;
							}
						}
						ans++;
					}
				}
			}
			
			
			System.out.println(ans);
		}
		

		
	}
}

import java.util.*;
import java.io.*;

public class b10026 {
	
	static int N;
	static int [] dx = {1, -1, 0 , 0};
	static int [] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int [][] board = new int [N][N];
		int [][] colorBoard = new int [N][N];
		boolean visit[][] = new boolean [N][N];
				
		// R = 1 , G = 2, B = 3 ,, RG = 1, B = 3;
		for(int i = 0; i < N ; i++) {
			String s = br.readLine();
			for(int j=0; j < N; j++) {
				if(s.charAt(j) == 'R') {
					board[i][j] = 1;
					colorBoard[i][j] = 1;
				}
				else if(s.charAt(j) == 'G') {
					board[i][j] = 2;
					colorBoard[i][j] = 1;
				}
				else {
					board[i][j] = 3;
					colorBoard[i][j] = 3;
				}
			}
		}
		
		area(board, visit);
		visit = new boolean[N][N];
		area(colorBoard, visit);
	}
	
	public static void area(int [][] board, boolean [][] visit) {
		
		Queue<int []> q = new LinkedList<>();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					cnt++;
					int value = board[i][j];
					q.add(new int [] { i, j });
					
					while(!q.isEmpty()) {
						int temp [] = q.poll();
						
						for(int k = 0; k < 4; k++) {
							if(inRange(temp[0]+dx[k], temp[1] + dy[k]) 
									&& board[temp[0]+dx[k]][temp[1] + dy[k]] == value
									&& !visit[temp[0]+dx[k]][temp[1] + dy[k]]) {
								visit[temp[0]+dx[k]][temp[1] + dy[k]] = true;
								q.add(new int [] {temp[0]+dx[k], temp[1]+dy[k]} );
							}
						}
					}
				}
			}
		}		
		System.out.print(cnt+" ");		
	}
	
	
	public static boolean inRange(int x, int y) {
		return x >=0 && x < N && y >= 0 && y < N;
	}
}

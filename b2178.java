import java.io.*;
import java.util.*;

class b2178 {
	static int board[][];
	static boolean visit[][];
	static int count = 1;
	static int[][] dic = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		board = new int[a][b];
		visit = new boolean[a][b];


		for (int i = 0; i < a; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				board[i][j] = s.charAt(j) - 48;
			}
		}
		
		visit[0][0] = true;
		
		findway(0, 0);
		System.out.println(board[a-1][b-1]);
	}

	public static void findway(int a, int b) {
		Queue <int []> que = new LinkedList<>();
		que.add(new int [] {a, b});
		
		while(!que.isEmpty()) {
			int [] move = que.poll();
			int move_a = move[0];
			int move_b = move[1];
			
			for(int i =0; i <4 ;i++) {
				int temp_a = move_a + dic[i][0];
				int temp_b = move_b + dic[i][1];
				
				if(temp_a >=0 && temp_a <board.length && temp_b>=0 && temp_b <board[0].length) {
					if(board[temp_a][temp_b] == 1 && !visit[temp_a][temp_b])
					{	
						board[temp_a][temp_b] = board[move_a][move_b] + 1;
						visit[temp_a][temp_b] = true;
						que.add(new int [] {temp_a, temp_b});
						
					}
				}
			}
		}

	}
}

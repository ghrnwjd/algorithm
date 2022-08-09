import java.util.*;
import java.io.*;

public class b7576 {

	static int M,N, cnt, days;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};  // 상 하 좌 우
	
	static int [][] tomato;
	static boolean [][] visit;
	static Queue<int []> que = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int tomato_count = N * M;
		tomato = new int [N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i ++) { // 입력 받기.
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					tomato[i][j] = 1;
					que.add(new int [] {i, j});
					visit[i][j] = true;
				}
				else if (temp == -1) {
					visit[i][j] = true;
				}
				else continue;
				tomato_count--;
			}
		}
		
		bfs();
		
		// 익은 사과와 익혀야 될 사과의 갯수를 비교한다.
		if(cnt >= tomato_count) System.out.println(days - 1);
		else System.out.println(-1);
		
	}
	
	public static void bfs() {
		
		while(!que.isEmpty()) {
			int que_size = que.size();
			for(int i = 0; i < que_size; i++) {
				int temp [] = que.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int j = 0; j < 4; j++) { // 익은 토마토의 갯수를 세준다.
					if(inRange(x + dx[j], y + dy[j]) && !visit[x+dx[j]][y+dy[j]]) {
						visit[x+dx[j]][y+dy[j]] = true;
						que.add(new int [] { x+ dx[j], y+dy[j] });
						cnt++;
					}
				}				
			}
			// 한 사이클이 끝나면 하루를 더 해준다.
			days++;
		}
	}
	
	public static boolean inRange(int x, int y) {
		return x>=0 && x <N && y>=0 && y < M;
	}
}
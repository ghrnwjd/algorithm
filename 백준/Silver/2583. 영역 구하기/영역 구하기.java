import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static boolean [][] visit;
	static ArrayList<Integer> ans = new ArrayList<>();
	static int [][] dic = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean [N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			fill_visit(x1, y1, x2, y2);
		}
		
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					count = 0;
					find_value(i, j);
					ans.add(count);
				}
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int ans_value : ans) {
			System.out.print(ans_value + " ");
		}
	}
	
	public static void find_value(int x , int y) {
		
		visit[x][y] = true;
		count ++;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + dic[i][0];
			int newY = y + dic[i][1];
			
			if(isOut(newX,newY) && !visit[newX][newY]) {
				find_value(newX, newY);
			}
		}		
	}
	
	public static void fill_visit(int x1, int y1, int x2, int y2) {
		for(int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				visit[i][j] = true;
			}
		}
	}
	
	public static boolean isOut(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}

import java.util.*;
import java.io.*;

public class Main {
	
	// 나이트의 이동경로
	static int dx [] = {1, -1, 0, 0};
	static int dy [] = {0, 0, 1, -1};
	static char board [][];
	static int ans, C, R;
	static ArrayList<Character> alpha = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char [R][C];
				
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			
			board[i] = s.toCharArray();
		}
		
		alpha.add(board[0][0]);
		alphabet(0,0,1);
		
		System.out.println(ans);
		
	}
	
	public static void alphabet(int x, int y, int cnt) {		
		
		for(int i = 0; i < 4; i++) {			
			if(inRange(x+dx[i], y+dy[i])) {				
				if(alpha.contains(board[x+dx[i]][y+dy[i]])) {
					ans = Math.max(ans, cnt);
				}
				
				else {
					//visit[x+dx[i]][y+dy[i]] = true;
					alpha.add(board[x+dx[i]][y+dy[i]]);
					alphabet(x+dx[i], y+dy[i], cnt+1);
					alpha.remove(alpha.size()-1);
					//visit[x+dx[i]][y+dy[i]] = false;
				}				
			}
		}
		
	}
	
	
	
	public static boolean inRange(int x, int y) {
		return x>=0 && x < R && y>=0 && y < C;
	}
	
}



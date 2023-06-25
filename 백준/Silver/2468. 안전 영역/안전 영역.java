import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] area;
	static int answer = 0;
	static boolean [][] visited;
	static int dict [][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		area = new int [n][n];
		
		int maxHeight = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {				
				area[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = (maxHeight > area[i][j]) ? maxHeight : area[i][j];
			}
		}
				
		
		for(int height = 0; height <= maxHeight; height++) {
			visited = new boolean [n][n];
			int cnt = 0;
			for(int j = 0; j < n; j ++) {
				for(int k = 0; k < n; k++) {
					if(!visited[j][k] && area[j][k] > height) {
						cnt += countArea(j, k, height);
					}
				}
			}			
			
			answer = (answer > cnt) ? answer : cnt;			
		}				
		
		System.out.println(answer);
	}
	
	public static int countArea(int x, int y, int height) {
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dict[i][0];
			int ny = y + dict[i][1];
			
			if(isInside(nx, ny) && !visited[nx][ny]) {
				if(area[nx][ny] > height) {
					countArea(nx, ny, height);
				}
			}
		}
		
		
		return 1;
	}
	public static boolean isInside(int x, int y) {
		return x>=0 && y>= 0 && x < area.length && y < area[0].length;
	}

}


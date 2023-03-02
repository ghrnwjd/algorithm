import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n,m, answer;
	static final int maxSize = 26;
	static boolean visited[][] = new boolean [maxSize][maxSize];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		
		nemonemo(1,1);
		System.out.println(answer);
				
	}
	
	static void nemonemo(int row, int col) {
		if(row == n && col == m+1) {
			answer++;
			return;
		}
		
		for(int i = row; i <= n; i++) {
			for(int j = (i == row ? col : 1); j <= m; j++) {
				if(visited[i-1][j] && visited[i][j-1] && visited[i-1][j-1]) {
					continue;
				}
				
				visited[i][j] = true;
				nemonemo(i, j+1);
				visited[i][j] = false;
				
			}
		}
		answer++;
	}
}

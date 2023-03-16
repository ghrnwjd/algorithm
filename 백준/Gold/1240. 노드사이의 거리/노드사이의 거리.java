import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, weight[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		weight = new int [n+1][n+1]; 
		
		for(int i = 1; i <=n; i++) {
			Arrays.fill(weight[i], 10000001);
		}
		
		
		for(int i = 1; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			weight[n1][n2] = w;
			weight[n2][n1] = w;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			dijkstra(n1, n2);
		}		
		
	}
	
	static void dijkstra(int start, int end) {
		
		int len [] = weight[start];	
		
		boolean visited [] = new boolean [n+1];
		
		visited[start] = true;
				
		while(true) {
			int idx = minValue(len, visited);
			visited[idx] = true;
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i]) {
					len[i] = Math.min(len[i], len[idx] + weight[idx][i]);
				}
			}
			
			if(idx == end) {
				System.out.println(len[idx]);
				return;
			}
		}		
	}
	
	static int minValue(int[] len, boolean [] visited) {
		
		int index = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			if(len[i] < min && !visited[i]) {
				min = len[i];
				index = i;
			}
		}
		
		return index;
	}
}
import java.util.*;
import java.io.*;

public class Main {

	static int N, M, town[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		town = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(town[i], -1);
		}

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(town[start][end] != -1) {
				town[start][end] = Math.min(town[start][end], cost);
			}
			else {
				town[start][end] = cost; 	
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		min_cost(start, end);

	}

	public static void min_cost(int start, int end) {
		int dist[] = new int[N + 1];
		boolean visit[] = new boolean[N + 1];
		visit[start] = true;
		
		for (int i = 1; i <= N; i++) { // 초기값 설정
			if (i == start)
				dist[i] = 0;
			dist[i] = town[start][i];
		}

		int index = 0;
		int min = 0;
		int cnt = 0;
		
		while (cnt < M) {
			
			min = Integer.MAX_VALUE;
			index = -1;

			for (int i = 1; i <= N; i++) { // 최솟값 구하기				
				if (!visit[i]) {
					if (dist[i] != -1 && dist[i] < min) {
						min = dist[i];
						index = i;
					}
				}
			}
			
			if(index == -1) break;
			visit[index] = true;

			for (int j = 1; j <= N; j++) {
				if (!visit[j] && town[index][j] != -1) {
					if (dist[j] != -1) {
						dist[j] = Math.min(dist[j], dist[index] + town[index][j]);
					} else {
						dist[j] = dist[index] + town[index][j];
					}
				}

			}
			cnt++;
		}
		if (dist[end] != -1)
		{
			System.out.println(dist[end]);
		}

	}
}

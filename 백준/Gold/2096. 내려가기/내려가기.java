import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int nums[][] = new int [N][3];
		int dp_max[][] = new int [N][3];
		int dp_min[][] = new int [N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					dp_max[i][j] = nums[i][j];
					dp_min[i][j] = nums[i][j]; 
				}
			}
		}
		
		// 최댓값 구하기
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					dp_max[i][j] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + nums[i][j];
				}
				else if (j == 1) {
					dp_max[i][j] = Math.max(dp_max[i-1][0],
							Math.max(dp_max[i-1][1], dp_max[i-1][2])) + nums[i][j];
				}
				else {
					dp_max[i][j] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + nums[i][j];
				}
			}
		}
		
		// 최솟값 구하기
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					dp_min[i][j] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + nums[i][j];
				}
				else if (j == 1) {
					dp_min[i][j] = Math.min(dp_min[i-1][0],
							Math.min(dp_min[i-1][1], dp_min[i-1][2])) + nums[i][j];
				}
				else {
					dp_min[i][j] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + nums[i][j];
				}
			}
		}
		
		int max_ans = Math.max(dp_max[N-1][0], Math.max(dp_max[N-1][1], dp_max[N-1][2]));
		int min_ans = Math.min(dp_min[N-1][0], Math.min(dp_min[N-1][1], dp_min[N-1][2]));
		
		System.out.println(max_ans + " " + min_ans);
		
		
		
	}
}

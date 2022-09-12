import java.util.*;
import java.io.*;

public class Main {	
	
	
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] nums = new int [N];

		for(int i = 0; i < N; i ++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
			
		Arrays.sort(nums);
		
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < N) {
			int temp = nums[p1] - nums[p2];
			if(temp < M) {
				p1++;
			}
			else if (temp == M) {
				ans = M;
				break;
			}
			else {
				ans = Math.min(ans, temp);
				p2++;
			}			
		}		
		System.out.println(ans);
	}
}

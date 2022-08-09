import java.util.*;
import java.io.*;

public class b1011 {
	static int diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			diff = y - x;
			alpha();
		}

	}
	

	public static void alpha() {
		int cnt = (int)Math.sqrt(diff);	
		
		int ans = 0;
		
		if(diff == cnt * cnt) {
			ans = 2 * cnt - 1;
		}
		else if(diff <= cnt * cnt + cnt) {
			ans = 2 * cnt;
		}
		else {
			ans = 2 * cnt + 1;
		}		
		System.out.println(ans);
	}
}



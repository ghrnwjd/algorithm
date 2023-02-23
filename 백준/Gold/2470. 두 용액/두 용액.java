import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int liquid [] = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		int p1 = 0;
		int p2 = n-1;
		int p3 = -1;
		int value = Integer.MAX_VALUE;
		int ans_p1 = 0, ans_p2 = 0;
		
		if(liquid[n-1] < 0) {
			System.out.println(liquid[n-2] + " " + liquid[n-1]);
		}
		else if (liquid[0] >= 0) {
			System.out.println(liquid[0] + " " + liquid[1]);
		}
		else {
			while(p2 > p1) {
				int temp_value = liquid[p1] + liquid[p2];
				value = moreClosedZero(value, temp_value);
				
				if(temp_value == value) {
					ans_p1 = liquid[p1];
					ans_p2 = liquid[p2];
				}
				
				if(temp_value > 0) {
					p2--;
				}
				else {
					p1++;
				}				
			}
			
		}
		
		
		System.out.println(ans_p1 + " " + ans_p2);
		
		
	}	
	
	static int moreClosedZero(int old_value, int new_value) {		
		return Math.abs(old_value) > Math.abs(new_value) ? new_value : old_value;
	}
}

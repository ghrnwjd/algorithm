import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	static int nums[] = new int [] {0,1,2,3,4,5,6,7,8,9};
	static ArrayList<Long> ans = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());		
		declinedNum(0, 9);
		
		Collections.sort(ans);
		try {
			System.out.println(ans.get(n-1));
		}
		catch(Exception e) {
			System.out.println(-1);
		}
	    
	}
	
	static void declinedNum(long number, int idx) {
		if(!ans.contains(number)) {
			ans.add(number);
		}
		
		if(idx < 0 ) return;
		
		declinedNum(number * 10 + nums[idx], idx - 1);
		declinedNum(number, idx - 1);
	}
	
}

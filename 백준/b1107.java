import java.util.*;
import java.io.*;

public class b1107 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> wrongNum = new ArrayList<>();
		int wrong_button = Integer.parseInt(br.readLine());
		int ans = Math.abs(100 - N);
		int cnt = Integer.MAX_VALUE;
		
		if (wrong_button != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < wrong_button; i++) {
				wrongNum.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < 1000000; i++) {
			boolean wrong = false;
			String temp = String.valueOf(i);
			
			for(int j = 0; j < temp.length(); j++) {
				if(wrongNum.contains(temp.charAt(j) - '0')) {
					// i를 String으로 변환 후 문자를 포함하고 있다면
					 wrong = true;
					 break;
				}
			}
			
			if(wrong) continue;			
			
			cnt = Math.min(cnt, 
					temp.length() + Math.abs(i - N));
			
		}		
		
		System.out.println(Math.min(cnt, ans));
		
	}
}

import java.util.*;

import java.io.*;

public class b16953 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		/* 2를 곱하거나 > 짝수
 		   1을 뒤에 붙인다 > 홀수 */
		
		int cnt = 0;
		
		while(true) {
			cnt ++;			
			String temp = String.valueOf(b);
			
			if(a > b) { // error case 1 : B가 A 보다 작아질 때
				System.out.println(-1);
				break;
			}
			if(temp.charAt(temp.length()-1) != '1' && b % 2 != 0) {
				//error case 2 : B가 홀수인데 뒷자리가 1이 아닐 때
				System.out.println(-1);
				break;
			}
			
			if(b % 2 == 0) {
				// 짝수라면 2를 나누자
				b /= 2;
			}
			else {
				b = Long.parseLong(temp.substring(0, temp.length() - 1));
			}
			
			if( a == b) {
				System.out.println(cnt + 1);
				break;
			}
		}		
	}
}

import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Long G = Long.parseLong(st.nextToken());
		
		long p1 = 1;
		long p2 = 2;
		
		ArrayList<Long> ans = new ArrayList<>();
		
		while(true) {
			
			// p2 == 50001, p1 == 50000 일 경우 차이는 100000이 넘는다.
			if(p1 > 50000) { 
				break;
			}
			
			long temp = p2*p2 - p1*p1;
			
			if(temp == G) {
				ans.add(p2);
				p2++;
			}
			else if (temp < G){
				p2++;
			}
			else {
				p1++;
			}		
			
		}
		

		
		if(ans.isEmpty()) {
			System.out.println(-1);
		}
		else {
			for(long num : ans) {
				System.out.println(num);
			}
		}
	}

}



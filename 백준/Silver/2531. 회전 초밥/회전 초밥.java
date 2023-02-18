import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int [] belt = new int [n];
		for(int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		
		int count = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			int ans = 0;
			boolean useCoupon = false;
			boolean isEat[] = new boolean [d+1]; 
			for(int j = i; j < i + k; j++) {
				int index = j % n; // 원형 큐 처럼 만들기 위해서
				if(!isEat[belt[index]]) {					
					isEat[belt[index]] = true;
					if(belt[index] == c) {						
						useCoupon = true;									
					}
					ans++;
				}
			}			
			
			if(!useCoupon) {
				ans ++;
			}
			count = Math.max(count, ans);
			
		}
		
		System.out.println(count);
	}
}

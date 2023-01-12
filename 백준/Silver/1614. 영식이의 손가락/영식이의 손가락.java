import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long ans = 0;
		
		// 1 엄지, 2 검지, 3 중지, 4 약지, 5 새끼
		int finger = Integer.parseInt(st.nextToken());
		// 다친 손가락으로 셀 수 있는 최대 횟수
		int finger_count = Integer.parseInt(br.readLine());
		
		while(true) {
			// 한바퀴 돌면서 한번 생략되는 손가락 1, 5
			if(finger == 1) {
				finger_count --;
				if(isExit(finger_count)) { // 종료한다.
					break;
				}
				// 1, 2, 3, 4, 5, 4, 3, 2 -> 8번 더 돌 수 있다.
				ans += 8;
			}
			else if(finger == 5) {
				// 1, 2, 3, 4 를 먼저 온다
				ans += 4;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 5, 4, 3, 2 -> 4번 더 돌수 있다. 위에서 1, 2, 3, 4를 생각했기에 생략
				ans += 4;
				
			} // 나머지 케이스 계산
			else if (finger == 2) {
				// 1은 먼저 돈다.
				ans += 1;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 2, 3, 4, 5, 4, 3, -> 6번
				ans += 6;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 2 손가락을 한번 더한다.
				ans += 1;
			}
			else if (finger == 3) {
				// 1,2 를 먼저 돈다.
				ans += 2;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 3, 4, 5, 4 -> 4번
				ans += 4;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 3, 2을 둔다.
				ans += 2;
			}
			else {
				// 1, 2, 3을 먼저 둔다.
				ans += 3;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 4, 5 -> 2번
				ans += 2;
				finger_count--;
				if(isExit(finger_count)) {
					break;
				}
				// 4, 3, 2를 둔다
				ans += 3;
				
			}
			
		}	
		
		System.out.println(ans);
	}
	
	public static boolean isExit(int count) {
		return count < 0;
	}
}

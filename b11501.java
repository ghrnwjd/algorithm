import java.util.*;
import java.io.*;

public class b11501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int a = Integer.parseInt(st.nextToken());
		long max[] = new long[a];
		// 앞선 가격보다 높으면 판다.

		for (int i = 0; i < a; i++) {
			int temp = Integer.parseInt(br.readLine());
			int[] arr = new int[temp];
			long ans = 0L;
			int max_price = 0;
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < temp; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = temp - 1; j >= 0; j--) {
				if (max_price < arr[j])
					max_price = arr[j];
				else {
					ans += (max_price - arr[j]);
				}
			}
			max[i] = ans;
		}

		for (long temp : max) {
			System.out.println(temp);
		}
	}
}

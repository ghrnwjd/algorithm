import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 최대공약수(N) * num1/N * num2/N = 최소공배수(M)

		int temp = M / N;
		
		if(temp == 1) {
			System.out.println(N + " " + N);
		}
		
		else {
			int min_value = Integer.MAX_VALUE;
			int ans1 = 0;
			int ans2 = 0;

			for (int i = 1; i <= temp / 2; i++) {
				if (temp % i == 0) {
					int num2 = temp / i;
					if (isTrue(N, i, num2)) {
						if (min_value > Math.abs(i - num2)) {
							min_value = Math.abs(i - num2);
							ans1 = i;
							ans2 = num2;
						}
					}
				}
			}

			System.out.println(N * ans1 + " " + N * ans2);
		}
	

	}

	/**
	 * 
	 * @param N    두 변수의 최대공약수
	 * @param num1 두 변수중 하나
	 * @param num2 두 변수중 남은 하나
	 * @return N 이상의 최대공약수를 가지는지
	 */
	public static boolean isTrue(int N, int num1, int num2) {

		int min = Math.min(num1, num2);
		
		for (int i = 2; i <= min; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				return false;
			}
		}
		return true;

	}
}
